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


    /**
        * @Description:根据id删除
        * @author XiaoLin
        * @date 2021/3/13
        * @Param: [id]
        * @return int
        */
    int deleteByPrimaryKey(Long id);
    
    /**
        * @Description:全部增加
        * @author XiaoLin
        * @date 2021/3/13
        * @Param: [department]
        * @return int
        */
    int insert(Department department);

    /**
        * @Description:有选择的增加
        * @author XiaoLin
        * @date 2021/3/13
        * @Param: [department]
        * @return int
        */
    int insertSelective(Department department);

    /**
        * @Description:通过id查询部门
        * @author XiaoLin
        * @date 2021/3/13
        * @Param: [id]
        * @return cn.linstudy.domain.Department
        */
    Department selectByPrimaryKey(Long id);

    /**
        * @Description:通过id有选择地修改部门
        * @author XiaoLin
        * @date 2021/3/13
        * @Param: [department]
        * @return int
        */
    int updateByPrimaryKeySelective(Department department);

    /**
        * @Description:通过id修改部门，全部属性1都会修改
        * @author XiaoLin
        * @date 2021/3/13
        * @Param: [record]
        * @return int
        */
    int updateByPrimaryKey(Department department);

    /**
        * @Description:分页查询（高级查询条件可选）
        * @author XiaoLin
        * @date 2021/3/13
        * @Param: [qo]
        * @return com.github.pagehelper.PageInfo<cn.linstudy.domain.Department>
        */
    PageInfo<Department> selectForPage(DepartmentQueryObject qo);

    /**
        * @Description:查询所有部门
        * @author XiaoLin
        * @date 2021/3/13
        * @Param: []
        * @return java.util.List<cn.linstudy.domain.Department>
        */
    List<Department> selectAll();
}
