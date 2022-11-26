<%--
  Created by IntelliJ IDEA.
  User: Hung Vo
  Date: 11/25/2022
  Time: 9:31 PM
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
            font-size: 15px;
        }
        a, a:hover {
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
            <a href="${pageContext.request.contextPath}/ProductServlet?action=reload" class="navbar-brand"> Product <b>Manager</b>
            </a>
        </div>
    </nav>
</header>
<br>

<div class="card-deck" style="margin: 20px">

    <div class="card col-sm-3 bg-light">
        <div class="card-body bg-light">
            <caption>
                <h2>Current Data</h2>
            </caption>
            <ul class="list-group list-group-flush bg-light">
                <li class="list-group-item bg-light">Index: <p><c:out value="${index}"/></li>
                <li class="list-group-item bg-light">Name: <p><c:out value="${name}"/></li>
                <li class="list-group-item bg-light">Price: <p><c:out value="${price}"/>  $</li>
                <li class="list-group-item bg-light">Quantity: <p><c:out value="${quantity}"/></li>
            </ul>
        </div>

    </div>

    <div class="card">
        <div class="card-body">
            <form action="${pageContext.request.contextPath}/ProductServlet" method="get">
                <input type="hidden" name="action" value="updateX">
                <input type="hidden" name="index" value="${index}">
                <caption>
                    <h2>
                        Update Data
                    </h2>
                </caption>

                <fieldset class="form-group">
                    <label>New Name</label> <input type="text" class="form-control" name="newName" required="required">
                </fieldset>

                <fieldset class="form-group">
                    <label>New Price</label> <input type="text" class="form-control" name="newPrice" required="required">
                </fieldset>

                <fieldset class="form-group">
                    <label>New Quantity</label> <input type="text" class="form-control" name="newQuantity" required="required">
                </fieldset>
                <br>
                <button type="submit" class="btn btn-success">Save</button>
                <button type="reset" class="btn btn-warning"><a
                        href="${pageContext.request.contextPath}/ProductServlet?action=reload">Cancel</a></button>
            </form>
        </div>
    </div>

</div>

</div>
</body>
</html>
