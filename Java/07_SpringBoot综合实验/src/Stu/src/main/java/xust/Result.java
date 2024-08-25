package xust;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/*
 * 执行结果
 */
public class Result<T>{
  private Locale locale = LocaleContextHolder.getLocale();
    private static final Logger log = LoggerFactory.getLogger(Result.class);

  /*
    * 结果码，0为成功，其它为具体的错误码
   */
   private Integer code = 0;
  
  /*
    * 信息
   */
  private String message;
  
  /*
    * 错误详细信息
   */
  private String detail;
  
  /*
    * 数据
   */
  private T data;

  private MessageSource messageSource;
  
  public Result() {
    //ac = new AnnotationConfigApplicationContext(HelloMybatisApplication.class);
    //messageSource = (MessageSource) applicationContext.getBean("messageSource");
    log.info("Load MessageSource:" + (null != messageSource));
    
    this.code = ErrEnum.SUCCESS.getCode();
    this.message = ErrEnum.SUCCESS.getMessage();
  }
  
  public void setErr(ErrEnum err) {
    this.code = err.getCode();
    this.message = err.getMessage();
  }
  
  public Result(Integer code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }
  
  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }
}
