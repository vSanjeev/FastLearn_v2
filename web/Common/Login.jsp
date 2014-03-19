<%-- 
    Document   : Login
    Created on : Mar 17, 2014, 6:31:48 PM
    Author     : Sanjeev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Enter Login Details</h1>
        <div>
            <form action="j_security_check"  method="POST">
                <label>User Name</label>
                <input type="text" name="j_username" value=""/><br>
                <label>Password</label>
                <input type="password" name="j_password" value=""/><br>
                <input type="submit" value="Log In"/>
            </form>
        </div>
    </body>
</html>
