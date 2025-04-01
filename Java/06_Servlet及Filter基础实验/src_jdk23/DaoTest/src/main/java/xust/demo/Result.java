package xust.demo;

/**
 * 操作结果类
 */
public class Result {

  /**
   * 结果码，0为成功
   */
  public int code;

  /**
   * 结果信息
   */
  public String message;

  /**
   * 结果数据
   */
  public Object data;

  public Result() {

  }

  public Result(Boolean v) {
    code = v ? 0 : 1;
  }
}
