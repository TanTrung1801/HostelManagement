<%-- 
    Document   : profileDetails
    Created on : Jun 17, 2022, 4:59:02 AM
    Author     : lekha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<jsp:useBean id='AccountDAO' class='daos.AccountDAO' scope='page'/>

<c:set var="AccountObj" value="${AccountDAO.getOne('account_id', sessionScope.loginId)}"/>

<div class="form-group">
    <label class="form-label" for="fullname">
        Full Name
    </label>
    <span id="fullname" class="form-control">${AccountObj.fullname}</span>
</div>

<div class="form-group">
    <label class="form-label" for="username">
        Username
    </label>
    <span id="username" class="form-control">${AccountObj.username}</span>
</div>

<div class="form-group">
    <label class="form-label" for="email">Email Address</label>
    <span id="email" class="form-control">${AccountObj.email}</span>
</div>
<div class="form-group">
    <label class="form-label" for="contact">
        Phone Number
    </label>
    <span id="contact" class="form-control">  ${AccountObj.phone}</span>
</div>
<div class="form-group">
    <label class="form-label" for="idcardnumber">
        ID Card Number
    </label>
    <span id="idcardnumber" class="form-control">${AccountObj.idCardNumber}</span>
</div>
<div class="form-group">
    <label class="form-label" for="dateOfBirth">Date of Birth</label>
    <span id="dateOfBirth" class="form-control"> ${AccountObj.dateOfBirth} </span>
</div>


<div class="text-center text-lg-start my-4 py-2">
    <a href="${pageContext.request.contextPath}/home/profile/view?action=getUpdateForm" class="btn btn-success" style="background-color:#628272; color:white" id="updateButton">Update profile</a>
</div>
