/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-12-06 09:55:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.base;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<div class=\"my-fixed-header row\">\r\n");
      out.write("\t<nav class=\"navbar navbar-static-top border-bottom\" role=\"navigation\"\r\n");
      out.write("\t\tstyle=\"margin-bottom: 0\">\r\n");
      out.write("\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t<a class=\"navbar-minimalize minimalize-styl-2 btn btn-primary \"\r\n");
      out.write("\t\t\t\thref=\"#\"><i class=\"fa fa-bars\"></i> </a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<ul class=\"nav navbar-top-links navbar-right\">\r\n");
      out.write("\t\t\t<li><span class=\"m-r-sm text-muted welcome-message\" style=\"font-size:14px;font-weight:bold;\"><a\r\n");
      out.write("\t\t\t\t\thref=\"index.html\" title=\"返回首页\"><i class=\"fa fa-home\"></i></a>欢迎使用B2C电商系统管理后台</span>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li class=\"dropdown\"><a class=\"dropdown-toggle count-info\"\r\n");
      out.write("\t\t\t\tdata-toggle=\"dropdown\" href=\"index.html#\"> <i\r\n");
      out.write("\t\t\t\t\tclass=\"fa fa-envelope\"></i> <span class=\"label label-warning\">16</span>\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t\t<ul class=\"dropdown-menu dropdown-messages\">\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"dropdown-messages-box\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"profile.html\" class=\"pull-left\"> <img alt=\"image\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"img-circle\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/assets/images/a7.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"media-body\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<small class=\"pull-right\">46小时前</small> <strong>小四</strong>\r\n");
      out.write("\t\t\t\t\t\t\t\t项目已处理完结 <br> <small class=\"text-muted\">3天前\r\n");
      out.write("\t\t\t\t\t\t\t\t\t2014.11.8</small>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li class=\"divider\"></li>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"dropdown-messages-box\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"profile.html\" class=\"pull-left\"> <img alt=\"image\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"img-circle\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/assets/images/a4.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"media-body \">\r\n");
      out.write("\t\t\t\t\t\t\t\t<small class=\"pull-right text-navy\">25小时前</small> <strong>国民岳父</strong>\r\n");
      out.write("\t\t\t\t\t\t\t\t这是一条测试信息 <br> <small class=\"text-muted\">昨天</small>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li class=\"divider\"></li>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"text-center link-block\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"mailbox.html\"> <i class=\"fa fa-envelope\"></i> <strong>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t查看所有消息</strong>\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t<li class=\"dropdown\"><a class=\"dropdown-toggle count-info\"\r\n");
      out.write("\t\t\t\tdata-toggle=\"dropdown\" href=\"index.html#\"> <i class=\"fa fa-bell\"></i>\r\n");
      out.write("\t\t\t\t\t<span class=\"label label-primary\">8</span>\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t\t<ul class=\"dropdown-menu dropdown-alerts\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"mailbox.html\">\r\n");
      out.write("\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"fa fa-envelope fa-fw\"></i> 您有16条未读消息 <span\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"pull-right text-muted small\">4分钟前</span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"divider\"></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"profile.html\">\r\n");
      out.write("\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"fa fa-qq fa-fw\"></i> 3条新回复 <span\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"pull-right text-muted small\">12分钟钱</span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"divider\"></li>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"text-center link-block\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"notifications.html\"> <strong>查看所有 </strong> <i\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"fa fa-angle-right\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t<li class=\"dropdown\" style=\"font-size:12px;\"><a href=\"#\" class=\"dropdown-toggle\"\r\n");
      out.write("\t\t\t\tdata-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\"\r\n");
      out.write("\t\t\t\taria-expanded=\"false\">用户名 <span class=\"caret\"></span></a>\r\n");
      out.write("\t\t\t\t<ul class=\"dropdown-menu animated fadeInRight m-t-xs\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"form_avatar.html\">修改头像</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"profile.html\">个人资料</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"contacts.html\">联系我们</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"mailbox.html\">信箱</a></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"divider\"></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"login.html\">安全退出</a></li>\r\n");
      out.write("\t\t\t\t</ul></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\r\n");
      out.write("\t</nav>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"row wrapper border-bottom white-bg page-heading\" style=\"margin:0;padding:10px\">\r\n");
      out.write("                <div class=\"col-lg-12\">\r\n");
      out.write("                    <ol class=\"breadcrumb\">\r\n");
      out.write("                        <li>主页</li>\r\n");
      out.write("                        <li id=\"nav1\">表格</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li><strong id=\"nav2\">数据表格</strong></li>\r\n");
      out.write("                    </ol>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("</div>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
