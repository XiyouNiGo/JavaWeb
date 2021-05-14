<%--
  Created by IntelliJ IDEA.
  User: NiGo
  Date: 2021/5/14
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
    <%-- 静态包含：相当于内容替换，生成一个源码文件 --%>
    <%@include file="download.html"%>
    <br><hr><br>
    <%-- 动态包含：生成多个源文件，可以传递参数 --%>
    <%
      String uname = "nigo";
    %>
    <jsp:include page="jsp3.jsp">
      <jsp:param name="uname" value="<%=uname%>"/>
    </jsp:include>
  </body>
</html>
