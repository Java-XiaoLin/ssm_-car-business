package cn.linstudy.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 员工实体类
 * @Author XiaoLin
 * @Date 2021/3/8 13:55
 */


@ApiModel(value = "员工实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

  @ApiModelProperty(value = "主键id")
  private Long id;

  @ApiModelProperty(value = "用户名")
  private String username;

  @ApiModelProperty(value = "真实姓名")
  private String name;

  @ApiModelProperty(value = "密码")
  private String password;

  @ApiModelProperty(value = "邮箱")
  private String email;

  @ApiModelProperty(value = "年龄")
  private Integer age;

  @ApiModelProperty(value = "是否为超级管理员")
  private Boolean admin;

  @ApiModelProperty(value = "部门id")
  private Long deptId;

  @ApiModelProperty(value = "状态")
  private Boolean status;

  @ApiModelProperty(value = "部门")
  private Department department;

  private static final long serialVersionUID = 1L;


}