<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Product Management Application</title>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
  <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
  <link rel="stylesheet" href="index.css">
  <style>
    body {
      color: #566787;
      font-family: 'Varela Round', sans-serif;
      font-size: 15px;
    }
    a, a:hover {
      text-decoration: none;
      color: white;
    }
  </style>
</head>
<%--<body>--%>
<%--<header>--%>
<%--  <nav class="navbar navbar-expand-md navbar-dark"--%>
<%--       style="background-color: #2c3e50">--%>
<%--    <div>--%>
<%--      <a href="${pageContext.request.contextPath}/ProductServlet?action=reload" class="navbar-brand"> Product <b>Manager</b>--%>
<%--      </a>--%>
<%--    </div>--%>
<%--  </nav>--%>
<%--</header>--%>
<%--<br>--%>
<%--<div class="card container col-sm-3 bg-light text-center">--%>
<%--  <div class="card">--%>
<%--    <div class="card-body">--%>
<%--      <form method="get" action="LoginServlet">--%>
<%--        <div class="login">--%>
<%--          <h2>Login</h2>--%>
<%--          <label>--%>
<%--            <input type="text" name="username" placeholder="username" required="required">--%>
<%--          </label>--%>
<%--          <label>--%>
<%--            <input type="password" name="password" placeholder="password" required="required">--%>
<%--          </label>--%>
<%--          <br>--%>
<%--          <input id="submit" type="submit" value="Sign in">--%>
<%--        </div>--%>
<%--      </form>--%>
<%--    </div>--%>
<%--  </div>--%>

<%--</div>--%>
<%--</body>--%>
<body>
<div class="sidenav">
  <div class="login-main-text">
    <h2>Product Manager<br> Login Page</h2>
    <p>Login or register from here to access.</p>
  </div>
</div>
<div class="main">
  <div class="col-md-6 col-sm-12">
    <div class="login-form">
      <form action="LoginServlet" method="get" >
        <div class="form-group">
          <label>User Name</label>
          <input type="text" class="form-control" placeholder="User Name" name="username">
        </div>
        <div class="form-group">
          <label>Password</label>
          <input type="password" class="form-control" placeholder="Password" name="password">
        </div>
        <button type="submit" class="btn btn-black">Login</button>
      </form>
    </div>
  </div>
</div>
</body>
</html>