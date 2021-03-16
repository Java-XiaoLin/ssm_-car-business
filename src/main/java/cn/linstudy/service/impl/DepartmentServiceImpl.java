package cn.linstudy.service.impl;

import cn.linstudy.domain.Employee;
import cn.linstudy.mapper.EmployeeMapper;
import cn.linstudy.qo.DepartmentQueryObject;
import cn.linstudy.qo.QueryObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.linstudy.domain.Department;
import cn.linstudy.mapper.DepartmentMapper;
import cn.linstudy.service.DepartmentService;
/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/7 19:46
 */

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentMapper departmentMapper;


    /**
        * @Description:通过id删除部门
        * @author XiaoLin
        * @date 2021/3/13
        * @Param: [id]
        * @return int
        */
    @Override
    public int deleteByPrimaryKey(Long id) {
        return departmentMapper.deleteByPrimaryKey(id);
    }

    /**
        * @Description:插入部门
        * @author XiaoLin
        * @date 2021/3/13
        * @Param: [record]
        * @return int
        */
    @Override
    public int insert(Department record) {
        return departmentMapper.insert(record);
    }

    /**
        * @Description:有选择的增加（只增加过来的属性）
        * @author XiaoLin
        * @date 2021/3/13
        * @Param: [department]
        * @return int
        */
    @Override
    public int insertSelective(Department department) {
        return departmentMapper.insertSelective(department);
    }

    /**
        * @Description:通过id查询部门
        * @author XiaoLin
        * @date 2021/3/13
        * @Param: [id]
        * @return cn.linstudy.domain.Department
        */
    @Override
    public Department selectByPrimaryKey(Long id) {
        return departmentMapper.selectByPrimaryKey(id);
    }

    /**
        * @Description:有选择得通过id修改部门
        * @author XiaoLin
        * @date 2021/3/13
        * @Param: [department]
        * @return int
        */
    @Override
    public int updateByPrimaryKeySelective(Department department) {
        return departmentMapper.updateByPrimaryKeySelective(department);
    }

    /**
        * @Description:修改部门，全部属性都会修改
        * @author XiaoLin
        * @date 2021/3/13
        * @Param: [department]
        * @return int
        */
    @Override
    public int updateByPrimaryKey(Department department) {
        return departmentMapper.updateByPrimaryKey(department);
    }

    /**
        * @Description: 分页查询（高级查询条件可选）   
        * @author XiaoLin
        * @date 2021/3/13
        * @Param: [qo]
        * @return com.github.pagehelper.PageInfo<cn.linstudy.domain.Department>
        */
    @Override
    public PageInfo<Department> selectForPage(DepartmentQueryObject qo) {
        //使用分页插件,传入当前页,每页显示数量
        PageHelper.startPage(qo.getCurrentPage(),qo.getPageSize());
        // 查询结果集
        List<Department> departments = departmentMapper.selectForPage(qo);
        // 将结果集放回1PageInfo对象中，并返回
        return new PageInfo(departments);
    }

    /**
        * @Description:查询所有部门
        * @author XiaoLin
        * @date 2021/3/13
        * @Param: []
        * @return java.util.List<cn.linstudy.domain.Department>
        */
    @Override
    public List<Department> selectAll() {
        return departmentMapper.selectAll();
    }

}
