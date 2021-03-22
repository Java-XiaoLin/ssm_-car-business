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
  狼途留言列表页
  <a href="#" class="btn btn-success btn-input" style="margin: 10px">
    <span class="glyphicon glyphicon-plus"></span> 我要留言
  </a>
  <!--高级查询--->
  <form class="form-inline" id="searchForm" action="/xxxxx" method="post">
    <input type="hidden" name="currentPage" id="currentPage" value="1">
  </form>
</h1>
<div class="container">
    <#list pageInfo.list as messageBoard>
      <div class="box-header with-border">
        <div class="user-block">
          <img class="img-circle" src="../../../static/js/adminlte/img/user2-160x160.jpg"
               alt="User Image">
          <span class="username"><a href="#">${messageBoard.nickname}</a></span>
          <span
              class="description">${(messageBoard.createTime?string("yyyy-MM-dd"))!}<span>咨询类型：</span><span>${messageBoard.category.title}</span>-<span>${messageBoard.categoryItem.title}</span></span>
        </div>
      </div>

      <div class="box-body">
        <p>${messageBoard.content}</p>
          <#if messageBoard.replyStatus == true >
            <span class="pull-right text-muted"
                  style="color: green">${messageBoard.num}条回复</span>
            <a href="/message/messageForBoardId?messageBoardId=${messageBoard.id}">查看详情</a>
          </#if>
          <#if messageBoard.replyStatus == false>
            <span class="pull-right text-muted"
                  style="color: red">未回复</span>
          </#if>
      </div>
    </#list>


  <!--分页-->
    <#include "/common/page.ftl" >
</div>

<!-- Modal -->
<div class="modal fade" id="messageModal" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog " style="max-width: 380px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <h4 class="modal-title">请输入留言信息</h4>
      </div>
      <form id="appointmentForm" method="post" action="/xxxx">
        <div class="modal-body">
          <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-user"></i> </span>
            <input class="form-control" placeholder="请输入您的昵称">
          </div>
          <br/>
          <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-home"></i></span>
            <select class="form-control">
              <option value="">请选择所属业务大类</option>
              <option value="1">售卖</option>
              <option value="2">保养</option>
              <option value="3">修理</option>
              <option value="4">美容</option>
            </select>
          </div>
          <br/>
          <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-tag"></i></span>
            <select class="form-control">
              <option value="">请选择所属业务小类</option>
              <option value="1">新车</option>
              <option value="1">二手车</option>
            </select>
          </div>
          <br/>
          <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-bookmark"></i></span>
            <textarea class="form-control" placeholder="请输入您的留言内容"></textarea>
          </div>
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-primary-full">确定留言</button>
        </div>
      </form>
    </div>
  </div>
</div>


</body>
</html>
