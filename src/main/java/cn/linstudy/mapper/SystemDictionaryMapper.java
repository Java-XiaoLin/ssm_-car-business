package cn.linstudy.mapper;

import cn.linstudy.domain.SystemDictionary;
import cn.linstudy.qo.SystemDictionaryQueryObject;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/12 10:10
 */

@Mapper
public interface SystemDictionaryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemDictionary record);

    int insertSelective(SystemDictionary record);

    SystemDictionary selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemDictionary record);

    int updateByPrimaryKey(SystemDictionary record);

    List<SystemDictionary> selectForPage(SystemDictionaryQueryObject qo);

    List<SystemDictionary> selectAll();
}