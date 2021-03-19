package cn.linstudy.mapper;

import cn.linstudy.domain.ConsumptionItem;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/17 14:46
 */

@Mapper
public interface ConsumptionItemMapper {

    List<ConsumptionItem> selectByConsumptionId(Long consumptionId);

    List<ConsumptionItem> selectAll();

    void insert(ConsumptionItem consumptionItem);

    void update(ConsumptionItem consumptionItem);

    void batchDelete(@Param("ids") Long[] ids);
}