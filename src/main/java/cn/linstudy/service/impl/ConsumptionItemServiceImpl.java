package cn.linstudy.service.impl;

import cn.linstudy.qo.response.ResponseResult;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.linstudy.mapper.ConsumptionItemMapper;
import cn.linstudy.domain.ConsumptionItem;
import cn.linstudy.service.ConsumptionItemService;
/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/17 14:46
 */

@Service
public class ConsumptionItemServiceImpl implements ConsumptionItemService{

    @Autowired
    private ConsumptionItemMapper consumptionItemMapper;

    @Override
    public List<ConsumptionItem> selectByConsumptionId(Long consumptionId) {
        return consumptionItemMapper.selectByConsumptionId(consumptionId);
    }

    @Override
    public void insert(ConsumptionItem consumptionItem) {
        consumptionItemMapper.insert(consumptionItem);
    }

    @Override
    public void update(ConsumptionItem consumptionItem) {
        consumptionItemMapper.update(consumptionItem);
    }

    @Override
    public ResponseResult batchDelete(Long[] ids) {
        consumptionItemMapper.batchDelete(ids);
        return new ResponseResult(true,"批量删除成功,删除的id为"+ Arrays.toString(ids));
    }


}
