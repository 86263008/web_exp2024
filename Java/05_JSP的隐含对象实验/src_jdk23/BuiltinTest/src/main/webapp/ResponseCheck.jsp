<%@ page contentType="text/html;charset=utf-8"%>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
  <%
  String str = null;
  str = request.getParameter("name");
  if (str == null) {
    str = "";
  }
  byte b[] = str.getBytes("ISO-8859-1");
  str = new String(b);
  if (str.equals("")) {
    response.sendRedirect("ResponseFail.jsp");
  } else {
    out.print("欢迎您来到本网页！");
    out.print(str);
  }
  %>
</body>
</html>
