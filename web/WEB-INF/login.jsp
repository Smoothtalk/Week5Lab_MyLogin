<%-- 
    Document   : login
    Created on : Oct 5, 2020, 3:36:22 PM
    Author     : 775653
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h2>Login</h2>
        <form action="login" method="post">
            <input type="text" name="username" value="${username}">Username <br>
            <input type="password" name="password" value="${password}">Password <br>
            <input type="submit" value="submit"> <br>
        </form>
        ${loginError}
    </body>
</html>
