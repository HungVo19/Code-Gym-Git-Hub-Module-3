<%--
  Created by IntelliJ IDEA.
  User: Hung Vo
  Date: 11/26/2022
  Time: 7:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Delete Page</title>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
  <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
  <style>
    body {
      color: #566787;
      /*background: #f5f5f5;*/
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

<div class="card container col-sm-3 bg-light text-center">
  <div class="card-body bg-light">
    <caption>
      <h3>Delete this product ?</h3>
    </caption>
    <ul class="list-group list-group-flush bg-light">
      <li class="list-group-item bg-light">Name: <p><c:out value="${name}"/></li>
      <li class="list-group-item bg-light">Price: <p><c:out value="${price}"/> $</li>
      <li class="list-group-item bg-light">Quantity: <p><c:out value="${quantity}"/></li>
    </ul>
  </div>

    <div class="form-group">
      <button style="margin-bottom: 30px" type="submit" class="btn btn-danger"><a
              href="${pageContext.request.contextPath}/ProductServlet?action=deleteX&index=<c:out value='${index}'/>">Yes</a>
      </button>
      <button style="margin-bottom: 30px" type="reset" class="btn btn-secondary"><a
              href="${pageContext.request.contextPath}/ProductServlet?action=reload">Cancel</a></button>
    </div>

</div>
</body>
</html>