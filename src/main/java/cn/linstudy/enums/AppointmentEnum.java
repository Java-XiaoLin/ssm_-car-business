package cn.linstudy.enums;

import lombok.Getter;

/**
 * @Description 预约单状态的枚举类
 * @Author XiaoLin
 * @Date 2021/3/14 17:09
 */
@Getter
public enum AppointmentEnum {

  PEND("待确认",0),
  PERFORM("履行中",1),
  CONSUME("消费中",2),
  FINISH("归档",3),
  FAILURE("废弃",4);

  private Integer value;
  private String name;

  AppointmentEnum(String name, Integer value) {
    this.name = name;
    this.value = value;
  }

  public static String findName(Integer value){
    AppointmentEnum[] values = AppointmentEnum.values();
    for(AppointmentEnum appointmentEnums:values){
      if(appointmentEnums.value.equals(value)){
        return appointmentEnums.name;
      }
    }
    return null;
  }
}
