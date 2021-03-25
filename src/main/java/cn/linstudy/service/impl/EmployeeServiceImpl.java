package cn.linstudy.service.impl;

import cn.linstudy.domain.Employee;
import cn.linstudy.domain.Role;
import cn.linstudy.exception.CarBussinessException;
import cn.linstudy.mapper.EmployeeMapper;
import cn.linstudy.qo.EmployeeQueryObject;
import cn.linstudy.service.EmployeeService;
import cn.linstudy.vo.EmployeeInsertVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletOutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/8 13:55
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeMapper employeeMapper;

  @Override
  public void deleteByPrimaryKey(Long id) {
    employeeMapper.deleteByPrimaryKey(id);
    employeeMapper.deleteRelation(id);
  }

  @Override
  public int insert(Employee record) {
    return employeeMapper.insert(record);
  }

  @Override
  public void save(Employee employee, Long[] ids) {
    // 增加员工
    employeeMapper.insertSelective(employee);
    // 维护中间表的关系
    if (ids != null) {
      for (Long roleId : ids) {
        employeeMapper.insertRelation(employee.getId(), roleId);
      }
    }

  }

  @Override
  public Employee selectByPrimaryKey(Long id) {
    return employeeMapper.selectByPrimaryKey(id);
  }

  @Override
  public void update(Employee employee, Long[] ids) {
    employeeMapper.updateByPrimaryKeySelective(employee);
    // 删除中间表的关系
    employeeMapper.deleteRelation(employee.getId());
    // 插入新的关系
    if (ids != null) {
      for (Long roleId : ids) {
        employeeMapper.insertRelation(employee.getId(), roleId);
      }
    }
  }

  @Override
  public int updateByPrimaryKey(Employee record) {
    return employeeMapper.updateByPrimaryKey(record);
  }

  @Override
  public PageInfo<Employee> selectForPage(EmployeeQueryObject qo) {
    PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
    List<Employee> employees = employeeMapper.selectForPage(qo);
    return new PageInfo<Employee>(employees);
  }

  /**
   * @return int
   * @Description:根据id查询员工
   * @author XiaoLin
   * @date 2021/3/13
   * @Param: [id]
   */
  @Override
  public int listForDeptId(Long id) {
    return employeeMapper.listForDeptId(id);
  }


  @Override
  public Employee login(String username, String password, String captcha, String code_in_session) {
    if (!captcha.equalsIgnoreCase(code_in_session)) {
      throw new CarBussinessException("验证码错误");

    } else {
      if (StringUtils.isEmpty(username)) {
        throw new CarBussinessException("用户名不可以为空");

      }
      if (StringUtils.isEmpty(password)) {
        throw new CarBussinessException("密码不可以为空");
      }
      try {
        // 对传进来的密码进行加密
        Md5Hash md5Hash = new Md5Hash(password, username, 1024);
        UsernamePasswordToken token = new UsernamePasswordToken(username, md5Hash.toString());
        SecurityUtils.getSubject().login(token);
        Employee employee = employeeMapper.selectByUsername(username);
        return employee;
      } catch (UnknownAccountException e) {
        throw new CarBussinessException("用户名错误");
      } catch (IncorrectCredentialsException e) {
        throw new CarBussinessException("密码错误");
      }

    }
  }

  @Override
  public List<Employee> selectAll() {
    return employeeMapper.selectAll();
  }

  @Override
  public List<Role> selectRolesById(Long id) {
    return employeeMapper.selectRolesById(id);
  }

  @Override
  public Employee selectByUsername(String username) {
    return employeeMapper.selectByUsername(username);
  }

  @Override
  public void regsiter(EmployeeInsertVO employeeVO) {
    employeeMapper.register(employeeVO);
  }

  @Override
  public List<String> getPermissionByEmployeeId(Long id) {
    return employeeMapper.getPermissionByEmployeeId(id);
  }

  @Override
  public void exportEmployeeExel(ServletOutputStream outputStream) throws IOException {
    // 创建excel文件
    Workbook wb = new HSSFWorkbook();
    // 创建sheet
    Sheet sheet = wb.createSheet("员工名单");
    // 创建标题行
    Row row = sheet.createRow(0);
    // 设置内容到单元格中
    // 第一行第一列为姓名
    row.createCell(0).setCellValue("编号");
    row.createCell(1).setCellValue("用户名");
    row.createCell(2).setCellValue("真实姓名");
    row.createCell(3).setCellValue("邮箱");
    row.createCell(4).setCellValue("年龄");
    row.createCell(3).setCellValue("部门");
    // 查询员工数据
    List<Employee> employees = employeeMapper.selectAll();
    // 遍历员工，一个员工就是一行
    for (int i = 0; i < employees.size(); i++) {
      Employee employee = employees.get(i);
      // 创建行，第0行已经给标题了
      row = sheet.createRow(i + 1);
      // 设置内容到单元格中
      row.createCell(0).setCellValue(employee.getId());
      row.createCell(1).setCellValue(employee.getUsername());
      row.createCell(2).setCellValue(employee.getName());
      row.createCell(3).setCellValue(employee.getEmail());
      row.createCell(4).setCellValue(employee.getAge());
      row.createCell(5).setCellValue(employee.getDepartment().getName());
    }
    //将文件输出到当浏览器中
    wb.write(outputStream);
  }

  /**
   * @return void
   * @Description:员工通讯录文件上传
   * @author XiaoLin
   * @date 2021/3/12
   * @Param: [file]
   */
  @Override
  public void importEmployeeFromExel(MultipartFile file) throws IOException {
    // 可以用来记录成功失败的数量
    ArrayList<Integer> linenum = new ArrayList<>();
    // 创建 HSSFWorkbook excel文档对象
    HSSFWorkbook wb = new HSSFWorkbook(file.getInputStream());
    // 读取excel中第一个工作页
    Sheet sheet = wb.getSheetAt(0);
    // 读取所有的行数
    int lastRowNum = sheet.getLastRowNum();
    for (int i = 1; i <= lastRowNum; i++) {
      Row row = sheet.getRow(i);
      Employee employee = new Employee();
      // 获取第一行第0列的数据,进行赋值
      employee.setUsername(row.getCell(0).getStringCellValue());
      employee.setName(row.getCell(1).getStringCellValue());
      // 值类型为int类型，所以需要特殊处理
      employee.setAge((int) row.getCell(2).getNumericCellValue());
      employee.setEmail(row.getCell(3).getStringCellValue());
      employee.setAdmin(false);
      employee.setPassword("123456");
      employeeMapper.insertSelective(employee);
    }

  }

  /**
   * @return cn.linstudy.domain.Employee
   * @Description:根据邮箱查询用户，用于进行注册时邮箱检测
   * @author XiaoLin
   * @date 2021/3/14
   * @Param: [email]
   */
  @Override
  public Employee selectForEmail(String email) {
    return employeeMapper.selectForEmail(email);
  }

  @Override
  public List<Employee> selectAllEmployee() {
    return employeeMapper.selectAllEmployee();
  }


}
