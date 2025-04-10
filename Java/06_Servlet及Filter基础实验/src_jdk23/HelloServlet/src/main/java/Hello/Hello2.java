package Hello;

import java.io.IOException;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Hello2")
public class Hello2 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private String message;

  public Hello2() {
  }

  public void init(ServletConfig config) throws ServletException {
    message = "Hello World Again!";
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setHeader("content-type", "text/html;charset=utf-8");
    response.getWriter().append("<h1>" + message + "</h1>");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

}