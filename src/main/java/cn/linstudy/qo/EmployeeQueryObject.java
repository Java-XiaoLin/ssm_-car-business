package cn.linstudy.qo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description 员工模糊查询
 * @Author XiaoLin
 * @Date 2021/3/7 19:56
 */
@Data
@AllArgsConstructor
public class EmployeeQueryObject extends QueryObject{

  @ApiModelProperty(value = "关键字")
  private String keyword;

  @ApiModelProperty(value = "部门id")
  private Integer dept_id;
}
