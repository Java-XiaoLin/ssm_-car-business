package cn.linstudy.controller;
import cn.linstudy.domain.Business;
import cn.linstudy.domain.Consumption;
import cn.linstudy.domain.ConsumptionItem;
import cn.linstudy.domain.Employee;
import cn.linstudy.domain.SystemDictionaryItem;
import cn.linstudy.enums.ConsumptionEnum;
import cn.linstudy.qo.ConsumptionQueryObject;
import cn.linstudy.service.AppointmentService;
import cn.linstudy.service.BusinessService;
import cn.linstudy.service.ConsumptionItemService;
import cn.linstudy.service.ConsumptionService;
import cn.linstudy.service.SystemDictionaryItemService;
import com.github.pagehelper.PageInfo;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/16 11:28
 */
@Controller
@RequestMapping("consumption")
@Slf4j
public class ConsumptionController {

  @Autowired
  ConsumptionService consumptionService;

  @Autowired
  BusinessService businessService;

  @Autowired
  SystemDictionaryItemService systemDictionaryItemService;

  @Autowired
  AppointmentService appointmentService;

  @Autowired
  ConsumptionItemService consumptionItemService;


  @RequestMapping("list")
  public String listAll(Model model,@ModelAttribute("qo") ConsumptionQueryObject qo){
    PageInfo<Consumption> consumptionPageInfo = consumptionService.selectForPage(qo);
    model.addAttribute("pageInfo",consumptionPageInfo);
    // 拿到消费单状态
    model.addAttribute("consumptionEnum", ConsumptionEnum.values());
    // 查询所有门店
    model.addAttribute("businessAll",businessService.selectAll());
    return "consumption/list";
  }

  @RequestMapping("toinput")
  public String input(Consumption consumption,Model model){
    // 查业务大类
    List<SystemDictionaryItem> businessType = systemDictionaryItemService
        .selectAllByTypeId(1L);
    // 支付方式
    List<SystemDictionaryItem> pay_type = systemDictionaryItemService
        .selectAllByTypeId(3L);
    model.addAttribute("businessType",businessType);
    model.addAttribute("pay_type",pay_type);
    return "/consumption/input";
  }


  @RequestMapping("detail")
  public String detail(Long consumptionId,Model model){
    Consumption consumption = consumptionService.selectByPrimaryKey(consumptionId);
    List<Business> businesses = businessService.selectAll();
    //根据结算单流水号查询结算单明细数据
    List<ConsumptionItem> consumptionItems = consumptionItemService.selectByConsumptionId(Long.valueOf(consumption.getCno()));
     //总消费金额
    BigDecimal AllAmount = new BigDecimal(0);
    // 总优惠金额
    BigDecimal DiscountAmount = new BigDecimal(0);
    // 总应收金额
    BigDecimal PayAmount = new BigDecimal(0);
    for (ConsumptionItem consumptionItem : consumptionItems) {
     AllAmount = AllAmount.add(consumptionItem.getAmount());
      DiscountAmount = DiscountAmount.add(consumptionItem.getDiscountAmount());

    }
    PayAmount =AllAmount.subtract(DiscountAmount);
    consumption.setTotalAmount( AllAmount);
    consumption.setDiscountAmount(DiscountAmount);
    consumption.setPayAmount(PayAmount);
    // 查业务大类
    List<SystemDictionaryItem> businessType = systemDictionaryItemService
        .selectAllByTypeId(1L);
    // 支付方式
    List<SystemDictionaryItem> pay_type = systemDictionaryItemService
        .selectAllByTypeId(3L);
    model.addAttribute("businessType",businessType);
    model.addAttribute("pay_type",pay_type);
    model.addAttribute("AllAmount",AllAmount);
    model.addAttribute("DiscountAmount",DiscountAmount);
    model.addAttribute("PayAmount",PayAmount);
    model.addAttribute("consumptionItems",consumptionItems);
    model.addAttribute("businesses",businesses);
    model.addAttribute("consumption",consumption);
    return "consumption/input";
  }


  @RequestMapping("createConsumption")
  public String createConsumption(String appointmentId,String ano,Integer status){
    // 先将预约单状态改为消费中
    appointmentService.updateStatus(Long.valueOf(appointmentId),status);
    // 生成消费单
    Consumption consumption = consumptionService.createConsumption(ano);
    // 生成完以后跳转到结算单详情页界面
    return "redirect:/consumption/detail?consumptionId="+consumption.getId();
  }

  @RequestMapping("saveOrUpdate")
  public String saveOrUpdate(Consumption consumption,String action){
    log.info("正在保存");
   consumptionService.updateByPrimaryKeySelective(consumption);
    return "redirect:/consumption/list";
  }

  @RequestMapping("settleConsumption")
  public String settleConsumption(String consumptionId,HttpSession httpSession){
    log.info("正在结算");
    Consumption consumption = consumptionService.selectByPrimaryKey(Long.valueOf(consumptionId));
    consumption.setStatus(ConsumptionEnum.AUDIT.getValue());
    consumption.setPayTime(new Date());
    consumption.setPayeeEmployee((Employee) httpSession.getAttribute("EMPLOYEE_IN_SESSION"));
    consumptionService.updateByPrimaryKeySelective(consumption);
    return "redirect:/consumption/list";
  }

  @RequestMapping("review")
  public String Review(String consumptionId,HttpSession httpSession){
    log.info("正在审核");
    Consumption consumption = consumptionService.selectByPrimaryKey(Long.valueOf(consumptionId));
    consumption.setAuditTime(new Date());
    consumption.setStatus(ConsumptionEnum.FINISH.getValue());
    consumption.setPayeeEmployee((Employee) httpSession.getAttribute("EMPLOYEE_IN_SESSION"));
    consumptionService.updateByPrimaryKeySelective(consumption);
    return "redirect:/consumption/list";
  }

}
