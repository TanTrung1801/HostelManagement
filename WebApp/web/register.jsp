<%-- 
    Document   : register
    Created on : May 22, 2022, 10:12:52 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <h1>Register Page</h1>
        <form action="MainController" method="POST">
            User ID </br>
                <input type="text" name="userID" required="" placeholder="Input your ID"/></br>    
            Email </br>
                <input type ="email" name="email" required="" placeholder="Input your email"></br>
            Role </br>
                <input type ="radio" name="roleID" name="" value="user" checked> User
                <input type="radio" name="roleID" value="manager"> Manager</br>
            Password </br> 
                <input type="password" name="password" required="" placeholder="Input your password"/><br>
            Confirm  </br>
                <input type="password" name="confirm" required=""placeholder="Confirm your password"/></br>
            Full Name </br> 
                <input type="text" name="fullName" placeholder="Input Your Name "/></br>
            Date of Birth </br> 
                <input type="date" name="dateOfBirth"/></br>
            Identity Card </br> 
                <input type="text" name="idCard" placeholder="Input Your Indentity Card"/></br>
            Phone Number </br>
                <input type="text" name="phone" placeholder="Input Your Phone Number"/></br>
                <input type="submit" name="action" value="Register"/>
                <input type="reset" value="Reset"/> 
            </form>
        
        <%--Already have a account--%>
        <h2>
            --Already Have An Account ?-- </br>
            <button href="login.jsp">Sign In</button>
        </h2>
        <%-- Forgot Password--%>
        <h3>
            --Forgot Your Password ?--</br>
             <button href="forgot_password.jsp">Forgot my password</button>
        </h3>
    </body>
</html>
