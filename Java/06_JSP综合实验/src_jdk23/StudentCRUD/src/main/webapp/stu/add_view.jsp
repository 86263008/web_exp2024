<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <title>学生表</title>
</head>

<body>
  <h3>学生表</h3>
  <div>
    <form action="<%=String.format(" %s/stu/add.jsp", request.getContextPath())%>">
      <div>
        <label for="no">学号:</label>
        <input type="text" id="no" name="no" placeholder="请输入学号..">
      </div>
      <div>
        <label for="name">姓名:</label>
        <input type="text" id="name" name="name" placeholder="请输入姓名..">
      </div>
      <div>
        <label for="gender">性别:</label>
        <input type="text" id="gender" name="gender" placeholder="请输入性别..">
      </div>
      <div>
        <label for="age">年龄:</label>
        <input type="number" id="age" name="age" placeholder="请输入年龄..">
      </div>
      <div>
        <label for="dept">所在系:</label>
        <input type="text" id="dept" name="dept" placeholder="请输入所在系..">
      </div>
      <button type="submit">提交</button>
    </form>
  </div>
</body>

</html>