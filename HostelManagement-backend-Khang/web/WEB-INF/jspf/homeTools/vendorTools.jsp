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
    <a href="${pageContext.request.contextPath}/home/${splitter[1]}/hostel-list" 
       data-toggle="collapse" aria-expanded="true"  class="dropdown-toggle">Hostel List</a>
    <ul class="list-unstyled collapse show" id="pageSubmenu" style="">
       
        <li id="create-hostel" class="tool-page">
            <a href="${pageContext.request.contextPath}/home/${splitter[1]}/create-hostel">Create Hostel</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/home/${splitter[1]}/hostel-list">View All</a>
        </li>
        <li>
            <a href="#">Manager</a>
        </li>

    </ul>
</li>

<li>
    <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="true" class="dropdown-toggle">Transaction</a>
    <ul class="list-unstyled collapse show" id="pageSubmenu" style="">

        <li>
            <a href="#">View All</a>
        </li>
        <li>
            <a href="#">View History</a>
        </li>
        <li>
            <a href="#">Report</a>
        </li>
    </ul>
</li>
<script>
    $(document).ready(function () {
        $(".tool-page").removeClass("active");
        $("#${currentPage}").addClass("active");
    });
</script>
