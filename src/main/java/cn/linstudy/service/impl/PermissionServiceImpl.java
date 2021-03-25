package cn.linstudy.service.impl;

import cn.linstudy.domain.Permission;
import cn.linstudy.mapper.PermissionMapper;
import cn.linstudy.qo.PermissionQueryObject;
import cn.linstudy.service.PermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.Map;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/8 21:29
 */

@Service
public class PermissionServiceImpl implements PermissionService {

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
    PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
    List<Permission> permissions = permissionMapper.selectForPage(qo);
    return new PageInfo<Permission>(permissions);
  }

  /**
   * @return void
   * @Description:根据注解信息重新加载权限信息
   * @author XiaoLin
   * @date 2021/3/13
   * @Param: []
   */
  @Override
  public void reload() {
    //一次性的把所有的权限信息查出来.
    List<Permission> permissionsOnDB = permissionMapper.selectAll();
    // 拿到所有方法
    Map<RequestMappingInfo, HandlerMethod> handlerMethods = rmhm.getHandlerMethods();
    // 遍历所有方法
    for (HandlerMethod method : handlerMethods.values()) {
      // 判断方法上是否有RequiresPermissions注解
      RequiresPermissions annotation = method.getMethodAnnotation(RequiresPermissions.class);
      if (annotation != null) {
        // 如果不为空。说明是贴了注解的
        // 数组的第一个元素表示的是权限表达式
        String expression = annotation.value()[0];
        // 数组的第二个元素表示的是权限的名称
        String name = annotation.value()[1];
        // 在存入数据库之前先判断以下，如果数据库中没有才插入
        if (!permissionsOnDB.contains(expression)) {
          Permission permission = new Permission();
          permission.setName(name);
          permission.setExpression(expression);
          permissionMapper.insert(permission);
        }
      }
    }
  }

  /**
   * @return java.util.List<cn.linstudy.domain.Permission>
   * @Description:查询所有权限信息
   * @author XiaoLin
   * @date 2021/3/13
   * @Param: []
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
