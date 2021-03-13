package cn.linstudy.service;

import cn.linstudy.domain.SystemDictionary;
import cn.linstudy.qo.SystemDictionaryQueryObject;
import com.github.pagehelper.PageInfo;
import java.util.List;

/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/12 10:10
 */

public interface SystemDictionaryService{


    int deleteByPrimaryKey(Long id);

    int insert(SystemDictionary record);

    int insertSelective(SystemDictionary record);

    SystemDictionary selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemDictionary record);

    int updateByPrimaryKey(SystemDictionary record);

    PageInfo<SystemDictionary> selectForPage(SystemDictionaryQueryObject qo);

    List<SystemDictionary> selectAll();
}
