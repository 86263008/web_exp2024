<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
  <%
  Vector v = (Vector) application.getAttribute("Mess");
  for (int i = 0; i < v.size(); i++) {
    String message = (String) v.elementAt(i);
    out.print("<br>" + message);
  }
  %>
</body>
</html>
