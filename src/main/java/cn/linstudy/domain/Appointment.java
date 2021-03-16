package cn.linstudy.domain;

import cn.linstudy.enums.AppointmentEnum;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Description 预约单实体类
 * @Author  XiaoLin
 * @Date  2021/3/14 14:42
 */

/**
    * 预约单
    */
@ApiModel(value="预约单实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment implements Serializable {
    @ApiModelProperty(value="主键")
    private Long id;

    @ApiModelProperty(value="预约单流水号")
    private String ano;

    @ApiModelProperty(value="预约单状态 （预约中/履行中/消费中/归档/废弃单）")
    private Integer status;

    @ApiModelProperty(value="业务大类id")
    private Long categoryId;

    @ApiModelProperty(value="业务大类")
    private SystemDictionaryItem category;

    @ApiModelProperty(value="预约说明")
    private String info;

    @ApiModelProperty(value="联系电话")
    private String contactTel;

    @ApiModelProperty(value="联系人名称")
    private String contactName;

    @ApiModelProperty(value="预约门店Id")
    private Long businessId;

    @ApiModelProperty(value="预约门店")
    private Business business;

    @ApiModelProperty(value="创建时间")
    private Date createTime;

    @ApiModelProperty(value="预约时间")
    @DateTimeFormat(pattern ="yyyy-MM-dd") // 前台注入参数到后台对象的时候需要执行的解析格式
    @JSONField(format = "yyyy-MM-dd")
    private Date appointmentTime;

    private static final long serialVersionUID = 1L;

    public String getStatusName(){
        return AppointmentEnum.findName(this.status);
    }

    @Override
    public String toString() {
       return JSON.toJSONString(this);
    }
}