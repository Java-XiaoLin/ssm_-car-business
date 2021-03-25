package cn.linstudy.shiro;

import cn.linstudy.domain.Employee;
import cn.linstudy.domain.Role;
import cn.linstudy.service.EmployeeService;
import java.util.List;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description 自定义Realm
 * @Author XiaoLin
 * @Date 2021/3/24 19:39
 */
public class CarBusinessRealm extends AuthorizingRealm {

  @Autowired
  private EmployeeService employeeService;

  // 认证
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
      throws AuthenticationException {
    // 通过token获取用户名（用户登录的时候）
    String username = (String) token.getPrincipal();
    // 判断是否存在在数据库
    Employee employee = employeeService.selectByUsername(username);
    if (employee != null) {
      // 说明此时用户名是对的，返回一个身份对象
      return new SimpleAuthenticationInfo(employee, employee.getPassword(), this.getName());
    }
    return null;
  }


  // 授权
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    // 创建info对象
    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
    // 获取当前登录主体对象
    //Subject subject = SecurityUtils.getSubject();
    // 获取主体的身份对象（这里获取的对象与认证方法doGetAuthenticationInfo返回的SimpleAuthenticationInfo对象的第一个参数是同一个对象）
    Subject subject = SecurityUtils.getSubject();
    Employee employee = (Employee) subject.getPrincipal();
    // 判断是否是超级管理员
    if (employee.getAdmin()) {
      info.addRole("admin");
      // 给他所有的权限
      info.addStringPermission(" *:* ");
    } else {
      // 通过员工id拿到所有的角色
      List<Role> roles = employeeService.selectRolesById(employee.getId());
      for (Role role : roles) {
        info.addRole(role.getSn());
      }
      //通过员工id查询出所有的权限
      List<String> permissionByEmployeeId = employeeService
          .getPermissionByEmployeeId(employee.getId());
      info.addStringPermissions(permissionByEmployeeId);
    }
    return info;
  }


}
