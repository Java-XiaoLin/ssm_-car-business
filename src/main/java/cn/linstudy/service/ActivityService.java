package cn.linstudy.service;

import cn.linstudy.domain.Activity;
import cn.linstudy.qo.ActivityQueryObject;
import com.github.pagehelper.PageInfo;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/21 14:28
 */

public interface ActivityService {


  int deleteByPrimaryKey(Long id);

  int insert(Activity record);

  int insertSelective(Activity record);

  Activity selectByPrimaryKey(Long id);

  int updateByPrimaryKeySelective(Activity record);

  int updateByPrimaryKey(Activity record);

  PageInfo<Activity> selectForPage(ActivityQueryObject qo);

  Activity checkVote(Long employeeId, Long activityId);

  void vote(Long employeeId, Long activityId, Long activityItemId);

}
