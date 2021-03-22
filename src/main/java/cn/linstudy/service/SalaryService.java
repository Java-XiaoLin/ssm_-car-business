package cn.linstudy.service;

import cn.linstudy.domain.Salary;
import cn.linstudy.qo.SalaryQueryObject;
import com.github.pagehelper.PageInfo;

/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/20 9:15
 */

public interface SalaryService{


    int deleteByPrimaryKey(Long id);

    int insert(Salary record);

    int insertSelective(Salary record);

    Salary selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Salary record);

    int updateByPrimaryKey(Salary record);

    PageInfo<Salary> selectForPage(SalaryQueryObject qo);
    }
