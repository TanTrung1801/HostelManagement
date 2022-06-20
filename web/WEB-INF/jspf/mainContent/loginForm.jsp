<%-- 
    Document   : newjsp
    Created on : Jun 16, 2022, 2:21:41 AM
    Author     : lekha
--%>

<div class="authentication" style="background-image: url('${pageContext.request.contextPath}/img/sign-in.jpg');">


    <!-- Sign in  Form -->
    <section class="sign-in">
        <div class="container-fluid">
            <div class=" d-flex justify-content-center align-items-center h-100">
                <div class="col-md-9 col-lg-6 col-xl-5">
                    <img src="${pageContext.request.contextPath}/img/sign-in.png" class="img-fluid" alt="Sample image">
                </div>
                <div class="col-md-8 col-lg-6 col-xl-4 offset-sm-1 form-login">
                    <form method="POST" action="#" class="register-form"
                          id="login-form">
                        <a class="navbar-brand auth-logo " href="${pageContext.request.contextPath}"><img src="${pageContext.request.contextPath}/img/HomeCity.png"
                                                                                         height="50" width="50"><span>Hostel</span>City</a>

                        <!-- Email input -->
                        <div class="form-group mb-4">
                            <label class="form-label" for="user-login">Your Username, email or phone
                                number</label>
                            <input type="text" id="user-login" class="form-control form-control-lg"
                                   name="indexValue"
                                   placeholder="Username, email or phone number" required />

                        </div>

                        <!-- Password input -->
                        <div class="form-group mb-3">
                            <label class="form-label" for="password">Password</label>
                            <input type="password" id="password" class="form-control form-control-lg"
                                   name="password"
                                   placeholder="Enter password" required />

                        </div>



                        <div class="small d-flex justify-content-between align-items-center">
                            <!-- Checkbox -->
                            <div class=" form-check mb-0">
                                <input class="form-check-input me-2" type="checkbox" value="" name="rememberMe" id="form2Example3" />
                                <label class="form-check-label" for="form2Example3">
                                    Remember me
                                </label>
                            </div>
                            <a href="forgotpassword.jsp" class="text-body">Forgot password?</a>
                        </div>
                        <p>${ERROR}</p>


                        <div class="text-center text-lg-start mt-2 pt-2">

                            <input type="submit" name="action" id="signin" value="Login"
                                   class="form-submit btn btn-success btn-lg"
                                   style="padding-left: 2.5rem; padding-right: 2.5rem;background-color:#628272"></input>

                        </div>

                        <div class="divider d-flex align-items-center my-3">
                            <p class="text-center fw-bold mx-3 mb-0">Or</p>
                        </div>
                        <div class="text-center text-lg-start mt-2 pt-2">
                            <a class="google-login btn btn-lg btn-success " style="background-color: white; color:#303030;"
                               href="https://accounts.google.com/o/oauth2/auth?scope=email&amp;redirect_uri=http://localhost:8084/WebApp_1/LoginGoogleController&amp;response_type=code
                               &amp;client_id=292534222114-c67cd7kucbrqlgpkvf02g68i64pisibc.apps.googleusercontent.com&amp;approval_prompt=force"><img
                                    src="${pageContext.request.contextPath}/img/1534129544.png" height="20" width="20"> Sign in with google</a>

                        </div>


                        <p class=" fw-bold mt-5 pt-1 mb-0">Don't have an account? <a href="${pageContext.request.contextPath}/register" style="color: green; font-style:italic; " >Register</a></p>
                    </form>
                </div>
            </div>
        </div>
    </section>

</div> 
