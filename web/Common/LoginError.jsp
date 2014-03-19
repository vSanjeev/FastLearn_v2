<%-- 
    Document   : LoginError
    Created on : Mar 17, 2014, 7:06:37 PM
    Author     : Sanjeev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
   prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Error</title>
    </head>
    <body>
        <h1>Please enter a valid username or password</h1>
        <c:url var="url" value="Login.jsp"/>
   <p><a href="${url}">Try again.</a></p>
    </body>
</html>
