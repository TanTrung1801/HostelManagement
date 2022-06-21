<%-- 
    Document   : home
    Created on : Jun 16, 2022, 3:58:17 AM
    Author     : lekha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<jsp:useBean id='AccountDAO' class='daos.AccountDAO' scope='page'/>

<c:set var="AccountObj" value="${AccountDAO.getOne('account_id', sessionScope.loginId)}"/>

<header class="navbar navbar-expand-lg navbar-light">
    <div class="container-fluid">

        <a class="navbar-brand mr-auto" href="${pageContext.request.contextPath}/home"><img src="${pageContext.request.contextPath}/img/HomeCity.png" height="40"
                                                                      width="40"><span>Hostel</span>City</a>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">



            <ul class="nav navbar-nav ml-auto">


                <li class="nav-item dropdown no-arrow mx-1">
                    <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-bell fa-fw"></i>
                        <!-- Counter - Alerts -->
                        <span class="badge badge-danger badge-counter">3+</span>
                    </a>
                    <!-- Dropdown - Alerts -->
                    <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in p-0"
                         aria-labelledby="alertsDropdown">
                        <h6 class="dropdown-header ">
                            Notification
                        </h6>
                        <a class="dropdown-item d-flex align-items-center" href="#">
                            <div class="mr-3">
                                <div class="icon-circle bg-primary">
                                    <i class="fas fa-file-alt text-white"></i>
                                </div>
                            </div>
                            <div>
                                <div class="small text-gray-500">December 12, 2019</div>
                                <span class="font-weight-bold">A new monthly report is ready to download!</span>
                            </div>
                        </a>
                        <a class="dropdown-item d-flex align-items-center" href="#">
                            <div class="mr-3">
                                <div class="icon-circle bg-success">
                                    <i class="fas fa-donate text-white"></i>
                                </div>
                            </div>
                            <div>
                                <div class="small text-gray-500">December 7, 2019</div>
                                $290.29 has been deposited into your account!
                            </div>
                        </a>
                        <a class="dropdown-item d-flex align-items-center" href="#">
                            <div class="mr-3">
                                <div class="icon-circle bg-warning">
                                    <i class="fas fa-exclamation-triangle text-white"></i>
                                </div>
                            </div>
                            <div>
                                <div class="small text-gray-500">December 2, 2019</div>
                                Spending Alert: We've noticed unusually high spending for your account.
                            </div>
                        </a>
                        <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
                    </div>
                </li>


                <div class="topbar-divider d-none d-sm-block"></div>
                <li class="nav-item dropdown no-arrow">
                    <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <span class="mr-2 d-none d-lg-inline text-white">${AccountObj.fullname}</span>
                        <img class="img-profile bg-white rounded-circle" src="${pageContext.request.contextPath}/img/Avatar_icon_green_1.svg.png">
                    </a>
                    <!-- Dropdown - User Information -->
                    <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                         aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/home/profile">
                            <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                            Profile
                        </a>
                        <a class="dropdown-item" href="#">
                            <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                            Settings
                        </a>
                        <a class="dropdown-item" href="#">
                            <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                            Activity Log
                        </a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/logout">
                            <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                            Logout
                        </a>
                    </div>
                </li>

            </ul>
        </div>
    </div>
</header>

<div id="homeContent">
    <c:choose>
        <c:when test ="${(homeContent eq 'homeDefault') or (homeContent eq 'unverifiedAccount')}">
            <jsp:include page="/WEB-INF/jspf/homeContent/${homeContent}.jsp"/>
        </c:when>
        <c:otherwise>
            <div class="main">
                <jsp:include page="/WEB-INF/jspf/homeContent/${homeContent}Tools.jsp"/>

                <div id="content">
                    <div class="row">
                        <ol class="col-12 breadcrumb">
                            <c:set var='linkName' value="${fn:split(requestScope.processingPath,'/')}" scope='page'/>

                            <c:forEach begin='0' end="${fn:length(linkName)-2}" var='i'>
                                <c:set var='linkPath' value='${linkName[0]}' scope='page'/>
                                <c:forEach begin='1' end='${i}' var='j'>
                                    <c:set var='linkPath' value='${linkPath}/${linkName[j]}' scope='page'/>
                                </c:forEach>

                                <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/${linkPath}">${fn:toUpperCase(fn:substring(linkName[i], 0, 1))}${fn:toLowerCase(fn:substring(linkName[i], 1,fn:length(linkName[i])))}</a></li>                               
                                </c:forEach>

                            <li class="breadcrumb-item active">${fn:toUpperCase(fn:substring(linkName[fn:length(linkName)-1], 0, 1))}${fn:toLowerCase(fn:substring(linkName[fn:length(linkName)-1], 1,fn:length(linkName[fn:length(linkName)-1])))}</li>
                        </ol>
                        <div class="col-12">
                            <h3>${fn:toUpperCase(fn:substring(linkName[fn:length(linkName)-1], 0, 1))}${fn:toLowerCase(fn:substring(linkName[fn:length(linkName)-1], 1,fn:length(linkName[fn:length(linkName)-1])))}</h3>
                            <!--<h3>${linkName[fn:length(linkName)-1]}</h3>-->
                        </div>
                    </div>

                    <jsp:include page="/WEB-INF/jspf/homeContent/${homeContent}.jsp"/>
                </div>         
            </div>
        </c:otherwise>
    </c:choose>

</div>

<footer class="footer">
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-sm-5 col-xs-6">
                <a class="site-title"><img src="${pageContext.request.contextPath}/img/HomeCity.png" height="50" width="50"><span>Hostel</span>City</a>
                <p>We provide accommodation management support services for homeowners</p>
            </div>
            <div class="col-md-5 col-sm-5 col-sm-offset-0 col-xs-6  ">
                <h3>Keep in touch</h3>
                <ul class="list-unstyled contact-links">
                    <li><i class="fa fa-envelope" aria-hidden="true"></i><a
                            href="mailto:info@agencyperfect.com">Hostelmanagementse1633@gmail.com</a></li>
                    <li><i class="fa fa-phone" aria-hidden="true"></i><a href="tel:+37400800000">+374 (00) 80 00 00
                        </a></li>
                    <li><i class="fa fa-fax" aria-hidden="true"></i><a href="+37400900000">+374 (00) 90 00 00</a>
                    </li>
                    <li><i class="fa fa-map-marker" aria-hidden="true"></i>
                        <a href="#">FPT University, HCM City</a>

                    </li>
                </ul>
            </div>
            <div class="clearfix visible-xs"></div>
            <div class="col-md-offset- col-lg-3 col-md-3 col-sm-4 col-md-offset-2 col-xs-6">
                <h3>Featured links</h3>
                <ul class="list-unstyled">
                    <li><a href="#">Home</a></li>
                    <li class="active"><a href="#">View User</a></li>
                </ul>
            </div>
        </div>
    </div>
</footer>
