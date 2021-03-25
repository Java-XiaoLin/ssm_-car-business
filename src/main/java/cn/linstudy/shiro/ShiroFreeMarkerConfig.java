package cn.linstudy.shiro;

import com.jagregory.shiro.freemarker.ShiroTags;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import java.io.IOException;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

/**
 * @Description FreeMarker的拓展标签配置类
 * @Author XiaoLin
 * @Date 2021/3/25 10:47
 */
public class ShiroFreeMarkerConfig extends FreeMarkerConfigurer {

  @Override
  public void afterPropertiesSet() throws IOException, TemplateException {
    //继承之前的属性配置，这不能省
    super.afterPropertiesSet();
    Configuration cfg = this.getConfiguration();
    cfg.setSharedVariable("shiro", new ShiroTags());//注册shiro 标签，这里可以换成自己想要其他的标签，但是一般建议是用shiro
  }
}
