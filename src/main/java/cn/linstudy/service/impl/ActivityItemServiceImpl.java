package cn.linstudy.service.impl;

import cn.linstudy.domain.ActivityItem;
import cn.linstudy.mapper.ActivityItemMapper;
import cn.linstudy.service.ActivityItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/21 14:28
 */

@Service
public class ActivityItemServiceImpl implements ActivityItemService {

  @Autowired
  private ActivityItemMapper activityItemMapper;

  @Override
  public int deleteByPrimaryKey(Long id) {
    return activityItemMapper.deleteByPrimaryKey(id);
  }

  @Override
  public int insert(ActivityItem record) {
    return activityItemMapper.insert(record);
  }

  @Override
  public int insertSelective(ActivityItem record) {
    return activityItemMapper.insertSelective(record);
  }

  @Override
  public ActivityItem selectByPrimaryKey(Long id) {
    return activityItemMapper.selectByPrimaryKey(id);
  }

  @Override
  public int updateByPrimaryKeySelective(ActivityItem record) {
    return activityItemMapper.updateByPrimaryKeySelective(record);
  }

  @Override
  public int updateByPrimaryKey(ActivityItem record) {
    return activityItemMapper.updateByPrimaryKey(record);
  }

  @Override
  public List<ActivityItem> selectActivityItemByActivityId(Long activityId) {
    return activityItemMapper.selectActivityItemByActivityId(activityId);
  }

  
}
