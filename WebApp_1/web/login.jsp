<%-- 
    Document   : login
    Created on : May 22, 2022, 10:02:01 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form action="MainController" method="POST">
            User ID </br>
                <input type="text" name="userID" required="" placeholder="Input your ID"/></br>
            Password </br> 
                <input type="password" name="password" required="" placeholder="Input your password"/><br>
                <input type="submit" name="action" value="Login"/>
                <input type="reset" value="Reset"/>
            </form>
            
        <h1>
            ${requestScope.ERROR}
            ${requestScope.status}
        </h1>
        
        <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8084/WebApp_1/LoginGoogleController&response_type=code
    &client_id=292534222114-c67cd7kucbrqlgpkvf02g68i64pisibc.apps.googleusercontent.com&approval_prompt=force">Login with Google</a>
        
        <h2>
            <a href="register.jsp">Register</a>
        </h2>
        <h3>
            <a href="forgot_password.jsp">Forgot my password</a>
        </h3>
        
    </body>
</html>
