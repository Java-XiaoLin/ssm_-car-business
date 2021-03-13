<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>字典目录管理</title>
    <#include "/common/link.ftl">

</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <#include "/common/navbar.ftl">

    <#assign currentMenu="systemDictionary"/>

    <#include "/common/menu.ftl">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>字典目录管理</h1>
        </section>
        <section class="content">
            <div class="box">
                <!--高级查询--->
                <form class="form-inline" id="searchForm" action="/systemDictionary/list" method="post">
                    <input type="hidden" name="currentPage" id="currentPage" value="1">
                </form>
                <!--编写内容-->
                <div class="box-body table-responsive">
                    <table class="table table-hover table-bordered table-striped">
                        <thead>
                            <tr>
                                <th>编号</th>
                                <th>字典目录标题</th>
                                <th>字典目录编码</th>
                                <th>字典目录简介</th>
                            </tr>
                        </thead>
                        <tbody>
                        <#list pageInfo.list as systemdictionary>
                            <tr>
                                <td>${systemdictionary.id}</td>
                                <td>${systemdictionary.title}</td>
                                <td>${systemdictionary.sn}</td>
                                <td>${systemdictionary.intro}</td>
                            </tr>
                        </#list>

                        </tbody>
                    </table>
                    <#include "/common/page.ftl" >
                </div>
            </div>
        </section>
    </div>
<#--    <#include "/common/footer.ftl" >-->
</div>

</body>
</html>
