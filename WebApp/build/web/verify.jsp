<%-- 
    Document   : verify
    Created on : May 25, 2022, 2:55:49 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <!-- Tailwind CSS -->
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet" />
    <!-- Alpine.js -->
    <script src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.7.3/dist/alpine.min.js" defer></script>
    </head>
    <body>
        <h1>Please Wait a minute </h1> ${sessionScope.AUTHCODE.userID} 
        The OTP have been seen to ${sessionScope.AUTHCODE.email}</br> 
        check your email <a href="mail.google.com" /> HERE </a>
    <form action="MainController" x-data="otpForm()" method="POST">
            <div>
                <template x-for="(input, index) in length" :key="index">
                    <input type="tel" maxlength="1" class="border border-gray-500 w-10 h-10 text-center" :x-ref="index"
                        x-on:input="handleInput($event)" x-on:paste="handlePaste($event)"
                        x-on:keydown.backspace="$event.target.value || handleBackspace($event.target.getAttribute('x-ref'))" />
                </template>
            </div>
            <input type="hidden" name="otp" x-model="value">
            <button type="submit" name="action" value="Verify">
                Verify OTP!
            </button>
            <p style="color: red; text-align: center">${requestScope.ERROR}</p>
        </form>
    
    
    <script>
        function otpForm() {
            return {
                length: 6,
                value: "",

                handleInput(e) {
                    const input = e.target;

                    this.value = Array.from(Array(this.length), (element, i) => {
                        return this.$refs[i].value || "";
                    }).join("");

                    if (input.nextElementSibling && input.value) {
                        input.nextElementSibling.focus();
                        input.nextElementSibling.select();
                    }
                },

                handlePaste(e) {
                    const paste = e.clipboardData.getData('text');
                    this.value = paste;

                    const inputs = Array.from(Array(this.length));

                    inputs.forEach((element, i) => {
                        this.$refs[i].value = paste[i] || '';
                    });
                },

                handleBackspace(e) {
                    const previous = parseInt(e, 10) - 1;
                    this.$refs[previous] && this.$refs[previous].focus();
                },
            };
        }
    </script>
    </body>
</html>
