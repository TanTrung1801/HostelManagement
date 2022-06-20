<%-- 
    Document   : createHostel
    Created on : Jun 18, 2022, 6:43:49 PM
    Author     : lekha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
