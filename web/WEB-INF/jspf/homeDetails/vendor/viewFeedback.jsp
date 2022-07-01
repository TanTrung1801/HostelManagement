<%-- 
    Document   : viewFeedback
    Created on : Jun 30, 2022, 9:27:04 AM
    Author     : tantrung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id='FeedbackDAO' class="daos.FeedbackDAO" scope="page"/>
<jsp:useBean id='HostelDAO' class="daos.HostelDAO" scope="page"/>
<jsp:useBean id='RoomDAO' class="daos.RoomDAO" scope="page"/>
<jsp:useBean id='AccountDAO' class="daos.AccountDAO" scope="page"/>

<c:set var="ListHostel" value="${HostelDAO.getList('owner_id', sessionScope.loginId.toString())}"/>



<c:choose>
    <c:when test="${(ListHostel != null) and (not empty ListHostel)}">

        <div class="card mx-5 my-5">
            <div class="table-responsive text-nowrap">
                <table class="table">
                    <thead>
                        <tr class="btn-green">
                            <th>Hostel</th>
                            <th>Room</th>
                            <th>Client</th>
                            <th>Content</th>
                            <th>Send at</th>

                        </tr>
                    </thead>
                    <tbody class="table-border-bottom-0">

                        <c:forEach var="listHostel" items="${ListHostel}">



                            <c:set var="hostel_id" value="${listHostel.hostelId}"/>
                            <c:set var="feedback" value="${FeedbackDAO.getList('hostel_id', hostel_id)}"/>
                            <c:forEach var="list" items="${feedback}">
                                <tr>
                                    <td>
                                        <c:set var="hostel_id" value="${list.hostel_id}"/>
                                        <c:out value="${HostelDAO.getOne('hostel_id', hostel_id).name}"/>
                                    </td>
                                    
                                    <td>
                                        <c:set var = "room_id" value="${list.room_id}"/>
                                        <c:choose>
                                            <c:when test="${room_id != 0}">
                                                <c:out value="${RoomDAO.getOne('room_id', room_id).name}"/>
                                            </c:when>
                                            <c:otherwise>
                                                <c:out value="---"/>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    
                                    <td>
                                        <c:set var="client_id" value="${list.client_id}"/>
                                        <c:out value="${AccountDAO.getOne('account_id', client_id).fullname}"/>
                                    </td>
                                    <td>${list.content}</td>
                                    <td>${list.send_at}</td>
                                </tr>

                            </c:forEach>








                        </c:forEach>




                    </tbody>
                </table>
            </div>
        </div>




    </c:when>

    <c:otherwise>
        <span><c:out value="Your hostel don't have any feedbacks"/></span>
    </c:otherwise>
</c:choose>
