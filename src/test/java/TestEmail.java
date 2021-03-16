import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.linstudy.utils.EmailUtils;
import java.util.Date;
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
  public void test(){
    System.out.println();
    System.out.println(DateUtil.format(new Date(),"yyyyMMdd") +RandomUtil.randomNumbers(5));
  }
}
