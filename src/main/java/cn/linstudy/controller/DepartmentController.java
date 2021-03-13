package cn.linstudy.controller;
import cn.linstudy.annotation.RequiredPermission;
import cn.linstudy.domain.Department;
import cn.linstudy.qo.DepartmentQueryObject;
import cn.linstudy.qo.response.ResponseResult;
import cn.linstudy.service.DepartmentService;
import cn.linstudy.service.EmployeeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 部门Controller
 * @Author XiaoLin
 * @Date 2021/3/7 19:54
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

  @Autowired
  DepartmentService departmentService;

  @Autowired
  EmployeeService employeeService;

  @RequiredPermission(name = "查询所有部门",expression = "/department/list")
  @RequestMapping("/list")
  public String selectForPage(DepartmentQueryObject qo, Model model){
    PageInfo<Department> pageInfo = departmentService.selectForPage(qo);
    model.addAttribute("pageInfo",pageInfo);
    return "department/list";
  }

  @RequiredPermission(name = "增加部门",expression = "/department/save")
  @RequestMapping("/save")
  @ResponseBody
  public String save(Department department){
    departmentService.insert(department);
    return "redirect:/department/list";
  }


  @RequiredPermission(name = "跳转到增加或者回显部门",expression = "/department/saveOrUpdate")
  @RequestMapping("saveOrUpdate")
  public String saveOrUpdate(Long id,Department department){
    if(id == null){
      departmentService.insertSelective(department);
      return "redirect:/department/list";
    }else {
      departmentService.updateByPrimaryKeySelective(department);
      return "redirect:/department/list";
    }
  }

  @RequiredPermission(name = "删除部门",expression = "/department/delete")
  @RequestMapping("delete")
  @ResponseBody
  public ResponseResult delte(Long id){
    int count = employeeService.listForDeptId(id);
    if (count == 0){
      departmentService.deleteByPrimaryKey(id);
      return new ResponseResult(true,"删除成功");
    }else {
      return new ResponseResult(false,"该部门旗下还有员工，不可以删除");
    }

  }
}
