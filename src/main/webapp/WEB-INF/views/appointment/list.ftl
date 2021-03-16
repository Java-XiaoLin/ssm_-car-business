<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>预约单管理</title>
    <#include "/common/link.ftl">
</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <#include "/common/navbar.ftl">
    <!--菜单回显-->
    <#assign currentMenu="appointment"/>
    <#include "/common/menu.ftl">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>预约单管理</h1>
        </section>
        <section class="content">
            <div class="box">
                <!--高级查询--->
                <div style="margin: 20px 0px 0px 10px">
                    <form class="form-inline" id="searchForm" action="/appointment/list" method="post">
                        <input type="hidden" name="currentPage" id="currentPage" value="1">
                        <div class="form-group">
                            <label>预约单流水号</label>
                            <input type="text" class="form-control" id="ano" name="ano" value="${qo.ano}"  placeholder="请输入预约单流水号">
                        </div>
                                <div class="form-group">
                                    <label>预约业务大类</label>
                                    <select class="form-control" name="categoryId" id="categoryId">
                                        <option value="" disabled="disabled" selected >请选择业务大类</option>
                                        <#list systemDictionaryItems as systemDictionaryItem>
                                            <option value="${systemDictionaryItem.id}">${systemDictionaryItem.title}</option>
                                        </#list>
                                    </select>
                                    <script>
                                        $("#categoryId").val(${qo.categoryId})
                                    </script>
                                </div>
                                <div class="form-group">
                                    <label>预约单状态</label>
                                    <select class="form-control" id="status" name="status">
                                        <option value=""  selected>全部</option>
                                        <#list AppointmentEnum as appointmentEnum>
                                          <option value="${appointmentEnum.getValue()}" >${appointmentEnum.getName()}</option>
                                        </#list>
                                    </select>
                                    <script>
                                        $("#status").val(${qo.status})
                                    </script>
                                </div>

                                <div class="form-group">
                                    <label>门店查询</label>
                                    <select class="form-control"  id="businessId">
                                        <option value="" disabled="disabled" selected>请选择门店</option>
                                        <#list businessAll as business>
                                          <option value="${business.id}" >${business.name}</option>
                                        </#list>
                                    </select>
                                </div>
                                    <script>
                                        $("#businessId").val(${qo.businessId})
                                    </script>
                                <div class="form-group">
                                    <label>客户名称</label>
                                    <input type="text" class="form-control" name="contactName" value="${qo.contactName}" placeholder="请输入客户名称">
                                </div>
                        <br/>
                        <br/>

                                <div class="form-group">
                                    <label>客户手机号</label>
                                    <input type="text" class="form-control" name="contactTel" value="${qo.contactTel}" placeholder="请输入客户手机号">
                                </div>



                        <div class="form-group ">
                            <label>预约时间查询：</label>
                            <input placeholder="请输入开始时间" type="text" name="startTime" value="${(qo.startTime?string('yyyy-MM-dd'))!}" class="form-control input-dateTime"  /> -
                            <input placeholder="请输入结束时间" type="text" name="endTime"  value="${(qo.endTime?string('yyyy-MM-dd '))!}" class="form-control input-dateTime"  />
                        </div>

                        <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span> 查询</button>


                        <a href="#" class="btn btn-success btn-input">
                            <span class="glyphicon glyphicon-plus"></span> 添加
                        </a>
                        <button type="reset" class="btn btn-primary" id="clear-btn"><span class="glyphicon glyphicon-record"></span> 重置</button>
                    </form>

                </div>
                <div class="box-body table-responsive ">
                <table class="table table-hover table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>流水号</th>
                        <th>业务大类</th>
                        <th>预约说明</th>
                        <th>预约时间</th>
                        <th>客户名称</th>
                        <th>联系方式</th>
                        <th>预约门店</th>
                        <th>状态</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list pageInfo.list as appointment>
                        <tr>
                            <td>#{appointment.id}</td>
                            <td>${appointment.ano}</td>
                            <td>${appointment.category.title}</td>
                            <td>${appointment.info}</td>
                            <td>${(appointment.appointmentTime)?string("yyyy-MM-dd")}</td>
                            <td>${appointment.contactName}</td>
                            <td>${appointment.contactTel}</td>
                            <td>${appointment.business.name}</td>
                            <td>${appointment.statusName}</td>
                            <td>
                                <a  class="btn btn-info btn-xs btn-input" data-json='${appointment}'>
                                    <span class="glyphicon glyphicon-pencil"></span> 编辑
                                </a>
                                <a class="btn btn-xs btn-primary btn-status "  data-id="${appointment.id}">
                                    <span class="glyphicon glyphicon-phone-alt"></span> 确认预约</a>
                                <a class="btn btn-xs btn-danger btn-remove" data-id="${appointment.id}">
                                    <span class="glyphicon glyphicon-remove"></span> 取消预约</a>
                                <a href="#" class="btn btn-success btn-xs btn-consume" >
                                    <span class="glyphicon glyphicon-shopping-cart"></span> 确认到店
                                </a>
                            </td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
                    <!--分页-->
                    <#include "/common/page.ftl">
                </div>

            </div>
        </section>
    </div>
