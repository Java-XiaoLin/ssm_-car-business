package cn.linstudy.controller;
import cn.linstudy.qo.SystemDictionaryItemQueryObject;
import cn.linstudy.qo.SystemDictionaryQueryObject;
import cn.linstudy.qo.response.ResponseResult;
import cn.linstudy.service.SystemDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 数据字典目录控制器
 * @Author XiaoLin
 * @Date 2021/3/12 10:23
 */
@Controller
@RequestMapping("/systemDictionary")
public class SystemDictionaryController {

  @Autowired
  SystemDictionaryService systemDictionaryService;

  @RequestMapping("list")
  public String listAll(SystemDictionaryQueryObject qo, Model model){
    model.addAttribute("pageInfo",systemDictionaryService.selectForPage(qo));
    return "systemDictionary/list";
  }

  @RequestMapping("listAllsystemDictionary")
  @ResponseBody
  public ResponseResult listAllsystemDictionary(){
    return new ResponseResult(true,"查询所有字典目录成功",systemDictionaryService.selectAll());
  }


}
