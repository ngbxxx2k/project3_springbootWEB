
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>

<c:url var ="buildinglistURL" value="/admin/building-list"/>
<c:url var="buildingAPI" value="/api/building"/>


<html>
<head>
    <title>quản lý toà nhà</title>
</head>
<body>

<div class="main-content" id="main-container">

    <div class="main-content">
        <div class="main-content-inner">
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

                <div class="nav-search" id="nav-search">
                    <form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="ace-icon fa fa-search nav-search-icon"></i>
								</span>
                    </form>
                </div><!-- /.nav-search -->
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
                        Quản Lý Toà Nhà
                        <small>
                            <i class="ace-icon fa fa-angle-double-right"></i>
                            Danh sách toà nhà
                        </small>
                    </h1>
                </div><!-- /.page-header -->
                <div  class ="row">

                    <div class="col-xs-12 ">

                        <div class="widget-box ui-sortable-handle" style="opacity: 1;">
                            <div class="widget-header">
                                <h5 class="widget-title">Tìm Kiếm Toà Nhà</h5>

                                <div class="widget-toolbar">
                                    <div class="widget-menu">


                                        <ul class="dropdown-menu dropdown-menu-right dropdown-light-blue dropdown-caret dropdown-closer">
                                            <li>
                                                <a data-toggle="tab" href="#dropdown1">Option#1</a>
                                            </li>

                                            <li>
                                                <a data-toggle="tab" href="#dropdown2">Option#2</a>
                                            </li>
                                        </ul>
                                    </div>





                                    <a href="#" data-action="collapse">
                                        <i class="ace-icon fa fa-chevron-up"></i>
                                    </a>


                                </div>
                            </div>

                            <div class="widget-body" style="display: block;">
                                <div class="widget-main" >
                                // action là gửi cho api nào
                                //modelAttribute là để nhận dữ liệu từ backend dán lên fontend
                                //method la method get post put...
                                //có thể dùng buildinglistURL để tạo url nhanh bằng < c:url var ="buildinglistURL" value="/admin/building-list"/>

                                    <form:form modelAttribute="modelSearchBuilding" action="/admin/building-list" method="GET" id="listform">
                                        <div class ="row">

                                            <div class ="form-group">
                                                <div class="col-xs-12">
                                                    <div class="col-sm-6">
                                                        <label class ="name">Tên Toà Nhà</label>
                                                        <form:input class="form-control" path="name"/>

                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label class ="name">Diện Tích Sàn</label>
                                                         <form:input class="form-control" path="floorArea"/>

                                                    </div>
                                                </div>
                                            </div>


                                            <div class ="form-group">
                                                <div class="col-xs-12">
                                                    <div class="col-sm-2">
                                                        <label class ="name">Quận</label>
                                                        <form:select class="form-control" path="district" >
                                                            <form:option value="">-----Chọn Quận-----</form:option>
                                                            <form:options items="${districtCode}"/>
                                                        </form:select>


                                                    </div>
                                                    <div class="col-sm-5">
                                                        <label class ="name">Phường</label>
                                                        <form:input class="form-control" path="ward" />


                                                    </div>
                                                    <div class="col-sm-5">
                                                        <label class ="name">Đường</label>
                                                        <form:input  class="form-control" path="street"/>


                                                    </div>
                                                </div>
                                            </div>
                                        <div class ="form-group">
                                            <div class="col-xs-12">
                                                <div class="col-sm-4">
                                                    <label class ="name">Số tần hầm</label>
                                                    <form:input class="form-control" id="numberOfBasement" path="numberOfBasement"/>


                                                </div>
                                                <div class="col-sm-4">
                                                    <label class ="name">Hướng</label>
                                                    <form:input class="form-control" path="direction"/>


                                                </div>
                                                <div class="col-sm-4">
                                                    <label class ="name">Hạng</label>
                                                    <form:input class="form-control" path="level"/>


                                                </div>
                                            </div>
                                        </div>

                                        <div class ="form-group">
                                            <div class="col-xs-12">
                                                <div class="col-sm-3">
                                                    <label class ="name">Diện tích từ</label>
                                                    <form:input  class="form-control" path="areaFrom"/>


                                                </div>
                                                <div class="col-sm-3">
                                                    <label class ="name">Diện tích đến</label>
                                                    <form:input class="form-control" path="areaTo" />


                                                </div>
                                                <div class="col-sm-3">
                                                    <label class ="name">Giá thuê từ</label>
                                                    <form:input class="form-control" path="rentPriceFrom"/>


                                                </div>
                                                <div class="col-sm-3">
                                                    <label class ="name">Giá thuê đến</label>
                                                    <form:input class="form-control" path="rentPriceTo"/>


                                                </div>
                                            </div>
                                        </div>

                                        <div class ="form-group">
                                            <div class="col-xs-12">
                                                <div class="col-sm-4">
                                                    <label class ="name">Tên quản lý</label>
                                                    <form:input class="form-control"  path="managerName"/>
                                                </div>
                                                <div class="col-sm-4">
                                                    <label class ="name">Điện thoại quản lý</label>
                                                    <form:input class="form-control"  path="managerPhone"/>
                                                </div>
                                                <div class="col-sm-4">

                                                    <label class ="name">Chọn nhận viên phụ trách</label>
                                                    <form:select type ="text" class="form-control" path="staffId">
                                                        <form:option value="">-----Chọn nhân viên-----</form:option>
                                                        <form:options items="${listStaff}"/>

                                                    </form:select>

                                                </div>
                                            </div>
                                        </div>

                                        <div class ="form-group">
                                            <div class="col-xs-12">
                                                <div class="col-sm-6">
                                                    <form:checkboxes items="${typeCode}" path="typeCode"/>
                                                </div>

                                            </div>
                                        </div>


                                            <div class="col-xs-12">
                                                <div class="col-sm-6">
                                                    <button class="btn btn-danger" id="btnsearchbuilding"><i class="ace-icon glyphicon glyphicon-search"></i>Tìm Kiếm</button>
                                                </div>

                                            </div>



                                    </div>

                                    </form:form>


                                </div>
                            </div>

                        </div>
                        <div class="pull-right">
                            <a href="/admin/building-edit">
                                <button class ="btn-info" title="Thêm toà nhà">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-building-add" viewBox="0 0 16 16">
                                        <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0"/>
                                        <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                                        <path d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                                    </svg></button>
                            </a>

                            <button class ="btn-warning" title="Xoá toà nhà" id="btnDeleteBuildings">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-building-fill-dash" viewBox="0 0 16 16">
                                    <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7M11 12h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1 0-1"/>
                                    <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v7.256A4.5 4.5 0 0 0 12.5 8a4.5 4.5 0 0 0-3.59 1.787A.5.5 0 0 0 9 9.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .39-.187A4.5 4.5 0 0 0 8.027 12H6.5a.5.5 0 0 0-.5.5V16H3a1 1 0 0 1-1-1zm2 1.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5m3 0v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5m3.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zM4 5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5M7.5 5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm2.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5M4.5 8a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                                </svg>
                            </button>
                        </div>
                    </div>

                </div>

                <!-- bảng danh sách toà nha -->
                <div class="row">
                    <div class="col-xs-12">
                        <table id="tableBuilding" style ="margin: 3em 0 1.5em;"class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th class="center">
                                    <label class="pos-rel">
                                        <input type="checkbox" class="ace">
                                        <span class="lbl"></span>
                                    </label>
                                </th>
                                <th>Tên Toà Nhà</th>
                                <th>Địa chỉ</th>
                                <th >Số tầng hầm</th>
                                <th>Tên quản lý</th>
                                <th >Số điện thoại</th>
                                <th>DT sàn</th>
                                <th>DT trống</th>
                                <th>DT thuê</th>
                                <th>Phí môi giới</th>
                                <th>Giá thuê</th>
                                <th>Phí dịch vụ</th>
                                <th>Thao tác</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach var="item" items="${buildingEntity}">
                                 <tr>
                                <td class="center">
                                    <label class="pos-rel">
                                        <input type="checkbox" class="ace" name="checkList" value="${item.id}">
                                        <span class="lbl"></span>
                                    </label>
                                </td>

                                <td>${item.name}</td>
                                <td>${item.address}</td>
                                <td>${item.numberOfBasement}</td>
                                <td>${item.managerName}</td>
                                <td>${item.managerPhone}</td>
                                <td>${item.floorArea}</td>
                                <td>${item.id}</td>
                                <td>${item.id}</td>
                                <td >${item.id}</td>
                                <td >${item.id}</td>
                                <td >${item.id}</td>


                                <td>
                                    <div class="hidden-sm hidden-xs btn-group">
                                        <button class="btn btn-xs btn-success" title="Giao toà nhà" onclick="assingmentBuilding(${item.id})">
                                            <i class="ace-icon glyphicon glyphicon-align-justify"></i>
                                        </button>

                                            <a class="btn btn-xs btn-info" title="Sửa toà nha" href="/admin/building-edit-${item.id}">
                                                <i class="ace-icon fa fa-pencil bigger-120"></i>
                                            </a>



                                        <button class="btn btn-xs btn-danger" title="Xoá toà nhà" onclick="btnDeleteBuilding(${item.id})">
                                            <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                        </button>


                                    </div>

                                </td>
                            </tr>
                            </c:forEach>



                            </tbody>
                        </table>
                    </div><!-- /.span -->
                </div>


            </div><!-- /.page-content -->
        </div><!-- /.main-content -->




    </div><!-- /.main-container -->

    <div class="modal fade" id="assingmentBuildingModal" role="dialog" >
        <div class="modal-dialog">
            <!-- Modal content  -->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times; </button>
                    <h4 class="modal-title">Danh sách nhân viên</h4>
                </div>
                <div class="modal-body">
                    <table  style ="margin: 3em 0 1.5em;"class="table table-striped table-bordered table-hover" id="staffList">
                        <thead>
                        <tr>


                            <th class="center">Chọn</th>
                            <th>Tên nhân viên</th>

                        </tr>
                        </thead>

                        <tbody>
                        <tr>
                            <td class="center">

                                <input type="checkbox" id="checkbox_1" value="1">


                            </td>

                            <td>Nguyễn văn a</td>

                        </tr>
                        <tr>
                            <td class="center">

                                <input type="checkbox"  id="checkbox_2" value="2">


                            </td>

                            <td>Nguyễn văn c</td>

                        </tr>


                        </tbody>
                    </table>
                    <input type="hidden" id="buildingId" name="building" value="1">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" id="btnassingmentBuilding">Giao toà nhà</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
                </div>

            </div>


        </div>
    </div>
