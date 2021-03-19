<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Echarts演示</title>
  <script src="../../../static/js/plugins/echarts/echarts.common.min.js"></script>
</head>
<body>
<div id="main" style="width: 1200px;height:800px;"></div>
</body>
<script>
  var chartDom = document.getElementById('main');
  var myChart = echarts.init(chartDom);
  var option;

  option = {
    legend: {},
    tooltip: {},
    dataset: {
      source: [
        ['分组类型',  '总消费金额', '总实优惠金额','总实收金额'],
        <#list items as item>
        ['${item.groupByName}', ${item.totalAmount}, ${item.totalDiscountAmount}, ${item.totalPayAmount}]
        <#if item_index < (items?size - 1)>
        ,
        </#if>
        </#list>
      ]
    },
    xAxis: {type: 'category'},
    yAxis: {},
    // Declare several bar series, each will be mapped
    // to a column of dataset.source by default.
    series: [
      {type: 'bar'},
      {type: 'bar'},
      {type: 'bar'}
    ]
  };
  option && myChart.setOption(option);
</script>
</html>