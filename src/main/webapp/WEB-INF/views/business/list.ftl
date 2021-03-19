<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>门店管理</title>
    <#include "/common/link.ftl">
</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <#include "/common/navbar.ftl">
    <!--菜单回显-->
    <#assign currentMenu="business"/>
    <#include "/common/menu.ftl">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>门店管理</h1>
        </section>
        <section class="content">
            <div class="box">
                <!--高级查询--->
                <div style="margin: 20px 0px 0px 10px">
                    <form class="form-inline" id="searchForm" action="/business/list" method="post">
                        <input type="hidden" name="currentPage" id="currentPage" value="1">
                        <div class="form-group">
                            <label for="name">门店名称：</label>
                            <input type="text" class="form-control" name="name" value="${qo.name}"
                                   placeholder="请输入门店名称">
                        </div>
                        <div class="form-group">
                            <label for="scope">经营范围：</label>
                            <input type="text" class="form-control" name="scope" value="${qo.scope}"
                                   placeholder="请输入经营范围">
                        </div>
                        <div class="form-group">
                            <label for="tel">门店联系方式：</label>
                            <input type="text" class="form-control" name="tel" value="${qo.tel}"
                                   placeholder="请输入门店联系方式">
                        </div>
                        <div class="form-group">
                            <label for="legalName">根据法人查询：</label>
                            <input type="text" class="form-control" name="legalName" value="${qo.legalName}"
                                   placeholder="请输入法人姓名">
                        </div>

                        <br/>
                        <br/>
                        <div class="form-group">
                            <label>经营日期查询：</label>
                            <input placeholder="请输入开始日期" type="text" name="startDate" value="${(qo.startDate?string("yyyy-MM-dd"))!}" class="form-control input-date"  /> -
                            <input placeholder="请输入结束日期" type="text" name="endDate" value="${(qo.endDate?string("yyyy-MM-dd"))!}" class="form-control input-date"  />
                        </div>

                        <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span> 查询</button>

                        <a href="/business/toInput" class="btn btn-success">
                            <span class="glyphicon glyphicon-plus"></span> 添加
                        </a>
                        <button type="reset" class="btn btn-primary" id="clear-btn"><span class="glyphicon glyphicon-record"></span> 重置</button>
                    </form>

                </div>
                <div class="box-body table-responsive">
                <table class="table table-hover table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>门店名称</th>
                        <th>门店电话</th>
                        <th>门店地址</th>
                        <th>经营时间</th>
                        <th>门店性质</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list pageInfo.list as business>
                        <tr>
                            <td>${business.id}</td>
                            <td>${business.name}</td>
                            <td>${business.tel}</td>
                            <td>${business.address}</td>
                            <td>${business.openDate?string("yyyy-MM-dd")}</td>
                            <td>${business.mainStore?string('总店','分店')}</td>
                            <td>
                                <a href="/business/saveOrUpdate?id=${business.id}" class="btn btn-info btn-xs">
                                    <span class="glyphicon glyphicon-pencil"></span> 编辑
                                </a>
                            </td>
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

</script>
