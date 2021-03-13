package cn.linstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 异常页面跳转
 * @Author XiaoLin
 * @Date 2021/3/11 21:25
 */
@Controller
public class ExceptionController {
  @RequestMapping("error")
  public String toErrorPage(){
    return "common/error";
  }
}
