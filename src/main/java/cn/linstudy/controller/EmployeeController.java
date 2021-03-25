package cn.linstudy.controller;

import cn.linstudy.domain.Department;
import cn.linstudy.domain.Employee;
import cn.linstudy.domain.Role;
import cn.linstudy.qo.DepartmentQueryObject;
import cn.linstudy.qo.EmployeeQueryObject;
import cn.linstudy.service.DepartmentService;
import cn.linstudy.service.EmployeeService;
import cn.linstudy.service.RoleService;
import com.github.pagehelper.PageInfo;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description 员工控制器
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

  // shiro注解无法使用name属性，所以约定，value中第一个位置的值是权限表达式，第二个位置的值是权限名称.
  // 但是 logical 的值必须是Logical.OR
  @RequiresPermissions(value = {"employee:list", "员工列表"}, logical = Logical.OR)
  @RequestMapping("list")
  public String listAll(@ModelAttribute("qo") EmployeeQueryObject employeeQueryObject, Model model,
      DepartmentQueryObject departmentQueryObject) {
    PageInfo<Employee> pageInfo = employeeService.selectForPage(employeeQueryObject);
    List<Department> departments = departmentService.selectAll();
    List<Role> roles = roleService.selectAll();
    model.addAttribute("departments", departments);
    model.addAttribute("roles", roles);
    model.addAttribute("pageInfo", pageInfo);
    return "employee/list";
  }

  @RequestMapping("tosaveOrUpdate")
  public String tosaveOrUpdate(Long id, Model model, DepartmentQueryObject qo) {
    Employee employee = employeeService.selectByPrimaryKey(id);
    List<Role> selectRolesById = employeeService.selectRolesById(id);
    List<Department> departments = departmentService.selectAll();
    List<Role> roles = roleService.selectAll();
    employeeService.selectAll();
    model.addAttribute("departments", departments);
    if (id == null) {
      model.addAttribute("roles", roles);
      return "employee/input";
    }
    model.addAttribute("selectRolesById", selectRolesById);

    model.addAttribute("roles", roles);
    model.addAttribute("employee", employee);
    return "employee/input";
  }

  @RequestMapping("saveOrUpdate")
  public String saveOrUpdate(Long id, Employee employee, Long[] ids) {
    if (id != null) {
      employeeService.update(employee, ids);
      return "redirect:/employee/list";
    } else {
      employeeService.save(employee, ids);
    }
    return "redirect:/employee/list";
  }

  @RequestMapping("delete")
  public String delete(Long id) {
    employeeService.deleteByPrimaryKey(id);
    return "redirect:/employee/list";
  }

  @RequestMapping("toNoPermissionPage")
  public String toNoPermissionPage() {
    return "/common/nopermission";
  }

  @RequestMapping("exportEmployeeExel")
  @ResponseBody
  public void exportEmployeeExel(HttpServletResponse response) throws IOException {
    String FileName = new String("员工通讯录.xls".getBytes(StandardCharsets.UTF_8), "ISO-8859-1");
    // 文件下载的响应头（让浏览器访问资源的时候以下载的方式打开）
    response.setHeader("Content-Disposition", "attachment;filename=" + FileName);
    // 创建excel文件
    employeeService.exportEmployeeExel(response.getOutputStream());
  }

  @RequestMapping("importEmployeeFromExel")
  public String importEmployeeFromExel(MultipartFile file) throws IOException {
    employeeService.importEmployeeFromExel(file);
    return "redirect:/employee/list";
  }

}
