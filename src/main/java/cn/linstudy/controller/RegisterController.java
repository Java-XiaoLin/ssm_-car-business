package cn.linstudy.controller;

import cn.linstudy.domain.Employee;
import cn.linstudy.qo.response.ResponseResult;
import cn.linstudy.service.EmployeeService;
import cn.linstudy.utils.EmailUtils;
import cn.linstudy.utils.VerifyCodeUtils;
import cn.linstudy.vo.EmployeeInsertVO;
import javax.servlet.http.HttpSession;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 注册控制器
 * @Author XiaoLin
 * @Date 2021/3/10 14:32
 */
@Controller
public class RegisterController {

  @Autowired
  EmployeeService employeeService;

  @RequestMapping("getEmailCode")
  @ResponseBody
  public ResponseResult getEmailCode(String email, HttpSession session) {
    if (employeeService.selectForEmail(email) != null) {
      return new ResponseResult(false, "邮箱以注册，请更换");
    } else {
      String code = VerifyCodeUtils.generateVerifyCode(4);
      session.setAttribute("EMAIL_CODE", code);
      session.setAttribute("EMAIL_IN_SESSION", email);
      try {
        EmailUtils.sendEmail(email, code);
        ResponseResult responseResult = new ResponseResult(true, "发送邮件成功");
        return responseResult;
      } catch (Exception e) {
        ResponseResult responseResult = new ResponseResult(true, "发送邮件成功");
        return responseResult;
      }
    }

  }

  @RequestMapping("checkEmail")
  @ResponseBody
  public ResponseResult checkEmail(String code, HttpSession session) {
    if (code == null) {
      code = "";
    }
    if (code.equals(session.getAttribute("EMAIL_CODE"))) {
      return new ResponseResult(true, "邮箱验证成功");
    } else {
      return new ResponseResult(false, "激活码错误");
    }
  }

  @RequestMapping("checkUsername")
  @ResponseBody
  public ResponseResult checkUsername(String username, String password, HttpSession session) {
    Employee employee = employeeService.selectByUsername(username);
    if (employee == null) {
      // 进行MD5密码加密
      Md5Hash md5Hash = new Md5Hash(password, username, 1024);
      EmployeeInsertVO employeeVO = new EmployeeInsertVO(username, username, md5Hash.toString(),
          session.getAttribute("EMAIL_IN_SESSION").toString(), false, true);
      employeeService.regsiter(employeeVO);
      return new ResponseResult(true, "注册成功");
    } else {
      return new ResponseResult(false, "用户名已存在");
    }
  }

  @RequestMapping("checkEmailIsHave")
  @ResponseBody
  public ResponseResult checkEmail(String email) {
    Employee employee = employeeService.selectForEmail(email);
    if (employee == null) {
      return new ResponseResult(false, "邮箱可以注册");
    } else {
      return new ResponseResult(false);
    }

  }
}
