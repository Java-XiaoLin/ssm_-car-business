package cn.linstudy.mapper;

import cn.linstudy.domain.Activity;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/21 14:28
 */

@Mapper
public interface ActivityMapper {

  int deleteByPrimaryKey(Long id);

  int insert(Activity record);

  int insertSelective(Activity record);

  Activity selectByPrimaryKey(Long id);

  int updateByPrimaryKeySelective(Activity record);

  int updateByPrimaryKey(Activity record);

  List<Activity> selectForPage();

  Activity checkVote(@Param("employeeId") Long employeeId, @Param("activityId") Long activityId);

  void vote(@Param("employeeId") Long employeeId, @Param("activityId") Long activityId);

  void updateNum(Long activityItemId);
}