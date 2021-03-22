package cn.linstudy.enums;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/21 16:20
 */
public enum ActivityStatusEnum {

  OVER("已结束", 0),
  VOTING("投票中", 1);

  private String status;
  private Integer code;

  ActivityStatusEnum(String status, Integer code) {
    this.code = code;
    this.status = status;
  }

  public static String getStatusName(Integer code) {
    for (ActivityStatusEnum activityStatusEnum : ActivityStatusEnum.values()) {
      if (activityStatusEnum.code.equals(code)) {
        return activityStatusEnum.status;
      }
    }
    return null;
  }
}
