<%-- 
    Document   : hostelList
    Created on : Jun 24, 2022, 1:27:47 PM
    Author     : lekha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<jsp:useBean id='HostelDAO' class='daos.HostelDAO' scope='page'/>
<jsp:useBean id='AccountDAO' class='daos.AccountDAO' scope='page'/>

<c:set var='splitter' value="${fn:split(requestScope.processingPath,'/')}" scope='page'/>

<c:set var="HostelList" value="${HostelDAO.getList('owner_id', sessionScope.loginId.toString())}"/>
    
    
<c:choose>
    <c:when test="${(HostelList != null) and (not empty HostelList)}">
        <div class="card mx-5 my-5">
            Total: ${HostelList.size()}
            <table class="table">
                <thead>
                    <tr class="btn-green">
                        <th>Image</th>
                        <th>Owner</th>
                        <th>Name</th>
                        <th>Address</th>                      
                        <th>Actions</th>
                    </tr>
                </thead>   
                <c:forEach var="hostel" items="${HostelList}">                   
                    <tbody class="table-border-bottom-0">
                        <tr>
                            <td width="20%"><img src="${pageContext.request.contextPath}/img/background-image.jpg" alt="Hostel image" width="100%"></td>
                            <td>${AccountDAO.getOne("account_id", hostel.ownerId).fullname}</td>
                            <td>${hostel.name}</td>
                            <td><i class="fa fa-map-marker" aria-hidden="true"></i>${hostel.street} - ${hostel.ward} - ${hostel.district} - ${hostel.city}</td>
                            
                            <td>
                                <a href="${pageContext.request.contextPath}/home/owning/hostels/${hostel.hostelSlug}" class="btn btn-green ">Details</a>
                            </td>
                        </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
<!--          <div class="row mt-5">
            <c:forEach var="hostel" items="${HostelList}">          
                    <div class="col-md-6 col-lg-4 mb-3">
                        <div class="card h-100">
                            <img class="card-img-top" src="${pageContext.request.contextPath}/img/background-image.jpg" alt="Card image cap" height="100%">
                            <div class="card-body ">
                                <h5 class="card-title">${hostel.name}</h5>
                                <p class="card-text">
                                    <i class="fa fa-map-marker" aria-hidden="true"></i>
                                    ${hostel.street} - ${hostel.ward} - ${hostel.district} - ${hostel.city}
                                </p>
                                <a href="${pageContext.request.contextPath}/home/owning/hostels/${hostel.hostelSlug}" class="btn btn-green ">Detail</a>
                                
                            </div>
                        </div>
                    </div>
            </c:forEach>
          </div>-->
          <div>
            <nav aria-label="Page navigation">
                    <ul class="pagination justify-content-center mt-5">
                        <li class="page-item prev">
                            <a class="page-link" href="javascript:void(0);"><i class="fa fa-angle-left"></i></a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="javascript:void(0);">1</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="javascript:void(0);">2</a>
                        </li>
                        <li class="page-item active">
                            <a class="page-link" href="javascript:void(0);">3</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="javascript:void(0);">4</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="javascript:void(0);">5</a>
                        </li>
                        <li class="page-item next">
                            <a class="page-link" href="javascript:void(0);"><i class="fa fa-angle-right"></i></a>
                        </li>
                    </ul>
                </nav>
        </div>
    </c:when>
    <c:otherwise>
        <span><c:out value="you don't own any hostels"/></span>
    </c:otherwise>
</c:choose>

