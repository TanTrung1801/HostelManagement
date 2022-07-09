<%-- 
    Document   : profileTools
    Created on : Jun 23, 2022, 9:19:09 PM
    Author     : lekha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<c:set var='splitter' value="${fn:split(requestScope.processingPath,'/')}" scope='page'/>

<c:set var='currentPage' value="${splitter[fn:length(splitter)-1]}" scope='page'/>

<li id="view" class="tool-page">
    <a href="${pageContext.request.contextPath}/home/profile/view">View</a>
</li>
<li id="change-password" class="tool-page">
    <a href="${pageContext.request.contextPath}/home/profile/change-password">Change Password</a>
</li>

<script>
    $(document).ready(function () {
        $(".tool-page").removeClass("active");
        $("#${currentPage}").addClass("active");
    });
</script>

