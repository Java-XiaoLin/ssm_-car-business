package cn.linstudy.service.impl;

import cn.linstudy.domain.Activity;
import cn.linstudy.mapper.ActivityMapper;
import cn.linstudy.qo.ActivityQueryObject;
import cn.linstudy.service.ActivityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/21 14:28
 */

@Service
public class ActivityServiceImpl implements ActivityService {

  @Autowired
  private ActivityMapper activityMapper;

  @Override
  public int deleteByPrimaryKey(Long id) {
    return activityMapper.deleteByPrimaryKey(id);
  }

  @Override
  public int insert(Activity record) {
    return activityMapper.insert(record);
  }

  @Override
  public int insertSelective(Activity record) {
    return activityMapper.insertSelective(record);
  }

  @Override
  public Activity selectByPrimaryKey(Long id) {
    return activityMapper.selectByPrimaryKey(id);
  }

  @Override
  public int updateByPrimaryKeySelective(Activity record) {
    return activityMapper.updateByPrimaryKeySelective(record);
  }

  @Override
  public int updateByPrimaryKey(Activity record) {
    return activityMapper.updateByPrimaryKey(record);
  }

  @Override
  public PageInfo<Activity> selectForPage(ActivityQueryObject qo) {
    PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
    return new PageInfo<Activity>(activityMapper.selectForPage());
  }

  @Override
  public Activity checkVote(Long employeeId, Long activityId) {
    return activityMapper.checkVote(employeeId, activityId);
  }

  @Transactional
  @Override
  public void vote(Long employeeId, Long activityId, Long activityItemId) {
    activityMapper.vote(employeeId, activityId);
    activityMapper.updateNum(activityItemId);
  }


}
