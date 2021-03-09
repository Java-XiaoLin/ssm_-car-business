
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>叩丁狼客户管理系统</title>
    <#-- 使用相对当前模板文件的路径 再去找另一个模板文件 -->
    <#include "/common/link.ftl">
</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <#include "/common/navbar.ftl">
    <#include "/common/menu.ftl">

    <div class="content-wrapper">

        <!-- Main content -->
        <section class="content">

            <div class="error-page">
                <h2 class="headline text-yellow"></h2>

                <div class="error-content">
                    <h3><i class="fa fa-warning text-yellow"></i> 您没有足够的权限访问该页面 </h3>
                    <p>
                        若要继续访问 ，请联系管理员开通 ，联系方式 ：020-85628002
                    </p>


                </div>
            </div>
            <!-- /.error-page -->

        </section>
        <!-- /.content -->
    </div>
    <#include "/common/footer.ftl" >
</div>
</body>
</html>
