<%-- 
    Document   : profile
    Created on : Jun 2, 2022, 6:37:38 PM
    Author     : lekha
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <jsp:useBean id='AccountDAO' class='daos.AccountDAO' scope='page'/>

    <c:set var="AccountObj" value="${AccountDAO.getAccount(requestScope.indexNames, sessionScope.loginedAccount)}"/>

    <c:choose>
        <c:when test="${(param.tool eq null) or (param.tool eq 'view')}">
            <table>
                <tr>
                    <td>User Name:</td><td> ${AccountObj.username}</td>
                </tr>
                <tr>
                    <td>Name:</td><td> ${AccountObj.fullname}</td>
                </tr>
                <tr>
                    <td>Email:</td><td> ${AccountObj.email}</td>
                </tr>
                <tr>
                    <td>Phone Number:</td><td> ${AccountObj.phone}</td>
                </tr>
                <tr>
                    <td>ID card number:</td><td> ${AccountObj.idCardNumber}</td>
                </tr>
                <tr>
                    <td>Date of birth:</td><td> ${AccountObj.dateOfBirth}</td>
                </tr>
                <tr>
                    <td>This account was created on ${AccountObj.createdAt}</td>
                </tr>
            </table>
        </c:when>

        <c:when test="${param.tool eq 'change-password'}">
            <div id="changePasswordContent">
                <form id="change-password" >
                    <table>
                        <tr>
                            <td>Current Password:</td>     <td><input type="password" name="currentPass" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}$" required placeholder="Your current password"/></td>
                        </tr>
                        <tr>
                            <td>New Password:</td>      <td><input type="password" name="newPass" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}$" required placeholder="Your new password"/></td>
                        </tr>
                        <tr>
                            <td>Confirm new Password:</td>  <td><input type="password" name="confirmPass" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}$" required placeholder="Confirm your password again"/></td>
                        </tr>
                        <tr>
                            <td>
                                <input type='hidden' name='action' value='changePassword'/>
                                <!--<input type="submit" value="Change"/>-->
                                <button  > Change Password </button>
                            </td>
                        </tr>
                        <p>${ERROR}</p>
                    </table>             
                </form>

                <script>
//                    function changePassword() {
//                        $.ajax({
//                            url: "/HostelManagement_main/changePasswordServlet",
//                            type: "POST",
//                            success: function (data) {
//                                document.getElementById("changePasswordContent").innerHTML = data;
//                            },
//                            error: function (xhr) {
//                                document.getElementById("changePasswordContent").innerHTML = "HELLO WORLD";
//                            }
//                        });
//                    }
                        //document.getElementById("changePasswordContent").innerHTML = "HELLO WORLD";
                        $("#change-password").submit(function (e) {
                            e.preventDefault(); // prevent actual form submit
                            var form = $(this);
                            var url = "/HostelManagement_main/home/profile?tool=change-password"; //get submit url [replace url here if desired]
                            $.ajax({
                                type: "POST",
                                url: url,
                                data: form.serialize(), // serializes form input
                                success: function (data) {
                                    document.getElementById("changePasswordContent").innerHTML = data;
                                }
                            });
                        });
                    
                </script>    
            </c:when>

            <c:when test="${param.tool eq 'update'}">
                <form action="#" method="POST">
                    <table>
                        <tr>
                            <td>First Name:</td><td> ${AccountObj.username}</td>
                        </tr>
                        <tr>
                            <td>Last Name:</td><td> ${AccountObj.fullname}</td>
                        </tr>
                        <tr>
                            <td>Phone Number:</td><td> ${AccountObj.phone}</td>
                        </tr>
                        <tr>
                            <td>Date of birth:</td><td> ${AccountObj.dateOfBirth}</td>
                        </tr>
                    </table>
                </form>
            </c:when>
        </c:choose>

    </div>
