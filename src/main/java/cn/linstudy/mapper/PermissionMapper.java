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
    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    List<Permission> selectForPage(PermissionQueryObject qo);

    List<Permission> selectAll();

    void deleteByExpression(String expression);

  List<Permission> selectPermissionByRoleId(Long roleId);
}