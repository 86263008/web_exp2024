<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="java.util.*" %>
<html>
<head>
<meta charset="utf-8">
</head>

<body>
  现在的时间是：<br>
  <% out.println("" + new Date()); response.setHeader("Refresh", "5" ); %>
</body>

</html>