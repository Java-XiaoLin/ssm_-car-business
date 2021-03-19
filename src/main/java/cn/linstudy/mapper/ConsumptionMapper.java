package cn.linstudy.mapper;

import cn.linstudy.domain.Consumption;
import cn.linstudy.qo.ConsumptionQueryObject;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/16 11:26
 */

@Mapper
public interface ConsumptionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Consumption record);

    int insertSelective(Consumption consumption);

    Consumption selectByPrimaryKey(Long consumptionId);

    int updateByPrimaryKeySelective(Consumption consumption);

    int updateByPrimaryKey(Consumption consumption);

    List<Consumption> selectForPage(ConsumptionQueryObject qo);
}