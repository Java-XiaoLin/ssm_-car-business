import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import java.util.Date;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/10 14:48
 */
public class TestEmail {

  /**
   * 用于测试
   */
  @Test
  public void test() {
    System.out.println();
    System.out.println(DateUtil.format(new Date(), "yyyyMMdd") + RandomUtil.randomNumbers(5));
  }

  /**
   * 用于测试MD5的密码
   */
  @Test
  public void testMd5() {
    Md5Hash md5Hash = new Md5Hash("123456", "ls", 1024);
    System.out.println(md5Hash);


  }
}
