package xust;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RestControllerAdvice
public class GlobalErrorHandler implements ErrorController{
  @ExceptionHandler(Exception.class)
  public Result<Object> handleException(HttpServletRequest request, HttpServletResponse response, Exception e) {
    Result<Object> res = new Result<Object>();
    res.setCode(HttpStatus.OK.value());
    res.setMessage(e.getLocalizedMessage());
    res.setDetail(request.getRequestURI());
    
    return res;
  }
    
	@RequestMapping("/error")
  public Result<Object> handleError(HttpServletRequest request, HttpServletResponse response, Exception e) {
    Result<Object> res = new Result<Object>();
    
    Object code = request.getAttribute("javax.servlet.error.status_code");
    res.setCode(code != null ? (Integer) code : 404);
    String message = (String) request.getAttribute("javax.servlet.error.message");
    res.setMessage(message);
    
    String url = (String) request.getRequestURI();
    res.setDetail(url);

    return res;
  }

  public String getErrorPath() {
    return "/error";
  }
}
