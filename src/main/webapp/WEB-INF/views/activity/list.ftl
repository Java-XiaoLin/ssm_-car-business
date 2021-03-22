<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>投票活动列表</title>
    <#include "/common/link.ftl">

</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <#include "/common/navbar.ftl">

    <#assign currentMenu="activity"/>

    <#include "/common/menu.ftl">
  <div class="content-wrapper">
    <section class="content-header">
      <h1>投票活动列表</h1>
    </section>
    <section class="content">
      <div class="box">
        <!--高级查询--->
        <form class="form-inline" id="searchForm" action="/xxxx/list" method="post"
              style="margin-top: 20px">
          <input type="hidden" name="currentPage" id="currentPage" value="1">
        </form>
        <!--编写内容-->
        <div class="box-body table-responsive">
          <table class="table table-hover table-bordered table-striped">
            <thead>
            <tr>
              <th>编号</th>
              <th>投票主题</th>
              <th>投票类型</th>
              <th>投票状态</th>
              <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <#list pageInfo.list as activity>
              <tr>
                <td>${activity.id}</td>
                <td>${activity.title}</td>
                <td>${activity.typeName}</td>
                  <#if activity.status >
                    <td>投票中</td>
                    <td>
                      <a href="/activityItem/vote?activityId=${activity.id}"
                         class="btn btn-info btn-xs btn-input">
                        <span class="glyphicon glyphicon-arrow-right"></span> 投票
                      </a>
                    </td>
                  </#if>
                  <#if !activity.status>
                    <td>已结束</td>
                    <td>
                      <a class="btn btn-info btn-xs btn-input"
                         href="/activity/result?activityId=${activity.id}">
                        <span class="glyphicon glyphicon-lock"></span>查看结果
                      </a>
                    </td>
                  </#if>
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

</body>
</html>
