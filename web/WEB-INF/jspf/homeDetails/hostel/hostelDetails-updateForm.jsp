<%-- 
    Document   : hostelDetails-updateForm
    Created on : Jul 10, 2022, 11:02:03 PM
    Author     : lekha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<jsp:useBean id='HostelDAO' class='daos.HostelDAO' scope='page'/>
<jsp:useBean id='AccountDAO' class='daos.AccountDAO' scope='page'/>

<c:set var='splitter' value="${fn:split(requestScope.processingPath,'/')}" scope='page'/>

<c:set var="HostelObj" value="${HostelDAO.getOne('hostel_slug', splitter[3])}"/>

<c:set var="AccountObj" value="${AccountDAO.getOne('account_id', HostelObj.ownerId)}"/>

<form method="POST" action="${pageContext.request.contextPath}/home/${splitter[1]}/hostels/${splitter[3]}/hostel-details" class="register-form" id="login-form">
    <div class="form-group ">
        <label class="form-label" for="name">Hostel Name</label>
        <input type="text" name="hostel_name" id="hostel_name" placeholder="Hostel Name"
               value='${HostelObj.name}' class="form-control" required="">
    </div>

 
        <div class="form-group">
            <label for="city">City
                <select class="form-control "  name="city" id="city" required="">
                    <option value="${HostelObj.city}">${HostelObj.city}</option>
                </select>
            </label>
        </div>

        <div class="form-group">
            <label for="district">District
                <select class="form-control "  name="district" id="district" required="">
                    <option value="${HostelObj.district}">${HostelObj.district}</option>
                </select>
            </label>
        </div>

        <div class="form-group ">
            <label for="ward">Ward
                <select class="form-control mx-0 " name="ward" id="ward" required="">
                    <option value="${HostelObj.ward}">${HostelObj.ward}</option>
                </select>

            </label>
        </div>


    

    <div class="form-group">
        <label class="form-label" for="street">
            Street
        </label>
        <input type="text" name="street" id="street" placeholder="Street"
               class="form-control" value='${HostelObj.street}'>
    </div>
    
    <div class="text-center text-lg-start my-4 py-2">
        <input type="hidden" name="action" value="updateHostelDetails"/>
        <input type="submit" value="Update"
               class="form-submit btn btn-success"
               style="padding-left: 2.5rem; padding-right: 2.5rem;background-color:#628272">
        <a href="${pageContext.request.contextPath}/home/${splitter[1]}/hostels/${splitter[3]}/hostel-details" class="btn btn-outline-secondary" id="cancelUpdate">Cancel</a>
    </div>
</form>

<!-- Axios JS -->        
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>

<script>
    var citis = document.getElementById("city");
    var districts = document.getElementById("district");
    var wards = document.getElementById("ward");
    var Parameter = {
      url: "${pageContext.request.contextPath}/js/addressData.json", //Đường dẫn đến file chứa dữ liệu hoặc api do backend cung cấp
      method: "GET", //do backend cung cấp
      responseType: "application/json" //kiểu Dữ liệu trả về do backend cung cấp
    };
    //gọi ajax = axios => nó trả về cho chúng ta là một promise
    var promise = axios(Parameter);
    //Xử lý khi request thành công
    promise.then(function (result) {
      renderCity(result.data);
    });

    function renderCity(data) {
      for (const x of data) {
        citis.options[citis.options.length] = new Option(x.Name, x.Name);
      }

      // xứ lý khi thay đổi tỉnh thành thì sẽ hiển thị ra quận huyện thuộc tỉnh thành đó
      citis.onchange = function () {
        district.length = 1;
        ward.length = 1;
        if(this.value != ""){
          const result = data.filter(n => n.Name === this.value);

          for (const k of result[0].Districts) {
            district.options[district.options.length] = new Option(k.Name, k.Name);
          }
        }
      };

       // xứ lý khi thay đổi quận huyện thì sẽ hiển thị ra phường xã thuộc quận huyện đó
      district.onchange = function () {
        ward.length = 1;
        const dataCity = data.filter((n) => n.Name === citis.value);
        if (this.value != "") {
          const dataWards = dataCity[0].Districts.filter(n => n.Name === this.value)[0].Wards;

          for (const w of dataWards) {
            wards.options[wards.options.length] = new Option(w.Name, w.Name);
          }
        }
      };
    }
</script>
