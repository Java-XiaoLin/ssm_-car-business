package cn.linstudy.service.impl;

import cn.linstudy.qo.SystemDictionaryQueryObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.linstudy.mapper.SystemDictionaryMapper;
import cn.linstudy.domain.SystemDictionary;
import cn.linstudy.service.SystemDictionaryService;
/**
 * @Description 数据字典目录实现类
 * @Author  XiaoLin
 * @Date  2021/3/12 10:10
 */

@Service
public class SystemDictionaryServiceImpl implements SystemDictionaryService{

    @Autowired
    private SystemDictionaryMapper systemDictionaryMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return systemDictionaryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SystemDictionary record) {
        return systemDictionaryMapper.insert(record);
    }

    @Override
    public int insertSelective(SystemDictionary record) {
        return systemDictionaryMapper.insertSelective(record);
    }

    @Override
    public SystemDictionary selectByPrimaryKey(Long id) {
        return systemDictionaryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SystemDictionary record) {
        return systemDictionaryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SystemDictionary record) {
        return systemDictionaryMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<SystemDictionary> selectForPage(SystemDictionaryQueryObject qo) {
        PageHelper.startPage(qo.getCurrentPage(),qo.getPageSize());
        return new PageInfo<SystemDictionary>(systemDictionaryMapper.selectForPage(qo));
    }

    @Override
    public List<SystemDictionary> selectAll() {
        return systemDictionaryMapper.selectAll();
    }

}
