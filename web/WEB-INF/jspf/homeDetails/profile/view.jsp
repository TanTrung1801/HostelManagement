<%-- 
    Document   : view
    Created on : Jun 23, 2022, 10:01:02 PM
    Author     : lekha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<jsp:useBean id='AccountDAO' class='daos.AccountDAO' scope='page'/>

<c:set var="AccountObj" value="${AccountDAO.getOne('account_id', sessionScope.loginId)}"/>

<div class="container-fluid mb-5">
    <div class=" d-flex mt-5  ">
        <div class="col-md-9 col-lg-5 col-xl-4 offset-sm-1 mt-5">
            <div class="card" height="auto" width="auto">
                <div class=" justify-content-between align-items-center">
                    <img src="${pageContext.request.contextPath}/img/Avatar_icon_green_1.svg.png" alt="user-avatar"
                         class="d-block bg-white rounded-circle border shadow my-4 mx-auto" height="300"
                         width="300" id="uploadedAvatar">
                    <div class="button-wrapper mx-4">

                        <label for="upload" class="btn btn-green mx-3 me-2 mb-4" tabindex="0">
                            <span class="d-none d-sm-block">Upload photo</span>
                            <i class="bx bx-upload d-block d-sm-none"></i>
                            <input type="file" id="upload" class="account-file-input" hidden=""
                                   accept="image/png, image/jpeg">
                        </label>
                        <button type="button"
                                class="btn btn-outline-secondary account-image-reset mx-2 me-2 mb-4">
                            <i class="bx bx-reset d-block d-sm-none"></i>
                            <span class="d-none d-sm-block">Reset</span>
                        </button>

                    </div>
                </div>
            </div>
        </div>
        <div id="profileDetails" class="col-md-8 col-lg-6 col-xl-5 offset-sm-1 ">
            <c:if test="${viewContent eq 'null'}"><c:set var="viewContent" value="profileDetails.jsp"/>"</c:if>
            <jsp:include page="/WEB-INF/jspf/homeDetails/profile/${viewContent}"/>
        </div>
    </div>
</div>

<script>
    $('body').on('click', '#updateButton', function (e) {
        console.log("Hello world!");
        e.preventDefault();
        $.ajax({
            url: "${pageContext.request.contextPath}/home/profile/view?action=getUpdateForm",
            success: function (result) {
                $("#profileDetails").html(result);
            }
        });
    });

    $('body').on('click', '#cancelUpdate', function (e) {
        console.log("Hello world!");
        e.preventDefault();
        $.ajax({
            url: "${pageContext.request.contextPath}/home/profile/view?action=getView",
            success: function (result) {
                $("#profileDetails").html(result);
            }
        });
    });

    $('body').on('submit', '#update-profile-form', function (e) {
//    $("#update-profile-form").submit(function (e) {
        e.preventDefault(); // prevent actual form submit
        console.log("Hello world!");
        var form = $(this);
        var url = form.attr('action'); //get submit url [replace url here if desired]
        $.ajax({
            type: "POST",
            url: url,
            data: form.serialize(), // serializes form input
            success: function (result) {
                $("#profileDetails").html(result);
            }
        });
    });

</script>

