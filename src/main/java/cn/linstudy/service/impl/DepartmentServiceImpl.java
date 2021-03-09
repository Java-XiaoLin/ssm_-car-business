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



    @Override
    public int deleteByPrimaryKey(Long id) {
        return departmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Department record) {
        return departmentMapper.insert(record);
    }

    @Override
    public int insertSelective(Department record) {
        return departmentMapper.insertSelective(record);
    }

    @Override
    public Department selectByPrimaryKey(Long id) {
        return departmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Department record) {
        return departmentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Department record) {
        return departmentMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Department> selectForPage(DepartmentQueryObject qo) {
        //使用分页插件,传入当前页,每页显示数量
        PageHelper.startPage(qo.getCurrentPage(),qo.getPageSize());
        List<Department> departments = departmentMapper.selectForPage(qo);
        return new PageInfo(departments);
    }

    @Override
    public List<Department> selectAll() {
        return departmentMapper.selectAll();
    }

}
