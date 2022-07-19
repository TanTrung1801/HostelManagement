<%-- 
    Document   : detail
    Created on : Jun 23, 2022, 9:15:49 PM
    Author     : lekha
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<jsp:useBean id='AccountDAO' class='daos.AccountDAO' scope='page'/>
<jsp:useBean id='HostelDAO' class='daos.HostelDAO' scope='page'/>
<jsp:useBean id='RoomDAO' class='daos.RoomDAO' scope='page'/>

<c:set var="AccountObj" value="${AccountDAO.getOne('account_id', sessionScope.loginId)}"/>

<div id="content">
    <div class="row">
        <ol class="col-12 breadcrumb">
<!--            <c:set var='linkName' value="${fn:split(requestScope.processingPath,'/')}" scope='page'/>

            <c:forEach begin='0' end="${fn:length(linkName)-2}" var='i'>
                <c:set var='linkPath' value='${linkName[0]}' scope='page'/>
                <c:forEach begin='1' end='${i}' var='j'>
                    <c:set var='linkPath' value='${linkPath}/${linkName[j]}' scope='page'/>
                </c:forEach>

                <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/${linkPath}">${fn:toUpperCase(fn:substring(linkName[i], 0, 1))}${fn:toLowerCase(fn:substring(linkName[i], 1,fn:length(linkName[i])))}</a></li>                               
            </c:forEach>

            <li class="breadcrumb-item active">${fn:toUpperCase(fn:substring(linkName[fn:length(linkName)-1], 0, 1))}${fn:toLowerCase(fn:substring(linkName[fn:length(linkName)-1], 1,fn:length(linkName[fn:length(linkName)-1])))}</li>-->
                    
<!--    new breadcrumb logic    -->
            <c:set var='splitter' value="${fn:split(requestScope.processingPath,'/')}" scope='page'/>
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/home">Home</a></li>
            <c:choose>
                <c:when test="${fn:length(splitter)<4}">
                    <li class="breadcrumb-item active">
                        <c:if test="${splitter[1] eq 'owning'}">Owner</c:if>
                        <c:if test="${splitter[1] eq 'managing'}">Manager</c:if>
                        <c:if test="${splitter[1] eq 'renting'}">Tenant</c:if>
                    </li>
                </c:when>
                <c:when test="${fn:length(splitter)>=4 and fn:length(splitter)<6}">
                    <li class="breadcrumb-item">
                        <c:if test="${splitter[1] eq 'owning'}"><a href="${pageContext.request.contextPath}/home/owning">Owner</a></c:if>
                        <c:if test="${splitter[1] eq 'managing'}"><a href="${pageContext.request.contextPath}/home/managing">Manager</a></c:if>
                        <c:if test="${splitter[1] eq 'renting'}"><a href="${pageContext.request.contextPath}/home/renting">Tenant</a></c:if>
                    </li>
                    <li class="breadcrumb-item active">
                        <c:set var="HostelObj" value="${HostelDAO.getOne('hostel_slug', splitter[3])}"/>
                        ${HostelObj.name}
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="breadcrumb-item">
                        <c:if test="${splitter[1] eq 'owning'}"><a href="${pageContext.request.contextPath}/home/owning">Owner</a></c:if>
                        <c:if test="${splitter[1] eq 'managing'}"><a href="${pageContext.request.contextPath}/home/managing">Manager</a></c:if>
                        <c:if test="${splitter[1] eq 'renting'}"><a href="${pageContext.request.contextPath}/home/renting">Tenant</a></c:if>
                    </li>
                    <li class="breadcrumb-item">
                        <c:set var="HostelObj" value="${HostelDAO.getOne('hostel_slug', splitter[3])}"/>
                        <a href="${pageContext.request.contextPath}/home/${splitter[1]}/hostels/${splitter[3]}">${HostelObj.name}</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <c:set var="RoomObj" value="${RoomDAO.getOne(requestScope.columnValuePair)}"/>                        
                        ${RoomObj.name}
                    </li>
                </c:otherwise>
            </c:choose>
         
        </ol>
        <div class="col-12">
            <!--<h3>${fn:toUpperCase(fn:substring(linkName[fn:length(linkName)-1], 0, 1))}${fn:toLowerCase(fn:substring(linkName[fn:length(linkName)-1], 1,fn:length(linkName[fn:length(linkName)-1])))}</h3>-->
            <h3>${pageTitle}</h3>
        </div>
    </div>

    <jsp:include page="/WEB-INF/jspf/homeDetails/${homeDetails}"/>
</div>         
