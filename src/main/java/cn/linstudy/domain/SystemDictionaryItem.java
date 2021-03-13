package cn.linstudy.domain;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/12 10:10
 */

@ApiModel(value="数据实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemDictionaryItem implements Serializable {
    @ApiModelProperty(value="主键")
    private Long id;

    @ApiModelProperty(value="标题")
    private String title;

    @ApiModelProperty(value="序号")
    private Integer sequence;

    @ApiModelProperty(value="所属目录")
    private Long typeId;

    @ApiModelProperty(value="上级明细")
    private Long parentId;

    @ApiModelProperty(value="所属目录对象")
    private SystemDictionary systemDictionary;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}