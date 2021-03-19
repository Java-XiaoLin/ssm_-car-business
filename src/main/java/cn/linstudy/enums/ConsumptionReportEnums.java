package cn.linstudy.enums;

import lombok.Data;
import lombok.Getter;

/**
 * @Description 数据报表显示的枚举类
 * @Author XiaoLin
 * @Date 2021/3/18 20:50
 */
@Getter
public enum ConsumptionReportEnums {

  BUSINESS("门店","business.name"),
  YEAR("年","DATE_FORMAT(consumption.pay_time,'%Y')"),
  MONTH("月","DATE_FORMAT(consumption.pay_time,'%Y%m')"),
  DAY("日","DATE_FORMAT(consumption.pay_time,'%Y%m%d')");

  private String name;
  private String sql;

  ConsumptionReportEnums(String name,String sql){
    this.name = name;
    this.sql = sql;
  }
}
