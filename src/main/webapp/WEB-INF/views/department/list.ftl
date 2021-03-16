<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>部门管理</title>
    <#-- 使用相对当前模板文件的路径 再去找另一个模板文件 -->
    <#include "/common/link.ftl">

</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <#include "/common/navbar.ftl">

    <!--定义一个变量  用于菜单回显-->
    <#assign currentMenu="department"/>

    <#include "/common/menu.ftl">

    <div class="content-wrapper">
        <section class="content-header">
            <h1>部门管理</h1>
        </section>
        <section class="content">
            <div class="box">
                <!--高级查询--->
                <form class="form-inline" id="searchForm" action="/department/list" method="post">
                    <input type="hidden" name="currentPage" id="currentPage" value="1">
                    <a  data-target="#addModal"  class="btn btn-success btn-input" style="margin: 10px" >
                        <span class="glyphicon glyphicon-plus" ></span> 添加
                    </a>
                </form>



                <!--编写内容-->
                <div class="box-body table-responsive ">
                    <table class="table table-hover table-bordered table-striped">
                        <thead>
                        <tr>
                            <th>编号</th>
                            <th>部门名称</th>
                            <th>部门编号</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list pageInfo.list as department>
                            <tr>
                                <td>${department.id}</td>
                                <td>${department.name}</td>
                                <td>${department.sn}</td>
                                <td>
                                    <a  class="btn btn-info btn-xs btn-input" id="update" data-json='${department}'>
                                        <span class="glyphicon glyphicon-pencil"></span> 编辑
                                    </a>
                                    <a class="btn btn-danger btn-xs btn-deletable" onclick="checkdelete(${department.id},'${department.name}')" >
                                        <span class="glyphicon glyphicon-trash" ></span> 删除
                                    </a>
                                </td>
                            </tr>
                        </#list>


                        </tbody>
                    </table>
                    <!--分页-->
                    <#include "/common/page.ftl" >
                </div>
            </div>
        </section>
    </div>


        </div>


<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form action="/department/saveOrUpdate" type="post" >
                <input name="id" hidden="hidden" >
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">添加/编辑部门</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="exampleInputEmail1">部门名称</label>
                        <input type="text" class="form-control" name="name" id="exampleInputEmail1" placeholder="请输入部门名称" onfocus="this.placeholder=''" onblur="this.placeholder='请输入部门名称'" value="${qo}">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">部门编号</label>
                        <input type="text" class="form-control" name="sn" id="exampleInputPassword1" placeholder="请输入部门编号" onfocus="this.placeholder=''" onblur="this.placeholder='请输入部门编号'" value="${qo}">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" value="保存" class="btn btn-primary">保存</button>
                </div>
            </form>
        </div>
    </div>
</div>

<#--    <#include "/common/footer.ftl" >-->
</div>



</body>
</html>

<script>

    function checkdelete(id,name){
                       Swal.fire({
                           title: '你确定要删除'+name+'吗',
                           text: "删除后数据不可恢复",
                           icon: 'warning',
                           showCancelButton: true,
                           confirmButtonColor: '#3085d6',
                           cancelButtonColor: '#d33',
                           confirmButtonText: '确定',
                           cancelButtonText: '取消',
                       }).then((result) => {
                           if (result.value) {
                               $.ajax({
                                   url: '/department/delete',
                                   data: {'id': id},
                                   success:function (result){
                                       if (result.success){
                                           Swal.fire({
                                                   title:'删除成功',
                                                   text:  'Your file has been deleted.',
                                                   icon: 'success',
                                               }
                                           ),
                                               window.setTimeout(function (){
                                                   window.location.reload();
                                               },1000);
                                       }else {
                                           Swal.fire({
                                               icon: 'error',
                                               title: '不可以删除'+name,
                                               text: '因为该部门下还有员工',
                                           })
                                       }
                                   }
                               })

                           }
                       })

    }
    <!--在打开模态框之前进行数据的加载回显-->
    $(function (){
        $(".btn-input").click(function (){
            // 拿到data-自定义属性挂载的值，用data("自定义属性")来进行取值
            let data = $(this).data("json");
            // 如果取出来有值，就进行渲染数据
            if (data){
                // 拿到name属性为sn的输入框，将value值进行赋值
                $("input[name=sn]").val(data.sn);
                // 拿到name属性为id的输入框，将value值进行赋值
                $("input[name=id]").val(data.id);
                // 拿到name属性为name的输入框，将value值进行赋值
                $("input[name=name]").val(data.name);
            }else {
                // 打开增加模态框的时候，先将里面的值清空
                $("#addModal input").val("")
            }
            // 打开模态框
            $('#addModal').modal("show")
        })
    })
</script>