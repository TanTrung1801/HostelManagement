

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<form method="POST" action="#" class="register-form">
    <div class="form-row">
     <div class="form-group col-3 col-md-3">
        <div class="form-group">
            <label class="form-label" for="name">Room name</label> 
            <input class="form-control" type="text" name="name" id="name" required="">
        </div>
    </div>
     <div class="form-group col-3 col-md-3">
        <div class="form-row">
            <label class="form-label" for="maxContract">Max Contract</label> 
            <input class="form-control" type=number name="maxContract" id="maxContract" required=""/>
        </div>
         </div>
    <div class="form-group col-3 col-md-3">
            <label class="form-label" for="room_slug">Room Slug</label> 
            <input class="form-control" type=text name="room_slug" id="room_slug" required=""/>
        </div>
</div>
       
    <input type="hidden" name="action" value="createRoom"/>
    <input type="submit" value="Create"/>
    <input type ="reset" value ="reset"/>
</form>

    
<p>${ERROR}</p>

