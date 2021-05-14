<%@ page import="java.util.SplittableRandom" %><%--
  Created by IntelliJ IDEA.
  User: NiGo
  Date: 2021/5/14
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h3>接受动态包含传递的参数</h3>
  <%
      String uname = request.getParameter("uname");
  %>
  <%=uname%><br>
  <%=request.getParameter("uname")%><br>
</body>
</html>
