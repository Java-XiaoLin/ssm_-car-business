package cn.linstudy.mapper;

import cn.linstudy.domain.ActivityItem;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 投票管理
 * @Author XiaoLin
 * @Date 2021/3/21 14:28
 */

@Mapper
public interface ActivityItemMapper {

  int deleteByPrimaryKey(Long id);

  int insert(ActivityItem record);

  int insertSelective(ActivityItem record);

  ActivityItem selectByPrimaryKey(Long id);

  int updateByPrimaryKeySelective(ActivityItem record);

  int updateByPrimaryKey(ActivityItem record);

  List<ActivityItem> selectActivityItemByActivityId(Long activityId);

}