package cn.linstudy.qo;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/14 16:03
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentQueryObject extends QueryObject{

  @ApiModelProperty(value="预约单流水号")
  private String ano;

  @ApiModelProperty(value="业务大类id")
  private Long categoryId;

  @ApiModelProperty(value="预约单状态 （预约中/履行中/消费中/归档/废弃单）")
  private Integer status;

  @ApiModelProperty(value="预约门店Id")
  private Long businessId;

  @ApiModelProperty(value="联系人名称")
  private String contactName;

  @ApiModelProperty(value="联系电话")
  private String contactTel;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @ApiModelProperty(value = "开始时间")
  private Date startTime;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @ApiModelProperty(value = "结束时间")
  private Date endTime;
}
