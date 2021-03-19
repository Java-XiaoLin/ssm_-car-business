package cn.linstudy.service;

import cn.linstudy.qo.ConsumptionReportQueryObject;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/18 20:48
 */
@Service
public interface CustomerReportService{

  PageInfo query(ConsumptionReportQueryObject qo);
}
