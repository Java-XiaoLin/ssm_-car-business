package cn.linstudy.mapper;

import cn.linstudy.domain.Business;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/12 15:36
 */

@Mapper
public interface BusinessMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Business record);

    int insertSelective(Business record);

    Business selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Business record);

    int updateByPrimaryKey(Business record);
}