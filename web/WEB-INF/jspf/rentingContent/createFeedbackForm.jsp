<%-- 
    Document   : createFeedback
    Created on : Jun 21, 2022, 3:13:39 PM
    Author     : nguye
--%>


<div class="container-fluid my-5">
                <div class="col-12 col-md-9">
                    <form method="POST" action="${pageContext.request.contextPath}/home/renting/view" class="register-form" 
      id="create-feedback">
                        
                        <div class="form-group row ">
                            <label for="hostel_name" class="col-md-2 col-form-label">Hostel Name</label>
                            <div class="col-md-10">
                                <input type="text" class="form-control" id="hostel_name" name="hostel_name" placeholder="Hostel Name" required="">
                            </div>
                        </div>
                      
                        <div class="form-group row">
                            <div class="col-md-6 offset-md-2">
                                <div class="form-check">
                                    <input type="checkbox" class="form-check-input" name="room_id" id="room_id" value="1">
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
                        <input type="hidden" name="action" value="createFeedback"/>
                    </form>
                </div>
            </div>




<!--<form method="POST" action="${pageContext.request.contextPath}/home/renting/view" class="register-form" 
      id="create-feedback">
    
    <div class="form-row">
        <div class="form-group col-3 col-md-3">
            <label class="form-label" for="hostel_id">Hostel ID</label> 
            <input class="form-control" type="number" name="hostel_id" id="hostel_id">
        </div>
        
        <div class="form-group col-3 col-md-3">
            <label class="form-label" for="room_id">Room ID</label> 
            <input class="form-control" type="number" name="room_id" id="room_id"/>
        </div>
    </div>
    
    
    
    <div class="form-row">
        <div class="form-group col-3 col-md-3">
            <label class="form-label" for="content">Content</label> 
            <input class="form-control" type="text" name="content" id="content" required=""/>
        </div>
    </div>
    
    <input type="hidden" name="client_id" value="${sessionScope.loginId}"/>
    <input type="hidden" name="action" value="createFeedback"/>
    <input type="submit" value="Create"/>
    <input type ="reset" value ="reset"/>
</form>-->
    <p>${ERROR}</p>
