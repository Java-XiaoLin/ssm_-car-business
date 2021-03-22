package cn.linstudy.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/19 16:39
 */
@Getter
public enum NoticeStatusEnum {

  RELEASE(1,"已发布"),
  NO_release(2,"未发布"),
  DRAFT(3,"存入草稿");

  private Integer value;
  private String status;

  NoticeStatusEnum(Integer value,String status){
    this.value = value;
    this.status = status;
  }

  public static String getStatus(Integer value){
    NoticeStatusEnum[] values = NoticeStatusEnum.values();
    for (NoticeStatusEnum noticeStatusEnum : values) {
      if (noticeStatusEnum.value.equals(value)){
        return noticeStatusEnum.status;
      }
    }
    return null;
  }

}
