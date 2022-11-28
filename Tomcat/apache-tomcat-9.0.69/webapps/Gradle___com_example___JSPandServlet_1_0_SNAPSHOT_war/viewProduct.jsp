<%--
  Created by IntelliJ IDEA.
  User: Hung Vo
  Date: 11/25/2022
  Time: 12:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Price</th>
    <th>Quantity</th>
  </tr>
  <c:forEach items="${products}" var="p">
    <tr>
      <td><c:out value="${p.getId()}"/></td>
      <td><c:out value="${p.getName()}"/></td>
      <td><c:out value="${p.getPrice()}"/></td>
      <td><c:out value="${p.getQuantity()}"/></td>
     <td><button><a href="/ProductServlet?action=update&id=${p.getId()}"/>Update</button></td>
     <td><button><a href="/ProductServlet?action=delete&id=${p.getId()}"/>Delete</button></td>
    </tr>
  </c:forEach>
</table>
<a href="index.jsp">Add New Product</a>
</body>
</html>
