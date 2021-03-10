package cn.linstudy.utils;

import org.apache.commons.mail.HtmlEmail;


/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/10 14:37
 */
public class EmailUtils {

  /**
      * @Description:邮箱验证码
      * @author XiaoLin
      * @date 2021/3/10
      * @Param:
      * @return
      */
  public static boolean sendEmail(String emailAddress,String code){
    try {
      //不用更改
      HtmlEmail email = new HtmlEmail();
      //需要修改，126邮箱为smtp.126.com,163邮箱为163.smtp.com，QQ为smtp.qq.com
      email.setHostName("smtp.qq.com");
      email.setCharset("UTF-8");
      // 收件地址
      email.addTo(emailAddress);
      //此处填邮箱地址和用户名,用户名可以任意填写
      email.setFrom("1101121833@qq.com", "XiaoLin");
      // 此处填写邮箱地址和客户端授权码
      email.setAuthentication("1101121833@qq.com", "xldyhraiqbizhdej");

      //此处填写邮件名，邮件名可任意填写
      email.setSubject("XiaoLin");
      //此处填写邮件内容
      email.setMsg("尊敬的用户您好,您本次注册的验证码是:" + code);

      email.send();
      return true;
    }
    catch(Exception e){
      e.printStackTrace();
      return false;
    }
  }



}
