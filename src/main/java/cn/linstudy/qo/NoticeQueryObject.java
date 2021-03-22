package cn.linstudy.qo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/19 16:08
 */
@Data
@AllArgsConstructor
public class NoticeQueryObject extends QueryObject{

  private Integer level;

  private Boolean read;

  private Integer status;



}
