<%-- 
    Document   : hostelDetails-details
    Created on : Jul 10, 2022, 11:02:29 PM
    Author     : lekha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<jsp:useBean id='HostelDAO' class='daos.HostelDAO' scope='page'/>
<jsp:useBean id='AccountDAO' class='daos.AccountDAO' scope='page'/>

<c:set var='splitter' value="${fn:split(requestScope.processingPath,'/')}" scope='page'/>

<c:set var="HostelObj" value="${HostelDAO.getOne('hostel_slug', splitter[3])}"/>

<c:set var="AccountObj" value="${AccountDAO.getOne('account_id', HostelObj.ownerId)}"/>

    <div class="form-group ">
        <label class="form-label" for="hostelName">Hostel Name</label>
        <span id="hostelName" class="form-control" >${HostelObj.name}</span>
    </div>
        
    <div class="form-group ">
        <label class="form-label" for="ownerName">Hostel Owner</label>
        <span id="ownerName" class="form-control" >${AccountObj.fullname}</span>
    </div>

<!--    <div class="form-row">
        <div class="form-group col-6 col-sm-6">
            <label class="form-label" for="firstname">Hostel ID</label>
            <span class="form-control">${HostelObj.hostelId} </span>
        </div>

        <div class="form-group col-6 col-sm-6">
            <label class="form-label" for="lastname">Owner ID</label>
            <input type="text" name="owner_id" id="owner_id" placeholder="123"
                   value=${requestScope.details.ownerId} class="form-control" required="">
        </div>
    </div>-->

    <div class="form-group">
        <label class="form-label" for="address">
            Address
        </label>
        <span id="address" class="form-control"> ${HostelObj.street} - ${HostelObj.ward} - ${HostelObj.district} - ${HostelObj.city} </span>
    </div>
    <div class="text-center text-lg-start my-4 py-2">
        <a href="${pageContext.request.contextPath}/home/${splitter[1]}/hostels/${splitter[3]}/hostel-details?action=getUpdateForm" class="btn btn-success" style="background-color:#628272; color:white" id="updateButton">Update</a>
    </div>
