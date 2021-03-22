<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>狼途汽车互联网商户平台</title>
    <#include "/common/link.ftl"/>
  <link rel="stylesheet" href="../../../static/css/index_css.css">
</head>
<body>
<div class="nav">
  <div class="nav-div">
    <div class="row justify-content-between">
      <div class="col-md-4 border-right" style="padding: 0px;">
        <h4>狼途汽车服务平台</h4>
        <h5 style="color:#434343;font-size: 18px">连锁运营顾问 / 高级服务专家</h5>
      </div>
      <div class="col-md-3 category" style="padding-left: 30px">
        <button class="btn btn-primary-cus ">售卖</button>
        <button class="btn btn-primary-cus ">保养</button>
        <button class="btn btn-primary-cus ">修理</button>
        <button class="btn btn-primary-cus ">美容</button>
        <button class="btn btn-primary-cus ">配件</button>
        <button class="btn btn-primary-cus ">售后</button>
      </div>
      <div class="col-md-1" style="text-align: center;padding: 20px;">
        <button class="btn btn-primary-full" type="button" id="btn-appointment">
          马上预约
        </button>

      </div>
      <div class="col-md-4 tel" style="padding: 15px;">
        <h2 style="vertical-align:middle;"><i class="fa fa-phone"></i></h2>
        <h5 style="color:#434343; ">全国免费热线:</h5>
        <h2>020-85628002</h2>
      </div>
    </div>
  </div>

</div>

<h1 style="text-align: center">
  狼途留言详情页
</h1>
<div class="container">
  <div class="box box-widget">
      <#list messageBoardInfo as messageInfo>
    <div class="box-header with-border">
      <div class="user-block">
        <img class="img-circle" src="../../../static/js/adminlte/img/user2-160x160.jpg"
             alt="User Image">
        <span class="username"><a href="#">${messageInfo.nickname}</a></span>
        <span
            class="description">${(messageInfo.createTime?string("yyyy-MM-dd"))!} <span>咨询类型：</span><span>${messageInfo.category.title}</span>-<span>${messageInfo.categoryItem.title}</span></span>
      </div>
    </div>
    <div class="box-body">
      <p>${messageInfo.content}</p>
      <span class="pull-right text-muted">${messageInfo.num}条回复</span>
    </div>
      <#list messageInfo.messageReply as messageReply>
        <div class="box-footer box-comments">
          <div class="box-comment">
            <img class="img-circle img-sm" src="../../../static/js/adminlte/img/user2-160x160.jpg"
                 alt="User Image">
            <div class="comment-text">
              <span class="username">${messageReply.replyUser.name}<span
                    class="text-muted pull-right">${(messageReply.createTime?string("yyyy-MM-dd"))!}</span></span>
              <p>${messageReply.content}</p>
            </div>
          </div>
        </div>
      </#list>
  </div>
    </#list>


</div>

</body>
</html>
