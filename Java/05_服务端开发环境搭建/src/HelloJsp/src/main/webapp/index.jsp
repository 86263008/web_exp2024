<%@ page language="java" contentType="text/html; charset=utf-8" 
  import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hello JSP</title>
</head>
<body>
<%
  Date now = new Date();
  out.print("Hello Jsp:" + now);
%>
</body>
</html>