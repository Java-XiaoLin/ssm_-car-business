package cn.linstudy.mapper;

import cn.linstudy.domain.Permission;
import cn.linstudy.qo.PermissionQueryObject;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/8 21:29
 */

@Mapper
public interface PermissionMapper {
    /**
        * @Description:根据id删除权限
        * @author XiaoLin
        * @date 2021/3/13
        * @Param: [id]
        * @return int
        */
    int deleteByPrimaryKey(Long id);

    /**
        * @Description:插入权限
        * @author XiaoLin
        * @date 2021/3/13
        * @Param: [permission]
        * @return int
        */
    int insert(Permission permission);

    int insertSelective(Permission permission);

    Permission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Permission permission);

    int updateByPrimaryKey(Permission permission);

    List<Permission> selectForPage(PermissionQueryObject qo);

    /**
        * @Description:查询所有权限
        * @author XiaoLin
        * @date 2021/3/13
        * @Param: []
        * @return java.util.List<cn.linstudy.domain.Permission>
        */
    List<Permission> selectAll();

    /**
        * @Description:通过表达式删除权限
        * @author XiaoLin
        * @date 2021/3/13
        * @Param: [expression]
        * @return void
        */
    void deleteByExpression(String expression);

    List<Permission> selectPermissionByRoleId(Long roleId);
}