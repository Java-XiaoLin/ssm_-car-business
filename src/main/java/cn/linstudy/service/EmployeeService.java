package cn.linstudy.service;

import cn.linstudy.domain.Employee;
import cn.linstudy.domain.Role;
import cn.linstudy.qo.EmployeeQueryObject;
import cn.linstudy.vo.EmployeeInsertVO;
import com.github.pagehelper.PageInfo;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletOutputStream;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/8 13:55
 */

public interface EmployeeService {


  void deleteByPrimaryKey(Long id);

  int insert(Employee record);

  void save(Employee employee, Long[] ids);

  Employee selectByPrimaryKey(Long id);

  void update(Employee employee, Long[] ids);

  int updateByPrimaryKey(Employee record);

  PageInfo<Employee> selectForPage(EmployeeQueryObject qo);


  /**
   * @return int
   * @Description:根据部门id查询员工
   * @author XiaoLin
   * @date 2021/3/13
   * @Param: [id]
   */
  int listForDeptId(Long id);

  Employee login(String username, String password, String captcha, String code_in_session);

  List<Employee> selectAll();

  List<Role> selectRolesById(Long id);

  Employee selectByUsername(String username);

  void regsiter(EmployeeInsertVO employeeVO);

  List<String> getPermissionByEmployeeId(Long id);

  void exportEmployeeExel(ServletOutputStream outputStream) throws IOException;

  void importEmployeeFromExel(MultipartFile file) throws IOException;

  /**
   * @return cn.linstudy.domain.Employee
   * @Description:根据邮箱查询用户，用于进行注册时邮箱检测
   * @author XiaoLin
   * @date 2021/3/14
   * @Param: [email]
   */
  Employee selectForEmail(String email);

  /**
   * @return java.util.List<cn.linstudy.domain.Employee>
   * @Description:查询所有员工
   * @author XiaoLin
   * @date 2021/3/20
   * @Param: []
   */
  List<Employee> selectAllEmployee();
}
