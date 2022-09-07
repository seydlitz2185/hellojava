<%--
  Created by IntelliJ IDEA.
  User: stevenyu
  Date: 2022/1/3
  Time: 8:15 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <c:set scope="page" var="age" value="20"/>
  <c:if test="${age ge 18}">
    你好
    </c:if>
  </body>
</html>
