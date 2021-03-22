package cn.linstudy.service.impl;

import cn.linstudy.qo.SalaryQueryObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.linstudy.domain.Salary;
import cn.linstudy.mapper.SalaryMapper;
import cn.linstudy.service.SalaryService;
/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/20 9:15
 */

@Service
public class SalaryServiceImpl implements SalaryService{

    @Autowired
    private SalaryMapper salaryMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return salaryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Salary record) {
        return salaryMapper.insert(record);
    }

    @Override
    public int insertSelective(Salary record) {
        return salaryMapper.insertSelective(record);
    }

    @Override
    public Salary selectByPrimaryKey(Long id) {
        return salaryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Salary record) {
        return salaryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Salary record) {
        return salaryMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Salary> selectForPage(SalaryQueryObject qo) {
        PageHelper.startPage(qo.getCurrentPage(),qo.getPageSize());
        return new PageInfo<Salary>(salaryMapper.selectForPage(qo));
    }

}
