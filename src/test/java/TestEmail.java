import cn.linstudy.utils.EmailUtils;
import org.junit.Test;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/10 14:48
 */
public class TestEmail {

  /**
   * 用于测试邮箱
   */
  @Test
  public void test(){
    EmailUtils.sendEmail("ljp2020vip@163.com","123456");
  }
}
