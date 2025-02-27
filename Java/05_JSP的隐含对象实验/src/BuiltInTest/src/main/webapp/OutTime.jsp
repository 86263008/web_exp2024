<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*"%>
<%!public String getDayWeek(int n) {
    String week[] = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
    return week[n];
  }%>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
  <%
    Calendar calendar = Calendar.getInstance(); //创建一个日历对象。
    calendar.setTime(new Date());//用当前时间初始化日历时间。
    String Year = String.valueOf(calendar.get(Calendar.YEAR));
    String Month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
    String Day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
    String WeekDay = getDayWeek(calendar.get(Calendar.DAY_OF_WEEK) - 1);
    int hour = calendar.get(Calendar.HOUR_OF_DAY);
    int minute = calendar.get(Calendar.MINUTE);
    int second = calendar.get(Calendar.SECOND);
  %>
  <p>
    现在的时间是<br>
    <%=Year%>年
    <%=Month%>月
    <%=Day%>日
    <%=WeekDay%><br>
    <%=hour%>点
    <%=minute%>分
    <%=second%>秒
    <%
      if (Day.equals("26")) {
        out.print("<br><H2>今天是病毒容易发作的日子！</H2>");
      }
      if (hour >= 22) {
        out.print("<br><H2>现在时间很晚了注意休息</H2>");
      }
    %>
  </p>
</body>
</html>
