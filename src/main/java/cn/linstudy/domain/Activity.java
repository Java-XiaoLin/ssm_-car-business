package cn.linstudy.domain;

import cn.linstudy.enums.ActivityTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 投票活动实体类
 * @Author XiaoLin
 * @Date 2021/3/21 14:28
 */

@ApiModel(value = "投票活动表")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity implements Serializable {

  @ApiModelProperty(value = "")
  private Long id;

  @ApiModelProperty(value = "主题")
  private String title;

  @ApiModelProperty(value = "类型(单选0/多选1/ 等等)")
  private Integer type;

  public String getTypeName() {
    return ActivityTypeEnum.getName(this.type);
  }

  @ApiModelProperty(value = "状态(1投票中/0停止投票)")
  private Boolean status;


  private static final long serialVersionUID = 1L;
}