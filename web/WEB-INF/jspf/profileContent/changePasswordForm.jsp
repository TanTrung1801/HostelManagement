<%-- 
    Document   : changePassword
    Created on : Jun 17, 2022, 4:02:32 AM
    Author     : lekha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="card mx-5 my-5">
    <h5 class="card-header btn-green">Change Password</h5>
    <div class="card-body">
        <div class="my-4 col-7 ml-5">
            <div>
                <form method="POST" action="${pageContext.request.contextPath}/home/profile/change-password" class="register-form"
                      id="change-password">
                    <div class="form-group">
                        <label class="form-label" for="currentPass">Current Password:</label>
                        <input type="password" name="currentPass" id="currentPass" placeholder="Current Password"
                               pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}$" class="form-control"
                               required />

                    </div>

                    <div class="form-group">
                        <label class="form-label" for="newPass">New Password</label>
                        <input type="password" name="newPass" id="newPass" placeholder="New Password"
                               pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}$" class="form-control"
                               required />

                    </div>
                    <div class="form-group">
                        <label class="form-label" for="confirmPass">Confirm Password</label>
                        <input type="password" name="confirmPass" id="confirmPass"
                               placeholder="Repeat your password"
                               pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}$" class="form-control"
                               required />

                    </div>
                    <a href="./owner page.html"  style="color: green; font-style:italic; padding-left:70% ">I forgot my
                        password</a>


                    <div class="text-center text-lg-start mt-4 pt-2">

                        <input type='hidden' name='action' value='changePassword'/>
                        <input type="submit" id="signup" value="Change Password"
                               class="form-submit btn btn-success"
                               style="padding-left: 2.5rem; padding-right: 2.5rem;background-color:#628272"></input>

                    </div>

                </form>
                <p>${ERROR}</p>
            </div>
        </div>

    </div>
</div>

