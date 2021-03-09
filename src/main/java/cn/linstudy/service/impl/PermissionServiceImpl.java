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

    @Override
    public void reload() {
        //1.一次性的把所有的权限信息查出来.
        List<Permission> permissions = permissionMapper.selectAll();
        Set<String> expressionSet = new HashSet<>();
        for(Permission p:permissions){
            expressionSet.add(p.getExpression());
        }
        //获取到所有贴了RequiredPermission注解，取出注解上的name和expression，
        // 封装成Permission，保存到数据库中
        //HandlerMethod代表每一个控制的方法引用
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = rmhm.getHandlerMethods();
        Collection<HandlerMethod> values = handlerMethods.values();
        for(HandlerMethod method:values){
            RequiredPermission methodAnnotation = method.getMethodAnnotation(RequiredPermission.class);
            if(methodAnnotation!=null){
                String expression = methodAnnotation.expression();
                if(!expressionSet.contains(expression)){
                    //目前扫描的表达式不在集合中
                    //说明方法上贴了注解
                    Permission p = new Permission();
                    p.setName(methodAnnotation.name());
                    p.setExpression(expression);
                    permissionMapper.insert(p);
                }else{
                    //目前扫描到的表达式在集合中
                    expressionSet.remove(expression);
                }
            }
        }
        //如果expressionSet不为空，说明有些权限已经删除了，代码中已经没有了，但是数据库依然存在. 根据表达式删除权限
        for(String expression:expressionSet){
            permissionMapper.deleteByExpression(expression);
        }
    }

    @Override
    public List<Permission> selectAll() {
        return permissionMapper.selectAll();
    }

    @Override
    public List<Permission> selectPermissionByRoleId(Long roleId) {
        return permissionMapper.selectPermissionByRoleId(roleId);
    }


}
