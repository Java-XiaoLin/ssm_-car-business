package cn.linstudy.vo;

import cn.linstudy.domain.Department;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/10 17:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeInsertVO {


  @ApiModelProperty(value = "用户名")
  private String username;

  @ApiModelProperty(value = "真实姓名")
  private String name;

  @ApiModelProperty(value = "密码")
  private String password;

  @ApiModelProperty(value = "邮箱")
  private String email;

  @ApiModelProperty(value = "是否为超级管理员")
  private Boolean admin;

  @ApiModelProperty(value = "状态")
  private Boolean status;


}
