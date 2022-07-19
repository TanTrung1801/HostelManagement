<%-- 
    Document   : contractList
    Created on : Jul 1, 2022, 10:35:03 AM
    Author     : lekha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<c:set var='splitter' value="${fn:split(requestScope.processingPath,'/')}" scope='page'/>

<c:set var='currentPage' value="${splitter[fn:length(splitter)-1]}" scope='page'/>

<jsp:useBean id='RoomDAO' class='daos.RoomDAO' scope='page'/>
<jsp:useBean id='ContractDAO' class='daos.ContractDAO' scope='page'/>
<jsp:useBean id='AccountDAO' class='daos.AccountDAO' scope='page'/>

<c:set var="roomObj" value="${RoomDAO.getOne(requestScope.columnValuePair)}"/>

<c:set var="ContractList" value="${ContractDAO.getList('room_id', roomObj.roomId)}"/>

<c:choose>
    <c:when test="${(ContractList != null) and (not empty ContractList)}">
        <div class="card mx-5 my-5">
            Total: ${ContractList.size()}
            <table class="table">
                <thead>
                    <tr class="btn-green">
                        <th>Tenant</th>
                        <th>Start Date</th>
                        <th>End date</th>
                        <th>Status</th>
                        <th>Created At</th>
                        <th>Actions</th>
                    </tr>
                </thead>   
                <c:forEach var="contract" items="${ContractList}">                   
                    <tbody class="table-border-bottom-0">
                        <tr>
                            <td>${AccountDAO.getOne("account_id", contract.clientId).fullname}</td>
                            <td>${contract.startDate}</td>
                            <td>${contract.endDate}</td>
                            <td><c:out value="${contract.status eq 0 ? 'inactive' : 'active'}"/></td>
                            <td>${contract.createdAt}</td>
                            <td>
                                <div class="dropdown no-arrow">
                                    <a class="dropdown-toggle hide-arrow" href="#" id="userDropdown" role="button"
                                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">

                                        <button type="button" class="btn p-0  ">
                                            <i class="fa fa-ellipsis-v"></i>
                                        </button>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/home/owning/hostels/${splitter[3]}/rooms/${room.roomSlug}/room-details">
                                            Details
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
        <span><c:out value="This hostel doesn't have any room"/></span>
    </c:otherwise>
</c:choose>

