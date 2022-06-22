<%-- 
    Document   : view
    Created on : Jun 20, 2022, 5:21:39 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:useBean id='ContractDAO' class='daos.ContractDAO' scope='page'/>
<jsp:useBean id='AccountDAO' class='daos.AccountDAO' scope='page'/>


<c:set var="ContractList" value="${ContractDAO.getList('client_id', sessionScope.loginId.toString())}"/>


<c:choose>
    <c:when test="${(ContractList != null) and (not empty ContractList)}">
        <div>
            <table border="1">
                <thead>
                    <tr>
                        <th>Contract ID</th>
                        <th>Room ID</th>
                        
                        <th>Room price</th>
                        <th>Start date</th>
                        <th>End date</th>
                        <th>Status</th>
                        <th>Deposit</th>
                        <th>Create at</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="hostel" items="${ContractList}">
                        
                            <c:set var="status" value="${hostel.contract_status}"/>
                            <c:if test="${status !=0}">
                                <tr>
                                    <td>${hostel.contract_id}</td>
                                    <td>${hostel.room_id}</td>
                                    
                                    <td>${hostel.room_price}</td>
                                    <td>${hostel.start_date}</td>
                                    <td>${hostel.end_date}</td>
                                    <td>${hostel.contract_status}</td>
                                    <td>${hostel.deposit}</td>
                                    <td>${hostel.created_at}</td>
                                </tr>
                            </c:if>          
                </c:forEach>

                </tbody>
            </table>
        </div>
    </c:when>
    <c:otherwise>
        <span><c:out value="you don't renting any rooms"/></span>
    </c:otherwise>
</c:choose>
