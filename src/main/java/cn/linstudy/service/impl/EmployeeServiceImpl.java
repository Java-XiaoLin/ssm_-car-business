package cn.linstudy.service.impl;

import cn.linstudy.domain.Role;
import cn.linstudy.qo.EmployeeQueryObject;
import cn.linstudy.qo.response.ResponseResult;
import cn.linstudy.vo.EmployeeInsertVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.linstudy.domain.Employee;
import cn.linstudy.mapper.EmployeeMapper;
import cn.linstudy.service.EmployeeService;
import org.springframework.util.StringUtils;

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
    if (ids != null){
        for (Long roleId : ids){
            employeeMapper.insertRelation(employee.getId(),roleId);
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

  @Override
  public int listForDeptId(Long id) {
    return employeeMapper.listForDeptId(id);
  }

  @Override
  public ResponseResult login(String username, String password,String captcha,String code_in_session) {
    if (!captcha.equalsIgnoreCase(code_in_session)){
      return  new ResponseResult(false, "验证码错误");
    }else {
      if (StringUtils.isEmpty(username)) {
        return new ResponseResult(false, "用户名不可以为空");
      }
      if (StringUtils.isEmpty(password)) {
        return new ResponseResult(false, "密码不可以为空");
      }
      Employee employee = employeeMapper.selectByUsername(username);
      if (employee == null) {
        return new ResponseResult(false, "用户名错误");
      }
      if (!employee.getPassword().equals(password)) {
        return new ResponseResult(false, "密码错误");
      }
      return new ResponseResult(true, "登录成功",employee);
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


}
