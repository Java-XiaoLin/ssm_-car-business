package cn.linstudy.mapper;

import cn.linstudy.qo.ConsumptionReportQueryObject;
import java.util.List;
import java.util.Map;
import org.mapstruct.Mapper;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/18 20:56
 */
@Mapper
public interface ConsumptionReportMapper {

    List<Map> query(ConsumptionReportQueryObject qo);
}
