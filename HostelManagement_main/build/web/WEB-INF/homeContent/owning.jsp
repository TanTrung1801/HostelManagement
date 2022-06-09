<%-- 
    Document   : owningDefault
    Created on : Jun 2, 2022, 8:00:25 PM
    Author     : lekha
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div id="content">

    <!-- Breadcrumb Content Holder -->
    <div class="row">
        <ol class="col-12 breadcrumb">
            <li class="breadcrumb-item"><a href="./index.html">Home</a></li>
            <li class="breadcrumb-item active">My Hostel</li>
        </ol>
        <div class="col-12">
            <h3>My Hostel</h3>

        </div>
    </div>


    <div>
        <jsp:useBean id='HostelDAO' class='daos.HostelDAO' scope='page'/>
        <c:set var="HostelList" value="${HostelDAO.getByColumn('owner_id',sessionScope.loginedAccount.toString())}"/>

        <c:choose>
            <c:when test="${(param.tool eq null) or (param.tool eq 'view')}">
                <c:choose>
                    <c:when test="${(HostelList != null) and (not empty HostelList)}">
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>NAME</th>
                                    <th>ADDRESS</th>                    
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="hostel" items="${HostelList}">
                                    <tr onclick="window.location = '/HostelManagement_main/home/owning/${hostel.hostelSlug}'">
                                        <td>${hostel.name}</td>
                                        <td>${hostel.street} - ${hostel.ward} - ${hostel.distrinct} - ${hostel.city}</td>

                                        <!--                            <td> 
                                        <%--update--%>
                                        <form action="/HostelManagement_main/home/owner/tool/update" method="POST">
                                            <input type="submit" value="Create"/>
                                            <input type="hidden" name="hostel_id" value="${hostel.hostel_id}">
                                        </form>
                                    </td>
                                    <td>
                                        <%--delete --%>
                                    </td>-->

                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:when>
                    <c:otherwise>
                        <span><c:out value="you don't own any hostels"/></span>
                    </c:otherwise>
                </c:choose>
            </c:when>
            <c:when test="${param.tool eq 'create'}">
                <form method="POST" action="#" class="register-form">
                    <div class="form-row">
                        <div class="form-group">
                            <label class="form-label" for="name">Hostel Name</label> 
                            <input class="form-control" type="text" name="name" id="name" required="">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-3 col-md-3">
                            <label class="form-label" for="city">City</label> 
                            <input class="form-control" type="text" name="city" id="city" required=""/>
                        </div>

                        <div class="form-group col-3 col-md-3">
                            <label class="form-label" for="district">District</label> 
                            <!--                        <select name="district" id="district" required>
                                                        <option value='hello'>hello</option> 
                                                    </select>-->
                            <input class="form-control" type="text" name="dítrict" id="city" required=""/>
                        </div>

                        <div class="form-group col-3 col-md-3">
                            <label class="form-label" for="ward">Ward</label> 
                            <input class="form-control" type="text" name="ward" id="ward" required=""/>  
                        </div>

                        <div class="form-group col-3 col-md-3">
                            <label class="form-label" for="street">Street</label> 
                            <input class="form-control" type="text" name="street" id="street" required=""/>
                        </div>
                    </div>
                    <input type="hidden" name="action" value="createHostel"/>
                    <input type="submit" value="Create"/>
                    <input type ="reset" value ="reset"/>
                </form>

                <!--            <script>
                                var district = document.getElementById('district');
                                const districtList = ["AAAA", "BBBB", "CCC"];
                                districtList.forEach(a => {
                                    let option_elem = document.createElement('option');
                                    option_elem.value = a;
                                    option_elem.textContent = a+"asdasd";
                                    district.appendChild(option_elem);
                                });
                                
                                
                            </script> -->
            </c:when>
        </c:choose>
    </div>


</div>
