package cn.linstudy.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/22 9:15
 */

@ApiModel(value = "cn-linstudy-domain-MessageBoard")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageBoard implements Serializable {

  @ApiModelProperty(value = "")
  private Long id;

  @ApiModelProperty(value = "昵称")
  private String nickname;

  @ApiModelProperty(value = "留言内容")
  private String content;

  @ApiModelProperty(value = "留言时间")
  private Date createTime;

  @ApiModelProperty(value = "业务大类")
  private SystemDictionary category;

  @ApiModelProperty(value = "业务小类")
  private SystemDictionaryItem categoryItem;

  @ApiModelProperty(value = "回复状态(未回复/已回复)")
  private Boolean replyStatus;

  @ApiModelProperty(value = "回复对象")
  private List<MessageReply> messageReply;

  public int getNum() {
    return messageReply.size();
  }


  private static final long serialVersionUID = 1L;
}