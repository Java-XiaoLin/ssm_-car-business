package cn.linstudy.service;

import cn.linstudy.domain.Business;
    /**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/12 15:36
 */

public interface BusinessService{


    int deleteByPrimaryKey(Long id);

    int insert(Business record);

    int insertSelective(Business record);

    Business selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Business record);

    int updateByPrimaryKey(Business record);

}
