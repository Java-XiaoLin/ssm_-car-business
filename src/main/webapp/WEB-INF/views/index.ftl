<!DOCTYPE html>
<html>
<head>
  <link href="/static/login/css/bootstrap.min.css" type="text/css" rel="stylesheet">
  <link href="/static/login/font/css/font-awesome.min.css" type="text/javascript" rel="stylesheet">
  <link href="/static/login/css/bootsnav.css" type="text/css" rel="stylesheet">
  <link href="/static/login/css/normalize.css" type="text/css" rel="stylesheet">
  <link href="/static/login/css/css.css" rel="stylesheet" type="text/css">
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>叩丁狼互联网商户平台</title>
  <#include "/common/link.ftl"/>
  <link rel="stylesheet" href="../../static/css/index_css.css">
  <script src="/static/login/js/jquery.js" type="text/javascript"></script>
</head>
<body>
<div class="nav">
  <div class="nav-div">
    <div class="row justify-content-between" >
      <div class="col-md-4 border-right" style="padding: 0px;" >
        <h4>互联网汽车服务平台</h4>
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
      <div class="col-md-1" style="margin-right: 100px;padding: 20px;">
        <button class="btn btn-primary-full" type="button" id="btn-appointment">
          马上预约
        </button>
      </div>

      <div class="col-md-4 tel"  >
        <h2 style="vertical-align:middle;"><i class="fa fa-phone"></i></h2>
        <h5 style="color:#434343; ">全国免费热线:</h5>
        <h2 >020-85628002</h2>
      </div>
    </div>
  </div>

</div>
<div class="body">
  <div class="banner">
    <img src="../../static/img/system/banner.png" />
  </div>
</div>
<div class="footer">
  <div class="row">
    <div class="col-sm-4">
      <div class="position-relative p-3 bg-white " style="height: 200px">
        <blockquote><strong>店铺信息</strong></blockquote>
        <small style="line-height:30px">BUSINESS INFORMATION</small>
        <p class="text-muted">
          深圳狼途汽车服务有限公司成立于2011年 ，是“深圳狼途汽车用品发展有限公司”旗下以发展汽车美容连锁加盟店业务为主的子公司，公司定位于“连锁运营顾问，汽车服务专家”。立志于以“4S店标准”打造全国统一的养车连锁服务平台！
        </p>
      </div>
    </div>
    <div class="col-sm-4 ">
      <div class="position-relative p-3 bg-white " style="height: 200px">
        <blockquote><strong>服务与支持</strong></blockquote>
        <small style="line-height:30px">SERVICE AND SUPPORT</small>
        <p class="text-muted">“店面营建”板块主要介绍在投资加盟者建店过程中，车仆提供的具体支持服务。从市场调研、店面选址、规划指导、店面设计、装修指导，车仆运营部的团队成员们将全程服务！我们将为各位投资者指引如何成功打造一家汽车美容店的具体流程。我们的用心，您感受得到！</p>
      </div>
    </div>
    <div class="col-sm-4 ">
      <div class="position-relative p-3 bg-white" style="height: 200px">
        <blockquote><strong>联系我们</strong></blockquote>
        <small style="line-height:30px">CONCAT US</small>
        <h5 class="text-muted" ><strong style="font-size: 17px">联系电话：</strong>020-85628002</h5>
        <h5 class="text-muted" ><strong style="font-size: 17px">联系地址：</strong>广州市天河区棠下涌东路大地工业园D栋603</h5>
      </div>
    </div>
  </div>

</div>

<!-- Modal -->



<div class="modal fade" id="appointmentModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog " style="max-width: 380px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <h4 class="modal-title" >请输入预约信息</h4>
      </div>
      <form id="appointmentForm" method="post" action="/appointment/save">
        <div class="modal-body">
          <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-user"></i> </span>
            <input  class="form-control" placeholder="请输入您的姓名">
          </div>
          <br/>
          <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-phone"></i></span>
            <input id="phone" class="form-control input_phone" placeholder="请输入您的电话" style="width: 180px;height: 50px">
            <div class="col-lg-4 col-md-4 col-xs-4 fl" style="height: 2px"><input type="button" id="btn" class="btn_mfyzm" value="获取激活码"  onclick="Sendpwd(this)"/></div>
          </div>

          <br/>
          <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-key"></i></span>
            <input id="code" class="form-control " placeholder="请输入您的验证码" >
          </div>
          <br/>
          <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-home"></i></span>
            <select class="form-control" placeholder="请选择预约门店">
              <option value="">请选择预约门店</option>
              <option value="1">叩丁狼互联网汽车服务平台</option>
              <option value="1">叩丁狼互联网汽车服务平台</option>
              <option value="1">叩丁狼互联网汽车服务平台</option>
              <option value="1">叩丁狼互联网汽车服务平台</option>
            </select>
          </div>
          <br/>
          <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-tag"></i></span>
            <select class="form-control"  placeholder="请选择预约业务">
              <option value="">请选择预约业务</option>
              <option value="1">售卖</option>
              <option value="2">保养</option>
              <option value="3">修理</option>
              <option value="4">美容</option>
              <option value="5">配件</option>
              <option value="6">订货</option>
              <option value="7">售后</option>
            </select>
          </div>
          <br/>
          <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
            <input  class="form-control"  placeholder="请选择预约时间">
          </div>
          <br/>
          <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-bookmark"></i></span>
            <textarea  class="form-control" placeholder="备注说明"></textarea>
          </div>
        </div>
        <div class="tishi"></div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-primary-full">确定预约</button>
        </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>
<script>
  $(function (){

    $("#btn-appointment").click(function (){
      $("#appointmentModal").modal("show");
    })
    $("#btn").click(function (){
      let phoneNum =  $.trim($(".input_phone").val());
      let phoneRegular =/^(13[0-9]|14[5|7]|15[0|1|2|3|4|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}/;
      if ($.trim(phoneNum) === "") {
        Tip('请填写电话！');
        $("#phone").focus();
        return;
      }if(!phoneRegular.exec(phoneNum)){
        Tip('电话输入格式不正确,请重新输入');
        $("#phone").focus();
        return;
      }else {
       $.ajax({
         data:{"phone":phoneNum},
         url:"/fronted/sendMessage",
         success:function (result){
           if (result.success){
              let code = $.trim($("#code").val());
              if ($.trim(code) === ""){
                Tip('请填写激活码');
              }
              if (result.data != code){
                Tip('激活码错误');
                $("#code").focus();
              }
           }
         }
       })
      }

    })
  })

</script>
