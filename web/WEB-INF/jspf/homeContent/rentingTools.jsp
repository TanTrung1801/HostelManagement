<%-- 
    Document   : rentingTools
    Created on : Jun 20, 2022, 5:25:24 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<c:set var='splitter' value="${fn:split(requestScope.processingPath,'/')}" scope='page'/>

<c:set var='currentPage' value="${splitter[fn:length(splitter)-1]}" scope='page'/>

<nav id="menu">
    <ul class="list-unstyled components">
        <li <c:if test="${currentPage eq 'view'}">class="active"</c:if>>
            <a href="${pageContext.request.contextPath}/home/renting/view">View</a>
        </li>
        <li <c:if test="${currentPage eq 'create-feedback'}">class="active"</c:if>>
            <a href="${pageContext.request.contextPath}/home/renting/create-feedback">Create Feedback</a>
        </li>
        <li <c:if test="${currentPage eq 'view-payment'}">class="active"</c:if>>
            <a href="${pageContext.request.contextPath}/home/renting/view-payment">View Payment</a>
        </li>
    </ul>
</nav>
