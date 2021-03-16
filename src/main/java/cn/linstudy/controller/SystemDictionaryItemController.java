package cn.linstudy.controller;

import cn.linstudy.domain.SystemDictionary;
import cn.linstudy.domain.SystemDictionaryItem;
import cn.linstudy.qo.SystemDictionaryItemQueryObject;
import cn.linstudy.qo.response.ResponseResult;
import cn.linstudy.service.SystemDictionaryItemService;
import cn.linstudy.service.SystemDictionaryService;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 数据库字典详情控制器
 * @Author XiaoLin
 * @Date 2021/3/12 15:53
 */
@Controller
@RequestMapping("/systemDictionaryItem")
public class SystemDictionaryItemController {

  @Autowired
  SystemDictionaryItemService systemDictionaryItemService;

  @Autowired
  SystemDictionaryService systemDictionaryService;

  @RequestMapping("list")
  public String listAll(Model model, @ModelAttribute("qo") SystemDictionaryItemQueryObject qo){
    // 查询详细
    PageInfo<SystemDictionaryItem> systemDictionaryItems = systemDictionaryItemService
        .selectForPage(qo);
    // 查询字典的目录
   List<SystemDictionary> systemDictionaries = systemDictionaryService.selectAll();
   systemDictionaryItemService.selectForQuery(qo);
    model.addAttribute("pageInfo",systemDictionaryItems);
    model.addAttribute("systemDictionaries",systemDictionaries);
    return "systemDictionaryItem/list";
  }

  @RequestMapping("update")
  public String update(Model model,SystemDictionaryItem systemDictionaryItem){
    systemDictionaryItemService.updateByPrimaryKeySelective(systemDictionaryItem);
    return "redirect:/systemDictionaryItem/list?typeId=1";
  }
  @RequestMapping("selectItemByParentId")
  @ResponseBody
  public ResponseResult selectItemByParentId(SystemDictionaryItemQueryObject qo){
    List<SystemDictionaryItem> systemDictionaryItems = systemDictionaryItemService.selectForQuery(qo);
      return new ResponseResult(true,"查询成功",systemDictionaryItems);
  }

  @RequestMapping("save")
  public String save(SystemDictionaryItem systemDictionaryItem){
    systemDictionaryItemService.save(systemDictionaryItem);
    return "redirect:/systemDictionaryItem/list?typeId=1";
  }

  @RequestMapping("listForParentId")
  public String listForParentId(SystemDictionaryItemQueryObject qo,Model model){
    List<SystemDictionaryItem> systemDictionaryItems = systemDictionaryItemService
        .selectForQuery(qo);
    model.addAttribute("pageInfo",systemDictionaryItems);
    return "systemDictionaryItem/list";
  }

}
