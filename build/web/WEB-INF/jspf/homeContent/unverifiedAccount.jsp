<%-- 
    Document   : unverifiedAccount
    Created on : Jun 16, 2022, 3:45:59 PM
    Author     : lekha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Your Email is not verified</h1>
<c:choose>
    <c:when test="${sent}">
        <form method="post">
            <input type="submit" value="Resend verification">
        </form>
        <p>An verification email had been sent, please check your email</p>
    </c:when>
    <c:otherwise>
        <form method="post">
            <input type="submit" value="Verify Your Email">
        </form>
    </c:otherwise>
</c:choose>

