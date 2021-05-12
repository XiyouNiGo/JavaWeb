<%--
  Created by IntelliJ IDEA.
  User: NiGo
  Date: 2021/5/12
  Time: 21:44
  能够结合Java代码的动态网页技术
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="serv8">
        姓名：<input type="text" name="uname">
        <button>登录</button>
        <span id="err_msg">
            <%=request.getAttribute("err_msg")%>
        </span>
    </form>
</body>
</html>
