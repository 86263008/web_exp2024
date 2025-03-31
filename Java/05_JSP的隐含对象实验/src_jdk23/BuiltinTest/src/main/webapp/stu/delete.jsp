<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="stu.Student" contentType="text/html;charset=utf-8" %>
<%
  String no = request.getParameter("no");
  List<Student> students = (List<Student>)session.getAttribute("stu_list");
  if(students != null){
    //检索待删除学生的索引
    int no_index = -1;
    for(int i = 0; i < students.size(); i++){
      if(no.equals(students.get(i).getNo())){
        no_index = i;
        break;
      }
    }
    
    if(no_index != -1){
      students.remove(no_index);
    }
  }

  //操作完成，回到列表
  response.sendRedirect(String.format("%s%s", request.getContextPath(), "/stu/list.jsp"));
%>


