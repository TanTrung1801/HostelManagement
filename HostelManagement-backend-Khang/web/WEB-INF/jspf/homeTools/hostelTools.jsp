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


<li id="detail-infomation" class="tool-page">
    <a href="${pageContext.request.contextPath}/home/owning/hostels/${splitter[3]}/hostel-details">Detail Infomation</a>
</li>

<li id="room-list" class="tool-page">
    <a href="${pageContext.request.contextPath}/home/owning/hostels/${splitter[3]}/room-list">Room List</a>
    <ul class="list-unstyled collapse show" id="roomList" style="">
        <li>
            <a href="${pageContext.request.contextPath}/home/owning/hostels/${splitter[3]}/create-room">Create New Room</a>
        </li>
        <li>
            <a href="#">View All</a>
        </li>
        <li>
            <a href="#">Manager</a>
        </li>
    </ul>
</li>

<li id="transaction" class="tool-page">
    <a href="#">Transaction</a>
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
<li id="feedback" class="tool-page">
    <a href="#">Feedback</a>
</li>
<li id="help-center" class="tool-page">
    <a href="#">Help Center</a>
</li>

<script>
    $(document).ready(function () {
        $(".tool-page").removeClass("active");
        $("#${currentPage}").addClass("active");
    });
</script>
