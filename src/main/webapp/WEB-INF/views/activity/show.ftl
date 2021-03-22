<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>投票页面</title>
    <#include "/common/link.ftl">

</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <#include "/common/navbar.ftl">
    <#assign currentMenu="activity"/>
    <#include "/common/menu.ftl">
  <div class="content-wrapper">
    <section class="content-header">
      <h1>投票页面</h1>
    </section>
    <section class="content">
      <div class="box" style="padding: 10px">
        <div class="row">

          <div class="col-md-offset-4 col-md-8">
            <h1>${title}</h1>
          </div>
          <div class="col-md-12">
            <div class="panel panel-default container">
              <div class="panel-body">
                <form id="editForm" action="/xxxxx" method="post">
                    <#assign index=1 >
                    <#list ActivityItem as activityItem>
                      <div class="row">
                        <div class="col-md-2">
                          <div class="radio">
                            <label>
                              <input hidden="hidden" class="activityId"
                                     value="#{activityItem.activityId}">
                              <input type="radio" name="activityItemId" value="${activityItem.id}">
                                ${index}、${activityItem.content}
                            </label>
                          </div>
                            <#assign index = index+1>
                        </div>
                      </div>
                    </#list>
                  <button type="button" onclick="vote()" class="btn btn-primary btn-submit">
                    提交
                  </button>
                </form>
              </div>

            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</div>
</body>
</html>
<script>

  function vote() {
    let activityId = $(".activityId").val();
    // 拿到所选择的id
    let activityItemId = $("input[name='activityItemId']:checked").val();
    $.ajax({
      data: {"activityItemId": activityItemId, "activityId": activityId},
      url: "/activityItem/employeeVote",
      success: function (reult) {
        if (reult.success) {
          window.location.href = "/activity/list"
        } else {
          alert(reult.msg)
          setTimeout(function () {
            window.location.href = "/activity/list"
          }, 500);

        }
      }
    })

  }


</script>
