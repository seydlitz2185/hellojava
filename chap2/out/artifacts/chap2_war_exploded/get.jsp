<%--
  Created by IntelliJ IDEA.
  User: stevenyu
  Date: 2022/1/3
  Time: 3:02 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  姓名：${stu.stuName}<br/>
  年级：${stu.grade}<br/>
  选课1：${stu.sc[0].courseName}，学分：${stu.sc[0].creditHour}<br/>
  选课2：${stu.sc[1].courseName}，学分：${stu.sc[1].creditHour}<br/>
  </body>
</html>
