<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Hung Vo
  Date: 11/27/2022
  Time: 10:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Map<String, String> dic = new HashMap<>();
    dic.put("hello", "Xin chào");
    dic.put("how", "Thế nào");
    dic.put("book", "Quyển vở");
    dic.put("computer", "Máy tính");

    PrintWriter printWriter = response.getWriter();
    String search = request.getParameter("search").toLowerCase();
    String result = dic.get(search);
    if (result!= null) {
        printWriter.println("Word: " + search);
        printWriter.println("Value: " + result);
    } else {
        printWriter.println("Not found");
    }
%>
</body>
</html>
