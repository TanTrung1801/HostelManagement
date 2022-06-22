<%-- 
    Document   : viewPayment
    Created on : Jun 21, 2022, 8:50:41 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id='PaymentDAO' class='daos.PaymentDAO' scope='page'/>
<jsp:useBean id='Payment_detail_DAO' class='daos.Payment_detail_DAO' scope='page'/>

<c:set var="PaymentList" value="${PaymentDAO.getList('receiver_id', sessionScope.loginId.toString())}"/>
<c:choose>
    <c:when test="${(PaymentList != null) and (not empty PaymentList)}">
        <div class="form-group">
            <table border="1">
                <thead>
                    <tr>
                        <th>Payment ID</th>
                        <th>Contract ID</th>
                        <th>Sender ID</th>
                        <th>Created at</th>
                        <th>Paid at</th>
                        <th>Payment status</th>
                        <th>View details</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="payment" items="${PaymentList}">
                        <tr>
                            <td>${payment.payment_id}</td>
                            <td>${payment.contract_id}</td>
                            <td>${payment.sender_id}</td>                            
                            <td>${payment.created_at}</td>
                            <td>${payment.paid_at}</td>
                            <td>${payment.payment_status}</td>
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
    </c:when>
    <c:otherwise>
        <span><c:out value="you don't have any payments"/></span>
    </c:otherwise>
</c:choose>