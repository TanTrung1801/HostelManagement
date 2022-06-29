<%-- 
    Document   : changePassword
    Created on : Jun 23, 2022, 10:01:25 PM
    Author     : lekha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/jspf/homeDetails/profile/${changePasswordContent}"/>

<script>   
    $('body').on('submit', '#change-password', function (e) {
        e.preventDefault();
        var form = $(this);
        var url = form.attr('action');
        $.ajax({
            type: "POST",
            url: url,
            data: form.serialize(), // serializes form input
            success: function (result) {
                $("#passwordForm").html(result);
            }
        });
    });
</script>