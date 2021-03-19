package cn.linstudy.service.impl;

import cn.linstudy.mapper.ConsumptionReportMapper;
import cn.linstudy.qo.ConsumptionReportQueryObject;
import cn.linstudy.service.CustomerReportService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/18 20:55
 */
@Service
public class CustomerReportServiceImpl implements CustomerReportService {

  @Autowired
  ConsumptionReportMapper consumptionReportMapper;

  @Override
  public PageInfo query(ConsumptionReportQueryObject qo) {
    PageHelper.startPage(qo.getCurrentPage(),qo.getPageSize());
    List<Map> query = consumptionReportMapper.query(qo);
    return new PageInfo(query);
  }
}
