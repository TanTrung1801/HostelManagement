<%-- 
    Document   : default
    Created on : Jun 16, 2022, 4:32:15 AM
    Author     : lekha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container-fluid p-0">
    <div id="header-carousel" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="w-100" src="${pageContext.request.contextPath}/img/carousel-3.jpg" alt="Image"  height="700" width="auto">
                <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                    <div class="p-3" style="max-width: 800px;">
                        <h4 class=" text-uppercase font-weight-bold mb-md-3">Best Hostel management Service</h4>
                        <h3 class="display-3 font-weight-normal text-white mb-md-4">HOSTELS YOU OWN</h3>
                        <a href="${pageContext.request.contextPath}/home/owning" class="btn btn-homepage py-md-3 px-md-5 mt-2 mt-md-4">Go</a>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <img class="w-100" src="${pageContext.request.contextPath}/img/carousel-2.jpg" alt="Image"  height="700" width="auto">
                <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                    <div class="p-3" style="max-width: 800px;">
                        <h4 class=" text-uppercase font-weight-bold mb-md-3">Best Hostel management Service</h4>
                        <h3 class="display-3 font-weight-normal  text-white mb-md-4">HOSTELS YOU MANAGE</h3>
                        <a href="${pageContext.request.contextPath}/home/managing" class="btn btn-homepage py-md-3 px-md-5 mt-2 mt-md-4">Go</a>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <img class="w-100" src="${pageContext.request.contextPath}/img/carousel-1.jpg" alt="Image" height="700" width="auto" >
                <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                    <div class="p-3" style="max-width: 800px;">
                        <h4 class="text-uppercase font-weight-bold mb-md-3">Best Hostel management Service</h4>
                        <h3 class="display-3 font-weight-normal text-white mb-md-4">ROOMS YOU ARE RENTING </h3>
                        <a href="${pageContext.request.contextPath}/home/renting" class="btn btn-homepage py-md-3 px-md-5 mt-2 mt-md-4">Go</a>
                    </div>
                </div>
            </div>
        </div>
        <a class="carousel-control-prev" href="#header-carousel" data-slide="prev">
            <div class="btn btn-homepage" style="width: 45px; height: 45px;">
                <span class="carousel-control-prev-icon mb-n2"></span>
            </div>
        </a>
        <a class="carousel-control-next" href="#header-carousel" data-slide="next">
            <div class="btn btn-homepage" style="width: 45px; height: 45px;">
                <span class="carousel-control-next-icon mb-n2"></span>
            </div>
        </a>
    </div>
</div>
