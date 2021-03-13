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

@ApiModel(value="数据字典目录实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemDictionary implements Serializable {
    @ApiModelProperty(value="主键")
    private Long id;

    @ApiModelProperty(value="编码")
    private String sn;

    @ApiModelProperty(value="标题")
    private String title;

    @ApiModelProperty(value="简介")
    private String intro;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}