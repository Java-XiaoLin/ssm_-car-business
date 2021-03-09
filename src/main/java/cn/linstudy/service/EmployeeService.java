package cn.linstudy.service;

import cn.linstudy.domain.Employee;
import cn.linstudy.domain.Role;
import cn.linstudy.qo.EmployeeQueryObject;
import cn.linstudy.qo.response.ResponseResult;
import com.github.pagehelper.PageInfo;
import java.util.List;

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


    int listForDeptId(Long id);

    ResponseResult login(String username, String password);

    List<Employee> selectAll();

    List<Role> selectRolesById(Long id);
}
