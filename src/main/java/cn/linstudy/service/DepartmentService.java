package cn.linstudy.service;

import cn.linstudy.domain.Department;
import cn.linstudy.qo.DepartmentQueryObject;
import cn.linstudy.qo.QueryObject;
import com.github.pagehelper.PageInfo;
import java.util.List;

/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/7 19:46
 */

public interface DepartmentService{


    int deleteByPrimaryKey(Long id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    PageInfo<Department> selectForPage(DepartmentQueryObject qo);

    List<Department> selectAll();
}
