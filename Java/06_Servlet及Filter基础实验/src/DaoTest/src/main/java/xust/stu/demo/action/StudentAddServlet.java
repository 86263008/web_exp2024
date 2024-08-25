package xust.stu.demo.action;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xust.stu.Result;
import xust.stu.demo.domain.Student;
import xust.stu.demo.service.StudentService;
import xust.stu.demo.service.StudentServiceImpl;

//--8<-- [start:add]
@WebServlet("/demo/Student/Add")
public class StudentAddServlet extends HttpServlet {
  private StudentService _StudentService = new StudentServiceImpl();

  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    
    Student o = _StudentService.toO(request);
    Result res = _StudentService.create(o);
    response.setCharacterEncoding("utf-8");
    response.setContentType("application/json");
    response.getWriter().append(String.format("{\"code\":%d, \"message\":\"%s\"}", res.code, res.message));
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doGet(request, response);
  }
}
//--8<-- [end:add]

