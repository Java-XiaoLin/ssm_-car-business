package cn.linstudy.controller;

import cn.linstudy.enums.ConsumptionEnum;
import cn.linstudy.enums.ConsumptionReportEnums;
import cn.linstudy.qo.ConsumptionReportQueryObject;
import cn.linstudy.service.BusinessService;
import cn.linstudy.service.CustomerReportService;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 数据报表控制器
 * @Author XiaoLin
 * @Date 2021/3/18 20:40
 */
@Controller
@RequestMapping("/consumptionReport")
public class CustomerReportController {

  @Autowired
  private CustomerReportService customerReportService;

  @Autowired
  BusinessService businessService;

  @RequestMapping("list")
  public String list(@ModelAttribute("qo") ConsumptionReportQueryObject qo, Model model){
    model.addAttribute("pageInfo",customerReportService.query(qo));
    model.addAttribute("AllbusinessList",businessService.selectAll());
    model.addAttribute("groupByItems", ConsumptionReportEnums.values());
    return "/businessReport/list";
  }

  @RequestMapping("echart")
  public String echart(@ModelAttribute("qo") ConsumptionReportQueryObject qo,Model model){
    // 设置不分页
    qo.setPageSize(0);
    PageInfo query = customerReportService.query(qo);
    model.addAttribute("items",query.getList());
    return "/businessReport/echart";
  }

}
