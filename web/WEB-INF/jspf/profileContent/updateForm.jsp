<%-- 
    Document   : updateForm
    Created on : Jun 17, 2022, 4:27:14 AM
    Author     : lekha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<jsp:useBean id='AccountDAO' class='daos.AccountDAO' scope='page'/>

<c:set var="AccountObj" value="${AccountDAO.getOne('account_id', sessionScope.loginId)}"/>

<form method="POST" action="${pageContext.request.contextPath}/home/profile/view" class="register-form" id="update-profile-form">

    <div class="form-row">
        <div class="form-group col-6 col-sm-6">
            <label class="form-label" for="firstname">First Name</label>
            <input type="text" name="firstName" id="firstname" placeholder="First Name"
                   value="${AccountObj.firstname}" class="form-control" required="">
        </div>

        <div class="form-group col-6 col-sm-6">
            <label class="form-label" for="lastname">Last Name</label>
            <input type="text" name="lastName" id="lastname" placeholder="Last Name"
                   value="${AccountObj.lastname}" class="form-control" required="">
        </div>
    </div>

    <div class="form-group">
        <label class="form-label" for="username">
            Username
        </label>
        <input type="text" id="username" placeholder="Username"
               value="${AccountObj.username}" class="form-control" disabled>

    </div>

    <div class="form-group">
        <label class="form-label" for="email">Email Address</label>
        <input type="email" id="email" placeholder="Your Email"
               pattern="[a-z0-9._%+-]+@(gmail.com|fpt.edu.vn|yahoo.com)" required=""
               title="Email addresses must not contain any upper letter and end with domains '@gmail.com' or '@fpt.edu.vn' or '@yahoo.com'"
               value="${AccountObj.email}" class="form-control" disabled>
    </div>

    <div class="form-group">
        <label class="form-label" for="contact">
            Phone Number
        </label>
        <input type="tel" name="phone" id="contact" placeholder="Contact no" value="${AccountObj.phone}"
               maxlength="10" pattern="[0-9]{10,10}" class="form-control">
        <p>${ERROR_PHONE}</p>
    </div>
    <div class="form-group">
        <label class="form-label" for="idcardnumber">
            ID Card Number
        </label>
        <input type="text" id="idcardnumber" placeholder="ID Card Number"
               value="${AccountObj.idCardNumber}" maxlength="16" class="form-control" disabled>
    </div>
    <div class="form-group">
        <label class="form-label" for="dateOfBirth">Date of Birth</label>
        <input type="date" name="dateOfBirth" id="dateOfBirth" placeholder="Date of birth"
               class="form-control" value="${AccountObj.dateOfBirth}">
    </div>
   

    <div class="text-center text-lg-start my-4 py-2">
        <input type="submit" id="signup" value="Confirm Update"
               class="form-submit btn btn-success"
               style="padding-left: 2.5rem; padding-right: 2.5rem;background-color:#628272">
        <a href="${pageContext.request.contextPath}/home/profile/view" class="btn btn-outline-secondary" id="cancelUpdate">Cancel</a>
    </div>
    <input type="hidden" name="action" value="updateProfile"/>
</form>
<p>${ERROR}</p>


