package cn.linstudy.mapper;

import cn.linstudy.domain.Business;
import cn.linstudy.qo.BusinessQueryObject;
import java.util.List;
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

    List<Business> selectForPage(BusinessQueryObject qo);

    List<Business> selectAll();
}