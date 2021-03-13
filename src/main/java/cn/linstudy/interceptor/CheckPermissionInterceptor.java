package cn.linstudy.interceptor;

import cn.linstudy.annotation.RequiredPermission;
import cn.linstudy.domain.Employee;
import cn.linstudy.domain.Permission;
import cn.linstudy.qo.response.ResponseResult;
import com.alibaba.fastjson.JSON;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @Description 权限控制的拦截器
 * @Author XiaoLin
 * @Date 2021/3/11 10:36
 */
public class CheckPermissionInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    if (handler instanceof HandlerMethod) {
      // 先从Session中拿到登录用户的信息
      Employee employee = (Employee) request.getSession().getAttribute("EMPLOYEE_IN_SESSION");
      // 判断是否为超级管理员
      // 如果是超级管理员
      if (employee.getAdmin()){
        // 放行
        return true;
      }
      // 来到这一步，说明不是超级管理员
      // handler里面封装了该请求方法的全部信息，先强转成HandlerMethod
      HandlerMethod method = (HandlerMethod) handler;
      // 获取贴了该注解方法的注解对象，如果为null，说明没有贴该注解，否则就是贴了该注解
      RequiredPermission methodAnnotation = method.getMethodAnnotation(RequiredPermission.class);
      if (methodAnnotation == null){
        // 说明该方法不需要权限控制，直接放行
        return true;
      }
      // 查询出注解所对应的权限表达式
      String expression = methodAnnotation.expression();
      // 从Session中拿到登录用户所拥有的权限
      List<Permission> permissionByEmployeeId = (List<Permission>) request.getSession().getAttribute("permissionByEmployeeId");
      // 遍历用户的权限，看看是否包含注解所需要的权限
      for (Permission permission : permissionByEmployeeId) {
        // 如果用户所拥有的权限中包含注解所需要的权限
        if (permission.getExpression().equals(expression)) {
          // 放行
          return true;
        }
      }
      // 循环遍历完都没有找到，说明用户集合中没有该权限，没有权限就进行拦截
      // 针对不同的相应情况进行拦截，分为返回页面和返回JSON，据当前访问方法是否有贴@ResponseBody注解判断是哪种请求
      ResponseBody responseBodyAnnotation = method.getMethodAnnotation(ResponseBody.class);
      if (responseBodyAnnotation == null) {
        // 如果没有贴ResponseBody注解，说明是页面请求
        response.sendRedirect("/employee/toNoPermissionPage");
      }else {
        // 说明返回JSON数据
        response.setContentType("application/json; charset=UTF-8");
        String reponseData = JSON.toJSONString(new ResponseResult(false, "对不起，您没有该权限"));
        response.getWriter().write(reponseData);
      }
      return false;
    }
    return true;
    }
  }