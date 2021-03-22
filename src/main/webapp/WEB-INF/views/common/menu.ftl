<aside class="main-sidebar ">
  <section class="sidebar">
    <!-- Sidebar user panel -->
    <div class="user-panel">
      <div class="pull-left image">
        <img src="../../../static/js/adminlte/img/user2-160x160.jpg" class="img-circle"
             alt="User Image">
      </div>
      <div class="pull-left info">
        <p>${EMPLOYEE_IN_SESSION.username}</p>
        <a href="#"><i class="fa fa-circle text-success"></i>在线</a>
      </div>
    </div>
    <!-- search form -->
    <form action="#" method="get" class="sidebar-form">
      <div class="input-group">
        <input type="text" name="q" class="form-control" placeholder="Search...">
        <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i
                      class="fa fa-search"></i>
                </button>
              </span>
      </div>
    </form>
    <ul class="sidebar-menu" data-widget="tree">
      <li class="treeview">
        <a href="#">
          <i class="fa fa-joomla"></i> <span>门店管理</span>
          <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
        </a>
        <ul class="treeview-menu">
          <li name="business"><a href="/business/list"><i class="fa fa-circle-o"></i>门店信息</a></li>
          <li name="appointment"><a href="/appointment/list"><i class="fa fa-circle-o"></i>业务预约</a>
          </li>
          <li name="consumption"><a href="/consumption/list"><i class="fa fa-circle-o"></i>结算单</a>
          </li>
            <#--                    <li name="consumptionItem"><a href="/consumptionItem/list"><i class="fa fa-circle-o"></i>结算单明细</a></li>-->
        </ul>
      </li>
      <li class="treeview">
        <a href="#">
          <i class="fa fa-dashboard"></i> <span>系统管理</span>
          <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
        </a>
        <ul class="treeview-menu">
          <li name="department"><a href="/department/list"><i class="fa fa-circle-o"></i> 部门管理</a>
          </li>
          <li name="employee"><a href="/employee/list"><i class="fa fa-circle-o"></i> 员工管理</a></li>
          <li name="employee"><a href="/salary/list"><i class="fa fa-circle-o"></i> 工资管理</a></li>
          <li name="permission"><a href="/permission/list"><i class="fa fa-circle-o"></i> 权限管理</a>
          </li>
          <li name="role"><a href="/role/list"><i class="fa fa-circle-o"></i> 角色管理</a></li>
        </ul>
      </li>
      <li class="treeview">
        <a href="#">
          <i class="fa fa-files-o"></i>
          <span>数据管理</span>
          <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
        </a>
        <ul class="treeview-menu">
          <li name="systemDictionary"><a href="/systemDictionary/list"><i
                  class="fa fa-circle-o"></i> 字典目录</a>
          </li>
          <li name="systemDictionaryItem"><a href="/systemDictionaryItem/list?typeId=1"><i
                  class="fa fa-circle-o"></i> 字典明细</a></li>
        </ul>
      </li>

      <li class="treeview">
        <a href="#">
          <i class="fa fa-pie-chart"></i>
          <span>客户管理</span>
          <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
        </a>
        <ul class="treeview-menu">
          <li name="customer"><a href="/customer/list"><i class="fa fa-circle-o"></i> 客户列表</a></li>
          <li name="customer_potential"><a href="/customer/potentialList"><i
                  class="fa fa-circle-o"></i>潜在客户</a></li>
          <li name="customer_pool"><a href="/customer/poolList"><i class="fa fa-circle-o"></i>
              客户池</a></li>
          <li name="customer_fail"><a href="/customer/failList"><i class="fa fa-circle-o"></i> 失败客户</a>
          </li>
          <li><a href="#"><i class="fa fa-circle-o"></i> 正式客户</a></li>
          <li><a href="#"><i class="fa fa-circle-o"></i> 流失客户</a></li>
        </ul>
      </li>
      <li class="treeview">
        <a href="#">
          <i class="fa fa-edit"></i>
          <span>客户历史</span>
          <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
        </a>
        <ul class="treeview-menu">

          <li name="customerTraceHistory"><a href="/customerTraceHistory/list"><i
                  class="fa fa-circle-o"></i> 跟进历史</a></li>
          <li name="customerTransfer"><a href="/customerTransfer/list"><i
                  class="fa fa-circle-o"></i> 移交历史</a>
          </li>
        </ul>
      </li>
      <li class="treeview">
        <a href="#">
          <i class="fa fa-laptop"></i>
          <span>报表统计</span>
          <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
        </a>
        <ul class="treeview-menu">
          <li name="customerReport"><a href="/consumptionReport/list"><i class="fa fa-circle-o"></i>门店数据报表</a>
          </li>
        </ul>
      </li>

      <li class="treeview">
        <a href="#">
          <i class="fa fa-calendar-times-o"></i>
          <span>公告管理</span>
          <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
        </a>
        <ul class="treeview-menu">
          <li name="notice"><a href="/notice/list"><i class="fa fa-circle-o"></i>公告管理</a>
          <li name="notice"><a href="/activity/list"><i class="fa fa-circle-o"></i>投票管理</a>
          <li name="notice"><a href="/message/list"><i class="fa fa-circle-o"></i>留言管理</a>
          </li>
        </ul>
      </li>


    </ul>
  </section>
</aside>

<script>
  $(function () {
    //菜单初始
    // $('.sidebar-menu').tree();
    //菜单激活
    var cuLi = $(".treeview-menu li[name='${currentMenu}']");
    cuLi.addClass("active");
    cuLi.closest(".treeview").addClass("active")
  })
</script>