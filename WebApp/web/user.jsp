<%-- 
    Document   : user
    Created on : May 24, 2022, 8:27:52 AM
    Author     : nguye
--%>

<%@page import="user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>    
        <%
            UserDTO loginUser = (UserDTO)session.getAttribute("LOGIN_USER");
            if(loginUser==null || !loginUser.getRoleID().equals("US")){
                response.sendRedirect("login.jsp");
                return;
            }
            %>
            <h1>Welcome: ${sessionScope.LOGIN_USER.getFullName()} </h1>
        <form action="MainController">
                <input type="submit" name="action" value="Logout"/>
        </form>
    </body>
</html>
