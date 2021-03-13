package cn.linstudy.exception;

/**
 * @Description 自定义运行时异常
 * @Author XiaoLin
 * @Date 2021/3/11 21:15
 */
public class CarBussinessException extends RuntimeException{

  public CarBussinessException() {
  }

  public CarBussinessException(String message) {
    super(message);
  }
}
