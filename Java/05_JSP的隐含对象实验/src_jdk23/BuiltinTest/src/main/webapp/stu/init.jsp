<%@ page import="stu.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=utf-8" %>
<%
  List<Student> students = new ArrayList<Student>();
  students.add(new Student("1", "张三", "男", 20, "计科"));
  students.add(new Student("2", "李四", "男", 20, "软工"));
  students.add(new Student("3", "王五", "男", 20, "网工"));

  session.setAttribute("stu_list", students);

  //初始化完成，回到列表
  response.sendRedirect(String.format("%s%s", request.getContextPath(), "/stu/list.jsp"));
%>