package cn.linstudy.qo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/7 21:58
 */
@Data


public class ResponseResult {

  @ApiModelProperty(value = "是否成功")
  private boolean success;

  @ApiModelProperty(value = "消息")
  private String msg;

  @ApiModelProperty(value = "数据")
  private Object data;

  public ResponseResult(boolean success, String msg) {
    this.success = success;
    this.msg = msg;
  }

  public ResponseResult(boolean success, String msg, Object data) {
    this.success = success;
    this.msg = msg;
    this.data = data;
  }
}
