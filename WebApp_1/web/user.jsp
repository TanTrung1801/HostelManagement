<%-- 
    Document   : user
    Created on : May 24, 2022, 8:27:52 AM
    Author     : nguye
--%>

<%@page import="dto.UserDTO"%>
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
            if(loginUser==null || !loginUser.getRoleID().equals("US") || loginUser.getStatus()!=1){
                response.sendRedirect("login.jsp");
                return;
            }
            %>
            <h1>Welcome: ${sessionScope.LOGIN_USER.getFullName()} </h1>
            User ID : ${sessionScope.LOGIN_USER.getUserID()}</br>
            Role ID : ${sessionScope.LOGIN_USER.getRoleID()}</br>
            Full Name : ${sessionScope.LOGIN_USER.getFullName()}</br>
            Email : ${sessionScope.LOGIN_USER.getEmail()}</br>
            Phone Number : ${sessionScope.LOGIN_USER.getPhoneNumber()}</br>
            ID card : ${sessionScope.LOGIN_USER.getIDcard()}</br>
            Date of birth : ${sessionScope.LOGIN_USER.getDoB()}</br>
        <form action="MainController">
                <input type="submit" name="action" value="Logout"/>
        </form>
        
    </body>
</html>
