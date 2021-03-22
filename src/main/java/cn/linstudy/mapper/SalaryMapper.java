package cn.linstudy.mapper;

import cn.linstudy.domain.Salary;
import cn.linstudy.qo.SalaryQueryObject;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/20 9:15
 */

@Mapper
public interface SalaryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Salary record);

    int insertSelective(Salary record);

    Salary selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Salary record);

    int updateByPrimaryKey(Salary record);

    List<Salary> selectForPage(SalaryQueryObject qo);
}