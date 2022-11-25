<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style type="text/css">
        .login{
            height: 180px;
            width: 230px;
            margin: 0;
            padding: 10px;
            border: 1px solid #CCC;
            text-align: center;
        }

        .login input{
            padding: 5px;
            margin: 5px;
        }
        .login h2{
            text-align: center;
        }
    </style>
</head>
<body>
<form method="get" action="Login_servlet">
    <div class="login">
        <h2>Login</h2>
        <label>
            <input type="text" name="username" size="27" placeholder="username">
        </label>
        <label>
            <input type="password" name="password" size="27" placeholder="password">
        </label>
        <input id="submit" type="submit" value="Sign in">
    </div>
</form>
</body>
</html>