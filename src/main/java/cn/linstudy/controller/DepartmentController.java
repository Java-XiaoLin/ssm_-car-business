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

  /**
      * @Description: 查询所有部门
      * @author XiaoLin
      * @date 2021/3/13
      * @Param: [qo, model]
      * @return java.lang.String
      */
  @RequiredPermission(name = "查询所有部门",expression = "/department/list")
  @RequestMapping("/list")
  public String selectForPage(DepartmentQueryObject qo, Model model){
    // 拿到DepartmentService返回的PageInfo对象
    PageInfo<Department> pageInfo = departmentService.selectForPage(qo);
    // 放到Model中，方便前端展示
    model.addAttribute("pageInfo",pageInfo);
    // 返回前端界面
    return "department/list";
  }

  /**
      * @Description:增加部门
      * @author XiaoLin
      * @date 2021/3/13
      * @Param: [department]
      * @return java.lang.String
      */
  @RequiredPermission(name = "增加部门",expression = "/department/save")
  @RequestMapping("/save")
  @ResponseBody
  public String save(Department department){
    departmentService.insert(department);
    return "redirect:/department/list";
  }


  /**
      * @Description:增加或者修改部门
      * @author XiaoLin
      * @date 2021/3/13
      * @Param: [id, department]
      * @return java.lang.String
      */
  @RequiredPermission(name = "增加或者修改部门",expression = "/department/saveOrUpdate")
  @RequestMapping("saveOrUpdate")
  public String saveOrUpdate(Long id,Department department){
    // 如果id为空，说明是新增
    if(id == null){
      // 调用新增方法
      departmentService.insertSelective(department);
      return "redirect:/department/list";
    }else {
      // 否则id不为空就是修改
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
