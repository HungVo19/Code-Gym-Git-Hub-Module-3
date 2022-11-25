<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        *{
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: "Agency FB", serif;
        }
        div{
            width: 280px;
            background-color: gray;
            text-align: left;
            padding-left: 10px;
            padding-top: 10px;
            padding-bottom: 5px;
        }
        .box{
            margin-top:3px;
            margin-bottom: 3px;
            font-size: 20px;
        }
    </style>
</head>
<body>
<div><form method="post" action="Converter">
    <h2 style="margin-bottom: 3px">Currency Converter</h2>
    <label style="font-weight: bold">Rate:</label><br>
    <label>
        <input class="box" type="text" name="rate" placeholder="rate" value="22000">
    </label><br>
    <label style="font-weight: bold">USD</label><br>
    <label>
        <input class="box" type="text" name="usd" placeholder="USD"><br>
    </label>
    <label>
        <input class="box" type = "submit" id = "submit" value = "Convert">
    </label>
</form>
<%--    <c:out value="${result}"/>--%>
    <c:set var="demo" value="${result}"/>
    <c:if test ="${demo != null}">
    <h3>Result: <c:out value="${demo}"/></h3>
    </c:if>
</div>
</body>
</html>