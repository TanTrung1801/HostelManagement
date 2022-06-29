<%-- 
    Document   : hostelList
    Created on : Jun 24, 2022, 1:27:47 PM
    Author     : lekha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:useBean id='HostelDAO' class='daos.HostelDAO' scope='page'/>


<c:set var="HostelList" value="${HostelDAO.getList('owner_id', sessionScope.loginId.toString())}"/>
    
    
<c:choose>
    <c:when test="${(HostelList != null) and (not empty HostelList)}">
          <div class="row mt-5">
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
          </div>
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

