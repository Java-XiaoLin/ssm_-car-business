package cn.linstudy.domain;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/17 14:46
 */

/**
    * 结算单明细
    */
@ApiModel(value="结算单明细")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ConsumptionItem implements Serializable {
    /** 主键*/
    private Long id;

    /** 业务大类*/
    private SystemDictionaryItem category;

    /** 业务小类*/
    private SystemDictionaryItem categoryItem;

    /** 结算类型*/
    private SystemDictionaryItem payType;

    /** 应收金额*/
    private BigDecimal amount;

    /** 实收金额*/
    private BigDecimal payAmount;

    /** 优惠金额*/
    private BigDecimal discountAmount;

    /** 创建人*/
    private Employee createUser;

    /** 创建时间*/
    private Date createTime;

    /** 结算单流水号*/
    private String cno;

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }

}