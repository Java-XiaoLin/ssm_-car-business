package cn.linstudy.service.impl;

import cn.linstudy.annotation.RequiredPermission;
import cn.linstudy.qo.PermissionQueryObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.linstudy.domain.Permission;
import cn.linstudy.mapper.PermissionMapper;
import cn.linstudy.service.PermissionService;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/8 21:29
 */

@Service
public class PermissionServiceImpl implements PermissionService{

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private RequestMappingHandlerMapping rmhm;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return permissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Permission record) {
        return permissionMapper.insert(record);
    }

    @Override
    public int insertSelective(Permission record) {
        return permissionMapper.insertSelective(record);
    }

    @Override
    public Permission selectByPrimaryKey(Long id) {
        return permissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Permission record) {
        return permissionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Permission record) {
        return permissionMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Permission> selectForPage(PermissionQueryObject qo) {
        PageHelper.startPage(qo.getCurrentPage(),qo.getPageSize());
        List<Permission> permissions = permissionMapper.selectForPage(qo);
        return new PageInfo<Permission>(permissions);
    }

    /**
        * @Description:根据注解信息重新加载权限信息
        * @author XiaoLin
        * @date 2021/3/13
        * @Param: []
        * @return void
        */
    @Override
    public void reload() {
        //一次性的把所有的权限信息查出来.
        List<Permission> permissions = permissionMapper.selectAll();
        // 创建一个集合，用于存储权限表达式
        Set<String> expressionSet = new HashSet<>();
        // 遍历查询出来的权限表达式信息
        for(Permission p:permissions){
            // 将查询出来的权限表达式放入到我们创建的集合中
            expressionSet.add(p.getExpression());
        }
        //获取到所有贴了RequiredPermission注解，取出注解上的name和expression，
        // 封装成Permission，保存到数据库中
        //HandlerMethod代表每一个控制的方法引用
        // 获取所有的控制器方法
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = rmhm.getHandlerMethods();
        // 获取到所有的控制器方法value值，这个值存储了方法的信息
        Collection<HandlerMethod> values = handlerMethods.values();
        // 遍历
        for(HandlerMethod method:values){
            // 获得这个方法上贴的RequiredPermission注解
            RequiredPermission methodAnnotation = method.getMethodAnnotation(RequiredPermission.class);
            // 如果注解信息不为空，说明是贴了RequiredPermission，是需要权限的
            if(methodAnnotation!=null){
                // 获得该注解的权限表达式信息
                String expression = methodAnnotation.expression();
                // 看看该注解的权限表达式信息是否在我们遍历的集合中，目前扫描的表达式不在集合（数据库）中
                if(!expressionSet.contains(expression)){
                   // 新建一个权限对象
                    Permission p = new Permission();
                    // 设置名字
                    p.setName(methodAnnotation.name());
                    // 设置表达式
                    p.setExpression(expression);
                    // 将数据库中没有的权限信息插入到数据库中
                    permissionMapper.insert(p);
                }else{
                    //目前扫描到的表达式在集合中，在集合中就移除
                    expressionSet.remove(expression);
                }
            }
        }
        //如果expressionSet不为空，说明有些权限已经删除了，代码中已经没有了，但是数据库依然存在. 根据表达式删除权限
        for(String expression:expressionSet){
            permissionMapper.deleteByExpression(expression);
        }
    }

    /**
        * @Description:查询所有权限信息
        * @author XiaoLin
        * @date 2021/3/13
        * @Param: []
        * @return java.util.List<cn.linstudy.domain.Permission>
        */
    @Override
    public List<Permission> selectAll() {
        return permissionMapper.selectAll();
    }

    @Override
    public List<Permission> selectPermissionByRoleId(Long roleId) {
        return permissionMapper.selectPermissionByRoleId(roleId);
    }


}
