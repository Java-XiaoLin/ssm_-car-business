package cn.linstudy.mapper;

import cn.linstudy.domain.Department;
import cn.linstudy.qo.DepartmentQueryObject;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/7 19:46
 */

@Mapper
public interface DepartmentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> selectForPage(DepartmentQueryObject qo);

    List<Department> selectAll();
}