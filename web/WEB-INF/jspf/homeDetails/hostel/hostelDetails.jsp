<%-- 
    Document   : hostelDetails
    Created on : Jun 24, 2022, 2:41:53 PM
    Author     : lekha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container-fluid mb-5">
    <div class=" d-flex mt-5  ">
        <div class="col-md-9 col-lg-5 col-xl-4 offset-sm-1 mt-5">
            <div class="card" height="auto" width="auto">
                <div class=" justify-content-between align-items-center">
                    <img src="${pageContext.request.contextPath}/img/carousel-1.jpg" alt="hostel-img"
                         class="d-block bg-white border shadow my-4 mx-auto" height="300"
                         width="300" id="uploadedHosImg">
                    <div class="button-wrapper mx-4">

                        <label for="upload" class="btn btn-green mx-5 me-2 mb-4" tabindex="0">
                            <span class="d-none d-sm-block">Upload New photo</span>
                            <i class="bx bx-upload d-block d-sm-none"></i>
                            <input type="file" id="upload" class="account-file-input" hidden=""
                                   accept="image/png, image/jpeg">
                        </label>


                    </div>
                </div>
            </div>

        </div>
        <div class="col-md-8 col-lg-6 col-xl-5 offset-sm-1 my-5">
            <c:if test="${hostelDetailsContent eq null}"><c:set var="hostelDetailsContent" value="hostelDetails-details.jsp"/></c:if>
            <jsp:include page="/WEB-INF/jspf/homeDetails/hostel/${hostelDetailsContent}"/>
        </div>
    </div>
</div>
