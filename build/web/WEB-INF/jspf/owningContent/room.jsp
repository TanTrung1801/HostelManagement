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
        <div>
            <c:forEach var="contracts" items="${contractList}">
                <div>
                    <h3>Client Name:${AccountDAO.getOne('account_id',contracts.client_id).fullname}</h3>
                    <p>Room_ID: ${contracts.room_id} - Price: ${contracts.room_price}- Start: ${contracts.start_date}- End: ${contracts.end_date}- deposit: ${contracts.deposit}</p>
                </div>
                <div class ="line"></div>
            </c:forEach>
        </div>
    </c:when>
     <c:otherwise>
        <span><c:out value="you don't have any reting at this rooms"/></span>
    </c:otherwise>
</c:choose>
