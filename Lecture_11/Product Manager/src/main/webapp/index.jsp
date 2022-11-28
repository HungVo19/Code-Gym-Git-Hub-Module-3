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
      font-size: 20px;
    }
    a, a:hover {
      text-decoration: none;
      color: white;
    }
  </style>
</head>
<body>
<div class="sidenav">
  <div class="login-main-text">
    <h2>Product Manager<br> Login Page</h2>
    <p>Login from here to access.</p>
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