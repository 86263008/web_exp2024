<%@ page import="stu.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <title>学生表</title>
</head>

<body>
  <h3>学生表</h3>
  <a href="<%=request.getContextPath()%>/stu/add_view.jsp">新增</a>
  <table id="STUDENT" border="1" width="100%">
    <thead>
      <th>学号</th>
      <th>姓名</th>
      <th>性别</th>
      <th>年龄</th>
      <th>所在系</th>
      <th>操作</th>
    </thead>
    <tbody>
    	<%
				List<Student> students = (List<Student>)session.getAttribute("stu_list");
        if(students != null){
        	for(Student stu: students){
        		String line = "";
        		line += String.format("<td>%s</td>", stu.getNo());
        		line += String.format("<td>%s</td>", stu.getName());
        		line += String.format("<td>%s</td>", stu.getGender());
        		line += String.format("<td>%s</td>", stu.getAge());
        		line += String.format("<td>%s</td>", stu.getDept());
        		line += String.format("<td><a href='%s/stu/update_view.jsp?no=%s'>修改</a>&nbsp;&nbsp;<a href='%s/stu/delete.jsp?no=%s'>删除</a></td>", request.getContextPath(), stu.getNo(), request.getContextPath(), stu.getNo());
	      	  out.print(String.format("<tr>%s</tr>", line));       		
        	}
        }
    	%>
    </tbody>
  </table>
</body>

</html>


