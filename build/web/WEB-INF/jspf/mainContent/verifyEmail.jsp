<%-- 
    Document   : verifyEmail
    Created on : Jun 16, 2022, 7:46:33 PM
    Author     : lekha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<c:choose>
    <c:when test="${verifyStatus eq 'succeeded'}">
        <h1>Your email had been verified, your account is now active</h1>
    </c:when>
    <c:otherwise>
        <h1>Verification failed:</h1>
        <h1>${ERROR}</h1>
    </c:otherwise>
</c:choose>
