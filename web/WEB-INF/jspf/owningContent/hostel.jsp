
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id='HostelDAO' class='daos.HostelDAO' scope='page'/>
<jsp:useBean id='RoomsDAO' class='daos.RoomsDAO' scope='page'/>
<c:set var="roomList" value="${RoomsDAO.getList('hostel_id', HostelDAO.getOne('hostel_slug', requestScope.hostelSlug).hostelId.toString())}"/>
<c:choose>
    <c:when test="${(roomList != null) and (not empty roomList)}">
        <div class="form-group">
            <table border="1">
                <thead>
                    <tr>
                        <th>Room Name</th>
                        <th>Number of Renting Available: </th>
                        <th> <th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="room" items="${roomList}">
                        <tr>
                            <td>${room.name}</td>
                            <td>${room.max_contract}</td>
                            <td> <a onclick="window.location = '${pageContext.request.contextPath}/home/owning/hostels/${hostel.hostelSlug}/room/${room.room_slug}'" class="btn btn-green " >Detail</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </c:when>
    <c:otherwise>
        <span><c:out value="you don't have any rooms at this hostel"/></span>
    </c:otherwise>
</c:choose>