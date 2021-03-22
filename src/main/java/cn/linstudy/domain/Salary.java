package cn.linstudy.domain;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/20 9:15
 */

@ApiModel(value="工资实体")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salary implements Serializable {
    @ApiModelProperty(value="主键id")
    private Long id;

    @ApiModelProperty(value="工资金额")
    private BigDecimal money;

    @ApiModelProperty(value="年份")
    private Integer year;

    @ApiModelProperty(value="月份")
    private Integer month;

    @ApiModelProperty(value="员工")
    private Employee employee;

    @ApiModelProperty(value="发放方式")
    private SystemDictionaryItem payoutType;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    private static final long serialVersionUID = 1L;
}