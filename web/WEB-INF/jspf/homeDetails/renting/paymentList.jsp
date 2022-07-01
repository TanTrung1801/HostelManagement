<%-- 
    Document   : paymentList
    Created on : Jun 30, 2022, 1:11:33 PM
    Author     : tantrung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id='PaymentDAO' class='daos.PaymentDAO' scope='page'/>
<jsp:useBean id='Payment_detail_DAO' class='daos.Payment_detail_DAO' scope='page'/>
<jsp:useBean id='AccountDAO' class='daos.AccountDAO' scope='page'/>
<jsp:useBean id='ContractDAO' class='daos.ContractDAO' scope='page'/>
<jsp:useBean id='RoomDAO' class='daos.RoomDAO' scope='page'/>
<jsp:useBean id='HostelDAO' class='daos.HostelDAO' scope='page'/>


<c:set var="PaymentList" value="${PaymentDAO.getList('receiver_id', sessionScope.loginId.toString())}"/>
<c:choose>
    <c:when test="${(PaymentList != null) and (not empty PaymentList)}">
        <div id="content">


            <div class="card mx-5 my-5">
                
                <div class="table-responsive text-nowrap">
                    
                
                <table class="table">
                    <thead>
                        <tr class="btn-green">
                            <th>Payment ID</th>
                            <th>Hostel</th>
                            <th>Room</th>
                            
                            <th>Sender Name</th>
                            <th>Created at</th>
                            <th>Paid at</th>
                            <th>Payment status</th>
                            <th>View details</th>
                        </tr>
                    </thead>
                    <tbody class="table-border-bottom-0">
                        
                        <c:forEach var="payment" items="${PaymentList}">
                            <c:set var="contract_id" value="${payment.contract_id}" scope="page"/>
                            <c:set var="contract" value="${ContractDAO.getOne('contract_id', contract_id)}" scope="page"/>
                            <c:set var="room_id" value="${contract.room_id}" scope="page"/>
                            <c:set var="room" value="${RoomDAO.getOne('room_id', room_id)}"/>
                            <c:set var="hostel_id" value="${room.hostel_id}"/>
                            <c:set var="hostel" value="${HostelDAO.getOne('hostel_id', hostel_id)}"/>
                            <tr>
                                <td>${payment.payment_id}</td>
                                <td>

                                    <c:out value="${hostel.name}"/>
                                </td>
                                <td>

                                    <c:out value="${room.name}"/>
                                </td>
                                
                                <td>
                                    <c:set var="sender" value="${payment.sender_id}" scope="page"/>
                                    <c:set var="sender_name" value="${AccountDAO.getOne('account_id', sender)}" scope="page"/>
                                    <c:out value="${sender_name.fullname}"/>
                                </td>                            
                                <td>${payment.created_at}</td>
                                <td>${payment.paid_at}</td>
                                <td>
                                    <c:set var="status" value="${payment.payment_status}"/>
                                    <c:choose>
                                        <c:when test="${status == 1}">
                                            
                                            <span class="badge bg-label-success me-1">
                                                <c:out value="Done"/>
                                            </span>
                                           
                                        </c:when>
                                        <c:otherwise>
                                            <span class="badge bg-label-danger me-1">
                                                <c:out value="Unpaid"/>
                                            </span>
                                            
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:set var="payment_id" value="${payment.payment_id}"/>
                                    <c:set var="DetailList" value="${Payment_detail_DAO.getList('payment_id', payment_id)}"/>
                                    <c:forEach var="detail" items="${DetailList}">
                                        
                                        <p>${detail.name} - ${detail.price}</p>
                                    </c:forEach>

                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                    </div>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <span><c:out value="you don't have any payments"/></span>
    </c:otherwise>
</c:choose>