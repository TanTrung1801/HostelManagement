<%-- 
    Document   : tenant_contract-confirm
    Created on : Jul 8, 2022, 5:37:37 PM
    Author     : zeddr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<jsp:useBean id='AccountDAO' class='daos.AccountDAO' scope='page'/>

<c:set var="AccountObj" value="${AccountDAO.getOne('account_id', sessionScope.loginId)}"/>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>Collapsible sidebar using Bootstrap 4</title>

    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
        integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="./css/style.css">

    <!-- Font Awesome JS -->
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"
        integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ"
        crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"
        integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY"
        crossorigin="anonymous"></script>

</head>

<body>


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







    <div class="main">

        <!-- Sidebar Holder -->
        <nav id="menu">
            <ul class="list-unstyled components">
                <li >
                    <a href="#">My Contract</a>
                </li>
                <li class="active">
                    
                </li>
                <li>
                    <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false"
                        class="dropdown-toggle">Transaction</a>
                    <ul class="collapse list-unstyled" id="pageSubmenu">
                        
                        <li>
                            <a href="#">My Bill</a>
                        </li>
                        <li>
                            <a href="#">History</a>
                        </li>
                        
                    </ul>
                </li>

                <li>
                    <a href="#">Feedback</a>
                </li>

                <li>
                    <a href="#">Help Center</a>
                </li>
            </ul>


        </nav>






        <div id="content">

            <!-- Breadcrumb Content Holder -->
            <div class="row">
                <ol class="col-12 breadcrumb">
                    <li class="breadcrumb-item"><a href="./index.html">Home</a></li>
                    <li class="breadcrumb-item active">Notification</li>
                    

                </ol>
                <div class="col-12">
                    <h3>New Contract</h3>

                </div>
            </div>


            <div class="container-fluid mt-5 mb-5">





                <div class="col-md-8 col-lg-8 col-xl-8 offset-sm-2 ">
                    <form method="POST" action="/HostelManagement_main/login/submit" class="register-form "
                        id="login-form">




                        <div class="form-group">
                            <label class="form-label" for="Hoatel_name">
                                Hostel Name
                            </label>
                            <input type="text" name="username" id="Hostel_name" placeholder="Hostel_Name"
                                value="Sky9 Hostel" class="form-control" disabled="">

                        </div>

                        <div class="form-group">
                            <label class="form-label" for="Room_name">
                                Room Name
                            </label>
                            <input type="text" name="username" id="Room_name" placeholder="Room_Name" value="Room 101"
                                class="form-control" disabled="">

                        </div>

                        <div class="form-group">
                            <label class="form-label" for="Tenant_id">
                                Tenant ID
                            </label>
                            <input type="text" name="tenant_id" id="tenant_id" placeholder="Tenant ID" value="LNK12345evr"
                                class="form-control" required="">

                        </div>

                        <div class="form-group">
                            <label class="form-label" for="Tenant_name">
                                Tenant Name
                            </label>
                            <input type="text" name="tenant_name" id="tenant_name" placeholder="Tenant Name" value="Le Nguyen Khang"
                                class="form-control" required="">

                        </div>


                      

                        <div class="form-group">

                            <label class="form-label" for="Price">
                                Price
                            </label>
                            <div class="input-group">
                                <input type="number" name="price" id="price" placeholder="price" value="100"
                                    maxlength="16" class="form-control" min="0" disabled>
                                <span class="input-group-text">$</span>
                            </div>

                        </div>

                        <div class="form-group">

                            <label class="form-label" for="Deposit">
                                Deposit
                            </label>
                            <div class="input-group">
                                <input type="number" name="Deposit" id="Deposit" placeholder="Deposit" value="200"
                                    maxlength="16" class="form-control" min="0" disabled>
                                <span class="input-group-text">$</span>
                            </div>

                        </div>

                        <div class="form-group">
                            <label class="form-label" for="dateOfBirth">Start Date</label>
                            <input type="date" name="Start_Date" id="Start_Date" placeholder="Start Date" value="22/2/2011"
                                class="form-control" disabled>
                        </div>

                        <div class="form-group">
                            <label class="form-label" for="dateOfBirth">End Date</label>
                            <input type="date" name="End_Date" id="End_Date" placeholder="End_ Date" value="22/2/2022"
                                class="form-control" disabled>
                        </div>



                        




                        <div class="text-center text-lg-start my-4 py-2">


                            <input type="submit" name="action" id="signup" value="Confirm"
                                class="form-submit btn btn-success"
                                style="padding-left: 2.5rem; padding-right: 2.5rem;background-color:#628272">
                            <button type="reset" class="btn btn-outline-secondary">Cancel</button>
                        </div>






                    </form>
                </div>
            </div>
        </div>


    </div>



    </div>
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
                                href="mailto:Hostelmanagementse1633@gmail.com">Hostelmanagementse1633@gmail.com</a></li>
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

    <script src='https://cdn.jsdelivr.net/gh/vietblogdao/js/districts.min.js'></script>
    <!-- jQuery CDN - Slim version (=without AJAX) -->
    <script src="https://code.jquery.com/jquery-3.6.0.js"
        integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <!-- Popper.JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
        integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
        crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
        integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
        crossorigin="anonymous"></script>
    <script src="/js/main.js"></script>

</body>

</html>