<%-- 
    Document   : admin
    Created on : May 23, 2022, 11:31:49 AM
    Author     : nguye
--%>

<%@page import="java.util.List"%>
<%@page import="org.apache.catalina.User"%>
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
        
        
        <form action="MainController">
            <input type="submit" name="action" value="View all user"/>
        </form>
        
        
        
        
        <%
            List<UserDTO> listUser = (List<UserDTO>)request.getAttribute("LIST_USER");
            if(listUser != null){
                if(listUser.size() > 0){
                    %>
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>User ID</th>
                                <th>Password</th>
                                <th>Role ID</th>
                                <th>Full Name</th>
                                <th>Email</th>
                                <th>Phone Number</th>
                                <th>ID card</th>
                                <th>DoB</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                int count = 1;
                                for(UserDTO user : listUser){
                                    %>
                                    <tr>
                                        <td><%= count++ %></td>
                                        <td><%=user.getUserID() %></td>
                                        <td><%=user.getPassword() %></td>
                                        <td><%=user.getRoleID() %></td>
                                        <td><%=user.getFullName() %></td>
                                        <td><%=user.getEmail() %></td>
                                        <td><%=user.getPhoneNumber() %></td>
                                        <td><%=user.getIDcard() %></td>
                                        <td><%=user.getDoB() %></td>
                                        <td><%=user.getStatus() %></td>
                                    </tr>
                                    <%
                                }
                            %>
                            
                        </tbody>
                    </table>

                    
                    
                    <%
                }
            }
        
        %>
            
           
            
        
            
            
            
            
    </body>
</html>
