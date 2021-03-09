package cn.linstudy.qo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 这个是查询结果集的父类封装
 * @Author XiaoLin
 * @Date 2021/3/2 13:48
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QueryObject {
  private Integer currentPage = 1;
  private Integer pageSize = 5;

}
