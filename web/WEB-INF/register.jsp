<%-- 
    Document   : register
    Created on : Oct 19, 2020, 10:35:47 AM
    Author     : 826847
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="shoppinglist" method="post" name="Register">
            
         <label>Username:</label><input type="text" value="" name="username"><input type="submit" value="Register name">
         <input type="hidden" name="action" value="register">
        </form>
        
        ${message}
    </body>
</html>
