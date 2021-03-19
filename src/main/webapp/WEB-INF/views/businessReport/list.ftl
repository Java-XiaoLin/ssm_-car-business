<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>门店收入报表</title>
    <#include "/common/link.ftl" >

</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <#include "/common/navbar.ftl" >

    <#assign currentMenu="businessReport"/>

    <#include "/common/menu.ftl" >
    <div class="content-wrapper">
        <section class="content-header">
            <h1>门店收入报表</h1>
        </section>
        <section class="content">
            <div class="box">
                <div style="margin: 10px;">
                    <!--高级查询--->
                    <form class="form-inline" id="searchForm" action="/consumptionReport/list" method="post">
                        <input type="hidden" name="currentPage" id="currentPage" value="1">
                        <div class="form-group">
                            <label>门店查询</label>
                            <select class="form-control"  name="businessId">
                                <option value="">全部</option>
                                <#list AllbusinessList as business>
                                  <option value="${business.id}">${business.name}</option>
                                </#list>
                            </select>
                            <script>
                                $("[name=businessId]").val(${qo.businessId});
                            </script>
                        </div>
                        <div class="form-group">
                            <label>时间段查询:</label>
                            <div class="input-daterange input-group" >
                                <input type="text" name="startDate" value="${(qo.getStartDate()?string("yyyy-MM-dd"))!}" class="input-sm form-control input-date"/>
                                <span class="input-group-addon">到</span>
                                <input type="text" name="endDate" value="${(qo.getEndDate()?string("yyyy-MM-dd"))!}" class="input-sm form-control input-date"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label>预约类型</label>
                            <select class="form-control" name="typeId">
                                <option value="">请选择预约类型</option>
                                <option value="1">预约</option>
                                <option value="0">非预约</option>
                            </select>
                        </div>
                        <script>
                            $("[name=typeId]").val(${qo.typeId})
                        </script>

                        <div class="form-group">
                            <label for="status">分组类型:</label>
                            <select class="form-control" name="groupByName">
                                <#list groupByItems as item>
                                    <option value="${item.name()}">${item.getName()}</option>
                                </#list>
                            </select>
                            <script>
                                $("[name=groupByName]").val('${qo.groupByName}');
                            </script>
                        </div>

                        <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span> 查询</button>
                        <button type="button" class="btn btn-info btn-chart" >
                            <span class="glyphicon glyphicon-stats " ></span> 柱状图
                        </button>
                    </form>
                </div>
                <div class="box-body table-responsive no-padding ">
                    <table class="table table-hover table-bordered">
                        <thead>
                            <tr>
                                <th>分组类型</th>
                                <th>总订单数</th>
                                <th>总消费金额</th>
                                <th>总实收金额</th>
                                <th>总优惠金额</th>
                            </tr>
                        </thead>
                        <tbody>
                        <#list pageInfo.list as businessReport>
                            <tr>
                                <td>${businessReport.groupByName}</td>
                                <td>${businessReport.count}</td>
                                <td>${businessReport.totalAmount}</td>
                                <td>${businessReport.totalDiscountAmount}</td>
                                <td>${businessReport.totalPayAmount}</td>
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

<!-- Modal模态框 -->
<div class="modal fade" id="chartModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content" style="padding: 20px">

        </div>
    </div>
</div>

</body>
</html>
<script>
    $(".btn-chart").click(function(){
        window.open("/consumptionReport/echart?"+$("#searchForm").serialize());
    });
</script>