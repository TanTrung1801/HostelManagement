<%-- 
    Document   : roomTools
    Created on : Jun 23, 2022, 9:21:55 PM
    Author     : lekha
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<c:set var='splitter' value="${fn:split(requestScope.processingPath,'/')}" scope='page'/>

<c:set var='currentPage' value="${splitter[fn:length(splitter)-1]}" scope='page'/>

<li id="room-details" class="tool-page">
    <a href="${pageContext.request.contextPath}/home/${splitter[1]}/tenant-room/${requestScope.room_slug}/room-details">View Room</a>
</li>

<li id="send-feedback" class="tool-page">
    <a href="${pageContext.request.contextPath}/home/${splitter[1]}/tenant-room/${requestScope.room_slug}/send-feedback">Send feedback</a>
</li>


<script>
    $(document).ready(function () {
        $(".tool-page").removeClass("active");
        $("#${currentPage}").addClass("active");
    });
</script>
