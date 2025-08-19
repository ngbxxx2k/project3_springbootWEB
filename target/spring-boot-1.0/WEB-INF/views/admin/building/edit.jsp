
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<%--api để xử lý call api bang ajax--%>
<c:url var="buildingAPI" value="/api/building"/>
<html>
<head>
    <title>Thêm và sửa toà nhà</title>
</head>
<body>


    <div class="main-content" >
        <div class="main-content-inner-pb-100" >
            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                    try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
                </script>

                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">Home</a>
                    </li>
                    <li class="active">Dashboard</li>
                </ul><!-- /.breadcrumb -->


            </div>

            <div class="page-content">
                <div class="ace-settings-container" id="ace-settings-container">
                    <div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
                        <i class="ace-icon fa fa-cog bigger-130"></i>
                    </div>

                    <div class="ace-settings-box clearfix" id="ace-settings-box">
                        <div class="pull-left width-50">
                            <div class="ace-settings-item">
                                <div class="pull-left">
                                    <select id="skin-colorpicker" class="hide">
                                        <option data-skin="no-skin" value="#438EB9">#438EB9</option>
                                        <option data-skin="skin-1" value="#222A2D">#222A2D</option>
                                        <option data-skin="skin-2" value="#C6487E">#C6487E</option>
                                        <option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
                                    </select>
                                </div>
                                <span>&nbsp; Choose Skin</span>
                            </div>

                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar" />
                                <label class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
                            </div>

                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
                                <label class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
                            </div>

                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs" />
                                <label class="lbl" for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
                            </div>

                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
                                <label class="lbl" for="ace-settings-rtl"> Right To Left (rtl)</label>
                            </div>

                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container" />
                                <label class="lbl" for="ace-settings-add-container">
                                    Inside
                                    <b>.container</b>
                                </label>
                            </div>
                        </div><!-- /.pull-left -->

                        <div class="pull-left width-50">
                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-hover" />
                                <label class="lbl" for="ace-settings-hover"> Submenu on Hover</label>
                            </div>

                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-compact" />
                                <label class="lbl" for="ace-settings-compact"> Compact Sidebar</label>
                            </div>

                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-highlight" />
                                <label class="lbl" for="ace-settings-highlight"> Alt. Active Item</label>
                            </div>
                        </div><!-- /.pull-left -->
                    </div><!-- /.ace-settings-box -->
                </div><!-- /.ace-settings-container -->

                <div class="page-header">
                    <h1>
                        thêm toà nhà
                        <small>
                            <i class="ace-icon fa fa-angle-double-right"></i>
                           thêm và sửa toà nhà
                        </small>
                    </h1>
                </div><!-- /.page-header -->
                <form:form modelAttribute="BuildingEdit" action="/admin/building-edit" method="post" id="listForm">
                    <div class="row">
                    <div class="col-xs-12">
                        <form class="form-horizontal" role ="form" id="form-edit">
                            <div class="form-group">
                                <label  class="col-xs-3">Tên toà nhà</label>
                                <div class ="col-xs-9">
                                    <form:input class="form-control"  id="name" path="name" value="" />
                                </div>
                            </div>
                            <div class="form-group">
                             <label  class="col-xs-3">Quận</label>
                            <div class ="col-xs-9">

                                <form:select id="districtid" type ="text" class="form-control" path="district" >
                                    <form:option value="">-----Chọn Quận-----</form:option>
                                   <form:options items="${districtCode}" value="" />

                                </form:select>
                            </div>

                        </div>
                            <div class="form-group">
                                <label  class="col-xs-3">Phường</label>
                                <div class ="col-xs-9">
                                    <form:input class="form-control" type="text" id="ward" path="ward" value=""/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-xs-3">Đường</label>
                                <div class ="col-xs-9">
                                    <form:input class="form-control" type="text" id="street" path="street" value=""/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-xs-3">Kết cấu</label>
                                <div class ="col-xs-9">
                                    <form:input class="form-control" type="text" id="structure" path="structure" value=""/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-xs-3">Số tầng hầm</label>
                                <div class ="col-xs-9">
                                    <form:input class="form-control" type="number" id="numberofbasement" path="numberOfBasement" value=""/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-xs-3">Diện tích sàn</label>
                                <div class ="col-xs-9">
                                    <form:input class="form-control" type="number" id="floorarea" path="floorArea" value=""/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-xs-3">Hướng</label>
                                <div class ="col-xs-9">
                                    <form:input class="form-control" type="text" id="direction" path="direction" value=""/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-xs-3">Hạng</label>
                                <div class ="col-xs-9">
                                    <form:input class="form-control" type="text" id="level" path="level" value=""/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-xs-3">Diện tích thuê</label>
                                <div class ="col-xs-9">
                                    <form:input class="form-control" type="text" id="rentarea" path="rentArea" value=""/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-xs-3">Giá thuê</label>
                                <div class ="col-xs-9">
                                    <form:input class="form-control" type="number" id="rentprice" path="rentPrice" value=""/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-xs-3">Mô tả giá</label>
                                <div class ="col-xs-9">
                                    <form:input class="form-control" type="text" id="rentpricedescription" path="rentPriceDescription" value=""/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-xs-3">Phí dịch vụ</label>
                                <div class ="col-xs-9">
                                    <form:input class="form-control" type="number" id="servicefee" path="serviceFee" value=""/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-xs-3">Phí ô tô</label>
                                <div class ="col-xs-9">
                                    <form:input class="form-control" type="number" id="carfee" path="carFee" value=""/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-xs-3">Phí mô tô</label>
                                <div class ="col-xs-9">
                                    <form:input class="form-control" type="number" id="motorbikefee" path="motoFee" value="" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-xs-3">Phí ngoài giờ</label>
                                <div class ="col-xs-9">
                                    <form:input class="form-control" type="number" id="overtimefee" path="overtimeFee" value=""/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-xs-3">Tiền điện</label>
                                <div class ="col-xs-9">
                                    <form:input class="form-control" type="number" id="electricityfee" path="electricityFee" value=""/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-xs-3">Đặt cọc</label>
                                <div class ="col-xs-9">
                                    <form:input class="form-control" type="number" id="deposit" path="deposit" value=""/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-xs-3">Thanh toán</label>
                                <div class ="col-xs-9">
                                    <form:input class="form-control" type="text" id="payment" path="payment" value=""/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-xs-3">Thời hạn thuê</label>
                                <div class ="col-xs-9">
                                    <form:input class="form-control" type="text" id="renttime" path="rentTime" value=""/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-xs-3">Thời gian trang trí</label>
                                <div class ="col-xs-9">
                                    <form:input class="form-control" type="text" id="decorationtime" path="decorationTime" value=""/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-xs-3">Tên quản lý</label>
                                <div class ="col-xs-9">
                                    <form:input class="form-control" type="text" id="managername" path="managerName" value=""/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-xs-3">SĐT quản lý</label>
                                <div class ="col-xs-9">
                                    <form:input class="form-control" type="text" id="managerphonenumber" path="managerPhone" value=""/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-xs-3">Phí môi giới</label>
                                <div class ="col-xs-9">
                                    <form:input class="form-control" type="number" id="brokeragefee" path="brokerageFee" value=""/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label  class="col-xs-3">Loại toà nhà</label>
                                <div class ="col-xs-9">
                                   <form:checkboxes items="${typeCode}" path="typeCode" value="" />
                                </div>

                            </div>
                            <div class="form-group">
                                <label  class="col-xs-3">Ghi chú</label>
                                <div class ="col-xs-9">
                                    <form:input class="form-control" type="text" id="note" path="note" value=""/>
                                </div>
                            </div>

                            <div class="form-group" >
                                <label  class="col-xs-3"></label>
                                <div class ="col-xs-9">
                                <c:if test="${not empty BuildingEdit.id}">
                                 <button type="button" class="btn btn-lg btn-success" title="Cập nhật toà nhà" id="btnAddOrUpdateBuilding"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-building-add" viewBox="0 0 16 16">
                                        <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0"/>
                                        <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                                        <path d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                                    </svg>Cập nhật toà nhà</button>
                                    <button type="button" class="btn btn-lg btn-info" title="Huỷ thao tác" id="btnCancel" >
                                        <i class="ace-icon glyphicon glyphicon-remove"></i>
                                        Huỷ thao tác </button>
                                </c:if>
                                <c:if test="${empty BuildingEdit.id}">
                                 <button type="button" class="btn btn-lg btn-success" title="Thêm toà nhà" id="btnAddOrUpdateBuilding"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-building-add" viewBox="0 0 16 16">
                                        <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0"/>
                                        <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                                        <path d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                                    </svg>Thêm toà nhà</button>
                                    <button type="button" class="btn btn-lg btn-info" title="Huỷ thao tác" id="btnCancel" >
                                        <i class="ace-icon glyphicon glyphicon-remove"></i>
                                        Huỷ thao tác </button>
                                </c:if>


                                </div>

                            </div>

                            <form:hidden path="id" id="buildingid"/>




                    </div>
                </div>
                </form:form>



            </div><!-- /.page-content -->
        </div><!-- /.main-content -->


    </div><!-- /.main-container -->

    <script>
        $('#btnAddOrUpdateBuilding').click(function(){
            var data ={};
            var typeCode=[];
            var formData =$('#listForm').serializeArray();
            $.each(formData,function(i,v){
                if(v.name === "typeCode"){
                    typeCode.push(v.value);

                }
                else{
                    data[""+v.name+""]=v.value;
                }
            });
            data['typeCode']=typeCode;
            var district = data.district;
            //kiểm tra dữ liệu đã nhậpđủ chưa
            if(typeCode != "" && district != ""){
                AddOrUpdateBuilding(data)
            }
            else{
                window.location.href="/admin/building-edit?typeCode=thieu";
                alert("Vui lòng nhập đầy đủ thông tin vào trường 'Quận' và 'Loại tòa nhà'.");
            }

        });

        function AddOrUpdateBuilding(data){
         //call api
            $.ajax({
                //phuong thuc http method
                type:"POST",
                //api không cần localhost vẫn được
                url:"${buildingAPI}",
                //chuyen dinh dang ve json
                data:JSON.stringify(data),
                //chuyen dinh dang ve json
                contentType:"application/json",
                // nhan ve kieu json
                //dataType:"JSON",
                //thong bao ket qua neu thanh cong
                 success: function(response, textStatus, jqXHR) {
                    // Kiểm tra status code là 200
                    if (jqXHR.status === 200) {
                        // Thông báo thành công
                        console.log("Thêm or sửa tòa nhà thành công!");
                        // Có thể reload lại trang hoặc cập nhật giao diện
                         window.location.href="/admin/building-list?update=success";
                    } else {
                        console.log("Thêm or sửa thành công, nhưng status không phải 204:", jqXHR.status);
                    }
                },
                // Callback khi request thất bại
                error: function(jqXHR, textStatus, errorThrown) {
                    console.log("Thêm or sửa thất bại!");
                    console.log("Status:", jqXHR.status);

                    // Xử lý lỗi validation từ GlobalExceptionHandler (status 400)
                    if (jqXHR.status === 400 && jqXHR.responseJSON) {
                        console.log("Thêm or sửa validation:", jqXHR.responseJSON);
                        alert("Lỗi validation: " + JSON.stringify(jqXHR.responseJSON));
                    } else {
                        console.log("Lỗi hệ thống:", errorThrown);
                        alert("Đã xảy ra lỗi không mong muốn.");
                    }
                }


            })}


    $('#btnCancel').click(function (){

        window.location.href="/admin/building-list";
    });


    </script>
</body>
</html>