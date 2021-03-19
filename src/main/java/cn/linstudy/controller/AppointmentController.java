package cn.linstudy.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.linstudy.domain.Appointment;
import cn.linstudy.domain.SystemDictionaryItem;
import cn.linstudy.enums.AppointmentEnum;
import cn.linstudy.qo.AppointmentQueryObject;
import cn.linstudy.qo.response.ResponseResult;
import cn.linstudy.service.AppointmentService;
import cn.linstudy.service.BusinessService;
import cn.linstudy.service.SystemDictionaryItemService;
import com.github.pagehelper.PageInfo;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 预约单
 * @Author XiaoLin
 * @Date 2021/3/14 15:40
 */
@Controller
@RequestMapping("/appointment")
public class AppointmentController {

  @Autowired
  AppointmentService appointmentService;

  @Autowired
  BusinessService businessService;

  @Autowired
  SystemDictionaryItemService systemDictionaryItemService;

  /**
      * @Description:查询所有预约单
      * @author XiaoLin
      * @date 2021/3/14
      * @Param: [qo, model]
      * @return java.lang.String
      */
  @RequestMapping("list")
  public String list(@ModelAttribute("qo") AppointmentQueryObject qo, Model model){
    PageInfo<Appointment> pageInfo = appointmentService.selectForPage(qo);
    List<SystemDictionaryItem> systemDictionaryItems = systemDictionaryItemService
        .selectAllByTypeId(1L);
    // 拿到所有业务大类
    model.addAttribute("systemDictionaryItems",systemDictionaryItems);
    // 查询所有门店
    model.addAttribute("businessAll",businessService.selectAll());
    // 拿到预约单的分页对象
    model.addAttribute("pageInfo",pageInfo);
    // 拿到预约单的状态枚举
    model.addAttribute("AppointmentEnum", AppointmentEnum.values());
    return "/appointment/list";
  }

  /**
      * @Description:增加或者修改
      * @author XiaoLin
      * @date 2021/3/15
      * @Param: [appointment, model]
      * @return void
      */
  @RequestMapping("saveOrUpdate")
  public String saveOrUpdate(Appointment appointment,Model model){
    if (appointment.getId() == null){
      appointment.setAno(DateUtil.format(new Date(),"yyyyMMdd") +RandomUtil.randomNumbers(5));
      appointment.setCreateTime(new Date());
      appointment.setStatus(AppointmentEnum.PERFORM.getValue());
      appointmentService.insert(appointment);
    }else {
      appointmentService.updateByPrimaryKeySelective(appointment);
    }
    return "redirect:/appointment/list";
  }

  /**
      * @Description:根据id修改为想要修改的状态
      * @author XiaoLin
      * @date 2021/3/16
      * @Param: [appointmentId]
      * @return cn.linstudy.qo.response.ResponseResult
      */
  @RequestMapping("updateStatus")
  public String updateStatus(String appointmentId,Integer status){
    appointmentService.updateStatus(Long.valueOf(appointmentId),status);
    return "redirect:/appointment/list";
  }



}
