<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
<meta charset="utf-8">
</head>

<body>
  <p>
    <% String s=session.getId(); %>
  </p>
  <p>
    您的session对象的ID是：<br>
    <%=s%>
  </p>
  <p>输入你的姓名连接到tom.jsp
  <form action="SessionTom.jsp" method="POST" name="form">
    <input type="text" name="boy">
    <input type="submit" value="送出" name=submit>
  </form>
  </p>
</body>

</html>