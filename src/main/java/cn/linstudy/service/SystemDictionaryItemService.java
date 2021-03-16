package cn.linstudy.service;

import cn.linstudy.domain.SystemDictionary;
import cn.linstudy.domain.SystemDictionaryItem;
import cn.linstudy.qo.SystemDictionaryItemQueryObject;
import cn.linstudy.qo.SystemDictionaryQueryObject;
import com.github.pagehelper.PageInfo;
import java.util.List;

/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/12 10:10
 */

public interface SystemDictionaryItemService{


    int deleteByPrimaryKey(Long id);

    int insert(SystemDictionaryItem record);

    int insertSelective(SystemDictionaryItem record);

    SystemDictionaryItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemDictionaryItem record);

    int updateByPrimaryKey(SystemDictionaryItem record);


    PageInfo<SystemDictionaryItem> selectForPage(SystemDictionaryItemQueryObject qo);

    List<SystemDictionaryItem> selectForQuery(SystemDictionaryItemQueryObject qo);

    void save(SystemDictionaryItem systemDictionaryItem);

    List<SystemDictionaryItem> selectAllByTypeId(Long typeId);
}
