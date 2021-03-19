package cn.linstudy.service;

import cn.linstudy.domain.Consumption;
import cn.linstudy.qo.ConsumptionQueryObject;
import com.github.pagehelper.PageInfo;

/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/16 11:26
 */

public interface ConsumptionService{


    int deleteByPrimaryKey(Long id);

    int insert(Consumption record);

    int insertSelective(Consumption record);

    Consumption selectByPrimaryKey(Long consumptionId);

    int updateByPrimaryKeySelective(Consumption record);

    int updateByPrimaryKey(Consumption record);

    PageInfo<Consumption> selectForPage(ConsumptionQueryObject qo);

    Consumption createConsumption(String ano);

}
