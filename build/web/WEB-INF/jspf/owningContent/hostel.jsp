

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:useBean id='HostelDAO' class='daos.HostelDAO' scope='page'/>

<jsp:useBean id='RoomDAO' class='daos.RoomsDAO' scope='page'/>

<c:set var="Hostel" value="${HostelDAO.getOne('owner_id', sessionScope.loginId.toString())}"/>

<c:choose>
    <c:when test="${(Hostel != null) and (not empty Hostel)}">        
        <div>
            <c:set var="RoomList" value="${RoomDAO.getList('hostel_id', Hostel.hostelId)}"/>
            
            <c:when test="${(RoomList != null) and (not empty RoomList)}">               
                <c:forEach var="room" items="${RoomList}">
                    <div onclick="window.location = '${pageContext.request.contextPath}/home/owning/hostels/${Hostel.hostelSlug}/rooms/${room.roomSlug}'">
                        <h3>${room.name}</h3>
                        <p>${room.max_contract} - ${room.room_slug}</p>
                    </div>
                    <div class ="line"></div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <span><c:out value="you don't have any room at this Hostels"/></span>
            </c:otherwise>
                
        </div>
    </c:when>
    <c:otherwise>
        <span><c:out value="you don't own any hostels"/></span>
    </c:otherwise>
</c:choose>
