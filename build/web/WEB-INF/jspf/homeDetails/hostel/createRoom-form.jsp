

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="mx-5 my-5">
    <form method="POST" action="#" class="register-form">
        <div class="form-row">
            <div class="form-group col-4 col-md-4">
                <div class="form-group">
                    <label class="form-label" for="name">Room name</label> 
                    <input class="form-control" type="text" name="name" id="name" required="">
                </div>
            </div>
            <div class="form-group col-4 col-md-4">
                <div class="form-row">
                    <label class="form-label" for="maxContract">Max Contract</label> 
                    <input class="form-control" type=number name="maxContract" id="maxContract" required=""/>
                </div>
            </div>
        </div>

        <input type="hidden" name="action" value="createRoom"/>
        <input class="btn btn-green" type="submit" value="Create"/>
        <!--<input type ="reset" value ="reset"/>-->
    </form>


    <p>${ERROR}</p>
</div>
