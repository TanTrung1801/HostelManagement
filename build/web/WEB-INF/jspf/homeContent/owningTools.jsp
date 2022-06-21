<%-- 
    Document   : owningTools
    Created on : Jun 17, 2022, 2:03:10 PM
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
            <a href="${pageContext.request.contextPath}/home/owning/view">View</a>
        </li>
        <li <c:if test="${currentPage eq 'create-hostel'}">class="active"</c:if>>
            <a href="${pageContext.request.contextPath}/home/owning/create-hostel">Create new Hostel</a>
        </li>
    </ul>
</nav>

