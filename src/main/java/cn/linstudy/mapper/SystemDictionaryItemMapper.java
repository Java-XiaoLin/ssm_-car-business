package cn.linstudy.mapper;

import cn.linstudy.domain.SystemDictionaryItem;
import cn.linstudy.qo.SystemDictionaryItemQueryObject;
import cn.linstudy.qo.SystemDictionaryQueryObject;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/12 10:10
 */

@Mapper
public interface SystemDictionaryItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemDictionaryItem record);

    int insertSelective(SystemDictionaryItem record);

    SystemDictionaryItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemDictionaryItem record);

    int updateByPrimaryKey(SystemDictionaryItem record);


    List<SystemDictionaryItem> selectForPage(SystemDictionaryItemQueryObject qo);

    List<SystemDictionaryItem> selectForQuery(SystemDictionaryItemQueryObject qo);

    List<SystemDictionaryItem> selectAllByTypeId(Long typeId);
}