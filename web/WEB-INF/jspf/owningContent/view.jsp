<%-- 
    Document   : view
    Created on : Jun 17, 2022, 2:07:24 PM
    Author     : lekha
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:useBean id='HostelDAO' class='daos.HostelDAO' scope='page'/>


<c:set var="HostelList" value="${HostelDAO.getList('owner_id', sessionScope.loginId.toString())}"/>
    
<c:choose>
    <c:when test="${(HostelList != null) and (not empty HostelList)}">
        <div>
            <c:forEach var="hostel" items="${HostelList}">
                <div>
<!--                <div onclick="window.location = '${pageContext.request.contextPath}/home/owning/hostels/${hostel.hostelSlug}'">-->
                    <h3>${hostel.name}</h3>
                    <p>${hostel.street} - ${hostel.ward} - ${hostel.district} - ${hostel.city}</p>
                    <a onclick="window.location = '${pageContext.request.contextPath}/home/owning/hostels/${hostel.hostelSlug}'" class="btn btn-green " >Detail</a>
                </div>
                <div class ="line"></div>
            </c:forEach>
        </div>
    </c:when>
    <c:otherwise>
        <span><c:out value="you don't own any hostels"/></span>
    </c:otherwise>
</c:choose>
