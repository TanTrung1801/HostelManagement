<%-- 
    Document   : hostelTools
    Created on : Jun 23, 2022, 9:21:45 PM
    Author     : lekha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<c:set var='splitter' value="${fn:split(requestScope.processingPath,'/')}" scope='page'/>

<c:set var='currentPage' value="${splitter[fn:length(splitter)-1]}" scope='page'/>

<li id="hostel-details" class="tool-page">
    <a href="${pageContext.request.contextPath}/home/${splitter[1]}/hostels/${splitter[3]}/hostel-details">Hostel Details</a>
</li>

<li id="room-list" class="tool-page">
    <a href="${pageContext.request.contextPath}/home/${splitter[1]}/hostels/${splitter[3]}/room-list">Room List</a>
</li>

<li id="create-room" class="tool-page">
    <a href="${pageContext.request.contextPath}/home/${splitter[1]}/hostels/${splitter[3]}/create-room">Create Room</a>
</li>


