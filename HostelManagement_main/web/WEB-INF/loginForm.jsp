<%-- 
    Document   : loginForm
    Created on : May 28, 2022, 10:20:46 PM
    Author     : lekha
--%>

<div class="main" style="background-size:100%; background-image: url('/HostelManagement_main/images/background-image.jpg')" >
    <!-- Sign in  Form -->
    <section class="sign-in">
        <div class="container">
            <div class="signin-content">
                <div class="signin-image">
                    <figure>
                        <img src="/HostelManagement_main/images/signin-image.jpg" alt="sign up image">
                    </figure>
                    <a href="/HostelManagement_main/register" class="signup-image-link">Create an account</a>
                </div>

                <div class="signin-form">
                    <h2 class="form-title">SIGN IN</h2>
                    <form method="POST" action="/HostelManagement_main/login/submit" class="register-form" id="login-form">
                        <div class="form-group">
                            <label for="indexvalue"><i class="zmdi zmdi-account material-icons-name"></i></label> 
                            <input type="text" name="indexValue" id="indexvalue" placeholder="Your username, email or phone" />
                        </div>
                        <div class="form-group">
                            <label for="password"><i class="zmdi zmdi-lock"></i></label> <input
                                type="password" name="password" id="password"
                                placeholder="Password" />

                        </div>
                        <div class="forgot-password">  <a href="forgotpassword.jsp">Forgot your Password?</a>
                        </div>
                        <div class="form-group">
                            <input type="checkbox" name="remember-me" id="remember-me" class="agree-term" /> 
                            <label for="remember-me" class="label-agree-term"><span><span></span></span>Remember me</label>
                        </div>

                        <div class="form-group form-button">

                            <input type="submit" name="action" id="signin" class="form-submit" value="Login" />
                            <p>${ERROR}</p>
                        </div>
                    </form>
                    <div class="social-login">
                        <span class="social-label">Or login with</span>
                        <ul class="socials">

                            <!--                                    <li><a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8084/WebApp_1/LoginGoogleController&response_type=code
                                &client_id=292534222114-c67cd7kucbrqlgpkvf02g68i64pisibc.apps.googleusercontent.com&approval_prompt=force"><i
                                                                            class="display-flex-center zmdi zmdi-google"></i></a></li>-->
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>