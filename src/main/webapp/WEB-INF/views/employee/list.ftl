
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>员工管理</title>
    <#include "/common/link.ftl">

</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <#include "/common/navbar.ftl">
    <!--菜单回显-->
    <#assign currentMenu="employee"/>
    <#include "/common/menu.ftl">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>员工管理</h1>
        </section>
        <section class="content">
            <div class="box">
                <!--高级查询--->
                <div style="margin: 10px;">
                    <form class="form-inline" id="searchForm" action="/employee/list" method="post">
                        <input type="hidden" name="currentPage" id="currentPage" value="1">
                        <div class="form-group">
                            <label for="keyword">关键字:&nbsp;</label>
                            <input type="text"  value="${qo.keyword}" class="form-control" name="keyword" placeholder="请输入用户名或邮箱" onfocus="this.placeholder=''" onblur="this.placeholder='请输入用户名或邮箱'">&nbsp;&nbsp;
                        </div>
                        <div class="form-group">
                            &nbsp;&nbsp;<label for="dept"> 部门:&nbsp;&nbsp;</label>
                            <select class="form-control" id="dept" name="dept_id" >
                                <option  selected value="">所有</option>
                                <#list departments as department>
                                    <option value="${department.id}">${department.name}</option>
                                </#list>
                            </select>
                        </div>
                        <script>
                            $("#dept").val(${qo.dept_id})
                        </script>
                        &nbsp;&nbsp;<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span> 查询</button>
                        <button type="reset" class="btn btn-primary" id="clear-btn"><span class="glyphicon glyphicon-record"></span> 重置</button>
                        &nbsp;&nbsp;<a href="/employee/tosaveOrUpdate" class="btn btn-success btn-input">
                            <span class="glyphicon glyphicon-plus"></span> 添加
                        </a>
                        <a href="/employee/exportEmployeeExel" class="btn btn-warning" >
                            <span class="glyphicon glyphicon-download"></span> 导出
                        </a>
                        <a  class="btn btn-warning btn-import">
                            <span class="glyphicon glyphicon-upload"></span> 导入
                        </a>
                    </form>
                </div>
                <div class="box-body table-responsive ">
                <table class="table table-hover table-bordered table-striped">
                    <thead>
                    <tr>
                        <th><input type="checkbox" id="allCb"></th>
                        <th>编号</th>
                        <th>用户名</th>
                        <th>真实姓名</th>
                        <th>邮箱</th>
                        <th>年龄</th>
                        <th>部门</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list  pageInfo.list as employee>
                        <tr>
                            <td><input type="checkbox" class="cb"  ></td>
                            <td>${employee.id}</td>
                            <td>${employee.username}</td>
                            <td>${employee.name}</td>
                            <td>${employee.email}</td>
                            <td>${employee.age}</td>
                            <td>${employee.department.name}</td>
                            <td>
                                <a href="/employee/tosaveOrUpdate?id=${employee.id}" class="btn btn-info btn-xs btn_redirect" >
                                    <span class="glyphicon glyphicon-pencil"></span> 编辑
                                </a>
                                <a data-url="/employee/delete?id=${employee.id}" class="btn btn-danger btn-xs btn-delete" id="delete" data-name="${employee.name}">
                                    <span class="glyphicon glyphicon-trash"></span> 删除
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

<div class="modal fade" id="importModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">导入</h4>
            </div>
            <form class="form-horizontal" action="/employee/importEmployeeFromExel" enctype="multipart/form-data" method="post" id="importForm">
                <div class="modal-body">
                    <div class="form-group" style="margin-top: 10px;">
                        <label for="name" class="col-sm-3 control-label"></label>
                        <div class="col-sm-6">
                            <!-- 文件上传框 -->
                            <input type="file" name="file">
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 10px;">
                        <div class="col-sm-3"></div>
                        <div class="col-sm-6">
                            <a href="/templates/exportTemplate.xls" class="btn btn-success" >
                                <span class="glyphicon glyphicon-download"></span> 下载模板
                            </a>
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
    $(".btn-import").click(function (){
        $("#importModal").modal("show")
    })

</script>