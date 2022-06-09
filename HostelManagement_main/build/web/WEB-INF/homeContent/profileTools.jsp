<%-- 
    Document   : profileTool
    Created on : Jun 3, 2022, 1:25:06 AM
    Author     : lekha
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav id="menu">
    <ul class="list-unstyled components">
        <li <c:if test="${(param.tool eq 'view') or (param.tool eq null)}">class="active"</c:if>>
            <a href="/HostelManagement_main/home/profile?tool=view">View</a>
        </li>
        <li <c:if test="${param.tool eq 'update'}">class="active"</c:if>>
            <a href="/HostelManagement_main/home/profile?tool=update">Update Profile</a>
        </li>
        <li <c:if test="${param.tool eq 'change-password'}">class="active"</c:if>>
            <a href="/HostelManagement_main/home/profile?tool=change-password">Change Password</a>
        </li>
    </ul>
</nav>