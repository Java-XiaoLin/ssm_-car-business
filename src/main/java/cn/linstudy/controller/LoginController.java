package cn.linstudy.controller;

import cn.linstudy.qo.response.ResponseResult;
import cn.linstudy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/9 15:18
 */
public class LoginController {

  @Autowired
  EmployeeService employeeService;

  @RequestMapping("login")
  @ResponseBody
  public ResponseResult login(String username,String password){
    ResponseResult responseResult = employeeService.login(username, password);
    return responseResult;
  }
}
