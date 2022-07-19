<%-- 
    Document   : roomDetails
    Created on : Jul 1, 2022, 10:34:55 AM
    Author     : lekha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<jsp:useBean id='RoomModelDAO' class='daos.RoomModelDAO' scope='page'/>
<jsp:useBean id='AccountDAO' class='daos.AccountDAO' scope='page'/>

<c:set var='splitter' value="${fn:split(requestScope.processingPath,'/')}" scope='page'/>

<c:set var="RoomModelObj" value="${RoomModelDAO.getOne(columnValuePair)}"/>

<div class="mx-5 my-3">
    <div class="form-row">
        <div class="form-group col-6 col-sm-6">
            <label class="form-label" for="roomName">Room Name</label>
            <span id="roomName" class="form-control">${RoomModelObj.name} </span>
        </div>

        <div class="form-group col-6 col-sm-6">
            <label class="form-label" for="currentContracts">Current Contract</label>
            <span id="currentContracts" class="form-control">
                <c:out value="${RoomModelObj.activeContracts eq null ? '0': RoomModelObj.activeContracts.size()}"/>/${RoomModelObj.maxContract}
            </span>
        </div>
    </div>
</div>

<div class="card mx-5 my-5">
    <table class="table">
        <thead>
            <tr class="btn-green">
                <th>Tenant</th>
                <th>Start Date</th>
                <th>End date</th>
                <th>Action</th>
            </tr>
        </thead>   
        <tbody class="table-border-bottom-0">
            <c:choose>
                <c:when test='${(RoomModelObj.activeContracts eq null) or (empty RoomModelObj.activeContracts)}'>
                    <tr><td colspan="4">This room is currently empty</td></tr>
                </c:when>
                <c:otherwise>
                    <c:forEach var="contract" items="${RoomModelObj.activeContracts}">                   
                        <tr>
                            <td>${AccountDAO.getOne("account_id", contract.clientId).fullname}</td>
                            <td>${contract.startDate}</td>
                            <td>${contract.endDate}</td>
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

                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </tbody>
    </table>
</div>
<!--<div>
    <div class="row mt-5">
        <div class="col-md-6 col-lg-4 mb-3">
            <div class="card h-100">

                <div class="card-body ">
                    <h5 class="card-title">Tran Hoang Kim Ngan</h5>
                    <div class="card-text">
                        <p class="mb-0">Start date: 02/02/2022</p>
                        <p class="mb-0">End date: 02/05/2022</p>
                        <p class="mb-0">Price: 100$</p>
                        <p class="mb-0">Deposit: 200$</p>

                    </div>


                    <a href="javascript:void(0)" class="btn btn-green ">Detail</a>
                    <a href="javascript:void(0)" class="btn btn-outline-success" style="background-color:#fafafa; color:#628272;">Create Bill</a>


                </div>
            </div>
        </div>
    </div>
</div>-->
