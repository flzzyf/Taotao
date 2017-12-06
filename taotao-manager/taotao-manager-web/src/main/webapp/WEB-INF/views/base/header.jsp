<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="my-fixed-header row">
	<nav class="navbar navbar-static-top border-bottom" role="navigation"
		style="margin-bottom: 0">
		<div class="navbar-header">
			<a class="navbar-minimalize minimalize-styl-2 btn btn-primary "
				href="#"><i class="fa fa-bars"></i> </a>
		</div>
		<ul class="nav navbar-top-links navbar-right">
			<li><span class="m-r-sm text-muted welcome-message" style="font-size:14px;font-weight:bold;"><a
					href="index.html" title="返回首页"><i class="fa fa-home"></i></a>欢迎使用B2C电商系统管理后台</span>
			</li>
			<li class="dropdown"><a class="dropdown-toggle count-info"
				data-toggle="dropdown" href="index.html#"> <i
					class="fa fa-envelope"></i> <span class="label label-warning">16</span>
			</a>
				<ul class="dropdown-menu dropdown-messages">
					<li>
						<div class="dropdown-messages-box">
							<a href="profile.html" class="pull-left"> <img alt="image"
								class="img-circle" src="${pageContext.request.contextPath}/assets/images/a7.jpg">
							</a>
							<div class="media-body">
								<small class="pull-right">46小时前</small> <strong>小四</strong>
								项目已处理完结 <br> <small class="text-muted">3天前
									2014.11.8</small>
							</div>
						</div>
					</li>
					<li class="divider"></li>
					<li>
						<div class="dropdown-messages-box">
							<a href="profile.html" class="pull-left"> <img alt="image"
								class="img-circle" src="${pageContext.request.contextPath}/assets/images/a4.jpg">
							</a>
							<div class="media-body ">
								<small class="pull-right text-navy">25小时前</small> <strong>国民岳父</strong>
								这是一条测试信息 <br> <small class="text-muted">昨天</small>
							</div>
						</div>
					</li>
					<li class="divider"></li>
					<li>
						<div class="text-center link-block">
							<a href="mailbox.html"> <i class="fa fa-envelope"></i> <strong>
									查看所有消息</strong>
							</a>
						</div>
					</li>
				</ul></li>
			<li class="dropdown"><a class="dropdown-toggle count-info"
				data-toggle="dropdown" href="index.html#"> <i class="fa fa-bell"></i>
					<span class="label label-primary">8</span>
			</a>
				<ul class="dropdown-menu dropdown-alerts">
					<li><a href="mailbox.html">
							<div>
								<i class="fa fa-envelope fa-fw"></i> 您有16条未读消息 <span
									class="pull-right text-muted small">4分钟前</span>
							</div>
					</a></li>
					<li class="divider"></li>
					<li><a href="profile.html">
							<div>
								<i class="fa fa-qq fa-fw"></i> 3条新回复 <span
									class="pull-right text-muted small">12分钟钱</span>
							</div>
					</a></li>
					<li class="divider"></li>
					<li>
						<div class="text-center link-block">
							<a href="notifications.html"> <strong>查看所有 </strong> <i
								class="fa fa-angle-right"></i>
							</a>
						</div>
					</li>
				</ul></li>
			<li class="dropdown" style="font-size:12px;"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown" role="button" aria-haspopup="true"
				aria-expanded="false">用户名 <span class="caret"></span></a>
				<ul class="dropdown-menu animated fadeInRight m-t-xs">
					<li><a href="form_avatar.html">修改头像</a></li>
					<li><a href="profile.html">个人资料</a></li>
					<li><a href="contacts.html">联系我们</a></li>
					<li><a href="mailbox.html">信箱</a></li>
					<li class="divider"></li>
					<li><a href="login.html">安全退出</a></li>
				</ul></li>
		</ul>

	</nav>
	
	<div class="row wrapper border-bottom white-bg page-heading" style="margin:0;padding:10px">
                <div class="col-lg-12">
                    <ol class="breadcrumb">
                        <li>主页</li>
                        <li id="nav1">表格</a>
                        </li>
                        <li><strong id="nav2">数据表格</strong></li>
                    </ol>
                </div>
            </div>
</div>