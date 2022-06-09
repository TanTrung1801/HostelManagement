<%-- 
    Document   : home
    Created on : Jun 2, 2022, 3:24:43 PM
    Author     : lekha
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="navbar navbar-expand-lg navbar-light">
    <div class="container-fluid">

        <a class="navbar-brand mr-auto" href="/HostelManagement_main/home"><img src="/HostelManagement_main/img/HomeCity.png" height="50"
                                                                      width="50"><span>Hostel</span>City</a>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">



            <ul class="nav navbar-nav ml-auto">

                <li class="nav-item">
                    <a class="nav-link" href="#">Notification</a>
                </li>
                <li class="dropdown nav-item">
                    <a href="#profile" class="nav-link" data-toggle="dropdown" aria-expanded="false">
                        <div class="photo">
                            <img src="/HostelManagement_main/img/img1.jpg" alt="Profile Photo">
                        </div>
                        <b class="caret d-none d-lg-block d-xl-block"></b>
                        <p class="d-lg-none">
                            Log out
                        </p>
                    </a>
                    <ul class="dropdown-menu dropdown-navbar">
                        <li class="nav-link">
                            <a href="/HostelManagement_main/home/profile" class="nav-item dropdown-item">Profile</a>
                        </li>
                        <li class="nav-link">
                            <a href="#" class="nav-item dropdown-item">Settings</a>
                        </li>
                        <li class="dropdown-divider"></li>
                        <li class="nav-link">
                            <a href="/HostelManagement_main/logout" class="nav-item dropdown-item">Log out</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</header>
<!--<header>
    <div>
        BANNER GOES HERE
        <a href="/HostelManagement_main/home/profile">Your profile</a>
        <a href="/HostelManagement_main/logout">Logout</a>
    </div>

    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item active" aria-current="page">Home</li>
        </ol>
    </nav>
</header>-->

<div id="homeContent">
    <c:choose>
        <c:when test ="${homeContent eq 'default'}">
            <jsp:include page="/WEB-INF/homeContent/${homeContent}.jsp"/>
        </c:when>
        <c:otherwise>
            <div class="main">
                <jsp:include page="/WEB-INF/homeContent/${homeContent}Tools.jsp"/>
                <jsp:include page="/WEB-INF/homeContent/${homeContent}.jsp"/>
            </div>
        </c:otherwise>
    </c:choose>

</div>

<footer class="footer">
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-sm-5 col-xs-6">
                <a class="site-title"><img src="/HostelManagement_main/img/HomeCity.png" height="50" width="50"><span>Hostel</span>City</a>
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



