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
    <title>$Title$</title>
    <jsp:useBean id="date" scope="application" class="Bean.DateBean"></jsp:useBean>
    <div text-align="center">
      <div id="clock">
        <div id="time">
          <jsp:getProperty name="date" property="dateTime"/>
        </div>
        <div id="week">
          <jsp:getProperty property="week" name="date"/>
        </div>
      </div>
    </div>
    <meta http-equiv="Refresh" content="1"/>
  </head>
  <body>
  <%!
    String greeting ="你好，世界";
  %>
  <%
    out.write(greeting+"<br/>");
  %>
  <%--
    out.write(date.getDateTime()+' '+date.getWeek()+"<br/>");
  --%>

  </body>
</html>
