<%-- 
    Document   : roomList
    Created on : Jul 15, 2022, 4:23:40 AM
    Author     : lekha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<c:set var='splitter' value="${fn:split(requestScope.processingPath,'/')}" scope='page'/>

<c:set var='currentPage' value="${splitter[fn:length(splitter)-1]}" scope='page'/>

<jsp:useBean id='RoomDAO' class='daos.RoomDAO' scope='page'/>
<jsp:useBean id='ContractDAO' class='daos.ContractDAO' scope='page'/>

<c:set var="ContractList" value="${ContractDAO.getList('client_id', sessionScope.loginId)}"/>

<c:set var="RoomList" value="${RoomDAO.getList('hostel_id', hostelObj.hostelId)}"/>

<c:choose>
    <c:when test="${(ContractList != null) and (not empty ContractList)}">
        <div class="card mx-5 my-5">
            Total: ${ContractList.size()}
            <table class="table">
                <thead>
                    <tr class="btn-green">
                        <th>Room Name</th>
                        <th>Max Contract</th>
                        <th>Active Contracts</th>
                        <th>Actions</th>
                    </tr>
                </thead>   
                <c:forEach var="room" items="${RoomList}">                   
                    <tbody class="table-border-bottom-0">
                        <tr>
                            <td>
                                ${room.name}
                            </td>
                            <td>${room.maxContract}</td>
                            <td>${RoomModelDAO.getOne(room).activeContracts.size()}</td>
                            <td>
                                <a class="btn btn-green" href="${pageContext.request.contextPath}/home/owning/hostels/${splitter[3]}/rooms/${room.roomSlug}/room-details">
                                    Details
                                </a>
                            </td>
                        </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
    </c:when>
    <c:otherwise>
        <span><c:out value="You are not renting any rooms"/></span>
    </c:otherwise>
</c:choose>

