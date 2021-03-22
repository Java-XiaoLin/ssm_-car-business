package cn.linstudy.controller;

import cn.linstudy.domain.Activity;
import cn.linstudy.domain.ActivityItem;
import cn.linstudy.domain.Employee;
import cn.linstudy.qo.response.ResponseResult;
import cn.linstudy.service.ActivityItemService;
import cn.linstudy.service.ActivityService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/21 17:04
 */
@Controller
@RequestMapping("activityItem")
public class ActivityItemController {

  @Autowired
  ActivityItemService activityItemService;

  @Autowired
  ActivityService activityService;

  @RequestMapping("vote")
  public String vote(String activityId, Model model) {
    List<ActivityItem> activityItems = activityItemService
        .selectActivityItemByActivityId(Long.valueOf(activityId));
    model.addAttribute("ActivityItem", activityItems);
    model.addAttribute("title", activityItems.get(0).getActivity().getTitle());
    return "activity/show";
  }

  @RequestMapping("employeeVote")
  @ResponseBody
  public ResponseResult employeeVote(String activityItemId, String activityId,
      HttpSession httpSession) {
    //  先检查之前是否投过票
    Employee employee_in_session = (Employee) httpSession.getAttribute("EMPLOYEE_IN_SESSION");
    Activity activity = activityService
        .checkVote(employee_in_session.getId(), Long.valueOf(activityId));
    // 如果返回值为空，说明没有投过票
    if (activity == null) {
      activityService.vote(employee_in_session.getId(), Long.valueOf(activityId),
          Long.valueOf(activityItemId));
      return new ResponseResult(true, "投票成功");
    } else {
      // 说明投过票了
      return new ResponseResult(false, "您已经投过票了");
    }

  }
}
