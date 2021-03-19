package cn.linstudy.enums;
import lombok.Getter;

/**
 * @Description 消费单类型的枚举
 * @Author XiaoLin
 * @Date 2021/3/16 11:35
 */
@Getter
public enum ConsumptionEnum {

  CONSUME("待结算",0),
  AUDIT("待审核",1),
  FINISH("归档",2),
  FAILURE("坏账",3);

  private String name;
  private Integer value;

  ConsumptionEnum (String name,Integer value){
   this.name = name;
   this.value = value;
  }

  public static String findName(Integer value){
    ConsumptionEnum[] values = ConsumptionEnum.values();
    for (ConsumptionEnum consumptionEnum : values) {
      if (consumptionEnum.value.equals(value)){
        return consumptionEnum.name;
      }
    }
    return null;
  }

}
