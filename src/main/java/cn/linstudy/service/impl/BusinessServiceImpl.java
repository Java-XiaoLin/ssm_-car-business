package cn.linstudy.service.impl;

import cn.linstudy.qo.BusinessQueryObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.linstudy.mapper.BusinessMapper;
import cn.linstudy.domain.Business;
import cn.linstudy.service.BusinessService;
/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/12 15:36
 */

@Service
public class BusinessServiceImpl implements BusinessService{

    @Autowired
    private BusinessMapper businessMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return businessMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Business record) {
        return businessMapper.insert(record);
    }

    @Override
    public int insertSelective(Business record) {
        return businessMapper.insertSelective(record);
    }

    @Override
    public Business selectByPrimaryKey(Long id) {
        return businessMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Business record) {
        return businessMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Business record) {
        return businessMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Business> selectForPage(BusinessQueryObject qo) {
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
        return new PageInfo<Business>(businessMapper.selectForPage(qo));
    }

    /**
        * @Description:查询所有公司
        * @author XiaoLin
        * @date 2021/3/14
        * @Param: []
        * @return java.util.List<cn.linstudy.domain.Business>
        */
    @Override
    public List<Business> selectAll() {
        return businessMapper.selectAll();
    }

}
