package cn.linstudy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description 自定义注解，哪些方法需要权限，需要哪些权限
 * @Author XiaoLin
 * @Date 2021/3/8 15:52
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiredPermission {
  String name();
  String expression();

}
