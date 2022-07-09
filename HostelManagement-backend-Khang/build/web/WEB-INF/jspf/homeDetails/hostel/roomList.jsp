<%-- 
    Document   : roomList
    Created on : Jul 1, 2022, 9:48:51 AM
    Author     : lekha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<c:set var='splitter' value="${fn:split(requestScope.processingPath,'/')}" scope='page'/>

<c:set var='currentPage' value="${splitter[fn:length(splitter)-1]}" scope='page'/>
<jsp:useBean id='RoomDAO' class='daos.RoomDAO' scope='page'/>
<c:set var="RoomList" value="${RoomDAO.getList('hostel_id', sessionScope.hostel_id)}"/>
<c:choose>
    <c:when test="${(RoomList != null) and (not empty RoomList)}">
        <div class="card mx-5 my-5">
            <table class="table">
                <thead>
                    <tr class="btn-green">
                        <th>No.</th>
                        <th>Room Name</th>
                        <th>No Contract</th>
                        <th>Actions</th>
                    </tr>
                </thead>   
                <c:forEach var="room" items="${RoomList}">                   
                    <tbody class="table-border-bottom-0">
                        <tr>
                            <td> ${room.roomId}</td>
                            <td>
                                ${room.name}
                            </td>
                            <td>${room.maxContract}</td>
                            <td>
                                <div class="dropdown no-arrow">
                                    <a class="dropdown-toggle hide-arrow" href="#" id="userDropdown" role="button"
                                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">

                                        <button type="button" class="btn p-0  ">
                                            <i class="fa fa-ellipsis-v"></i>
                                        </button>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/home/owning/hostels/${splitter[3]}/room-details">
                                            Detail
                                        </a>
                                        <a class="dropdown-item" href="#">
                                            Edit
                                        </a>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
    </c:when>
    <c:otherwise>
        <span><c:out value="you don't own any room"/></span>
    </c:otherwise>
</c:choose>
