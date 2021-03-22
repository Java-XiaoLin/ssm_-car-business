<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>投票结果查看</title>
    <#include "/common/link.ftl">

</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <#include "/common/navbar.ftl">
    <#assign currentMenu="activity"/>
    <#include "/common/menu.ftl">
  <div class="content-wrapper">
    <section class="content-header">
      <h1>投票结果查看</h1>
    </section>
    <section class="content">
      <div class="box" style="padding: 10px">
        <div class="row">

          <div class="col-md-offset-4 col-md-8">
            <h1>${activityResult.title}</h1>
          </div>
          <div class="col-md-12">
            <div class="panel panel-default container">
              <div class="panel-body">
                <div class="row">
                    <#assign index = 1>
                    <#list activityItemResult as activityItem>
                  <div class="col-md-2">
                    <div class="radio">
                        ${index}${activityItem.content}
                        <#assign index = index+1>
                    </div>
                  </div>
                  <div class="col-md-3">
                    <div class="progress" style="margin: 10px;">
                      <div class="progress-bar progress-bar-green" role="progressbar"
                           style="width: 40%">
                      </div>
                    </div>
                  </div>
                  <div class="col-md-2" style="margin: 10px;">${activityItem.num}</div>
                </div>
                  </#list>

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
