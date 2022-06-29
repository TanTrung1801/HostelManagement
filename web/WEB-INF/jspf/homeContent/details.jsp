<%-- 
    Document   : detail
    Created on : Jun 23, 2022, 9:15:49 PM
    Author     : lekha
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<jsp:useBean id='AccountDAO' class='daos.AccountDAO' scope='page'/>

<c:set var="AccountObj" value="${AccountDAO.getOne('account_id', sessionScope.loginId)}"/>

<div id="content">
    <div class="row">
        <ol class="col-12 breadcrumb">
            <c:set var='linkName' value="${fn:split(requestScope.processingPath,'/')}" scope='page'/>

            <c:forEach begin='0' end="${fn:length(linkName)-2}" var='i'>
                <c:set var='linkPath' value='${linkName[0]}' scope='page'/>
                <c:forEach begin='1' end='${i}' var='j'>
                    <c:set var='linkPath' value='${linkPath}/${linkName[j]}' scope='page'/>
                </c:forEach>

                <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/${linkPath}">${fn:toUpperCase(fn:substring(linkName[i], 0, 1))}${fn:toLowerCase(fn:substring(linkName[i], 1,fn:length(linkName[i])))}</a></li>                               
            </c:forEach>

            <li class="breadcrumb-item active">${fn:toUpperCase(fn:substring(linkName[fn:length(linkName)-1], 0, 1))}${fn:toLowerCase(fn:substring(linkName[fn:length(linkName)-1], 1,fn:length(linkName[fn:length(linkName)-1])))}</li>
        </ol>
        <div class="col-12">
            <!--<h3>${fn:toUpperCase(fn:substring(linkName[fn:length(linkName)-1], 0, 1))}${fn:toLowerCase(fn:substring(linkName[fn:length(linkName)-1], 1,fn:length(linkName[fn:length(linkName)-1])))}</h3>-->
            <h3>${pageTitle}</h3>
        </div>
    </div>

    <jsp:include page="/WEB-INF/jspf/homeDetails/${homeDetails}"/>
</div>         
