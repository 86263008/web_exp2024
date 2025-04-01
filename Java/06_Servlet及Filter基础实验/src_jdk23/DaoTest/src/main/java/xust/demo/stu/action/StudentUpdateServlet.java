package xust.demo.stu.action;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import xust.stu.Result;
import xust.demo.stu.domain.Student;
import xust.demo.stu.service.StudentService;
import xust.demo.stu.service.StudentServiceImpl;

//--8<-- [start:update]
@WebServlet("/demo/Student/Update") // 映射URL
public class StudentUpdateServlet extends HttpServlet {
  private StudentService _StudentService = new StudentServiceImpl();

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Student o = _StudentService.toO(request);
    Result res = _StudentService.update(o);
    response.setCharacterEncoding("utf-8");
    response.setContentType("application/json");
    response.getWriter()
        .append(String.format("{\"code\":%d, \"message\":\"%s\", \"data\":\"%s\"}", res.code, res.message, res.data));
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
// --8<-- [end:update]
