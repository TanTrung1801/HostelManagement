<%-- 
    Document   : room
    Created on : Jun 23, 2022, 4:39:02 PM
    Author     : Truong Thanh Trung
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:useBean id='RoomsDAO' class='daos.RoomsDAO' scope='page'/>
<jsp:useBean id='ContractDAO' class='daos.ContractsDAO' scope='page'/>
<jsp:useBean id='AccountDAO' class='daos.AccountDAO' scope='page'/>

<c:set var="contractList" value="${ContractDAO.getListContractsStatus('room_id', RoomsDAO.getOne('room_slug', requestScope.roomSlug).room_id.toString())}"/>
<c:choose>
    <c:when test="${(contractList != null) and (not empty contractList)}">
        <div class="form-group">
            <table border="1">
                <thead>
                    <tr>
                        <th>Client Name:</th>
                        <th>Price </th>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Deposit</th>
                        <th>Create Bill<th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="contracts" items="${contractList}">
                        <tr>
                            <td>${AccountDAO.getOne('account_id',contracts.client_id).fullname}</td>
                            <td>${contracts.room_price}</td>
                            <td> ${contracts.start_date}</td>
                            <td> ${contracts.end_date}</td>
                            <td> ${contracts.deposit}</td>
                            <td> <%-- tạo bill cho thằng thuê theo constracts --%></td>
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
