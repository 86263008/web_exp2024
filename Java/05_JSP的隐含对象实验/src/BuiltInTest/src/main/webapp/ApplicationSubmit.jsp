<%@ page contentType="text/html;charset=utf-8"%>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
  <form action="ApplicationMessagePane.jsp" method="post" name="MessagePane">
    <p>输入您的名字： <input type="text" name="peopleName"><br></p>
    <p>输入您的留言标题： <input type="text" name="Title"><br></p>
    <p>输入您的留言：<br>
      <textarea name="messages" ROWs="10" COLS=36 WRAP="physical"></textarea>
      <br> 
      <input type="submit" value="提交信息" name="submit">
    </p>
  </form>
  
  <form action="ApplicationShowMessage.jsp" method="post" name="ShowMessage">
    <input type="submit" value="查看留言板" name="look">
  </form>
</body>
</html>
