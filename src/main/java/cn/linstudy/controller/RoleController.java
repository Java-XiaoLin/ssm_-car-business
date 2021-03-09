package cn.linstudy.controller;

import cn.linstudy.domain.Department;
import cn.linstudy.domain.Permission;
import cn.linstudy.domain.Role;
import cn.linstudy.qo.RoleQueryObject;
import cn.linstudy.service.DepartmentService;
import cn.linstudy.service.PermissionService;
import cn.linstudy.service.RoleService;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/9 9:27
 */

@Controller
@RequestMapping("/role")
public class RoleController {

  @Autowired
  RoleService roleService;

  @Autowired
  PermissionService permissionService;

  @Autowired
  DepartmentService departmentService;

  @RequestMapping("list")
  public String listForPage( RoleQueryObject qo,Model model){
    List<Permission> permissions = permissionService.selectAll();
    PageInfo<Role> pageInfo = roleService.selectForPage(qo);
    List<Role> roles = roleService.selectAll();
    model.addAttribute("permissions",permissions);
    model.addAttribute("roles",roles);
    model.addAttribute("pageInfo",pageInfo);
    return "role/list";
  }

  @RequestMapping("input")
  public String input(Long id,Model model){
    List<Permission> permissions = permissionService.selectAll();
    model.addAttribute("permissions",permissions);
    List<Department> departments = departmentService.selectAll();
    model.addAttribute("departments",departments);
    if (id == null){
      return "role/input";
    }
    Role role = roleService.selectByPrimaryKey(id);
    // 根据id查询出当前角色的权限，进行回显
    List<Permission> permissionByRoleId = permissionService.selectPermissionByRoleId(id);
    model.addAttribute("permissionByRoleId",permissionByRoleId);
    model.addAttribute("role",role);
    return "role/input";
  }

  @RequestMapping("saveOrUpdate")
  public String saveOrUpdate(Role role,Long[] ids){
    // 保存
    if (role.getId() == null){
      roleService.save(role,ids);
    }else { // 修改
      roleService.update(role,ids);
    }
    return "redirect:/role/list";
  }

}
