<%--
  Created by IntelliJ IDEA.
  User: Hung Vo
  Date: 11/25/2022
  Time: 9:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product Management Application</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <style>
        body {
            color: #566787;
            background: #f5f5f5;
            font-family: 'Varela Round', sans-serif;
            font-size: 17px;
        }
        a,a:hover{
            text-decoration: none;
            color: white;
        }
    </style>
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: #2c3e50">
        <div>
            <a href="${pageContext.request.contextPath}/ProductServlet?action=reload" class="navbar-brand"> Product <b>Manager</b> </a>
        </div>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <form action="${pageContext.request.contextPath}/ProductServlet" method="get">
                <input type="hidden" name="action" value="add">
                <caption>
                    <h2>
                        Add New Product
                    </h2>
                </caption>

                <fieldset class="form-group">
                    <label>Product Name</label> <input type="text" class="form-control" name="name" required="required">
                </fieldset>

                <fieldset class="form-group">
                    <label>Product Price</label> <input type="text" class="form-control" name="price" required="required">
                </fieldset>

                <fieldset class="form-group">
                    <label>Product Quantity</label> <input type="text" class="form-control" name="quantity" required="required">
                </fieldset>

                <button type="submit" class="btn btn-success">Save</button>
                <button type="reset" class="btn btn-secondary"><a href="${pageContext.request.contextPath}/ProductServlet?action=reload">Cancel</a></button>
            </form>
        </div>
    </div>
</div>
</body>
</html>