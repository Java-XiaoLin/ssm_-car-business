package cn.linstudy.domain;

import cn.linstudy.enums.NoticeLevelNameEnum;
import cn.linstudy.enums.NoticeStatusEnum;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/20 14:16
 */

@ApiModel(value = "cn-linstudy-domain-Notice")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice implements Serializable {

  @ApiModelProperty(value = "主键id")
  private Long id;

  @ApiModelProperty(value = "公告标题")
  private String title;

  @ApiModelProperty(value = "内容")
  private String content;

  @ApiModelProperty(value = "创建人")
  private Employee createPeople;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @ApiModelProperty(value = "创建时间")
  private Date createTime;

  @ApiModelProperty(value = "公告级别（1为紧急，2为重要，3为普通）")
  private Integer level;

  public String getLevelName() {
    return NoticeLevelNameEnum.getDescription(this.level);
  }

  @ApiModelProperty(value = "是否发布（1为已发布，2为未发布）")
  private Integer status;

  public String getStatusName() {
    return NoticeStatusEnum.getStatus(this.status);
  }

  @ApiModelProperty(value = "逻辑删除字段（true为删除，false为未删除）")
  private boolean deleted;

  @ApiModelProperty(value = "关联属性，用户所读的公告")
  NoticeEmployee notices;

  @ApiModelProperty(value = "计算时间差属性")
  private String calTime;

  @Override
  public String toString() {
    return JSON.toJSONString(this);
  }

  private static final long serialVersionUID = 1L;
}