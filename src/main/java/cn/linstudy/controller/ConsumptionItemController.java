package cn.linstudy.controller;

import cn.linstudy.domain.ConsumptionItem;
import cn.linstudy.qo.response.ResponseResult;
import cn.linstudy.service.ConsumptionItemService;
import cn.linstudy.service.ConsumptionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/17 16:34
 */
@Controller
@RequestMapping("/consumptionItem")
public class ConsumptionItemController {

  @Autowired
  ConsumptionItemService consumptionItemService;

  @RequestMapping("saveConsumptionItem")
  public String saveConsumptionItem(ConsumptionItem consumptionItem,String consumptionId){
    consumptionItemService.insert(consumptionItem);
    return "redirect:/consumption/detail?consumptionId="+Long.valueOf(consumptionId);
  }

  @RequestMapping("batchDelete")
  @ResponseBody
  public ResponseResult batchDelete(Long[] ids){
       return consumptionItemService.batchDelete(ids);
  }


}
