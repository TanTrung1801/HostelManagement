<%-- 
    Document   : vendorTools
    Created on : Jun 23, 2022, 9:21:02 PM
    Author     : lekha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<c:set var='splitter' value="${fn:split(requestScope.processingPath,'/')}" scope='page'/>

<c:set var='currentPage' value="${splitter[fn:length(splitter)-1]}" scope='page'/>


<li id="hostel-list" class="tool-page">
    <a href="${pageContext.request.contextPath}/home/${splitter[1]}/hostel-list">Hostel List</a>
</li>

<li id="create-hostel" class="tool-page">
    <a href="${pageContext.request.contextPath}/home/${splitter[1]}/create-hostel">Create Hostel</a>
</li>

<script>
    $(document).ready(function () {
        $(".tool-page").removeClass("active");
        $("#${currentPage}").addClass("active");
    });
</script>
