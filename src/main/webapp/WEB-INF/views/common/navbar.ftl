<header class="main-header">
  <a href="../../index2.html" class="logo"
     style="background-color: #222d32;color: #fff;border-right: none;border-bottom: 1px solid grey;">
    <span class="logo-mini">wolf</span>
    <span class="logo-lg"><b>汽车门店管理平台</b></span>
  </a>
  <!-- Header Navbar: style can be found in header.less -->
  <nav class="navbar navbar-static-top">
    <!-- Sidebar toggle button-->
    <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
      <span class="sr-only">Toggle navigation</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </a>


    <div class="navbar-custom-menu">
      <ul class="nav navbar-nav">
        <li class="dropdown messages-menu">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">
            <i class="fa fa-envelope-o"></i>
            <span class="label label-danger">${unReadNumber}</span>
          </a>
          <ul class="dropdown-menu">
            <li class="header">你有${unReadNumber}条未读公告</li>
            <li>
              <ul class="menu">
                  <#list unReadNotice as unRead>
                    <li>
                      <a href="/notice/toShow?noticeId=${unRead.id}">
                        <div class="pull-left">
                          <img src="../../../static/js/adminlte/img/user2-160x160.jpg"
                               class="img-circle" alt="User Image">
                        </div>
                        <h4>
                            ${unRead.title}
                          <small class="time"
                                 data-tiem='${(unRead.createTime?string("yyyy-MM-dd HH:mm:ss"))!}'><i
                                class="fa fa-clock-o"
                            ></i>
                              ${unRead.calTime}</small>
                        </h4>
                        <p>${unRead.content}</p>
                      </a>
                    </li>
                  </#list>

              </ul>
            </li>
              <#if unReadNumber gt 2 >
                <li class="footer"><a href="/notice/list">查看更多公告</a></li>
              </#if>
          </ul>
        </li>
        <li class="dropdown tasks-menu">
          <a href="#">
            <i class="fa fa-flag-o"></i>
          </a>
        </li>
        <li class="dropdown notifications-menu">
          <a href="#">
            <i class="fa fa-bell-o"></i>
          </a>
        </li>
        <li>
          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-gears"></i></a>
          <ul class="dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close"
              style="min-width: 100px;">
            <li>
              <a href="#">
                <i class="fa fa-cog"></i>
                个人设置
              </a>
            </li>
            <li class="divider"></li>
            <li>
              <a href="#">
                <i class=" fa fa-user"></i>
                修改密码
              </a>
            </li>
            <li class="divider"></li>
            <li>
              <a href="/logout">
                <i class="fa fa-power-off"></i>
                注销
              </a>
            </li>
          </ul>
        </li>
      </ul>
    </div>
  </nav>
</header>
<script>
  function cal(dateTimeStamp) {
    setInterval(function () {
      console.log(getDateDiff(dateTimeStamp));
    }, 1000);
  }

  //计算时差
  function getDateDiff(dateTimeStamp) {
    var minute = 1000 * 60;
    var hour = minute * 60;
    var day = hour * 24;
    var halfamonth = day * 15;
    var month = day * 30;
    var now = new Date().getTime();
    var diffValue = now - dateTimeStamp;
    if (diffValue < 0) {
      //若日期不符则弹窗口告之,结束日期不能小于开始日期！
    }
    var monthC = diffValue / month;
    var weekC = diffValue / (7 * day);
    var dayC = diffValue / day;
    var hourC = diffValue / hour;
    var minC = diffValue / minute;
    if (monthC >= 1) {
      result = "发表于" + parseInt(monthC) + "个月前";
    } else if (weekC >= 1) {
      result = "发表于" + parseInt(weekC) + "周前";
    } else if (dayC >= 1) {
      result = "发表于" + parseInt(dayC) + "天前";
    } else if (hourC >= 1) {
      result = "发表于" + parseInt(hourC) + "个小时前";
    } else if (minC >= 1) {
      result = "发表于" + parseInt(minC) + "分钟前";
    } else {
      result = "刚刚发表";
    }
    $(".time").html(result)
    console.log(result)
    return result;

  }
</script>
