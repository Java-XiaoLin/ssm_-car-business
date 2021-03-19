<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>结算单明细管理</title>
    <#include "/common/link.ftl">

</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <#include "/common/navbar.ftl">
    <!--菜单回显-->
    <#assign currentMenu="consumption"/>
    <#include "/common/menu.ftl">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>结算单明细</h1>
        </section>
        <section class="content">
            <div class="box" style="padding: 10px;">
                <div class="box" style="border-top: none;">
                    <div class="box-header with-border">
                        <h3 class="box-title"><span class="glyphicon glyphicon-triangle-right"></span> 结算单明细</h3>
                    </div>
                    <div class="box-body no-padding">
                        <div class="mailbox-controls">
                            <div class="btn-group">
                                <#-- 新增 -->
                                <button type="button" class="btn btn-default btn-sm checkbox-toggle btn-input"><i class="fa fa-plus"></i></button>
                                <#-- 删除 -->
                                <button type="button" class="btn btn-default btn-sm" id="deleteBtn"><i class="fa fa-trash-o"></i></button>
                            </div>
                        </div>
                        <div class="table-responsive mailbox-messages">
                            <table class="table table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th><input type="checkbox" id="checkAll"></th>
                                        <th>业务大类</th>
                                        <th>业务小类</th>
                                        <th>结算类型</th>
                                        <th>消费金额(元)</th>
                                        <th>优惠金额(元)</th>
                                        <th>实收金额(元)</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <#list consumptionItems as consumptionitem>
                                    <tr>
                                        <td><input type="checkbox" class="check" value="${consumptionitem.id}"></td>
                                        <td>${consumptionitem.category.title}</td>
                                        <td>${consumptionitem.categoryItem.title}</td>
                                        <td>${consumptionitem.payType.title}</td>
                                        <td>${consumptionitem.amount}</td>
                                        <td>${consumptionitem.discountAmount}</td>
                                        <td>${consumptionitem.payAmount}</td>
                                    </tr>
                                </#list>

                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th>总消费金额:${AllAmount}元</th>
                                        <th>总优惠金额:${DiscountAmount}元</th>
                                        <th>总实收金额:${PayAmount}元</th>
                                    </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
                <br/>
				    <div class="box"  style="border-top: none;">
                    <div class="box-header with-border">
                        <h3 class="box-title"><span class="glyphicon glyphicon-triangle-right"></span> 结算单信息</h3>
                    </div>
                    <form class="box-body" class="form-horizontal" id="editForm" action="/consumption/saveOrUpdate" method="post" >
                        <input type="hidden" name="id" value="${consumption.id}" >
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>客户名称：</label>
                                    <input type="text" name="customerName" value="${consumption.customerName}" class="form-control" placeholder="请输入客户名称">
                                </div>
                                <div class="form-group">
                                    <label>客户电话：</label>
                                    <input type="text" class="form-control" name="customerTel" value="${consumption.customerTel}" placeholder="请输入客户电话">
                                </div>
                                <div class="form-group">
                                    <label>消费门店：</label>
                                    <select class="form-control" name="business.id">
                                        <option value="" id="businessItem">请选择门店</option>
                                        <#list businesses as business>
                                          <option value="${business.id}">${business.name}</option>
                                        </#list>
                                    </select>
                                    <script>
                                        $("select[name='business.id']").val(${consumption.business.id})
                                    </script>
                                </div>
                                <div class="form-group">
                                    <label>进店时间：</label>
                                    <input type="text" class="form-control input-dateTime" name="checkinTime" value="${(consumption.checkinTime?string('yyyy-MM-dd HH:mm'))!}">
                                </div>
                                <div class="form-group">
                                    <label>离店时间：</label>
                                    <input type="text" class="form-control input-dateTime" name="checkoutTime" value="${(consumption.checkoutTime?string('yyyy-MM-dd HH:mm'))!}">
                                </div>
                                <div class="form-group">
                                    <label>车牌记录：</label>
                                    <input type="text" class="form-control" placeholder="请输入车牌记录" name="carLicence" value="${consumption.carLicence}">
                                </div>
                                <div class="form-group">
                                    <label>车型记录：</label>
                                    <input type="text" class="form-control" placeholder="请输入车型记录" name="carType" value="${consumption.carType}">
                                </div>

                                <div class="form-group">
                                    <label>结算单备注：</label>
                                    <textarea class="form-control"  rows="4" name="info"
                                              placeholder="请输入结算单备注">${consumption.info}</textarea>
                                </div>
                                <div class="form-group">
                                    <label>结算单状态：</label>
                                    <input type="text" class="form-control"  readonly value="${consumption.statusName}">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>总消费金额(元)：</label>
                                    <input type="text" class="form-control" placeholder="请输入总消费金额" name="totalAmount" value="${(AllAmount)!}">
                                </div>
                                <div class="form-group">
                                    <label>优惠金额(元)：</label>
                                    <input type="text" class="form-control" placeholder="请输入优惠金额" name="discountAmount" value="${(DiscountAmount)!}">
                                </div>
                                <div class="form-group">
                                    <label>实收金额(元)：</label>
                                    <input type="text" class="form-control" placeholder="请输入实收金额" name="payAmount" value="${(PayAmount)}">
                                </div>
                                    <div class="form-group">
                                        <label>结算单流水号：</label>
                                        <input type="text" class="form-control" readonly  value="${consumption.cno}">
                                    </div>
                                    <div class="form-group">
                                        <label>关联预约单流水号：</label>
                                        <input type="text" class="form-control" readonly  value="${consumption.appointmentAno}">
                                    </div>
                                    <div class="form-group">
                                        <label>创建时间：</label>
                                        <input type="text" class="form-control" readonly  value="${(consumption.createTime?string('yyyy-MM-dd HH:mm:ss'))!}">
                                    </div>
                                    <div class="form-group">
                                        <label>结算时间：</label>
                                        <input type="text" readonly class="form-control" readonly  value="${(consumption.payTime?string('yyyy-MM-dd HH:mm:ss'))!}"/>
                                    </div>
                                    <div class="form-group">
                                        <label>结算人：</label>
                                        <input type="text" class="form-control" readonly  value="${consumption.payeeEmployee.name}">
                                    </div>
                                    <div class="form-group">
                                        <label>审核时间：</label>
                                        <input type="text" class="form-control" readonly  value="${(consumption.auditTime?string('yyyy-MM-dd HH:mm:ss'))!}">
                                    </div>
                                    <div class="form-group">
                                        <label>审核人：</label>
                                        <input type="text" class="form-control" readonly  value="${consumption.auditorEmployee.name}">
                                    </div>
                            </div>
                        </div>

                        <div class="pull-right">
                            <button type="submit" class="btn btn-primary btn-submit" id="save-btn"><span class="glyphicon glyphicon-book"></span> 保存</button>
                            <button type="button" class="btn btn-warning btn-consume" id="settle-btn"><span class="glyphicon glyphicon-yen"></span> 结算</button>
                            <button type="button" class="btn btn-success btn-audit" id="btn-audit"><span class="glyphicon glyphicon-flag"></span> 审核</button>
							<button type="button" class="btn btn-danger btn-delete"><span class="glyphicon glyphicon-trash"></span> 删除</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">后退</button>
                        </div>

                    </form>
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
                <h4 class="modal-title" id="myModalLabel">新增结算明细</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form id="consumptionItemForm" action="/consumptionItem/saveConsumptionItem?consumptionId=${consumption.id}" method="post" >
                <#-- 结算单流水号 -->
                <input type="hidden" name="cno" value="${consumption.cno}">
                <div class="modal-body">
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label">业务大类：</label>
                        <div class="col-sm-7">
                            <select class="form-control" id="category" name="category.id">
                                <option value="" selected="selected" disabled="disabled">请选择业务大类</option>
                                <#list businessType as business>
                                  <option value="${business.id}">${business.title}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label">业务小类：</label>
                        <div class="col-sm-7">
                            <select class="form-control" id="categoryItem" name="categoryItem.id" >
                                <option value="">请选择业务小类</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label">结算类型：</label>
                        <div class="col-sm-7">
                            <select class="form-control" id="payType" name="payType.id">
                                <option value="" selected="selected" disabled="disabled">请选择结算类型</option>
                                <#list pay_type as payType>
                                  <option value="${payType.id}">${payType.title}</option>
                                </#list>
                            </select>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label">消费金额(元)：</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" name="amount"
                                   placeholder="请输入应收金额">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label">优惠金额(元)：</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" name="discountAmount"
                                      placeholder="请输入优惠金额">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label">实收金额(元)：</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" name="payAmount"
                                   placeholder="请输入实收金额">
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
    $(function (){


        $("#deleteBtn").click(function (){
            // // 拿到所选中的元素，第一个参数是索引，第二个参数是元素
            // $.each(items,function (index,ele){
            //     console.log(index)
            // })
            let arr = [];
            let consumptionId = $("[name=id]").val();

            Swal.fire({
                title: '是否确定删除?',
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: '确定!',
                cancelButtonText:'取消！'

            }).then((result) => {
                if (result.value) {
                    $(".check:checked").each(function (index,ele){
                        if ($(ele).prop("checked")){
                            arr.push($(ele).val());

                        }
                    })
                    $.ajax({
                        data:{'ids':arr.toString(),'consumptionId':consumptionId},
                        url:"/consumptionItem/batchDelete",
                        success:function (result){
                            window.location.href="/consumption/detail?consumptionId="+consumptionId
                        }
                    })
                }
            });

        })
        $("#checkAll").click(function (){
            // 如果是选中状态
            if($(this).is(':checked')){
                $(".check").prop("checked",true)
            }else {
                $(".check").prop("checked","")
            }
        })

        $(".btn-input").click(function () {
            $("#editModal").modal("show");
        })
        $("#save-btn").click(function () {
            $("#consumptionItemForm").submit();
        })
        $("select[name='category.id']").change(function () {
            let categoryId = $(this).val();
            $.ajax({
                data: {"parentId": categoryId},
                url: "/systemDictionaryItem/selectItemByParentId",
                success: function (result) {
                    let str = '<option value="" disabled=disabled selected=selected>请选择业务小类</option>';
                    $.each(result.data, function (index, ele) {
                        str += '<option value="' + ele.id + '">' + ele.title + '</option>'
                    })
                    $("select[name='categoryItem.id']").html(str)
                }
            })


    })


    $("#settle-btn").click(function () {
        Swal.fire({
            title: '你确定要结算吗',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: '确定',
            cancelButtonText: '取消'
        }).then((result) => {
            if (result.value) {
                Swal.fire({
                    title: '结算成功',
                    icon: 'success',
                }).then((result) => {
                    if (result.value) {
                        window.setTimeout(function (){
                            window.location.href = "/consumption/settleConsumption?consumptionId=${consumption.id}";
                        },500);
                    }
                })


            }
        })

    })
    $("#btn-audit").click(function (){
        Swal.fire({
            title: '你确定审核通过了吗',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: '通过',
            cancelButtonText: '取消'
        }).then((result) => {
            if (result.value) {
                Swal.fire({
                    title: '审核成功',
                    icon: 'success',
                }).then((result) => {
                    if (result.value) {
                        window.setTimeout(function (){
                            window.location.href = "/consumption/review?consumptionId=${consumption.id}";
                        },500);
                    }
                })


            }
        })
    })
    })

</script>
