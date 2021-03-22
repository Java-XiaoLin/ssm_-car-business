package cn.linstudy.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/22 9:21
 */

@ApiModel(value = "cn-linstudy-domain-MessageReply")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageReply implements Serializable {

  @ApiModelProperty(value = "")
  private Long id;

  @ApiModelProperty(value = "回复内容")
  private String content;

  @ApiModelProperty(value = "所属留言对象")
  private Long messageBoardId;

  @ApiModelProperty(value = "回复人")
  private Employee replyUser;

  @ApiModelProperty(value = "回复时间")
  private Date createTime;


  private static final long serialVersionUID = 1L;
}