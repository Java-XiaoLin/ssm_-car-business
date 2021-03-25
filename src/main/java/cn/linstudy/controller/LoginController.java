package cn.linstudy.controller;

import cn.linstudy.domain.Employee;
import cn.linstudy.qo.response.ResponseResult;
import cn.linstudy.service.EmployeeService;
import cn.linstudy.service.NoticeService;
import cn.linstudy.utils.VerifyCodeUtils;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 登录控制器
 * @Author XiaoLin
 * @Date 2021/3/9 15:18
 */
@Controller
public class LoginController {

  @Autowired
  EmployeeService employeeService;

  @Autowired
  NoticeService noticeService;


  @RequestMapping("empLogin")
  @ResponseBody
  public ResponseResult login(HttpSession session, String username, String password, String captcha,
      HttpSession httpSession) {
    Employee employee = employeeService
        .login(username, password, captcha, session.getAttribute("CODE_IN_SESSION").toString());
    List<String> permissionByEmployeeId = employeeService
        .getPermissionByEmployeeId(employee.getId());
    session.setAttribute("permissionByEmployeeId", permissionByEmployeeId);
    session.setAttribute("EMPLOYEE_IN_SESSION", employee);
    return new ResponseResult(true, "登录成功", employee);
  }

  /**
   * @return
   * @Description:生成验证码
   * @author XiaoLin
   * @date 2021/3/10
   * @Param:
   */
  @RequestMapping("getImage")
  public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
    //1.获取随机数据
    String code = VerifyCodeUtils.generateVerifyCode(4);
    //2.将数字放入session
    session.setAttribute("CODE_IN_SESSION", code);
    //3.生成验证码图片
    VerifyCodeUtils.outputImage(125, 43, response.getOutputStream(), code);
  }
  
}
