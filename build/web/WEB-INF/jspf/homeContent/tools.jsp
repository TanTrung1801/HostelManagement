<%-- 
    Document   : toolList
    Created on : Jun 23, 2022, 9:12:59 PM
    Author     : lekha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<c:set var='splitter' value="${fn:split(requestScope.processingPath,'/')}" scope='page'/>

<c:set var='currentPage' value="${splitter[fn:length(splitter)-1]}" scope='page'/>

<nav id="menu">
    <ul class="list-unstyled components">
        <jsp:include page="/WEB-INF/jspf/homeTools/${homeTools}"/>
    </ul>
</nav>

<script>
    $(document).ready(function () {
        $(".tool-page").removeClass("active");
        $("#${currentPage}").addClass("active");
    });
</script>