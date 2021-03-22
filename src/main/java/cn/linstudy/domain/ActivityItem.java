package cn.linstudy.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/21 14:28
 */

/**
 * 投票选项表
 */
@ApiModel(value = "cn-linstudy-domain-ActivityItem")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityItem implements Serializable {

  @ApiModelProperty(value = "主键")
  private Long id;

  @ApiModelProperty(value = "内容")
  private String content;

  @ApiModelProperty(value = "投票数")
  private Integer num;

  @ApiModelProperty(value = "所属活动")
  private Long activityId;

  @ApiModelProperty(value = "封装投票的选项")
  Activity activity;

  private static final long serialVersionUID = 1L;
}