package cn.linstudy.controller;

import cn.linstudy.domain.ActivityItem;
import cn.linstudy.qo.ActivityQueryObject;
import cn.linstudy.service.ActivityItemService;
import cn.linstudy.service.ActivityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 投票控制器
 * @Author XiaoLin
 * @Date 2021/3/21 14:31
 */
@Controller
@RequestMapping("activity")
public class ActivityController {

  @Autowired
  ActivityService activityService;

  @Autowired
  ActivityItemService activityItemService;

  @RequestMapping("list")
  public String list(Model model, ActivityQueryObject qo) {
    model.addAttribute("pageInfo", activityService.selectForPage(qo));
    return "activity/list";
  }

  @RequestMapping("result")
  public String result(String activityId, Model model) {
    List<ActivityItem> activityItems = activityItemService
        .selectActivityItemByActivityId(Long.valueOf(activityId));
    model.addAttribute("activityItemResult", activityItems);

    return "activity/result";
  }


}
