<%-- 
    Document   : vendorManagerTools
    Created on : Jun 23, 2022, 9:37:15 PM
    Author     : lekha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<c:set var='splitter' value="${fn:split(requestScope.processingPath,'/')}" scope='page'/>

<c:set var='currentPage' value="${splitter[fn:length(splitter)-1]}" scope='page'/>


<li id="room-details" class="tool-page">
    <a href="${pageContext.request.contextPath}/home/${splitter[1]}/hostels/${splitter[3]}/rooms/${splitter[5]}/room-details">Room Details</a>
</li>

<li id="contract-list" class="tool-page">
    <a href="${pageContext.request.contextPath}/home/${splitter[1]}/hostels/${splitter[3]}/rooms/${splitter[5]}/contract-list">Contract List</a>
</li>

<li id="create-new-contract" class="tool-page">
    <a href="${pageContext.request.contextPath}/home/${splitter[1]}/hostels/${splitter[3]}/rooms/${splitter[5]}/create-new-contract">Create New Contract</a>
</li>
