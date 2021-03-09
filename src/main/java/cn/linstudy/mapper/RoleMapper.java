package cn.linstudy.mapper;

import cn.linstudy.domain.Role;
import cn.linstudy.qo.RoleQueryObject;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/9 9:05
 */

@Mapper
public interface RoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectForPage(RoleQueryObject qo);

    List<Role> selectAll();

    void insertRelation(@Param("rId") Long rId, @Param("pId") Long pId);

    void deleteRelation(Long roleId);

}