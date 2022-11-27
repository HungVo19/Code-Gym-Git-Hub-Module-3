<%--
  Created by IntelliJ IDEA.
  User: Hung Vo
  Date: 11/25/2022
  Time: 6:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product Management Application</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="index.css">
    <style>
        body {
            color: #566787;
            /*background: #f5f5f5;*/
            font-family: "Varela Round", sans-serif;
            font-size: 15px;
        }
    </style>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: #2c3e50">
        <div>
            <a href="${pageContext.request.contextPath}/ProductServlet?action=reload" class="navbar-brand"> Product <b>Manager</b>
            </a>
        </div>
    </nav>
</header>
<br>

<div class="row">
    <div class="container">
        <h3 class="text-center">List of Products</h3>
        <hr>
        <div class="container text-left">

            <a href="addProduct.jsp" class="btn btn-success">Add
                New Product</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="p" items="${products}">
                <tr>
                    <td><c:out value="${p.getId()}"/></td>
                    <td><c:out value="${p.getName()}"/></td>
                    <td><c:out value="${p.getPrice()}"/>$</td>
                    <td><c:out value="${p.getQuantity()}"/></td>
                    <td>
                        <a title="Update"
                           href="${pageContext.request.contextPath}/ProductServlet?action=update&id=<c:out value='${p.getId()}'/>"><i
                                class="material-icons" data-toggle="tooltip" title="Update" style="color:blue">&#xE254;</i></a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="${pageContext.request.contextPath}/ProductServlet?action=delete&id=<c:out value='${p.getId()}'/>"><i
                                class="material-icons" data-toggle="tooltip" title="Delete" style="color: red">&#xE872;</i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>