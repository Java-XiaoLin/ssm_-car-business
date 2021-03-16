package cn.linstudy.mapper;

import cn.linstudy.domain.Department;
import cn.linstudy.domain.Employee;
import cn.linstudy.domain.Permission;
import cn.linstudy.domain.Role;
import cn.linstudy.qo.DepartmentQueryObject;
import cn.linstudy.qo.EmployeeQueryObject;
import cn.linstudy.vo.EmployeeInsertVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/8 13:55
 */

@Mapper
public interface EmployeeMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<Employee> selectForPage(EmployeeQueryObject qo);

        /**
        * @Description:根据部门id查询员工
        * @author XiaoLin
        * @date 2021/3/13
        * @Param: [id]
        * @return int
        */
    int listForDeptId(Long id);

    Employee selectByUsername(String username);

    List<Employee> selectAll();

    void insertRelation(@Param("employeeId") Long employeeId, @Param("roleId") Long roleId);

    void deleteRelation(Long empId);

    List<Role> selectRolesById(Long empId);

    void register(EmployeeInsertVO employeeVO);

    List<Permission> getPermissionByEmployeeId(Long empId);

    /**
        * @Description:根据邮箱查询用户，用于进行注册时邮箱检测
        * @author XiaoLin
        * @date 2021/3/14
        * @Param: [email]
        * @return cn.linstudy.domain.Employee
        */
    Employee selectForEmail(String email);
}