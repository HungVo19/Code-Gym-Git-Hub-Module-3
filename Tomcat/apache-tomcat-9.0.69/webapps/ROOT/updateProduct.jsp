<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hung Vo
  Date: 11/25/2022
  Time: 2:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Product</title>
</head>
<body>
<h3>Update Product</h3>
<table>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
    </tr>
    <tr>
        <td><c:out value="${name}"/></td>
        <td><c:out value="${price}"/></td>
        <td><c:out value="${quantity}"/></td>
    </tr>
</table>
<form action="ProductServlet" method="get">
    <input type="hidden" name="action" value="updateX">
    <input type="hidden" name="index" value="${index}">
    <table>
        <tr>
            <td>Name</td>
            <td><label>
                <input type="text" name="newName">
            </label></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><label>
                <input type="text" name="newPrice">
            </label></td>
        </tr>
        <tr>
            <td>Quantity</td>
            <td><label>
                <input type="text" name="newQuantity">
            </label></td>
        </tr>
        <tr><td colspan="2"><input type="submit" value="Save Product"></td></tr>
    </table>
</form>
</body>
</html>
