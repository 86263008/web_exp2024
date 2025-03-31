<%@ page import="xust.stu.Result"%>
<%@ page import="xust.stu.demo.domain.Student"%>
<%@ page import="xust.stu.demo.service.StudentService"%>
<%@ page import="xust.stu.demo.service.StudentServiceImpl"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>学生表</title>
</head>

<body>
	<h3>学生表</h3>
	<%
	StudentService _StudentService = new StudentServiceImpl();
	Student stu = (Student)_StudentService.get(request.getParameter("no")).data;

	if (stu == null) {
		stu = new Student();
	}
	%>
	<div>
		<form
			action="<%=String.format("%s/stu/update.jsp", request.getContextPath())%>">
			<div>
				<label for="no">学号:</label> <input type="text" id="no" name="no"
					placeholder="请输入学号.." value="<%=stu.getNo()%>" readonly="true">
			</div>
			<div>
				<label for="name">姓名:</label> <input type="text" id="name"
					name="name" placeholder="请输入姓名.." value="<%=stu.getName()%>">
			</div>
			<div>
				<label for="gender">性别:</label> <input type="text" id="gender"
					name="gender" placeholder="请输入性别.." value="<%=stu.getGender()%>">
			</div>
			<div>
				<label for="age">年龄:</label> <input type="number" id="age"
					name="age" placeholder="请输入年龄.." value="<%=stu.getAge()%>">
			</div>
			<div>
				<label for="dept">所在系:</label> <input type="text" id="dept"
					name="dept" placeholder="请输入所在系.." value="<%=stu.getDept()%>">
			</div>
			<button type="submit">提交</button>
		</form>
	</div>
</body>

</html>

