<%-- 
    Document   : profileTools
    Created on : Jun 17, 2022, 3:36:02 AM
    Author     : lekha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<c:set var='splitter' value="${fn:split(requestScope.processingPath,'/')}" scope='page'/>

<c:set var='currentPage' value="${splitter[fn:length(splitter)-1]}" scope='page'/>

<nav id="menu">
    <ul class="list-unstyled components">
        <li <c:if test="${currentPage eq 'view'}">class="active"</c:if>>
            <a href="${pageContext.request.contextPath}/home/profile/view">View</a>
        </li>
        <li <c:if test="${currentPage eq 'change-password'}">class="active"</c:if>>
            <a href="${pageContext.request.contextPath}/home/profile/change-password">Change Password</a>
        </li>
    </ul>
</nav>
