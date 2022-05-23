<%-- 
    Document   : admin
    Created on : May 23, 2022, 11:31:49 AM
    Author     : nguye
--%>

<%@page import="user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <h1>ADMIN</h1>
        <%
            UserDTO loginUser = (UserDTO)session.getAttribute("LOGIN_USER");
            if(loginUser == null){
                response.sendRedirect("login.jsp");
                return;
            }
            %>
            <%= loginUser.getFullName() %>
    </body>
</html>
