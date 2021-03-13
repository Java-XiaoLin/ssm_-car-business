package cn.linstudy.exception;

import cn.linstudy.qo.response.ResponseResult;
import com.alibaba.fastjson.JSON;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

/**
 * @Description 全局异常处理
 * @Author XiaoLin
 * @Date 2021/3/11 21:12
 */
// 标记该类为Controller的增强类,用于捕获异常
@ControllerAdvice
public class ExceptionControllerAdvice {

  // @ExceptionHandler(异常类型.class)需要处理Controller抛出什么类型的异常.
  @ExceptionHandler(CarBussinessException.class)
  public void handleBussinessException(CarBussinessException carBussinessException,
      HttpServletResponse response, HandlerMethod handlerMethod) throws IOException { carBussinessException.printStackTrace();
      // 判断是返回页面还是返回JSON
    ResponseBody methodAnnotation = handlerMethod.getMethodAnnotation(ResponseBody.class);
    if (methodAnnotation == null){
      // 返回页面
      response.sendRedirect("error");
    }else {
      response.setContentType("application/json;charset=utf-8");
      String responseData = JSON.toJSONString(new ResponseResult(false, carBussinessException.getMessage()));
      response.getWriter().write(responseData);
    }
  }

  @ExceptionHandler(Exception.class)
  public void BussinessException(Exception exception, HttpServletResponse response, HandlerMethod handlerMethod)
      throws IOException {
    exception.printStackTrace();
    ResponseBody methodAnnotation = handlerMethod.getMethodAnnotation(ResponseBody.class);
    if (methodAnnotation == null){
      response.sendRedirect("/error");
    }else {
      response.setContentType("application/json;charset=utf-8");
      String responseData = JSON.toJSONString(new ResponseResult(false, exception.getMessage()));
      response.getWriter().write(responseData);
    }
  }
}
