<%@ page import="stu.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=utf-8" %>
<%
  Student stu_new = new Student();

  stu_new.setNo(request.getParameter("no"));
  stu_new.setName(request.getParameter("name")); 
  stu_new.setGender(request.getParameter("gender")); 
  try{
    stu_new.setAge(Integer.parseInt(request.getParameter("age"))); 
  }catch(Exception e){
    
  }
  stu_new.setDept(request.getParameter("dept")); 
  
  List<Student> students = (List<Student>)session.getAttribute("stu_list");
  if(students != null){
    for(int i = 0; i < students.size(); i++){
        if(stu_new.getNo().equals(students.get(i).getNo())){
          students.set(i, stu_new);
          break;
        }
      }
  }
  
  //操作完成，回到列表
  response.sendRedirect(String.format("%s%s", request.getContextPath(), "/stu/list.jsp"));
%>