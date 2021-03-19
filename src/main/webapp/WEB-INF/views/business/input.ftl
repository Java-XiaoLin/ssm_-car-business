<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="../../../static/css/simplelightbox.min.css">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>门店管理</title>
    <#include "/common/link.ftl">
    <script src="../../../static/js/simple-lightbox.min.js"></script>

</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <#include "/common/navbar.ftl">
    <!--菜单回显-->
    <#assign currentMenu="business"/>
    <#include "/common/menu.ftl">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>门店编辑</h1>
        </section>
        <section class="content">
            <div class="box">
                <form class="box-body" style="margin: 10px" class="form-horizontal" id="editForm" action="/business/updateAndSave"  enctype="multipart/form-data" method="post" >
                    <input type="hidden" name="id" value="${business.id}">
                    <input type="hidden" name="licenseImg" value="${business.licenseImg}">
                    <div class="row">
                        <div class="col-md-5">
                            <div class="form-group">
                                <label>门店名称：</label>
                                <input type="text" class="form-control" name="name"
                                       placeholder="请输入门店名称" value="${business.name}">
                            </div>
                            <div class="form-group">
                                <label >门店电话：</label>
                                <input type="text" class="form-control" name="tel"
                                       placeholder="请输入门店电话" value="${business.tel}">
                            </div>
                        </div>
                        <div class="col-md-5">
                            <div class="form-group">
                                <label>门店地址：</label>
                                <input type="text" class="form-control" name="address"
                                       placeholder="请输入门店地址" value="${business.address}">
                            </div>
                            <div class="form-group">
                                <label>经营日期：</label>
                                <input type="text" class="form-control input-date"  placeholder="请输入经营日期" name="openDate" value="${(business.openDate?string("yyyy-MM-dd"))!}"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-10">
                            <label>门店介绍：</label>
                            <textarea class="form-control" rows="4" placeholder="请输入门店介绍" name="intro">${business.intro}</textarea>
                        </div>
                    </div>
					 <div class="row">
                        <div class="form-group col-md-10">
                            <label>经营范围：</label>
                            <textarea class="form-control"  rows="4" placeholder="请输入经营范围"
                                      name="scope">${business.scope}</textarea>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-5">
                            <div class="form-group">
                                <label>法人姓名：</label>
                                <input type="text"  name="legalName" class="form-control" placeholder="请输入法人姓名" value="${business.legalName}">
                            </div>
                            <div class="form-group">
                                <label>法人电话：</label>
                                <input type="text" class="form-control" name="legalTel" placeholder="请输入法人电话" value="${business.legalTel}">
                            </div>
                            <div class="form-group">
                                <label>上传营业执照：</label>
                                <#if business.licenseImg != null>
                                    <a class="btn" target="_blank" id="licenseImg" href="${business.licenseImg}">
                                        <i class="fa fa-user"></i> 查看附件
                                    </a>
                                </#if>
                                <input type="file" class="form-control" name="file">
                            </div>
                        </div>
                        <div class="col-md-5">
                            <div class="form-group">
                                <label>法人身份证：</label>
                                <input type="text" class="form-control" name="legalIdcard"
                                       placeholder="请输入法人身份证" value="${business.legalIdcard}">
                            </div>
                            <div class="form-group">
                                <label>营业执照号码：</label>
                                <input type="text" class="form-control" name="licenseNumber"
                                       placeholder="请输入营业执照号码" value="${business.licenseNumber}">
                            </div>
                            <div class="form-group">
                                <label >门店性质：</label>
                                <select class="form-control" id="store" name="mainStore">
                                    <option value="0">分店</option>
                                    <option value="1">总店</option>
                                </select>
                            </div>
                        </div>
                        <script>
                            $("#store").val(${((business.mainStore)?string('1','0'))!})
                        </script>

                    </div>
                    <div>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary btn-submit">保存</button>
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
        $("#licenseImg").simpleLightbox();
    })
</script>
