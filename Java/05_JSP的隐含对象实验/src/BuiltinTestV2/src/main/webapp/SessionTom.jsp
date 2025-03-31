<%@ page contentType="text/html;charset=utf-8"%>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
  <p>我是Tom页面<%String s = session.getId();%></p>
  <p>您的在Tom页面中的session对象的ID是：<%=s%></p>
  <p>点击超链接，连接到Jerry的页面。 <br> 
    <a href="SessionJerry.jsp">欢迎到Jerry屋来！</a>
  </p>
</body>
</html>