<#--    <#include "/common/footer.ftl">-->
</div>


<#-- 文件上传模态框 -->
<!--模态框-->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">新增/编辑</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
            </div>

            <form id="editForm" action="/appointment/saveOrUpdate" method="post" >
                <div class="modal-body">
                    <input type="hidden" name="id">
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label">预约门店：</label>
                        <div class="col-sm-7">
                            <select class="form-control"  name="businessId">
                                <option value="" disabled="disabled" selected>请选择预约门店</option>
                                <#list businessAll as business>
                                    <option value="${business.id}">${business.name}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label ">预约时间：</label>
                        <div class="col-sm-7">
                            <input type="text" name="appointmentTime" class="form-control input-dateTime" placeholder="请输入预约时间"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label">业务大类：</label>
                        <div class="col-sm-7">
                            <select class="form-control" name="categoryId">
                                <option value="" disabled="disabled" selected>请选择业务大类</option>
                               <#list systemDictionaryItems as systemDictionaryItem>
                                 <option value="${systemDictionaryItem.id}">${systemDictionaryItem.title}</option>
                               </#list>
                            </select>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label">联系人：</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" name="contactName"
                                   placeholder="请输入联系人">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label">联系电话：</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" name="contactTel"
                                   placeholder="请输入联系电话">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label">预约说明：</label>
                        <div class="col-sm-7">
                            <textarea type="text" class="form-control" name="info"
                                      placeholder="请输入预约说明"></textarea>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary btn-submit">保存</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
<script>
    $(function (){
        $(".btn-input").click(function (){
            let data = $(this).data("json");
            if (data){
                $("select[name=businessId]").val(data.businessId);
                $("select[name=categoryId]").val(data.categoryId);
                $("input[name=contactTel]").val(data.contactTel)
                $("textarea[name=info]").val(data.info)
                $("input[name=contactName]").val(data.contactName)
                $("input[name=appointmentTime]").val(data.appointmentTime)
                $("input[name=id]").val(data.id)
            }else {
                // 将表单置空，否则会出现编辑后再点击添加，还会出现回显的数据
               $("#editForm input").val("")
               $("#editForm textarea").val("")
               $("#editForm select").val("")
            }
            $("#editModal").modal("show")
        })

        $(".btn-status").click(function (){
            Swal.fire({
                title: '你确定要确认预约吗吗',
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: '确定',
                cancelButtonText: '取消'
            }).then((result) => {
                if (result.value) {
                    let appointmentId = $(this).data("id");
                    $.ajax({
                        data:{"appointmentId":appointmentId},
                        url:"/appointment/updateStatus?status=1",
                        success:function (result){
                            if (result.success == true){
                                window.location.reload();
                            }else {
                                alert(result.msg)
                            }
                        }
                    })
                }
            })

        })

        $(".btn-remove").click(function (){
            Swal.fire({
                title: '你确定要取消预约吗',
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: '确定',
                cancelButtonText: '取消'
            }).then((result) => {
                if (result.value) {
                    let appointmentId = $(this).data("id");
                    $.ajax({
                        data:{"appointmentId":appointmentId},
                        url:"/appointment/updateStatus?status=4",
                        success:function (result){
                            if (result.success == true){
                                window.location.reload();
                            }else {
                                alert(result.msg)
                            }
                        }
                    })
                }
            })
        })

        $(".btn-consume").click(function (){
            Swal.fire({
                title: '你确定到店了吗',
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: '确定',
                cancelButtonText: '取消'
            }).then((result) => {
                if (result.value) {
                    let appointmentId = $(this).data("id");
                    $.ajax({
                        data:{"appointmentId":appointmentId},
                        url:"/appointment/updateStatus?status=2",
                        success:function (result){
                            if (result.success == true){
                                window.location.reload();
                            }else {
                                alert(result.msg)
                            }
                        }
                    })
                }
            })
        })
    })

</script>


