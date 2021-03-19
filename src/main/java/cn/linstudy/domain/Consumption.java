package cn.linstudy.domain;

import cn.linstudy.enums.ConsumptionEnum;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/16 11:26
 */

/**
    * 结算单
    */
@ApiModel(value="结算单实体")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consumption implements Serializable {
    @ApiModelProperty(value="主键")
    private Long id;

    @ApiModelProperty(value="消费单流水号")
    private String cno;

    @ApiModelProperty(value="消费单状态 （待结算/待审核/归档/坏账）")
    private Integer status;

    @ApiModelProperty(value="总消费金额")
    private BigDecimal totalAmount;

    @ApiModelProperty(value="实收金额")
    private BigDecimal payAmount;

    @ApiModelProperty(value="优惠金额")
    private BigDecimal discountAmount;

    @ApiModelProperty(value="结算备注")
    private String info;

    @ApiModelProperty(value="结算时间")
    private Date payTime;

    @ApiModelProperty(value="客户名称")
    private String customerName;

    @ApiModelProperty(value="结算人")
    private Employee payeeEmployee;

    @ApiModelProperty(value="客户联系方式")
    private String customerTel;

    @ApiModelProperty(value="车牌信息记录")
    private String carLicence;

    @ApiModelProperty(value="车型记录")
    private String carType;

    @ApiModelProperty(value="关联预约单")
    private String appointmentAno;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @ApiModelProperty(value="进店时间")
    private Date checkinTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @ApiModelProperty(value="离店时间")
    private Date checkoutTime;

    @ApiModelProperty(value="消费门店")
    private Long businessId;

    @ApiModelProperty(value="关联的门店信息")
    private Business business;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    @ApiModelProperty(value="创建人")
    private Employee createEmployee;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @ApiModelProperty(value="审核时间")
    private Date auditTime;

    @ApiModelProperty(value="审核人")
    private Employee auditorEmployee;

    public String getStatusName(){
        return ConsumptionEnum.findName(this.status);
    }

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }

    private static final long serialVersionUID = 1L;
}