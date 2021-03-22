package cn.linstudy.controller;

import cn.linstudy.domain.Employee;
import cn.linstudy.domain.Notice;
import cn.linstudy.domain.NoticeEmployee;
import cn.linstudy.enums.NoticeStatusEnum;
import cn.linstudy.qo.NoticeQueryObject;
import cn.linstudy.qo.response.ResponseResult;
import cn.linstudy.service.EmployeeService;
import cn.linstudy.service.NoticeService;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 公告管理的控制器
 * @Author XiaoLin
 * @Date 2021/3/19 15:59
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {

  @Autowired
  NoticeService noticeService;

  @Autowired
  EmployeeService employeeService;


  @RequestMapping("list")
  public String list(@ModelAttribute("qo") NoticeQueryObject qo, Model model,
      HttpSession httpSession) {
    Employee employee_in_session = (Employee) httpSession.getAttribute("EMPLOYEE_IN_SESSION");

    // 根据登录状态来判断是否是管理员，如果是管理员就可以查看所有公告
    if (employee_in_session.getAdmin()) {
      model.addAttribute("pageInfo", noticeService.selectForPage(employee_in_session.getId(), qo));
    } else {
      // 不是管理员只可以查看已发布的公告
      qo.setStatus(NoticeStatusEnum.RELEASE.getValue());
      model.addAttribute("pageInfo", noticeService.selectForPage(employee_in_session.getId(), qo));
    }
    return "notice/list";
  }

  @RequestMapping("saveOrUpdate")
  public String saveOrUpdate(Notice notice, HttpSession httpSession) {
    Employee employee_in_session = (Employee) httpSession.getAttribute("EMPLOYEE_IN_SESSION");
    if (notice.getId() == null) {
      notice.setCreatePeople(employee_in_session);
      notice.setCreateTime(new Date());
      // 增加
      noticeService.insertSelective(employee_in_session.getId(), notice);
    } else {
      noticeService.updateByPrimaryKeySelective(notice);
    }
    return "redirect:/notice/list ";
  }

  @RequestMapping("cancel")
  @ResponseBody
  public ResponseResult cancel(Long noticeId) {
    noticeService.updateStatus(noticeId, NoticeStatusEnum.NO_release.getValue());
    return new ResponseResult(true, "取消发布成功");
  }

  @RequestMapping("publish")
  @ResponseBody
  public ResponseResult publish(Long noticeId) {
    noticeService.updateStatus(noticeId, NoticeStatusEnum.RELEASE.getValue());
    return new ResponseResult(true, "发布成功");
  }

  @RequestMapping("toShow")
  public String toShow(String noticeId, HttpSession httpSession, Model model) {
    Employee employee_in_session = (Employee) httpSession.getAttribute("EMPLOYEE_IN_SESSION");
    // 判断是否是第一次点击查看
    List<NoticeEmployee> noticeEmployee = noticeService
        .checkClick(Long.valueOf(noticeId), employee_in_session.getId());
    if (noticeEmployee.size() == 0) {
      // 说明是第一次点击，维护中间表
      noticeService.insertRelationship(Long.valueOf(noticeId), employee_in_session.getId());
    }
    // 否则直接返回
    Notice notice = noticeService.readNotice(Long.valueOf(noticeId));
    model.addAttribute("notice", notice);
    return "/notice/show";
  }


}
