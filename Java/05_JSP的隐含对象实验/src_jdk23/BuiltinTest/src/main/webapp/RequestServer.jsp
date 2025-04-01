<%@ page contentType="text/html;charset=utf-8"%>
<html>
<head>
<meta charset="utf-8">
</head>

<body>
  <p>
    获取文本框提交的信息：
    <% String textContent = request.getParameter("boy"); %><br>
    <%=textContent%>
  </p>
  <p>
    获取按钮的名字：
    <% String buttonName = request.getParameter("submit"); %><br>
    <%=buttonName%>
  </p>
</body>

</html>