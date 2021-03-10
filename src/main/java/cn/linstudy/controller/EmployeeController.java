package cn.linstudy.controller;
import cn.linstudy.annotation.RequiredPermission;
import cn.linstudy.domain.Department;
import cn.linstudy.domain.Employee;
import cn.linstudy.domain.Role;
import cn.linstudy.qo.DepartmentQueryObject;
import cn.linstudy.qo.EmployeeQueryObject;
import cn.linstudy.service.DepartmentService;
import cn.linstudy.service.EmployeeService;
import cn.linstudy.service.RoleService;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/8 13:53
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

  @Autowired
  EmployeeService employeeService;

  @Autowired
  DepartmentService departmentService;

  @Autowired
  RoleService roleService;

  @RequiredPermission(name = "查询所有员工",expression = "/employee/list")
  @RequestMapping("list")
  public String listAll( @ModelAttribute("qo") EmployeeQueryObject employeeQueryObject , Model model, DepartmentQueryObject departmentQueryObject){
    PageInfo<Employee>  pageInfo= employeeService.selectForPage(employeeQueryObject);
    List<Department> departments = departmentService.selectAll();
    List<Role> roles = roleService.selectAll();
    model.addAttribute("departments",departments);
    model.addAttribute("roles",roles);
    model.addAttribute("pageInfo",pageInfo);
    return "employee/list";
  }

  @RequestMapping("tosaveOrUpdate")
  public String tosaveOrUpdate(Long id, Model model,DepartmentQueryObject qo){
    Employee employee = employeeService.selectByPrimaryKey(id);
    List<Role> selectRolesById= employeeService.selectRolesById(id);
    List<Department> departments = departmentService.selectAll();
    List<Role> roles = roleService.selectAll();
    employeeService.selectAll();
    model.addAttribute("departments",departments);
    if (id == null){
      model.addAttribute("roles",roles);
      return "employee/input";
    }
    model.addAttribute("selectRolesById",selectRolesById);

    model.addAttribute("roles",roles);
    model.addAttribute("employee",employee);
    return "employee/input";
  }

  @RequestMapping("saveOrUpdate")
  public String saveOrUpdate(Long id,Employee employee,Long[] ids){
    if (id != null){
      employeeService.update(employee,ids);
      return "redirect:/employee/list";
    }else {
    employeeService.save(employee,ids);
    }
    return "redirect:/employee/list";
  }

  @RequestMapping("delete")
  public String delete(Long id){
    employeeService.deleteByPrimaryKey(id);
    return "redirect:/employee/list";
  }
}
