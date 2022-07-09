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
                    <img src="img/carousel-1.jpg" alt="hostel-img"
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
            <form method="POST" action="/HostelManagement_main/login/submit" class="register-form"
                  id="login-form">
                <div class="form-group ">
                    <label class="form-label" for="name">Hostel Name</label>
                    <input type="text" name="hostel_name" id="hostel_name" placeholder="Hostel Name"
                           value='${requestScope.details.name}' class="form-control" required="">
                </div>

                <div class="form-row">
                    <div class="form-group col-6 col-sm-6">
                        <label class="form-label" for="firstname">Hostel ID</label>
                        <input type="text" name="hostel_id" id="hostel_id" placeholder="123"
                               value=${requestScope.details.hostelId} class="form-control" required="">
                    </div>

                    <div class="form-group col-6 col-sm-6">
                        <label class="form-label" for="lastname">Owner ID</label>
                        <input type="text" name="owner_id" id="owner_id" placeholder="123"
                               value=${requestScope.details.ownerId} class="form-control" required="">
                    </div>
                </div>

                <div class="form-row ">
                    <div class="form-group col-6 col-sm-6">
                        <label for="city">City
                            <select class="form-control "  name="calc_shipping_provinces" required="">
                                <option value="">abc</option>
                            </select>
                        </label>
                    </div>


                    <div class="form-group  col-6 col-sm-6">
                        <label for="ward">Ward
                            <select class="form-control mx-0 " name="calc_shipping_district" required="">
                                <option value="">Ward</option>
                            </select>

                        </label>
                    </div>


                </div>

                <div class="form-group">
                    <label class="form-label" for="street">
                        Street
                    </label>
                    <input type="text" name="street" id="street" placeholder="Street"
                           class="form-control" value='${requestScope.details.street}'>
                </div>
                <div class="form-group">
                    <label class="form-label" for="street">
                        Address
                    </label>
                    <input type="text" name="address" id="street" placeholder="Address"
                           class="form-control" value='${requestScope.details.address}'>
                </div>
                <div class="text-center text-lg-start my-4 py-2">
                    <input type="submit" name="action" id="signup" value="Create"
                           class="form-submit btn btn-success"
                           style="padding-left: 2.5rem; padding-right: 2.5rem;background-color:#628272">
                    <button type="reset" class="btn btn-outline-secondary">Reset</button>
                </div>
            </form>
        </div>

    </div>


</div>
