package cn.linstudy.service.impl;
import cn.linstudy.qo.SystemDictionaryItemQueryObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.linstudy.domain.SystemDictionaryItem;
import cn.linstudy.mapper.SystemDictionaryItemMapper;
import cn.linstudy.service.SystemDictionaryItemService;
/**
 * @Description 数据字典详情的实现类
 * @Author  XiaoLin
 * @Date  2021/3/12 10:10
 */

@Service
public class SystemDictionaryItemServiceImpl implements SystemDictionaryItemService{

    @Autowired
    private SystemDictionaryItemMapper systemDictionaryItemMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return systemDictionaryItemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SystemDictionaryItem record) {
        return systemDictionaryItemMapper.insert(record);
    }

    @Override
    public int insertSelective(SystemDictionaryItem record) {
        return systemDictionaryItemMapper.insertSelective(record);
    }

    @Override
    public SystemDictionaryItem selectByPrimaryKey(Long id) {
        return systemDictionaryItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SystemDictionaryItem record) {
        return systemDictionaryItemMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SystemDictionaryItem record) {
        return systemDictionaryItemMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<SystemDictionaryItem> selectForPage(SystemDictionaryItemQueryObject qo) {
        PageHelper.startPage(qo.getCurrentPage(),qo.getPageSize());
        return new PageInfo(systemDictionaryItemMapper.selectForPage(qo));
    }

    @Override
    public List<SystemDictionaryItem> selectForQuery(SystemDictionaryItemQueryObject qo) {
        return systemDictionaryItemMapper.selectForQuery(qo);
    }


}
