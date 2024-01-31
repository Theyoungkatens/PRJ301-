<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form action="LoginController" method="POST">
            User ID: <input type="text" name="userId" required /> 
            <br>
            Password: <input type="password" name="password" required />
            <br>
            <p style="background-color:red;color:white;display:inline-block">${message}</p>
            <input name="action" type="submit" value="Login" /> 
        </form>
    </body>
</html>