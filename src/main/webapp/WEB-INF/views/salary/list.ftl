<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>工资管理</title>
    <#include "/common/link.ftl">

</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <#include "/common/navbar.ftl">

    <#assign currentMenu="salary"/>

    <#include "/common/menu.ftl">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>工资管理</h1>
        </section>
        <section class="content">
            <div class="box">
                <!--高级查询--->
                <form class="form-inline" id="searchForm" action="/salary/list" method="post">
                    <input type="hidden" name="currentPage" id="currentPage" value="1">
                    <div class="form-group">
                        <label for="keyword">关键字:</label>
                        <input type="text" class="form-control" value="${qo.keyword}" name="keyword" placeholder="请输入姓名">
                    </div>
                    <div class="form-group">
                        <label > 发放方式:</label>
                            <select class="form-control"  name="systemDictionaryItem_id">
                            <option value="">全部</option>
                           <#list systemDictionaryItems as systemDictionaryItem>
                               <option value="${systemDictionaryItem.id}">${systemDictionaryItem.title}</option>
                           </#list>
                        </select>
                    </div>
                    <script>
                        $("select[name=systemDictionaryItem_id]").val(${qo.systemDictionaryItem_id})
                    </script>
                    <div class="form-group">
                        <label>工资范围查询：</label>
                        <input placeholder="请输入最低工资" type="text" value="${qo.minSalary}" name="minSalary" class="form-control "   /> -
                        <input placeholder="请输入最高工资" type="text" value="${qo.maxSalary}" name="maxSalary"  class="form-control "   />
                    </div>
                    <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span> 查询</button>
                    <a  class="btn btn-success btn-input btn-save" style="margin: 10px">
                        <span class="glyphicon glyphicon-plus"></span> 添加
                    </a>
                </form>
                <!--编写内容-->
                <div class="box-body table-responsive">
                    <table class="table table-hover table-bordered table-striped">
                        <thead>
                        <tr>
                            <th>编号</th>
                            <th>年份</th>
                            <th>月份</th>
                            <th>员工</th>
                            <th>工资</th>
                            <th>发放方式</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                            <#list pageInfo.list as salary>
                        <tr>
                                <td>${salary.id}</td>
                                <td>${salary.year}</td>
                                <td>${salary.month}</td>
                                <td>${salary.employee.name}</td>
                                <td>${salary.money}</td>
                                <td>${salary.payoutType.title}</td>
                                <td>
                                    <a  class="btn btn-info btn-xs btn-input btn-edit" data-id=${salary.employee.id} data-json=${salary}>
                                        <span class="glyphicon glyphicon-pencil"></span> 编辑
                                    </a>
                                </td>
                        </tr>
                            </#list>
                        </tbody>
                    </table>
                    <#include "/common/page.ftl" >
                </div>
            </div>
        </section>
    </div>
</div>




<!-- Modal -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">新增/编辑</h4>
            </div>
            <form class="form-horizontal" action="/salary/saveOrUpdate" method="post" id="editForm">
                <div class="modal-body">
                    <input type="hidden" name="id">
                    <div class="form-group" style="margin-top: 10px;">
                        <label for="name" class="col-sm-3 control-label">年份：</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="year"
                                   placeholder="请输入年份">
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 10px;">
                        <label for="sn" class="col-sm-3 control-label">月份：</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="month"
                                   placeholder="请输入月份">
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 10px;">
                        <label for="sn" class="col-sm-3 control-label">员工：</label>
                        <div class="col-sm-6">
                            <select type="text" class="form-control" name="employee.id" id="employee">
                                <#list Allemployee as employee>
                                  <option value="${employee.id}">${employee.name}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 10px;">
                        <label for="sn" class="col-sm-3 control-label">工资：</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="money"
                                   placeholder="请输入工资">
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 10px;">
                        <label for="sn" class="col-sm-3 control-label">发放方式：</label>
                        <div class="col-sm-6">
                            <select type="text" class="form-control" name="payoutType.id">
                                <option value="">请选择发放方式</option>
                                <#list systemDictionaryItems as systemDictionaryItem>
                                    <option value="${systemDictionaryItem.id}">${systemDictionaryItem.title}</option>
                                </#list>
                            </select>
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
    $(".btn-save").click(function (){
        $("#editModal").modal("show")
    })
    $(".btn-edit").click(function (){
            let employeeId = $(this).data("id");
            let salary = $(this).data("json");
        $.ajax({
            data:{"employeeId":employeeId},
            url:"/salary/selectEmployeeById",
            success:function (result){
                $("#employee").empty()
                $("#employee").append("<option value='" + result.data.id + "' readonly='readonly'>" + result.data.name + "</option>");
                if (salary){
                    $("input[name=id]").val(salary.id);
                    $("input[name=year]").val(salary.year);
                    $("input[name=month]").val(salary.month);
                    $("input[name=salary]").val(salary.money);
                    $("select[name='payoutType.id']").val(salary.payoutType.id)
                }
            }
        })
        $("#editModal").modal("show")
    })
</script>
