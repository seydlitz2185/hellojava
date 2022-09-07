<%@ page import="java.io.PrintWriter" %>
<%@ page import="Bean.DateBean" %>
<%--
  Created by IntelliJ IDEA.
  User: stevenyu
  Date: 2021/12/10
  Time: 2:31 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>JavaBean&Filter实例</title>
    <jsp:useBean id="date" scope="application" class="Bean.DateBean"></jsp:useBean>
    <div text-align="center">
      <div id="clock">
        <div id="time">
          <%--使用jsp:getProperty动作标识从JavaBean中得到当前时间和星期--%>
          <jsp:getProperty name="date" property="dateTime"/>
        </div>
        <div id="week">
          <jsp:getProperty property="week" name="date"/>
        </div>
      </div>
    </div>
    <%--使页面每秒自动刷新一次，模拟时钟每秒走一格--%>
    <meta http-equiv="Refresh" content="1"/>
  </head>
  <body>
  <%!
    String greeting ="你好，世界";
  %>
  <%
    out.write(greeting+"<br/>");
  %>
  <%--也可以直接使用jsp内置对象打印JavaBean时间（此out定义在Servlet文件里，但是它是全局的，jsp也可以调用）--%>
  <%--

    out.write(date.getDateTime()+' '+date.getWeek()+"<br/>");
  --%>
  <h2>
  欢迎光临,<br/>
  您是本站的第[
  <%=application.getAttribute("count")%>]
  名访客
  </h2>
  </body>
</html>
