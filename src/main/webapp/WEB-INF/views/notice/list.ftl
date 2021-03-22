<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>公告通知管理</title>
    <#include "/common/link.ftl">
</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <#include "/common/navbar.ftl">
  <!--菜单回显-->
    <#assign currentMenu="notice"/>
    <#include "/common/menu.ftl">
  <div class="content-wrapper">
    <section class="content-header">
      <h1>公告通知管理</h1>
    </section>
    <section class="content">
      <div class="box">
        <!--高级查询--->
        <div style="margin: 20px 0px 0px 10px">
          <form class="form-inline" id="searchForm" action="/notice/list" method="post">
            <input type="hidden" name="currentPage" id="currentPage" value="1">

            <div class="form-group">
              <label>公告级别：</label>
              <select class="form-control" name="level">
                <option value="">全部</option>
                <option value="1">紧急</option>
                <option value="2">重要</option>
                <option value="3">普通</option>
              </select>
            </div>
            <div class="form-group">
              <label>阅读状态：</label>
              <select class="form-control" name="read">
                <option value="">全部</option>
                <option value="0">未读</option>
                <option value="1">已读</option>
              </select>
            </div>

            <button type="submit" class="btn btn-primary"><span
                  class="glyphicon glyphicon-search"></span> 查询
            </button>
              <#if Session["EMPLOYEE_IN_SESSION"].admin == true>
                <a href="#" class="btn btn-success btn-input">
                  <span class="glyphicon glyphicon-plus"></span> 添加
                </a>
              </#if>
          </form>

        </div>
        <div class="box-body table-responsive">
          <table class="table table-hover table-bordered table-striped">
            <thead>
            <tr>
              <th>编号</th>
              <th>公告标题</th>
              <th>创建人</th>
              <th>创建时间</th>
              <th>公告级别</th>
              <th>是否已读</th>
              <th>发布状态</th>
              <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <#list pageInfo.list as notice>
              <tr>
                <td>${notice.id}</td>
                <td>${notice.title}</td>
                <td>${notice.createPeople.name}</td>
                <td>${(notice.createTime?string("yyyy-MM-dd HH:mm:ss"))!}</td>
                <td>${notice.levelName}</td>
                  <#if  notice.notices.read == false>
                    <td><span style="color:red">未读</span></td>
                  </#if>
                  <#if  notice.notices.read == true>
                    <td><span style="color:green">已读</span></td>
                  </#if>
                <td>${notice.statusName}</td>
                <td>
                    <#if notice.status ==1>
                      <a class="btn btn-success btn-xs  btn-show" data-nid='${notice.id}'
                         data-eid='${Session["EMPLOYEE_IN_SESSION"].id}'>
                        <span class="glyphicon glyphicon-phone-alt"></span> 查看
                      </a>
                    </#if>
                    <#if Session["EMPLOYEE_IN_SESSION"].admin == true>
                      <a class="btn btn-primary btn-xs btn-edit" data-json='${notice}'>
                        <span class="glyphicon glyphicon-pencil"></span> 编辑
                      </a>
                        <#if notice.status == 2 >
                          <a class="btn btn-xs btn-info btn-push" data-id='${notice.id}'>
                            <span class="glyphicon glyphicon-share"></span> 发布
                          </a>
                        </#if>
                        <#if notice.status != 2 >
                          <a class="btn btn-xs btn-danger btn-remove" data-id="${notice.id}">
                            <span class="glyphicon glyphicon-remove"></span> 取消</a>
                        </#if>
                        ${Session.user.userName}
                    </#if>
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

<!--模态框-->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" id="myModalLabel">新增/编辑</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
              aria-hidden="true">&times;</span>
        </button>
      </div>

      <form id="editForm" action="/notice/saveOrUpdate" method="post">
        <div class="modal-body">
          <input type="hidden" name="id">
          <div class="form-group row">
            <label class="col-sm-3 col-form-label">公告标题：</label>
            <div class="col-sm-7">
              <input type="text" class="form-control" name="title" placeholder="请输入公告标题"/>
            </div>
          </div>
          <div class="form-group row">
            <label class="col-sm-3 col-form-label">公告内容：</label>
            <div class="col-sm-7">
                            <textarea type="text" class="form-control" rows="8" name="content"
                                      placeholder="请输入公告内容"></textarea>
            </div>
          </div>

          <div class="form-group row">
            <label class="col-sm-3 col-form-label">公告级别：</label>
            <div class="col-sm-7">
              <select class="form-control" name="level">
                <option value="">请选择级别</option>
                <option value="1">紧急</option>
                <option value="2">重要</option>
                <option value="3">普通</option>
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


  $(".btn-edit").click(function () {
    let notice = $(this).data("json");
    $("input[name=id]").val(notice.id)
    $("input[name=title]").val(notice.title)
    $("textarea[name=content]").val(notice.content)
    $("select[name=level]").val(notice.level)
    $("#editModal").modal('show')
  })

  $(".btn-push").click(function () {
    let noticeId = $(this).data("id");
    $.ajax({
      data: {"noticeId": noticeId},
      url: "/notice/publish",
      success: function (result) {
        if (result.success) {
          window.location.reload();
        }
      }
    })
  })

  $(".btn-remove").click(function () {
    let noticeId = $(this).data("id");
    $.ajax({
      data: {"noticeId": noticeId},
      url: "/notice/cancel",
      success: function (result) {
        if (result.success) {
          window.location.reload();
        }
      }
    })
  })

  $(".btn-show").click(function () {
    let noticeId = $(this).data("nid")
    window.location.href = "/notice/toShow?noticeId=" + noticeId;
  })
</script>