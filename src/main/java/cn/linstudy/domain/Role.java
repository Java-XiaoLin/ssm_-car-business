package cn.linstudy.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/9 9:05
 */

@ApiModel(value="角色实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
    @ApiModelProperty(value="主键")
    private Long id;

    @ApiModelProperty(value="角色名称")
    private String name;

    @ApiModelProperty(value="角色编码")
    private String sn;

    @ApiModelProperty(value="逻辑删除字段")
    private boolean status;

    private static final long serialVersionUID = 1L;
}