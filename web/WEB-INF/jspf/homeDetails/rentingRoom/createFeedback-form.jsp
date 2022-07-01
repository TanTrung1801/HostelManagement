<%-- 
    Document   : createFeedback-form
    Created on : Jun 30, 2022, 7:35:57 PM
    Author     : tantrung
--%>

<div class="container-fluid my-5">
    <div class="col-12 col-md-9">

       

        <div class="container-fluid my-5">
            <div class="col-12 col-md-9">
                <form action="${pageContext.request.contextPath}/home/renting/tenant-room/${room_slug}" method="POST" class="register-form" 
                      id="create-feedback">

                    <!--                        <div class="form-group row ">
                                                <label for="hostel_id" class="col-md-2 col-form-label">Hostel ID</label>
                                                <div class="col-md-3">
                                                    <input type="number" class="form-control " id="hostel_id" name="hostel_id" placeholder="Hostel ID" required="">
                                                </div>
                                                
                                                
                                            </div>
                                            <div class="form-group row ">
                                                <label for="room_id" class="col-md-2 col-form-label">Room ID</label>
                                                <div class="col-md-3">
                                                    <input type="number" class="form-control" id="room_id" name="room_id" placeholder="Room ID">
                                                </div>
                                            </div>-->

                    <div class="form-group row">
                        <div class="col-md-10 offset-md-2">
                            <div class="form-check">
                                <input type="checkbox" class="form-check-input" name="room_id" id="room_id" value="${requestScope.room_id}">
                                <label class="form-check-label" for="room_id">
                                    <strong>Feedback about your room?</strong>
                                </label>
                            </div>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="feedback" class="col-md-2 col-form-label">Your Feedback</label>
                        <div class="col-md-10">

                            <textarea class="form-control" id="feedback" name="feedback" rows="12"></textarea>
                        </div>
                    </div>

                    <div class="form-group row">
                        <div class="offset-md-2 col-md-10 mt-5">
                            <button type="submit" class="btn btn-green">Send Feedback</button>
                        </div>
                    </div>

                    <input type="hidden" name="hostel_id" value="${requestScope.hostel_id}"/>
                    <input type="hidden" name="action" value="createFeedback"/>
                </form>
            </div>
        </div>



    </div>
</div>
