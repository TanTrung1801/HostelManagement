<%-- 
    Document   : clientTools
    Created on : Jun 23, 2022, 9:20:45 PM
    Author     : lekha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<c:set var='splitter' value="${fn:split(requestScope.processingPath,'/')}" scope='page'/>

<c:set var='currentPage' value="${splitter[fn:length(splitter)-1]}" scope='page'/>


<li id="renting-rooms" class="tool-page">
    <a href="${pageContext.request.contextPath}/home/${splitter[1]}/renting-rooms">Renting Rooms</a>
</li>

<li id="send-feedback" class="tool-page">
    <a href="${pageContext.request.contextPath}/home/${splitter[1]}/send-feedback">Send Feedback</a>
</li>
