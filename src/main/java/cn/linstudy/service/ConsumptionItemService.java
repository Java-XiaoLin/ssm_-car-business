package cn.linstudy.service;

import cn.linstudy.domain.ConsumptionItem;
import cn.linstudy.qo.response.ResponseResult;
import java.util.List;

/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/17 14:46
 */

public interface ConsumptionItemService{

      List<ConsumptionItem> selectByConsumptionId(Long consumptionId);


      void insert(ConsumptionItem consumptionItem);

      void update(ConsumptionItem consumptionItem);

      ResponseResult batchDelete(Long[] ids);
}
