package cn.linstudy.interceptor;

import cn.linstudy.domain.Employee;
import cn.linstudy.domain.Notice;
import cn.linstudy.service.NoticeService;
import cn.linstudy.utils.RelativeDateUtils;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/9 15:40
 */
public class CheckLoginInterceptor implements HandlerInterceptor {

  @Autowired
  NoticeService noticeService;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    //请求是静态资源,handler对应的类 class org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler
    //请求是动态资源,handler对应的类class org.springframework.web.method.HandlerMethod
    // 如果是动态资源

    if (handler instanceof HandlerMethod) {
      Employee employee = (Employee) request.getSession().getAttribute("EMPLOYEE_IN_SESSION");
      if (employee == null) {
        response.sendRedirect("/login.html");
        return false;
      }
      // 查看未读公告的数量
      int unReadNumber = noticeService.unReadNumber(employee.getId());
      // 查询未读公告
      List<Notice> unReadNotice = noticeService.unReadNotice(employee.getId());
      for (Notice notice : unReadNotice) {
        notice.setCalTime(RelativeDateUtils.format(notice.getCreateTime()));
      }
      request.getSession().setAttribute("unReadNumber", unReadNumber);
      request.getSession().setAttribute("unReadNotice", unReadNotice);
    }
    return true;
  }
}
