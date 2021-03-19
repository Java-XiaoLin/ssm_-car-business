<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <#include "/common/link.ftl">
</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <#include "/common/navbar.ftl">
    <!--菜单回显-->
    <#assign currentMenu="permission"/>
    <#include "/common/menu.ftl">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>权限管理</h1>
        </section>
        <section class="content">
            <div class="box" >
                <!--高级查询--->
                <form class="form-inline" id="searchForm" action="/permission/list" method="post">
                    <input type="hidden" name="currentPage" id="currentPage" value="1">
                    <a href="javascript:;" class="btn btn-success btn-reload" style="margin: 10px;">
                        <span class="glyphicon glyphicon-repeat"></span>  重新加载
                    </a>
                </form>
                <div class="box-body table-responsive ">
                <table class="table table-hover table-bordered table-striped" >
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>权限名称</th>
                        <th>权限表达式</th>
                   
                    </tr>
                    </thead>
                    <tbody>
                    <#list pageInfo.list as permission>
                        <tr>
                            <td>${permission.id}</td>
                            <td>${permission.name}</td>
                            <td>${permission.expression}</td>

                        </tr>
                    </#list>

                    </tbody>
                </table>
                    <#include "/common/page.ftl">
                </div>
            </div>
        </section>
    </div>
</div>
</body>
</html>
<script>
    $(".btn-reload").click(function(){
        Swal.fire({
            title: '需要重新加载权限吗？',
            icon: 'info',
            showCancelButton: true,
            confirmButtonText: '确定',
            cancelButtonText: '取消'
        }).then((result) => {
            //点击按钮之后触发方法.
            if (result.value) {
                //发送请求重新加载权限
                $.get("/permission/reload",function(data){
                    if(data.success){
                        window.location.reload();
                    }else{
                        Swal.fire({
                            title:data.msg,
                            icon: 'danger',
                        })
                    }
                })

            }
        })
    });
</script>