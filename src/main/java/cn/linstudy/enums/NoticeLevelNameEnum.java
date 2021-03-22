package cn.linstudy.enums;

/**
 * @Description 通知级别的枚举类
 * @Author XiaoLin
 * @Date 2021/3/19 16:30
 */
public enum NoticeLevelNameEnum {

  URGENT(1,"紧急"),
  IMPORTANT(2,"重要"),
  ORDINARY(3,"普通");

  private Integer level;
  private String description;

  NoticeLevelNameEnum(Integer level,String description){
    this.level = level;
    this.description = description;
  }

  public static String getDescription(Integer level){
    NoticeLevelNameEnum[] values = NoticeLevelNameEnum.values();
    for (NoticeLevelNameEnum levelNameEnum : values) {
      if (levelNameEnum.level.equals(level)){
        return levelNameEnum.description;
      }
    }
    return null;
  }

}
