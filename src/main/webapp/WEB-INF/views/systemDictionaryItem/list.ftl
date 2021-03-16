<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>字典明细管理</title>
    <#-- 使用相对当前模板文件的路径 再去找另一个模板文件 -->
    <#include "/common/link.ftl">


</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <#include "/common/navbar.ftl">
    <!--定义一个变量  菜单回显-->
    <#assign currentMenu="systemDictionaryItem"/>
    <#include "/common/menu.ftl">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>字典明细管理</h1>
        </section>
        <section class="content">
            <div class="box">
                <div class="row" style="margin:20px">
                    <div class="col-xs-2">
                        <div class="panel panel-default">
                            <div class="panel-heading">字典目录</div>
                            <div class="panel-body">
                                <div class="list-group" id="dic">
                                    <#list systemDictionaries as systemDictionarie>
                                        <a href="/systemDictionaryItem/list?typeId=${systemDictionarie.id}" name="typeId" class="list-group-item ${(systemDictionarie.id==qo.typeId)?string('active','')}">${systemDictionarie.title}</a>
                                    </#list>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-xs-10">
                        <!--高级查询--->
                        <form class="form-inline" id="searchForm" action="/systemDictionaryItem/list" method="post">
                            <input type="hidden" name="currentPage" id="currentPage" value="1">
                            <input type="text" hidden="hidden" name="typeId" value="${qo.typeId}">
                            <a href="#" class="btn btn-success btn-input" style="margin: 10px">
                                <span class="glyphicon glyphicon-plus"></span> 添加
                            </a>
                        </form>
                        <!--编写内容-->
                        <div class="box-body table-responsive no-padding ">
                            <table class="table table-hover table-bordered table-striped">
                                <thead>
                                    <tr>
                                        <th>编号</th>
                                        <th>字典明细标题</th>
                                        <th>字典明细序号</th>
                                        <th>上级明细</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <#list pageInfo.list as systemDictionaryItem>
                                    <tr>

                                        <td>${systemDictionaryItem.id}</td>
                                        <td>
                                            <a href="/systemDictionaryItem/list?parentId=${systemDictionaryItem.id}">${systemDictionaryItem.title}</a>
                                        </td>
                                        <td>${systemDictionaryItem.sequence}</td>
                                        <td>${(systemDictionaryItem.parentId)!'无'}</td>
                                        <td>
                                            <a href="#" class="btn btn-info btn-xs btn-update"  data-json='${systemDictionaryItem}'>
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
                </div>

            </div>
        </section>
    </div>
<#--    <#include "/common/footer.ftl" >-->
</div>


<!-- Modal -->
<div class="modal fade" id="insertModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >新增</h4>
            </div>
            <form class="form-horizontal" action="/systemDictionaryItem/save" method="post" id="editForm">
                <div class="modal-body">
                        <input type="hidden" name="id">
                        <div  class="form-group" style="margin-top: 10px;">
                            <label for="name" class="col-sm-3 control-label">字典目录：</label>
                            <div class="col-sm-6">
                                <select id="systemDictionarySelect" class="form-control" name="typeId"  >
                                    <option value="null" disabled="disabled" selected>请选择</option>
                                   <#list systemDictionaries as systemDictionarie>
                                     <option value="${systemDictionarie.id}">${systemDictionarie.title}</option>
                                   </#list>
                                </select>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 10px;">
                            <label   class="col-sm-3 control-label">上级明细：</label>
                            <div class="col-sm-6">
                                <select id="parent" class="form-control" name="parentId" >
                                </select>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 10px;">
                            <label  class="col-sm-3 control-label">明细标题：</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control"
                                       placeholder="请输入字典明细编码" name="title">
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 10px;">
                            <label class="col-sm-3 control-label">明细序号：</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control"
                                       placeholder="请输入字典明细序号" name="sequence">
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
<!-- Modal -->
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >编辑</h4>
            </div>
            <form class="form-horizontal" action="/systemDictionaryItem/update" method="post" id="editForm">
                <div class="modal-body">
                    <input type="hidden" name="id">
                    <div class="form-group" style="margin-top: 10px;">
                        <label  class="col-sm-3 control-label">明细标题：</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control"
                                   placeholder="请输入字典明细标题" name="title"/>
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 10px;">
                        <label class="col-sm-3 control-label">明细序号：</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control"
                                   placeholder="请输入字典明细序号" name="sequence"/>
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
            $("#insertModal").modal('show')
        })

        $("#systemDictionarySelect").change(function (){
            let str = '<option value="">无</option>';
            let typeId = $(this).val();
            $.ajax({
                url:"/systemDictionaryItem/selectItemByParentId",
                data:{"typeId":typeId},
                success:function (result){
                    $.each(result.data,function (index,ele) {
                        str += '<option value="'+ele.id+'">'+ele.title+'</option>'
                    })
                    $("#parent").html(str)
                }
            })
        })

        $(".btn-update").click(function (){
            let object = $(this).data("json");
            if (object){
                $("input[name=id]").val(object.id);
                $("input[name=title]").val(object.title);
                $("input[name=sequence]").val(object.sequence);
            }else {
                $("#addModal input").val("")
            }
            $("#updateModal").modal('show')
        })
    })


</script>
