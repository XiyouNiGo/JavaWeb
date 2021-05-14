<%--
  Created by IntelliJ IDEA.
  User: NiGo
  Date: 2021/5/14
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <%-- 动态网页技术、翻译为Servlet --%>
    <h3>注释</h3>
    显示注释：HTML注释<br>
    <!-- HTML -->
    隐式注释：Java注释、JSP注释<br>
    <%
    // Java
    /* Java */
    %>
    <%-- JSP --%>

    <h3>Scriptlet</h3>
    <%-- Java脚本段 --%>
    <%
        // Local
        int num = 1;
        // Console
        System.out.println("Hello JSP");
        // Browser
        out.write("Hello JSP");
    %>
    <%-- 声明 --%>
    <%!
        // Global
        String greeting = new String("Hello JSP");
    %>
    <%-- 输出表达式 --%>
    <%=greeting%><br>
    <%=num%><br>
</body>
</html>
