package cn.linstudy.controller;

import cn.linstudy.qo.response.ResponseResult;
import cn.linstudy.utils.SendMessageUtils;
import cn.linstudy.utils.VerifyCodeUtils;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 用户页面的控制器
 * @Author XiaoLin
 * @Date 2021/3/16 15:57
 */
@Controller
@RequestMapping("/fronted")
public class IndexController {

  @RequestMapping("index")
  public String index(){
    return "index";
  }

  @RequestMapping("sendMessage")
  @ResponseBody
  public ResponseResult sendMessage(String phone){
    String code = VerifyCodeUtils.generateVerifyCode(4);
    try {
      SendMessageUtils.sendShortMessage("SMS_213086602",phone,code );
      return new ResponseResult(true,"发送短信成功",code);
    } catch (ClientException e) {
      e.printStackTrace();
      return new ResponseResult(false,"发送短信失败",e.getMessage());
    }
  }
}
