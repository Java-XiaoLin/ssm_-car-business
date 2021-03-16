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

    /**
        * @Description:通过id删除
        * @author XiaoLin
        * @date 2021/3/13
        * @Param: [id]
        * @return int
        */
    int deleteByPrimaryKey(Long id);

    /**
        * @Description:增加
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
        * @Description:有选择地修改部门
        * @author XiaoLin
        * @date 2021/3/13
        * @Param: [record]
        * @return int
        */
    int updateByPrimaryKeySelective(Department department);

    /**
        * @Description:修改部门
        * @author XiaoLin
        * @date 2021/3/13
        * @Param: [department]
        * @return int
        */
    int updateByPrimaryKey(Department department);

    /**
        * @Description:分页查询（高级查询条件可选）
        * @author XiaoLin
        * @date 2021/3/13
        * @Param: [qo]
        * @return java.util.List<cn.linstudy.domain.Department>
        */
    List<Department> selectForPage(DepartmentQueryObject qo);

    /**
        * @Description:查询所有部门
        * @author XiaoLin
        * @date 2021/3/13
        * @Param: []
        * @return java.util.List<cn.linstudy.domain.Department>
        */
    List<Department> selectAll();
}