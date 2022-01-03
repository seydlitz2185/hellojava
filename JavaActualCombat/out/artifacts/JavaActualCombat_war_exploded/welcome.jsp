<%--
  Created by IntelliJ IDEA.
  User: stevenyu
  Date: 2022/1/3
  Time: 2:27 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Bean.StudentBean,Bean.CourseBean" %>
    <%
        CourseBean[] sc = new CourseBean[2];
        sc[0] = new CourseBean("Java Web",2);
        sc[1] = new CourseBean("B/S",2);
        StudentBean stu = new StudentBean();
        stu.setStuName("Steve");
        stu.setGrade(3);
        stu.setSc(sc);
        request.setAttribute("stu",stu);
        request.getRequestDispatcher("get.jsp").forward(request,response);
    %>
