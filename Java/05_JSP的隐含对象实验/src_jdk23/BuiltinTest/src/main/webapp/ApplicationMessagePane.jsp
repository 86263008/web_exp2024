<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
  <%!
    Vector v = new Vector();
    int i = 0;
    ServletContext application;
  
    synchronized void sendMessage(String s) {
      application = getServletContext();
      i++;
      v.add("No." + i + "," + s);
      application.setAttribute("Mess", v);
    }
  %>
    
  <%
    request.setCharacterEncoding("utf-8");
    String name = request.getParameter("peopleName");
    String title = request.getParameter("Title");
    String messages = request.getParameter("messages");
    if (name == null) {
      name = "guest" + (int) (Math.random() * 10000);
    }
    if (title == null) {
      title = "无标题";
    }
    if (messages == null) {
      messages = "无信息";
    }
    String s = "Name:" + name + "#" + "Title:" + title + "#" + "Content:" + "#" + messages;
    sendMessage(s);
    out.print("您的信息已经提交！");
  %>
  <a href="ApplicationSubmit.jsp">返回</a>
</body>
</html>
