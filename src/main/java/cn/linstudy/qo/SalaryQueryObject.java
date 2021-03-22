package cn.linstudy.qo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description 工资管理高级查询
 * @Author XiaoLin
 * @Date 2021/3/19 16:08
 */
@Data
@AllArgsConstructor
public class SalaryQueryObject extends QueryObject{

  @ApiModelProperty(value="关键字")
  private String keyword;

  @ApiModelProperty(value="发放方式id")
  private Long systemDictionaryItem_id;

  @ApiModelProperty(value="最低工资")
  private Integer minSalary;

  @ApiModelProperty(value="最高工资")
  private Integer maxSalary;
}
