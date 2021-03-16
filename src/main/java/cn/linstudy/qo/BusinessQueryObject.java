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
 * @Date 2021/3/13 14:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessQueryObject extends QueryObject{

  @ApiModelProperty(value="门店名称")
  private String name;
  @ApiModelProperty(value="经营范围")
  private String scope;
  @ApiModelProperty(value="门店联系方式")
  private String tel;
  @ApiModelProperty(value="法人名字")
  private String legalName;
  @ApiModelProperty(value="开始经营日期")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date startDate;
  @ApiModelProperty(value="结束经营日期")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date endDate;
}
