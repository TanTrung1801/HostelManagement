<%-- 
    Document   : createNewContract
    Created on : Jul 15, 2022, 1:23:15 PM
    Author     : lekha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<c:set var='splitter' value="${fn:split(requestScope.processingPath,'/')}" scope='page'/>

<c:set var='currentPage' value="${splitter[fn:length(splitter)-1]}" scope='page'/>

<jsp:useBean id='RoomDAO' class='daos.RoomDAO' scope='page'/>
<jsp:useBean id='ContractDAO' class='daos.ContractDAO' scope='page'/>
<jsp:useBean id='HostelDAO' class='daos.HostelDAO' scope='page'/>

<c:set var="hostelObj" value="${HostelDAO.getOne('hostel_slug', splitter[3])}"/>
<c:set var="roomObj" value="${RoomDAO.getOne(requestScope.columnValuePair)}"/>

<div class="container-fluid mt-5 mb-5">




    <div class="col-md-8 col-lg-8 col-xl-8 offset-sm-2 ">
        <form method="POST" action="#" class="register-form "
              id="login-form">




            <div class="form-group">
                <label class="form-label" for="Hostel_name">
                    Hostel Name
                </label>
                <input 
                       value="${hostelObj.name}" class="form-control" disabled="">

            </div>

            <div class="form-group">
                <label class="form-label" for="Room_name">
                    Room Name
                </label>
                <input value="${roomObj.name}"
                       class="form-control" disabled="">

            </div>




            <div class="form-group">

                <label class="form-label" for="Price">
                    Price
                </label>
                <div class="input-group">
                    <input type="number" name="price" id="price" placeholder="price" value=""
                           maxlength="16" class="form-control" min="0">
                    <span class="input-group-text">$</span>
                </div>

            </div>

            <div class="form-group">

                <label class="form-label" for="Deposit">
                    Deposit
                </label>
                <div class="input-group">
                    <input type="number" name="deposit" id="Deposit" placeholder="Deposit" value=""
                           maxlength="16" class="form-control" min="0">
                    <span class="input-group-text">$</span>
                </div>

            </div>

            <div class="form-group">
                <label class="form-label" for="startDate">Start Date</label>
                <input type="date" name="startDate" id="startDate" placeholder="Start Date"
                       class="form-control">
            </div>

            <div class="form-group">
                <label class="form-label" for="endDate">End Date</label>
                <input type="date" name="endDate" id="endDate" placeholder="End Date"
                       class="form-control">
            </div>








            <div class="text-center text-lg-start my-4 py-2">


                <input type="submit" name="action" id="signup" value="Create"
                       class="form-submit btn btn-success"
                       style="padding-left: 2.5rem; padding-right: 2.5rem;background-color:#628272">
                <button type="reset" class="btn btn-outline-secondary">Cancel</button>
            </div>






        </form>
    </div>
</div>
