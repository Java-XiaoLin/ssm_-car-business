package cn.linstudy.service;

import cn.linstudy.domain.Employee;
import cn.linstudy.domain.Permission;
import cn.linstudy.domain.Role;
import cn.linstudy.qo.EmployeeQueryObject;
import cn.linstudy.qo.response.ResponseResult;
import cn.linstudy.vo.EmployeeInsertVO;
import com.github.pagehelper.PageInfo;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletOutputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/8 13:55
 */

public interface EmployeeService{


    void deleteByPrimaryKey(Long id);

    int insert(Employee record);

    void save(Employee employee,Long[] ids);

    Employee selectByPrimaryKey(Long id);

    void update(Employee employee,Long[] ids);

    int updateByPrimaryKey(Employee record);

    PageInfo<Employee>  selectForPage(EmployeeQueryObject qo);


    /**
        * @Description:根据部门id查询员工
        * @author XiaoLin
        * @date 2021/3/13
        * @Param: [id]
        * @return int
        */
    int listForDeptId(Long id);

    Employee login(String username, String password,String captcha,String code_in_session);

    List<Employee> selectAll();

    List<Role> selectRolesById(Long id);

    Employee selectByUsername(String username);

    void regsiter(EmployeeInsertVO employeeVO);

    List<Permission>getPermissionByEmployeeId(Long id);

    void  exportEmployeeExel(ServletOutputStream outputStream) throws IOException;

    void importEmployeeFromExel(MultipartFile file) throws IOException;
    
    /**
        * @Description:根据邮箱查询用户，用于进行注册时邮箱检测
        * @author XiaoLin
        * @date 2021/3/14
        * @Param: [email]
        * @return cn.linstudy.domain.Employee
        */
    Employee selectForEmail(String email);
}
