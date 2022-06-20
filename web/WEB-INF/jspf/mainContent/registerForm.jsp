<%-- 
    Document   : registerForm
    Created on : Jun 16, 2022, 3:05:51 AM
    Author     : lekha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="authentication" style="background-image: url('${pageContext.request.contextPath}/img/sign-up.jpg');">


    <!-- Sign up  Form -->
    <section class="sign-up" >
        <div class="container-fluid">
            <div class=" d-flex justify-content-center align-items-center h-100">

                <div class="col-md-8 col-lg-6 col-xl-5 form-register">
                    <form method="POST" action="#" class="register-form"
                          id="register-form">

                        <a class="navbar-brand auth-logo " href="${pageContext.request.contextPath}"><img src="${pageContext.request.contextPath}/img/HomeCity.png"
                                                                                         height="50" width="50"><span>Hostel</span>City</a>





                        <div class="form-row">
                            <div class="form-group col-6 col-sm-6">
                                <label class="form-label" for="firstname">First Name</label>
                                <input type="text" name="firstName" id="firstname" placeholder="First Name" class="form-control"
                                       required />
                            </div>

                            <div class="form-group col-6 col-sm-6">
                                <label class="form-label" for="lastname">Last Name</label>
                                <input type="text" name="lastName" id="lastname" placeholder="Last Name" class="form-control" required />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="form-label" for="username">
                                Username
                            </label>
                            <input type="text" name="username" id="username" placeholder="Username" class="form-control" required="" />
                            <p>${ERROR_USERNAME}</p>
                        </div>
                        <div class="form-group">
                            <label class="form-label" for="pass">Password</label>
                            <input type="password" name="password" id="pass" placeholder="Password"
                                   pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}$" class="form-control" required />
                            <p>${ERROR_PASSWORD}</p>
                        </div>
                        <div class="form-group">
                            <label class="form-label" for="confirm">Confirm Password</label>
                            <input type="password" name="confirm" id="confirm" placeholder="Repeat your password"
                                   pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}$" class="form-control" required />
                            <p>${ERROR_CONFIRMPASSWORD}</p>
                        </div>

                        <div class="form-group">
                            <label class="form-label" for="email">Email Address</label>
                            <input type="email" name="email" id="email" placeholder="Your Email"
                                   pattern="[a-z0-9._%+-]+@(gmail.com|fpt.edu.vn|yahoo.com)" required=""
                                   title="Email addresses must not contain any upper letter and end with domains '@gmail.com' or '@fpt.edu.vn' or '@yahoo.com'"
                                   value='${email}' class="form-control" />
                            <p>${ERROR_EMAIL}</p>
                        </div>

                        <div class="form-group">
                            <label class="form-label" for="idcardnumber">
                                ID Card Number
                            </label>
                            <input type="text" name="idCardNumber" id="idcardnumber" placeholder="ID Card Number"
                                   maxlength="16" class="form-control" />
                            <p>${ERROR_IDCARDNUMBER}</p>
                        </div>
                        <div class="form-group">
                            <label class="form-label" for="dateOfBirth">Date of Birth</label>
                            <input type="date" name="dateOfBirth" id="dateOfBirth" placeholder="Date of birth"
                                   class="form-control" />
                        </div>
                        <div class="form-group">
                            <label class="form-label" for="contact">
                                Phone Number
                            </label>
                            <input type="tel" name="phone" id="contact" placeholder="Contact no" maxlength="10"
                                   pattern="[0-9]{10,10}" class="form-control" />
                            <p>${ERROR_PHONE}</p>
                        </div>




                        <div class="text-center text-lg-start mt-4 pt-2">


                            <input type="submit" name="action" id="signup" value="Register"
                                   class="form-submit btn btn-success"
                                   style="padding-left: 2.5rem; padding-right: 2.5rem;background-color:#628272"></input>

                        </div>
                        <p>${ERROR}</p>





                        <p class=" mt-5 pt-1 mb-0">Adready have account? <a href="${pageContext.request.contextPath}/login"
                                                                            style="color: green; font-style:italic; ">Log in now</a></p>
                    </form>
                </div>
            </div>
        </div>
    </section>

</div>
