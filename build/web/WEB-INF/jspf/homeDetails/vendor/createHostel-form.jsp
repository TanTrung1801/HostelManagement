<%-- 
    Document   : createHostel-form
    Created on : Jun 24, 2022, 1:43:16 PM
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
    <div class="form-row no-gutters">
        <div class="form-group col-4 col-md-4 no-gutters">
            <label class="form-label" for="city">City</label> 
            <!--<input class="form-control" type="text" name="city" id="city" required=""/>-->
            <select class="form-control" name="city" id="city" required>
                <option value='' selected>Choose city</option> 
            </select>
        </div>

        <div class="form-group col-4 col-md-4 no-gutters">
            <label class="form-label" for="district">District</label> 
            <select class="form-control" name="district" id="district" required>
                <option value='' selected>Choose district</option> 
            </select>
            <!--<input class="form-control" type="text" name="district" id="district" required=""/>-->
        </div>

        <div class="form-group col-4 col-md-4 no-gutters">
            <label class="form-label" for="ward">Ward</label> 
            <!--<input class="form-control" type="text" name="ward" id="ward" required=""/>--> 
            <select class="form-control" name="ward" id="ward" required>
                <option value='' selected>Choose ward</option> 
            </select>
        </div>


    </div>
    <div class="form-row">
        <div class="form-group col-12 col-md-12">
            <label class="form-label" for="street">Street</label> 
            <input class="form-control" type="text" name="street" id="street" required=""/>
        </div>
    </div>
    <input type="hidden" name="action" value="createHostel"/>
    <input class="btn btn-green" type="submit" value="Create"/>
    <!--<input type ="reset" value ="reset"/>-->
</form>
<p>${ERROR}</p>

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
