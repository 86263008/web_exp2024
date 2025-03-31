package xust.stu.demo.action;

// 导入必需的 java 库
import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//扩展 HttpServlet 类
@WebServlet("/HelloAnnotation") // 映射URL
public class HelloAnnotationServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public HelloAnnotationServlet() {
    // 执行必需的初始化
  }

  public void init(ServletConfig config) throws ServletException {
  }

  public void destroy() {
  }

  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doGet(request, response);
  }

}
