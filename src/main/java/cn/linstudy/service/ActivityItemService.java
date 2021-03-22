package cn.linstudy.service;

import cn.linstudy.domain.ActivityItem;
import java.util.List;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/21 14:28
 */

public interface ActivityItemService {


  int deleteByPrimaryKey(Long id);

  int insert(ActivityItem record);

  int insertSelective(ActivityItem record);

  ActivityItem selectByPrimaryKey(Long id);

  int updateByPrimaryKeySelective(ActivityItem record);

  int updateByPrimaryKey(ActivityItem record);

  List<ActivityItem> selectActivityItemByActivityId(Long activityId);

}
