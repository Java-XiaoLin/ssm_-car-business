package cn.linstudy.service;

import cn.linstudy.domain.Role;
import cn.linstudy.qo.RoleQueryObject;
import com.github.pagehelper.PageInfo;
import java.util.List;

/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/9 9:05
 */

public interface RoleService{


    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    PageInfo<Role> selectForPage(RoleQueryObject qo);

    List<Role> selectAll();

    void save(Role role, Long[] ids);

    void update(Role role, Long[] ids);
}
