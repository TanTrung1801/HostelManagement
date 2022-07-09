<%-- 
    Document   : roomDetails
    Created on : Jul 1, 2022, 10:34:55 AM
    Author     : lekha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<jsp:useBean id='RoomDAO' class='daos.RoomDAO' scope='page'/>
<c:set var="roomDetails" value="${RoomDAO.getList('owner_id', sessionScope.loginId.toString())}"/>--%>
    
<!DOCTYPE html>
<div>
                <h4 class="text-right mr-5">No.Contract:    4/10</h4>

            </div>
            <div>
                <div class="row mt-5">
                    <div class="col-md-6 col-lg-4 mb-3">
                        <div class="card h-100">

                            <div class="card-body ">
                                <h5 class="card-title">Tran Hoang Kim Ngan</h5>
                                <div class="card-text">
                                    <p class="mb-0">Start date: 02/02/2022</p>
                                    <p class="mb-0">End date: 02/05/2022</p>
                                    <p class="mb-0">Price: 100$</p>
                                    <p class="mb-0">Deposit: 200$</p>

                                </div>

                            
                                <a href="javascript:void(0)" class="btn btn-green ">Detail</a>
                                <a href="javascript:void(0)" class="btn btn-outline-success" style="background-color:#fafafa; color:#628272;">Create Bill</a>


                            </div>
                        </div>
                    </div>
