<%-- 
    Document   : registerForm
    Created on : May 28, 2022, 10:23:08 PM
    Author     : lekha
--%>

<div class="main" style="background-size:100%; background-image: url('/HostelManagement_main/images/background-image.jpg')">

    <!-- Sign up form -->
    <section class="signup">
        <div class="container">
            <div class="row">
                <div class="row col-md4 signup-form ">
                    <br>
                    <h2 class="form-title">SIGN UP</h2>
                    <form method="POST" action="/HostelManagement_main/register/submit" class="register-form" id="register-form">
                        <div class="form-row">
                            <div class="form-group col-6 col-sm-6">
                                <label for="firstname"><i class="zmdi zmdi-account material-icons-name"></i></label> 
                                <input type="text" name="firstName" id="firstname" placeholder="First Name" required />                               
                            </div>

                            <div class="form-group col-6 col-sm-6">
                                <label for="lastname"><i class="zmdi zmdi-account material-icons-name"></i></label> 
                                <input type="text" name="lastName" id="lastname" placeholder="Last Name" required />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="username"><ion-icon name="person-circle-outline" style="font-size: 18px;"></ion-icon></label> 
                            <input type="text" name="username" id="username" placeholder="Username" required =""/>
                            <p>${ERROR_USERNAME}</p>
                        </div>
                        <div class="form-group">
                            <label for="pass"><i class="zmdi zmdi-lock"></i></label> 
                            <input type="password" name="password" id="pass" placeholder="Password" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}$" required/>
                            <p>${ERROR_PASSWORD}</p>
                        </div >
                        <div class="form-group">
                            <label for="confirm"><i class="zmdi zmdi-lock-outline"></i></label>
                            <input  type="password" name="confirm" id="confirm" placeholder="Repeat your password" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}$" required />
                            <p>${ERROR_CONFIRMPASSWORD}</p>
                        </div>

                        <div class="form-group">
                            <label for="email"><i class="zmdi zmdi-email"></i></label> <input
                                type="email" name="email" id="email" placeholder="Your Email" pattern="[a-z0-9._%+-]+@(gmail.com|fpt.edu.vn|yahoo.com)" 
                                required ="" title="Email addresses must not contain any upper letter and end with domains '@gmail.com' or '@fpt.edu.vn' or '@yahoo.com'" value='${email}'/>
                            <p>${ERROR_EMAIL}</p>
                        </div>

                        <div class="form-group">
                            <label for="idcardnumber"><ion-icon name="card-outline" style="font-size: 18px"></ion-icon></label> 
                            <input type="text" name="idCardNumber" id="idcardnumber" placeholder="ID Card Number" maxlength="16" />
                            <p>${ERROR_IDCARDNUMBER}</p>
                        </div>
                        <div class="form-group">
                            <label for="dateOfBirth"><i
                                    class="zmdi zmdi-cake material-icons-name" title="Date of birth"></i></label> <input
                                type="date" name="dateOfBirth" id="dateOfBirth" placeholder="Date of birth" />
                        </div>
                        <div class="form-group">
                            <label for="contact"><ion-icon name="call-outline" style="font-size: 18px"></ion-icon></label>
                            <input type="tel" name="phone" id="contact" placeholder="Contact no" maxlength="10" pattern="[0-9]{10,10}"/>
                            <p>${ERROR_PHONE}</p>
                        </div>

                        <div class="form-group">
                            <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" /> 
                            <a href="/HostelManagement_main/login" class="signup-image-link">I am already member</a>
                            <div class="form-button">
                                <input type="submit" name="action" id="signup"
                                       class="form-submit" value="Register" />
                            </div>
                            <p>${ERROR}</p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
</div>
