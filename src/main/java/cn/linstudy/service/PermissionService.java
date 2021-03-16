package cn.linstudy.service;

import cn.linstudy.domain.Permission;
import cn.linstudy.qo.PermissionQueryObject;
import com.github.pagehelper.PageInfo;
import java.util.List;

/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/8 21:29
 */

public interface PermissionService{


    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    PageInfo<Permission> selectForPage(PermissionQueryObject qo);

    /**
        * @Description:重新加载权限
        * @author XiaoLin
        * @date 2021/3/13
        * @Param: []
        * @return void
        */
    void reload();

    /**
        * @Description:查询所有权限信息
        * @author XiaoLin
        * @date 2021/3/13
        * @Param: []
        * @return java.util.List<cn.linstudy.domain.Permission>
        */
    List<Permission> selectAll();

    List<Permission> selectPermissionByRoleId(Long roleId);
}
