<%-- 
    Document   : index
    Created on : May 24, 2022, 4:43:34 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
        String id = (String)request.getAttribute("id");
        String name = (String)request.getAttribute("name");
        String email = (String)request.getAttribute("email");
        String roleID = (String)request.getAttribute("roleID");

  %>
  
  ID: <%= id %> </br>
  Name: <%= name %></br>
  Email: <%= email %><br>
  Role ID: <%= roleID %>
    </body>
</html>