</div>
<script src="assets/js/jquery.2.1.1.min.js"></script>

<script>
    $('#btnsearchbuilding').click(function(e){
        e.preventDefault();
        $('#listform').submit();
    });
</script>


<script>
    function assingmentBuilding(buildingId){
        $('#assingmentBuildingModal').modal();
    }
    $('#btnassingmentBuilding').click(function(e){
        e.preventDefault();
        var data = {};
        data['buildingId' ]=$('#buildingId').val();
        var staffs = $('#staffList').find('tbody input[type = checkbox]:checked').map(function(){
            return $(this).val();
        }).get();
        data['staffs'] = staffs;
        console.log("OK");
    })
</script>


<%--chọn 1 toà nhà từ danh sách xoá--%>
<script>
       function btnDeleteBuilding(data){
           var buildingid = [data]
        deleteBuilding(data)
       }
       <%--chọn nhiều toà nhà để xoá--%>

        $('#btnDeleteBuildings').click(function(e){
        e.preventDefault();

        var ids = $('#tableBuilding').find('tbody input[type = checkbox]:checked').map(function(){
            return $(this).val();
        }).get();
        deleteBuilding(ids)
    })


<%--cả hai dùng chung 1 ajax call api gửi di list toà nhà--%>

    function deleteBuilding(data){
     $.ajax({
                //phuong thuc http method
                type:"DELETE",
                //api không cần localhost vẫn được
                url:"${buildingAPI}/"+data,
                //chuyen dinh dang ve json
                data:JSON.stringify(data),
                //chuyen dinh dang ve json
                contentType:"application/json",
                // nhan ve kieu json
                //dataType:"JSON",
                //thong bao ket qua neu thanh cong
                success: function(respond){
                    console.log("success");
                },
                error: function(respond){
                    console.log("failed");
                    console.log(respond);
                }


            })

    }


</script>



</body>
</html>
