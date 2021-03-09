package cn.linstudy.service.impl;

import cn.linstudy.domain.Permission;
import cn.linstudy.qo.RoleQueryObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.linstudy.domain.Role;
import cn.linstudy.mapper.RoleMapper;
import cn.linstudy.service.RoleService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/9 9:05
 */

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Role record) {
        return roleMapper.insert(record);
    }

    @Override
    public int insertSelective(Role record) {
        return roleMapper.insertSelective(record);
    }

    @Override
    public Role selectByPrimaryKey(Long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Role> selectForPage(RoleQueryObject qo) {
        PageHelper.startPage(qo.getCurrentPage(),qo.getPageSize());
        List<Role> roles = roleMapper.selectForPage(qo);
        return new PageInfo<Role>(roles);
    }

    @Override
    public List<Role> selectAll() {
        return roleMapper.selectAll();
    }


    @Override
    @Transactional
    public void save(Role role, Long[] ids) {
        // 不仅仅要增加角色，而且要维护角色_权限中间表
        roleMapper.insertSelective(role);
        if (ids != null && ids.length > 0){ // 说明传进来的权限值不为空
            for (Long pId : ids){
                roleMapper.insertRelation(role.getId(),pId);// 新增完成之后需要维护中间表关系
            }
        }
    }

    @Override
    @Transactional
    public void update(Role role, Long[] ids) {
        // 在修改之前先删除关系表之间的关系，再重新插入新的
        roleMapper.updateByPrimaryKeySelective(role);
        roleMapper.deleteRelation(role.getId());
        if (ids != null     ){
            for (Long pId : ids){
                roleMapper.insertRelation(role.getId(),pId);
            }
        }
    }

}
