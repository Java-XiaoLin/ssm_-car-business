package cn.linstudy.service;

import cn.linstudy.domain.Business;
import cn.linstudy.qo.BusinessQueryObject;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.w3c.dom.ls.LSInput;

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

    PageInfo<Business> selectForPage(BusinessQueryObject qo);

    List<Business> selectAll();
}
