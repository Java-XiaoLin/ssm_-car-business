package cn.linstudy.controller;

import cn.linstudy.domain.Employee;
import cn.linstudy.domain.Salary;
import cn.linstudy.domain.SystemDictionaryItem;
import cn.linstudy.qo.SalaryQueryObject;
import cn.linstudy.qo.response.ResponseResult;
import cn.linstudy.service.EmployeeService;
import cn.linstudy.service.SalaryService;
import cn.linstudy.service.SystemDictionaryItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 工资管理控制器
 * @Author XiaoLin
 * @Date 2021/3/20 9:23
 */
@Controller
@RequestMapping("/salary")
public class SalaryController {

  @Autowired
  SalaryService salaryService;

  @Autowired
  SystemDictionaryItemService systemDictionaryItemService;

  @Autowired
  EmployeeService employeeService;

  @RequestMapping("list")
  public String listAll(@ModelAttribute("qo") SalaryQueryObject qo, Model model){
    List<SystemDictionaryItem> systemDictionaryItems = systemDictionaryItemService
        .selectAllByTypeId(3L);
    model.addAttribute("pageInfo", salaryService.selectForPage(qo));
    model.addAttribute("Allemployee",employeeService.selectAllEmployee());
    model.addAttribute("systemDictionaryItems", systemDictionaryItems);
    return "/salary/list";
  }

  @RequestMapping("selectEmployeeById")
  @ResponseBody
  public ResponseResult selectEmployeeById(Long employeeId){
    Employee employee = employeeService.selectByPrimaryKey(employeeId);
    return new ResponseResult(true,"查询id为"+employeeId+"的员工成功",employee);
  }

  @RequestMapping("saveOrUpdate")
  public String saveOrUpdate(Salary salary){
    if (salary.getId() == null){
      salaryService.insertSelective(salary);
    }else {
      salaryService.updateByPrimaryKeySelective(salary);
    }
    return "redirect:/salary/list";
  }

  @RequestMapping("selectEmployeeAll")
  @ResponseBody
  public ResponseResult selectEmployeeAll(){
    return new ResponseResult(true,"查询所有员工",employeeService.selectAll());
  }
}
