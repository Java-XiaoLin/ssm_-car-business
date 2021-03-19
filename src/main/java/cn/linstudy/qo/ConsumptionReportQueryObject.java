package cn.linstudy.qo;

import cn.linstudy.enums.ConsumptionReportEnums;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/18 20:49
 */
@Getter
@Setter
public class ConsumptionReportQueryObject extends QueryObject {

  private String groupByName = ConsumptionReportEnums.BUSINESS.name();//BUSINESS
  private Long businessId;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date startDate;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date endDate;
  private Integer typeId;

  public String getGroupBy() {
    return ConsumptionReportEnums.valueOf(this.groupByName).getSql();
  }
}
