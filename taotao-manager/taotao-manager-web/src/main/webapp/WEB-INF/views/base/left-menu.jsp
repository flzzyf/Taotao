<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav id="sidebar1"
	class="navbar-default navbar-static-side left-menu-scroll-1"
	role="navigation">
	<div id="sidebar2" class="sidebar-collapse left-menu-scroll-2">
		<div class="nav-header" style="padding: 23px 0;">
			<div class="dropdown profile-element">
				<span>  <img
					src="${pageContext.request.contextPath}/assets/images/logo_lw.png" />
				</span>
			</div>
			<div class="logo-element">TTSC</div>
		</div>

		<div id="sidebar3" class="left-menu-scroll-3 content mCustomScrollbar light" data-mcs-theme="minimal-dark">
			<ul class="nav" id="side-menu">
				<li id="menu_item"><a href="index.html"><i
						class="fa fa-th-large"></i> <span class="nav-label">商品管理</span> <span
						class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li id="menu_item_query"><a href="${baseurl}/item/query.action">商品列表查询</a></li>
						<li><a href="">其它待开发功能1</a></li>
						<li><a href="">其它待开发功能2</a></li>
						<li><a href="">其它待开发功能3</a></li>
					</ul></li>
				
			</ul>
		</div>
	</div>
</nav>