<%@ page contentType="text/html;charset=utf-8"%>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
  <p>我是Jerry页面<%String s = session.getId();%></p>
  <p>您在Jerry页面中的session对象的ID是：<%=s%><p>
  <p>点击超链接，连接到session的页面。 <br>
    <a href="SessionClient.jsp">欢迎到session屋来！</a>
  </p>
</body>
</html>
