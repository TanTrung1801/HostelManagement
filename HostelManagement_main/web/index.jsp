<%-- 
    Document   : index
    Created on : May 28, 2022, 6:49:02 PM
    Author     : lekha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>${pageTitle}</title>

        <!-- Font Icon -->
        <link rel="stylesheet" href="/HostelManagement_main/fonts/material-icon/css/material-design-iconic-font.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <!-- Main css -->
        <link rel="stylesheet" href="/HostelManagement_main/css/style.css">
    </head>
    <body>

        <jsp:include page="WEB-INF/${pageContent}"/>

        <!-- JS -->
        <script src="/HostelManagement_main/vendor/jquery/jquery.min.js"></script>
        <script src="/HostelManagement_main/js/main.js"></script>
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>   
    </body>
    <footer>
        
    </footer>
</html>
