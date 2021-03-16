package cn.linstudy.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 权限实体类
 * @Author  XiaoLin
 * @Date  2021/3/8 21:29
 */

@ApiModel(value="权限实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission implements Serializable {
    @ApiModelProperty(value="主键")
    private Long id;

    @ApiModelProperty(value="权限名称")
    private String name;

    @ApiModelProperty(value="权限表达式")
    private String expression;

    private static final long serialVersionUID = 1L;
}