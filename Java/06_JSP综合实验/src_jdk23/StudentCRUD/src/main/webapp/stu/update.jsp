<%@ page import="xust.stu.Result"%>
<%@ page import="xust.stu.demo.domain.Student"%>
<%@ page import="xust.stu.demo.service.StudentService"%>
<%@ page import="xust.stu.demo.service.StudentServiceImpl"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%
StudentService _StudentService = new StudentServiceImpl();
Student stu_new = new Student();
Student o = _StudentService.toO(request);
Result res = _StudentService.update(o);

//操作完成，回到列表
response.sendRedirect(String.format("%s%s", request.getContextPath(), "/stu/list.jsp"));
%>