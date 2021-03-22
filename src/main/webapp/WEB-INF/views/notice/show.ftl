<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>公告通知管理</title>
    <#include "/common/link.ftl" >
</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <#include "/common/navbar.ftl" >
    <!--声明变量 用来做菜单回显-->
    <#assign currentMenu="notice"/>
    <#include "/common/menu.ftl" >
    <div class="content-wrapper">
        <section class="content-header">
            <h1>公告查看</h1>
        </section>
        <section class="content">
            <div class="box box-primary">
                <div class="box-header with-border">
                    <div class="user-block">
                        <img class="img-circle" src="../../../static/js/adminlte/img/user2-160x160.jpg" alt="User Image">
                        <span class="username"><a >${notice.createPeople.name}</a></span>
                        <span class="description">${(notice.createTime?string("yyyy-MM-dd"))!}</span>
                    </div>
                    <div class="box-tools">
                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                        <button type="button" class="btn btn-box-tool" onclick="javascript:window.location.href='/notice/list';" ><i class="fa fa-times"></i></button>
                    </div>
                    <br>
                    <div class="timeline-item">
                        <span class="time"><i class="fa fa-clock-o"></i> 公告级别 ：${notice.levelName}</span>
                    </div>
                </div>
                <div class="box-body no-padding">
                    <div class="mailbox-read-message" style="height: 500px" >
                        ${notice.content}
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>


</body>
</html>
