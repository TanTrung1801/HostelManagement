
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id='HostelDAO' class='daos.HostelDAO' scope='page'/>
<jsp:useBean id='RoomsDAO' class='daos.RoomsDAO' scope='page'/>

<c:set var="RoomList" value="${RoomsDAO.getList('hostel_id', HostelDAO.getOne('hostel_slug', requestScope.hostelSlug).hostelId.toString())}"/>

<c:choose>
    <c:when test="${ (RoomList != null) and (not empty RoomList)}"> 
        <div>
            <c:forEach var="room" items="${RoomList}">
                <div>
<!--                <div onclick="window.location = '${pageContext.request.contextPath}/home/owning/hostels/${Hostel.hostelSlug}/rooms/${room.roomSlug}'">-->
                    <h3>${room.name}</h3>
                    <p>${room.max_contract} - ${room.room_slug}</p>
                    <a onclick="window.location = '${pageContext.request.contextPath}/home/owning/hostels/${hostel.hostelSlug}'" class="btn btn-green " >Detail</a>
                </div>

<!--                <div onclick="window.location = '${pageContext.request.contextPath}/home/owning/hostels/${Hostel.hostelSlug}/rooms/${room.roomSlug}'">
    <h3>${room.name}</h3>
    <p>${room.max_contract} - ${room.room_slug}</p>
</div>-->                    
                <div class ="line"></div>
            </c:forEach>
        </div>
    </c:when>
     <c:otherwise>
        <span><c:out value="you don't have any rooms at this hostel"/></span>
    </c:otherwise>
</c:choose>
