<%-- 
    Document   : profile
    Created on : Jun 17, 2022, 3:23:56 AM
    Author     : lekha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="profileContent">
    <jsp:include page="/WEB-INF/jspf/profileContent/${profileContent}.jsp"/>
</div>

<script>
    $('body').on('click', '#updateButton', function (e) {
        console.log("Hello world!");
        e.preventDefault();
        $.ajax({
            url: "${pageContext.request.contextPath}/home/profile/view?action=getUpdateForm",
            success: function (result) {
                $("#profileDetails").html(result);
            }
        });
    });

    $('body').on('click', '#cancelUpdate', function (e) {
        console.log("Hello world!");
        e.preventDefault();
        $.ajax({
            url: "${pageContext.request.contextPath}/home/profile/view?action=getView",
            success: function (result) {
                $("#profileDetails").html(result);
            }
        });
    });

    $('body').on('submit', '#update-profile-form', function (e) {
//    $("#update-profile-form").submit(function (e) {
        e.preventDefault(); // prevent actual form submit
        console.log("Hello world!");
        var form = $(this);
        var url = form.attr('action'); //get submit url [replace url here if desired]
        $.ajax({
            type: "POST",
            url: url,
            data: form.serialize(), // serializes form input
            success: function (result) {
                $("#profileDetails").html(result);
            }
        });
    });

    $('body').on('submit', '#change-password', function (e) {
        e.preventDefault(); 
        var form = $(this);
        var url = form.attr('action');
        $.ajax({
            type: "POST",
            url: url,
            data: form.serialize(), // serializes form input
            success: function (result) {
                $("#profileContent").html(result);
            }
        });
    });

</script>
