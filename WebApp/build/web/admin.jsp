<%-- 
    Document   : admin
    Created on : May 23, 2022, 11:31:49 AM
    Author     : nguye
--%>

<%@page import="dto.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        
        <%
            UserDTO loginUser = (UserDTO)session.getAttribute("LOGIN_USER");
            if(loginUser==null || !loginUser.getRoleID().equals("AD")){
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
