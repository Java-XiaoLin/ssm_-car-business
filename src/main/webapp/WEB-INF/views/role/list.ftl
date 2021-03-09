<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>角色管理</title>
    <#include "/common/link.ftl">
</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <#include "/common/navbar.ftl">
    <!--菜单回显-->
    <#assign currentMenu="role"/>
    <#include "/common/menu.ftl">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>角色管理</h1>
        </section>
        <section class="content">
            <div class="box">
                <!--高级查询--->
                <div style="margin: 10px;">
                    <!--高级查询--->
                    <form class="form-inline" id="searchForm" action="/role/list" method="post">
                        <input type="hidden" name="currentPage" id="currentPage" value="1">
                        <a href="/role/input" class="btn btn-success btn-input"><span class="glyphicon glyphicon-plus"></span> 添加</a>
                    </form>
                    <div class="box-body table-responsive ">
                    <table class="table table-hover table-bordered table-striped" >
                        <thead>
                            <tr>
                                <th>编号</th>
                                <th>角色名称</th>
                                <th>角色编号</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                        <#list pageInfo.list as role>
                            <tr>
                                <td>${role.id}</td>
                                <td>${role.name}</td>
                                <td>${role.sn}</td>
                                <td>
                                    <a href="/role/input?id=${role.id}" class="btn btn-info btn-xs btn-input">
                                        <span class="glyphicon glyphicon-pencil"></span> 编辑
                                    </a>
                                    <a  class="btn btn-danger btn-xs btn-delete" >
                                        <span class="glyphicon glyphicon-trash"></span> 删除
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
            </div>
        </section>
    </div>
    <#--    <#include "/common/footer.ftl">-->
</div>
</body>
</html>
