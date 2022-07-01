<%-- 
    Document   : roomTenantList
    Created on : Jun 30, 2022, 1:33:23 PM
    Author     : tantrung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:useBean id='ContractDAO' class='daos.ContractDAO' scope='page'/>
<jsp:useBean id='AccountDAO' class='daos.AccountDAO' scope='page'/>


<c:set var="ContractList" value="${ContractDAO.getList('room_id', requestScope.room_id.toString())}"/>

<c:choose>
    
    <c:when test="${(ContractList != null) and (not empty ContractList)}">
        
        <div id="content">


            <div class="card mx-5 my-5">
                <table border="1" class="text-center">
                    <thead class="card-header btn-green">
                        <tr>
                            <th>Contract ID</th>
                            
                            <th>Client Name</th>
                            <th>Room price</th>
                            <th>Start date</th>
                            <th>End date</th>

                            <th>Deposit</th>
                            <th>Created at</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="contract" items="${ContractList}">

                            <c:set var="status" value="${contract.contract_status}"/>
                            <c:if test="${status !=0}">
                                <tr>
                                    <td>${contract.contract_id}</td>
                                    <td>
                                        <c:set var="client" value="${contract.client_id}" scope="page"/>
                                        <c:set var="client_name" value="${AccountDAO.getOne('account_id', client)}" scope="page"/>
                                        <c:out value="${client_name.fullname}"/>
                                    </td>
                                    <td>${contract.room_price}</td>
                                    <td>${contract.start_date}</td>
                                    <td>${contract.end_date}</td>

                                    <td>${contract.deposit}</td>
                                    <td>${contract.created_at}</td>
                                </tr>
                            </c:if>
                        </c:forEach>

                    </tbody>
                </table>

            </div>
        </div>
        
    </c:when>
    
    <c:otherwise>
        <span><c:out value="Don't have any contracts"/></span>
    </c:otherwise>
    
</c:choose>
