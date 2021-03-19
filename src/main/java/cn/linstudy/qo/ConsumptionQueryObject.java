package cn.linstudy.qo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Description 结算单高级查询
 * @Author XiaoLin
 * @Date 2021/3/16 12:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsumptionQueryObject extends QueryObject{

  // 结算单状态
  private Integer status;

  // 门店
  private Long businessId;

  // 预约类型
  private Integer reservationType;

  // 客户名称
  private String customerName;

  // 客户手机号码
  private String customerPhone;

  // 预约单流水号
  private String appointmentAno;

  // 结算单流水号
  private String cno;

  // 结算开始时间
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date startDate;

  // 结算结束时间
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date endDate;

}
