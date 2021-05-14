<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: NiGo
  Date: 2021/5/14
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%-- EL表达式
    取值范围从小到大，都没找到为空值（不是NULL）
    --%>
    <%
        pageContext.setAttribute("uname", "page");
        request.setAttribute("uname", "request");
        session.setAttribute("uname", "session");
        application.setAttribute("uname", "application");

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        request.setAttribute("list", list);

        Map<String, String> map = new HashMap();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        request.setAttribute("map", map);
    %>
    uname: ${uname}<br>
    hhh: ${hhh}<br>
    <%-- 指定范围 --%>
    pageScope.uname: ${pageScope.uname}
    <%-- List --%>
    list.size(): ${list.size()}<br>
    list[0]: ${list[0]}<br>
    <%-- Map --%>
    map["1"]: ${map["1"]}<br>
    <%-- empty --%>
    empty uname： ${uname}
    empty hhh： ${hhh}
</body>
</html>
