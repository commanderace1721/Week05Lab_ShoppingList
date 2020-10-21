<%-- 
    Document   : shoppinglist
    Created on : Oct 19, 2020, 10:35:55 AM
    Author     : 826847
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ShoppingList</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="shoppinglist" method="get" name="logout">
           <p>Hello, ${username} <a href="/ShoppingList" onclick="document.forms['logout'].submit(); return false;">Logout</a></p>
           <input type="hidden" name="action" value="reset">
        </form>
           <form action="shoppinglist" method="post" name="Add">
               <label>Add Item:</label><input type="text" name="item" value=""/><input type="submit" value="Add"/>
               <input type="hidden" name="action" value="add">
               
               <table>
                   <c:forEach var="item" items="${items}" >
                   <tr>
                       <td><input type="radio" value="" name="pickedItem"</td><td>${item}</td>
                   </tr>
                   </c:forEach> 
               </table>
               
                   
                   
                   
               
           </form>
           ${message}
           <form action="shoppinglist" method="post" name="delete">
               
               <input type="submit" value="Delete">
               
               <input type="hidden" name="action" value="delete">
           </form>
        
    </body>
</html>
