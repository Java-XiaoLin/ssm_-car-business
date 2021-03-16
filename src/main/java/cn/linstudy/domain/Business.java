package cn.linstudy.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Description 商户门店
 * @Author  XiaoLin
 * @Date  2021/3/12 15:36
 */

/**
    * 商户门店
    */
@ApiModel(value="商户门店实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Business implements Serializable {
    @ApiModelProperty(value="主键")
    private Long id;

    @ApiModelProperty(value="门店名称")
    private String name;

    @ApiModelProperty(value="门店介绍")
    private String intro;

    @ApiModelProperty(value="经营范围")
    private String scope;

    @ApiModelProperty(value="门店电话")
    private String tel;

    @ApiModelProperty(value="门店地址")
    private String address;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value="经营日期")
    private Date openDate;

    @ApiModelProperty(value="营业执照图片")
    private String licenseImg;

    @ApiModelProperty(value="营业执照号码")
    private String licenseNumber;

    @ApiModelProperty(value="法人姓名")
    private String legalName;

    @ApiModelProperty(value="法人电话")
    private String legalTel;

    @ApiModelProperty(value="法人身份证")
    private String legalIdcard;

    @ApiModelProperty(value="门店性质(总店/分店)")
    private Boolean mainStore;

    private static final long serialVersionUID = 1L;
}