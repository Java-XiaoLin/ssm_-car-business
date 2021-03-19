<!DOCTYPE html>

<html xmlns:c="http://www.w3.org/1999/html">
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
            <h1>员工编辑/新增</h1>
        </section>
        <section class="content" >
            <div class="box">
                <form class="form-horizontal" action="/employee/saveOrUpdate" method="post" id="editForm" style="height: 690px">
                    <input type="hidden" name="id" value="${employee.id}" >
                    <div class="form-group" style="margin-top: 10px;">
                        <label class="col-sm-2 control-label">用户名：</label>
                        <div class="col-sm-6">
                            <input type="text" value="${employee.username}" class="form-control" name="username"  placeholder="请输入用户名">
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 10px;">
                        <label class="col-sm-2 control-label">真实姓名：</label>
                        <div class="col-sm-6">
                            <input type="text" value="${employee.name}" class="form-control" name="name"  placeholder="请输入真实姓名">
                        </div>
                    </div>
                    <#if employee ==  null>
                        <div class="form-group">
                            <label for="password" class="col-sm-2 control-label">密码：</label>
                            <div class="col-sm-6">
                                <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="repassword" class="col-sm-2 control-label">验证密码：</label>
                            <div class="col-sm-6">
                                <input type="password" class="form-control" id="repassword" name="repassword" placeholder="再输入一遍密码">
                            </div>
                        </div>
                    </#if>

                    <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">电子邮箱：</label>
                        <div class="col-sm-6">
                            <input type="text" value="${employee.email}" class="form-control"  name="email" placeholder="请输入邮箱">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="age" class="col-sm-2 control-label">年龄：</label>
                        <div class="col-sm-6">
                            <input type="text" value="${employee.age}" class="form-control" name="age" placeholder="请输入年龄">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="dept" class="col-sm-2 control-label">部门：</label>
                        <div class="col-sm-6">
                            <select class="form-control" id="dept" name="deptId">
                                <#list departments as department>
                                    <option value="${department.id}" >${department.name}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <script>
                        $("#dept").val(${employee.department.id})
                    </script>
                    <div class="form-group" id="adminDiv">
                        <label for="admin" class="col-sm-2 control-label">超级管理员：</label>
                        <div class="col-sm-6"style="margin-left: 15px;">
                            <input type="checkbox" id="admin" name="admin" ${((employee.admin)?string("checked",""))!} class="checkbox">
                        </div>
                    </div>
                    <div class="form-group" id="roleDiv">
                        <label for="role" class="col-sm-2 control-label">分配角色：</label><br/>
                        <div class="row" style="margin-top: 10px">
                            <div class="col-sm-2 col-sm-offset-2">
                                <select multiple class="form-control allRoles" size="8">
                                    <#list roles as role>
                                        <option value="${role.id}">${role.name}</option>
                                    </#list>
                                </select>
                            </div>

                            <div class="col-sm-1" style="margin-top: -10px;" align="center">
                                <div>

                                    <a type="button" class="btn btn-primary  " style="margin-top: 10px" title="右移动"
                                       onclick="moveSelected('allRoles', 'selfRoles')">
                                        <span class="glyphicon glyphicon-menu-right"></span>
                                    </a>
                                </div>
                                <div>
                                    <a type="button" class="btn btn-primary " style="margin-top: 10px" title="左移动"
                                       onclick="moveSelected('selfRoles', 'allRoles')">
                                        <span class="glyphicon glyphicon-menu-left"></span>
                                    </a>
                                </div>
                                <div>
                                    <a type="button" class="btn btn-primary " style="margin-top: 10px" title="全右移动"
                                       onclick="moveAll('allRoles', 'selfRoles')">
                                        <span class="glyphicon glyphicon-forward"></span>
                                    </a>
                                </div>
                                <div>
                                    <a type="button" class="btn btn-primary " style="margin-top: 10px" title="全左移动"
                                       onclick="moveAll('selfRoles', 'allRoles')">
                                        <span class="glyphicon glyphicon-backward"></span>
                                    </a>
                                </div>
                            </div>

                            <div class="col-sm-2">
                                <select multiple class="form-control selfRoles" size="8" name="ids">
                                    <#list selectRolesById as role>
                                      <option value="${role.id}">${role.name}</option>
                                    </#list>

                                </select>
                            </div>
                        </div>
                    </div>
                    </br>

                    <div class="form-group" style="margin:0 auto;width:300px;height:100px;">
                        <div class="col-sm-offset-1 col-sm-6">
                            <button type="submit" class="btn btn-primary btn-submit">保存</button>
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
    $(function (){
        let roleDiv = $("#roleDiv").html();
        $("#admin").click(function (){
            if ($(this).prop('checked')){ // 判断选是否选中
                roleDiv = $("#roleDiv").detach(); // 如果选中就删除
            }else {
                $("#adminDiv").after(roleDiv); // 未选中就回显
            }
        })
    })

    function moveAll(source,target){
        $("."+source+" > option").appendTo($("."+target));
    }

    function moveSelected(source,target){
        $("."+source+" > option:selected").appendTo($("."+target));
    }

    var ids = [];
    $(".selfRoles > option").each(function(index,ele){
        ids.push($(ele).val())
    });
    $(".allRoles > option").each(function(index,ele){
        //取出元素的value值，判断是否在ids集合中，如果在就删除该元素
        var index = $.inArray($(ele).val(),ids);
        if(index>-1){
            $(ele).remove();
        }
    });

    // 拿到所有权限
    $(".allPermissions > option").each(function (index,ele){
        // 取出所有元素的value值，判断是否在ids集合中，如果存在就删除该元素
        let id = $.inArray($(ele).val(),ids); // 如果存在相同的会返回索引（正整数）
        if (id > -1){
            $(ele).remove();
        }
    });
</script>