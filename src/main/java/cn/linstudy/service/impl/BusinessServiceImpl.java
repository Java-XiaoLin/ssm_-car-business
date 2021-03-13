package cn.linstudy.service.impl;

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

}
