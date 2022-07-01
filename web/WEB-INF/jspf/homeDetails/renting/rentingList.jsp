<%-- 
    Document   : rentingList
    Created on : Jun 30, 2022, 8:59:53 AM
    Author     : tantrung
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id='ContractDAO' class='daos.ContractDAO' scope='page'/>
<jsp:useBean id='AccountDAO' class='daos.AccountDAO' scope='page'/>
<jsp:useBean id='RoomDAO' class='daos.RoomDAO' scope='page'/>
<jsp:useBean id='HostelDAO' class='daos.HostelDAO' scope='page'/>

<c:set var="ContractList" value="${ContractDAO.getList('client_id', sessionScope.loginId.toString())}"/>

<c:choose>
    <c:when test="${(ContractList != null) and (not empty ContractList)}">

        <div id="content">
            <div class="card mx-5 my-5">
                <table border="1" class="text-center">
                    <thead class="card-header btn-green">
                        <tr> 
                            <th>Hostel Name</th>
                            <th>Room name</th>
                            <th>View room</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="contract" items="${ContractList}">

                            <c:set var="status" value="${contract.contract_status}"/>
                            <c:if test="${status !=0}">
                                <c:set var="room_id" value="${contract.room_id}" scope="page"/>
                                <c:set var="ListRoom" value="${RoomDAO.getList('room_id', room_id.toString())}"/>
                                <c:forEach var="room" items="${ListRoom}">
                                    <tr>

                                        <td>
                                            <c:set var="hostel_id" value="${room.hostel_id}" scope="page"/>
                                            <c:set var="hostel_name" value="${HostelDAO.getOne('hostel_id', hostel_id)}" scope="page"/>
                                            <c:out value="${hostel_name.name}"/>
                                        </td>

                                        <td>${room.name}</td>

                                        <td class="text-center">
                                            <form method="GET" action="${pageContext.request.contextPath}/home/renting/tenant-room/${room.room_slug}">
                                                
                                                <input type="submit" value="View">
                                            </form>
                                        </td>
                                    </tr>

                                </c:forEach>
                            </c:if>
                        </c:forEach>



                    </tbody>
                </table>

            </div>

        </div>

    </c:when>

    <c:otherwise>
        <span><c:out value="you don't renting any rooms"/></span>
    </c:otherwise>

</c:choose>





