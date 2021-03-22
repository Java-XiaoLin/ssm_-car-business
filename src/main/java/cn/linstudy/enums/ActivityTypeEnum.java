package cn.linstudy.enums;

import lombok.Getter;

/**
 * @Description 投票类型选择的枚举
 * @Author XiaoLin
 * @Date 2021/3/21 16:11
 */
@Getter
public enum ActivityTypeEnum {

  SINGLE_CHOICE("单选", 0),
  MULTIPLE_CHOICE("多选", 1);

  private String type;
  private Integer code;

  ActivityTypeEnum(String type, Integer code) {
    this.code = code;
    this.type = type;
  }

  public static String getName(Integer code) {
    ActivityTypeEnum[] values = ActivityTypeEnum.values();
    for (ActivityTypeEnum activityTypeEnum : values) {
      if (activityTypeEnum.code.equals(code)) {
        return activityTypeEnum.type;
      }
    }
    return null;
  }

}
