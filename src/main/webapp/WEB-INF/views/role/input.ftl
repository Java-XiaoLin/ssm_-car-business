

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
            <h1>角色编辑</h1>
        </section>
        <section class="content">
            <div class="box">
                <form class="form-horizontal" action="/role/saveOrUpdate" method="post" id="editForm">
                    <input type="hidden"  name="id" value="${role.id}">
                    <div class="form-group"  style="margin-top: 10px;">
                        <label  class="col-sm-2 control-label">角色名称：</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control"  name="name" value="${role.name}" placeholder="请输入角色名称">
                        </div>
                    </div>

                    <div class="form-group">

                        <label class="col-sm-2 control-label">角色编号：</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control"  name="sn" value="${role.sn}" placeholder="请输入角色编号">
                        </div>
                    </div>
                    <div class="form-group " id="role">
                        <label for="role" class="col-sm-2 control-label">分配权限：</label><br/>
                        <div class="row" style="margin-top: 10px">
                            <div class="col-sm-2 col-sm-offset-2">
                                <select multiple class="form-control allPermissions" size="8">
                                    <#list permissions as permission>
                                      <option value="${permission.id}">${permission.name}</option>
                                    </#list>
                                </select>
                            </div>

                            <div class="col-sm-1" style="margin-top: -10px;" align="center">
                                <div>

                                    <a type="button" class="btn btn-primary" style="margin-top: 10px" title="右移动"
                                       onclick="moveSelected('allPermissions', 'selfPermissions')">
                                        <span class="glyphicon glyphicon-menu-right"></span>
                                    </a>
                                </div>
                                <div>
                                    <a type="button" class="btn btn-primary " style="margin-top: 10px" title="左移动"
                                       onclick="moveSelected('selfPermissions', 'allPermissions')">
                                        <span class="glyphicon glyphicon-menu-left"></span>
                                    </a>
                                </div>
                                <div>
                                    <a type="button" class="btn btn-primary " style="margin-top: 10px" title="全右移动"
                                       onclick="moveAll('allPermissions', 'selfPermissions')">
                                        <span class="glyphicon glyphicon-forward"></span>
                                    </a>
                                </div>
                                <div>
                                    <a type="button" class="btn btn-primary " style="margin-top: 10px" title="全左移动"
                                       onclick="moveAll('selfPermissions', 'allPermissions')">
                                        <span class="glyphicon glyphicon-backward"></span>
                                    </a>
                                </div>
                            </div>
                            <div class="col-sm-2">
                                <select multiple class="form-control selfPermissions" size="8" name="ids">
                                    <#list permissionByRoleId as perminssion>
                                      <option value="${perminssion.id}">${perminssion.name}</option>
                                    </#list>
                                </select>
                            </div>


                        </div>
                    </div>
                    <div class="form-group" style="margin:0 auto;width:300px;height:100px;">
                        <div class="col-sm-offset-1 col-sm-6">
                            <button type="button" class="btn btn-primary btn-submit">保存</button>
                            <a href="javascript:window.history.back()" class="btn btn-danger">取消</a>
                        </div>
                    </div>

                </form>
            </div>
        </section>
    </div>
</div>
</body>
</html>
<script>
    // 全部移动
    function moveAll(source,target){
        // 把左边的加入到右边去，需要appendTo
        $('.'+source +'> option').appendTo($('.'+target));
    }

    // 选中移动
    function moveSelected(source,target){
        // 将选中的进行移动
        $('.' + source +' > option:selected').appendTo($('.' + target))
    }


    // 将右边的表单全部选中进行提交
    $(".btn-submit").click(function (){
        // 选中所有的option
        $(".selfPermissions > option").prop("selected",true);
        // 提交表单
        $("#editForm").submit();
    })

    // 去除重复（回显的和原来可以选择的）
    var ids = [];
    // 遍历根据id查询角色的所有权限的option（右边）
    $(".selfPermissions > option").each(function (index,ele){
        // 将遍历出来的放入到我们新建的数组中
        ids.push($(ele).val())
    })

    // 拿到所有权限
    $(".allPermissions > option").each(function (index,ele){
        // 取出所有元素的value值，判断是否在ids集合中，如果存在就删除该元素
        let id = $.inArray($(ele).val(),ids); // 如果存在相同的会返回索引（正整数）
        if (id > -1){
            $(ele).remove();
        }
    });


</script>
