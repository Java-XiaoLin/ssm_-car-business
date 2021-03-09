package cn.linstudy.domain;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/7 19:46
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department implements Serializable {

    /**
     *id
     */
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     *部门名称

     */
    @ApiModelProperty(value = "部门名称 ")
        private String name;

        /**
         *部门简称
        */
        @ApiModelProperty(value = "部门简称")
        private String sn;

        /**
         *逻辑删除字段
         */
    @ApiModelProperty(value = "逻辑删除字段")
        private boolean status;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}