<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=9">
    <meta name="viewport" content="width=device-width, initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
	<meta name="keywords" content=""> 
    <meta name="description" content="">
    
    <title>标题</title>
      
	<%@ include file="/WEB-INF/views/base/tag.jsp" %>
	<%@ include file="/WEB-INF/views/base/common-css.jsp" %>

	<!--页面依赖的css-->
    <link href="${baseurl}/assets/lib/DataTables-1.10.9/media/css/jquery.dataTables.min.css" rel="stylesheet">
    <link href="${baseurl}/assets/lib/DataTables-1.10.9/extensions/Responsive/css/responsive.bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
    table.dataTable thead th, table.dataTable thead td {
	    border-bottom: 2px solid #ddd;
	}
	table.dataTable.no-footer {
	    border-bottom: 2px solid #ddd;
	}
    </style>
    
    <link href="${baseurl}/assets/lib/toastr/toastr.min.css" rel="stylesheet">
    <link href="${baseurl}/assets/lib/zTree_v3/css/zTreeStyle/zTreeStyle.css" rel="stylesheet">
    
    <!--引入CSS-->
	<link rel="stylesheet" type="text/css" href="webuploader-0.1.5/webuploader.css">
	
	<!--引入JS-->
	<script type="text/javascript" src="webuploader-0.1.5/webuploader.js"></script>
	
	<!--SWF在初始化的时候指定，在后面将展示-->
    
</head>

<body>
    <div id="wrapper">
        <!-- 这里包含左侧菜单-->
        <jsp:include page="/WEB-INF/views/base/left-menu.jsp" flush="true" />

        <div id="page-wrapper" class="gray-bg dashbard-1">
        	<!-- 这里包含头部-->
        	<jsp:include page="/WEB-INF/views/base/header.jsp" flush="true" />
            
            <!-- 这里写页面内容-->
			
            <div class="wrapper wrapper-content animated fadeInRight" style="margin-top:100px;">
                <div class="row">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>查询结果&nbsp;</h5>
							<div class="ibox-tools">		
								<a class="collapse-link"> <i class="fa fa-chevron-up"></i></a>
							</div>
						</div>
                            <div class="ibox-content">
                                <table class="display responsive " id="table">
                                    <thead>
                                        <tr>
                                        	<th style="padding-left:10px;padding-right:0;width:10px;"><input type="checkbox" id="cb_selectAll"/></th>
                                            <th width="50">商品ID</th>
                                            <th>商品名称</th>
                                            <th>类别</th>
                                            <th width="50">价格</th>
                                            <th width="50">数量</th>
                                            <th width="40">条形码</th>
                                            <th width="30">状态</th>
                                            <th width="80">创建时间</th>
                                            <th width="80">更新时间</th>
                                        </tr>
                                    </thead>
                                    
                                </table>

                            </div>

                    </div>
                </div>
            </div>
            
            
            <div class="footer">
                <div class="pull-right">
                    By：<a href="http://www.mju.edu.cn" target="_blank">闽江学院计算机魔法系</a>
                </div>
                <div>
                    <strong>Copyright</strong> TTSC &copy; 2016
                </div>
            </div>
            
            <!-- 一些模态框 -->
			<div class="modal fade" id="modal_catSel" 
				role="dialog" aria-hidden="true" data-backdrop="static">
				<div class="modal-dialog modal-sm">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title">选择类别</h4>
						</div>
						<div class="modal-body">
							<button id="btn_noCat" class="btn btn-white btn-sm">不设定类别</button>
							<ul id="treeCat" class="ztree" style="max-height:402px;overflow-y: auto;overflow-x: auto;"></ul>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-white" data-dismiss="modal">取消</button>
							<button id="btn_selCat" class="btn btn-primary">确定</button>
						</div>
					</div>
				</div>
			</div>

	<!-- 添加商品对话框 -->
	<!-- 添加/修改对话框。把 tabindex="-1" 属性去掉，kindedtor就能正常使用 -->
			<div class="modal fade" id="modal_save" 
				role="dialog" aria-hidden="true" data-backdrop="static">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title">添加/修改商品</h4>
						</div>
						<div class="modal-body">
							<form class="form-horizontal" role="form" id="form_save">
								<div class="row">
									<div class="col-sm-12">
										<div class="form-group">
											<label class="col-sm-2 control-label">商品标题：</label>
											<div class="col-sm-10">
												<input type="text" name="title" class="form-control" id="title">
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12">
										<div class="form-group">
											<label class="col-sm-2 control-label">商品卖点：</label>
											<div class="col-sm-10">
												<input type="text" name="sellPoint" class="form-control" id="sellPoint">
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12">
										<div class="form-group">
											<label class="col-sm-2 control-label">所属类别：</label>
											<div class="col-sm-10">
												<input type="text" name="catName" class="form-control" id="catName">
												<input type="hidden" name="catId" class="form-control" id="catId">
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-6 control-label">商品价格：</label>
											<div class="col-sm-6">
												<input type="text" name="price" class="form-control" id="price">
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">商品库存：</label>
											<div class="col-sm-8">
												<input type="text" name="num" class="form-control" id="num">
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label class="col-sm-4 control-label">商品条码：</label>
											<div class="col-sm-8">
												<input type="text" name="barcode" class="form-control" id="barcode">
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12">
										<div class="form-group">
											<label class="col-sm-2 control-label">商品图片：</label>

											<!--dom结构部分
											<div id="uploader-demo">-->
											    <!--用来存放item
											    <div id="fileList" class="uploader-list"></div>
											    <div id="filePicker" class="webuploader-pick">选择图片</div>
											</div>-->


											<!--dom结构部分-->
											<div id="uploader-demo">
											    <!--用来存放item-->
											    <div id="fileList" class="uploader-list"></div>
											    <div id="filePicker">选择图片</div>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12">
										<div class="form-group">
											<label class="col-sm-2 control-label">商品描述：</label>
											<div class="col-sm-10">
												<textarea id="editor_id" class="form-control" rows="10" name="desc"></textarea>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12">
										<div class="form-group">
											<label class="col-sm-2 control-label">商品参数：</label>
											<div class="col-sm-10">
												<input type="text" name="param" class="form-control" id="param">
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12">
										<div class="form-group">
											<label class="col-sm-2 control-label"></label>
											<div class="col-sm-10">
												<button type="button" class="btn btn-white" data-dismiss="modal">取消</button>
												<button type="submit" id="btn_save" class="btn btn-primary">保存</button>
											</div>
										</div>
									</div>
								</div>
								
							</form>

						</div>
					</div>
				</div>
			</div>

	<div class="modal fade" id="modal_cat"
				role="dialog" aria-hidden="true" data-backdrop="static">
				<div class="modal-dialog modal-sm">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button> 
							<h4 class="modal-title">选择类别</h4>
						</div>
						<div class="modal-body">
							<ul id="tree_cat" class="ztree" style="max-height:402px;overflow-y: auto;overflow-x: auto;"></ul>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-white" data-dismiss="modal">取消</button>
							<button id="btn_select_cat" class="btn btn-primary">确定</button>
						</div>
					</div>
				</div>
			</div>


			</div>	

		</div>
    </div>

    <!-- Mainly scripts -->
    <%@ include file="/WEB-INF/views/base/common-js.jsp" %>
	
	<!--页面依赖的js-->
    <script src="${baseurl}/assets/lib/DataTables-1.10.9/media/js/jquery.dataTables.min.js"></script>
    <script src="${baseurl}/assets/lib/DataTables-1.10.9/extensions/Responsive/js/dataTables.responsive.min.js"></script>
    <script src="${baseurl}/assets/lib/toastr/toastr.min.js"></script>
    <script src="${baseurl}/assets/lib/zTree_v3/js/jquery.ztree.core.min.js""></script>
    <script>
	$(document).ready(function() {

		/* Init DataTables */
		var oTable = $('#table').DataTable(
			{
				"dom" : '<"toolbarLeft"><"toolbarRight">rtip',
				"autoWidth" : false,
				"processing" : true,
				"serverSide" : true,
				"ajax" : {
					"url" : "${baseurl}/item/list.action",
					"data" : function(d) {
						//添加额外的参数传给服务器
						switch ($("#search_key").val()) {
							case "id":
								d.id = $.trim($("#search_value").val());
								break;
							case "title":
								d.title = $.trim($("#search_value").val());
								break;
						}
					}
				},
				"language" : {
					"lengthMenu" : "每页显示 _MENU_ 条记录",
					"zeroRecords" : "暂无记录",
					"info" : "从 _START_ 到 _END_，共 _TOTAL_ 记录",
					"infoEmpty" : "暂无记录",
					"infoFiltered" : "(filtered from _MAX_ total records)",
					"paginate" : {
						"previous" : "上一页",
						"next" : "下一页"
					},
					"processing" : "正在加载..."
				},
				"columns" : [
					{
						"data" : "id",
						"orderable" : false,
						"render" : function(data,type,full,meta) {//class = "cb_id"
							return '<input type="checkbox" value="'+data+'" class = "cb_id"/>';
						}
					},
					{
						"data" : "id",
						"orderable" : false,
					},
					{
						"data" : "title",
						"orderable" : false
					},
					{
						"data" : "catId",
						"orderable" : false
					},
					{
						"data" : "price",
						"name" : "price"
					},
					{
						"data" : "num",
						"name" : "num"
					},
					{
						"data" : "barcode",
						"orderable" : false
					},
					{
						"data" : "status",
						"orderable" : false,
						"render" : function(data,type,full,meta) {
							return TAOTAO.formatItemStatus(data);
						}
					},
					{
						"data" : "createTime",
						"name" : "createTime",
						"render" : function(data,type,full,meta) {
							return TAOTAO.formatDate(data);
						}
					},
					{
						"data" : "updateTime",
						"name" : "updateTime",
						"render" : function(data,type,full,meta) {
							return TAOTAO.formatDate(data);
						}
					}
				],
				"order" : [ [ 8,'asc' ] ]
			});

		$('#table').on('init.dt draw.dt', function() {
			$("#cb_selectAll").prop("checked", false);
		});

		$("div.toolbarLeft").html('<button id="btn_up" class="btn btn-primary btn-xs"><i class="fa fa-level-up"></i>&nbsp;上架</button> '
								+ '<button id="btn_down" class="btn btn-primary btn-xs"><i class="fa fa-level-down"></i>&nbsp;下架</button> '
								+ '<button id="btn_add" class="btn btn-primary btn-xs"><i class="fa fa-plus"></i>&nbsp;添加</button> '
								+ '<button id="btn_edit" class="btn btn-primary btn-xs"><i class="fa fa-wrench"></i>&nbsp;修改</button> '
								+ '<button id="btn_del" class="btn btn-primary btn-xs"><i class="fa fa-remove"></i>&nbsp;删除</button>'
								+ '<button id="btn_exp" class="btn btn-primary btn-xs"><i class="fa fa-remove"></i>&nbsp;爆炸</button>');
										
		$("div.toolbarLeft").addClass("dataTables_length");
		
		$("div.toolbarRight").html('<select id="search_key"><option value="id">商品id</option><option value="title">商品标题</option></select><input type="text" id="search_value"><button class="btn btn-primary btn-xs" id="btn_search">查询</button>');
						
		$("div.toolbarRight").addClass("dataTables_filter");

		$("#cb_selectAll").click(function() {//全选
			if (this.checked) {
				$("tbody :checkbox").prop("checked",true);
			} else {
				$("tbody :checkbox").prop("checked",false);
			}
		});

		$("tbody").on("click", "input:checkbox", function() {
			var isCheckAll = true;
			$("tbody :checkbox").each(function(index) {
				if (!$(this).prop("checked")) {
					isCheckAll = false;
					return false;
				}
			});
			if (isCheckAll) {
				$("#cb_selectAll").prop("checked",true);
			} else {
				$("#cb_selectAll").prop("checked",false);
			}
		});

		$("#btn_edit").click(function() {
			//
		});

		$("#btn_search").click(function() {
			oTable.ajax.reload();
		});
			
		function getSelectedIds() {
			var ids = [];
			$('input[class="cb_id"]:checked').each(function(index, element){
				ids.push($(this).val());
			});
			return ids;
		}
		
		
		$("#btn_del").click(function() {
				var $btn = $(this).button('loading');
				var ids = getSelectedIds();
				if (ids.length == 0) {
					alert("请至少选择一个商品");
					$btn.button('reset');
					return
				}
				
				if (confirm("请确认是否删除？") == false) {
					$btn.button('reset');
					return
				}
				
	            $.ajax({
	                type: 'post',
	                url: '${baseurl}/item/del.action',
	                data: {ids : ids},
	                dataType: 'json',
	                success: function (data, textStatus) {
	                    $btn.button('reset');
	                    if (data.status == '200') {
	                    	alert(data.msg);
	                    	oTable.ajax.reload(null, false);//刷新当前页
	                    }
	                },
	                error: function (XMLHttpRequest, textStatus, errorThrown) {
	                    $btn.button('reset');
	                    //其它处理代码
	                }
	            });
			});
		
		$("#btn_add").click(function() {
			var $btn = $(this).button('loading');

			$('#modal_save').modal('show');
			
			$btn.button('reset');
			
		});

	});
	
	//添加商品JS
	var setting = {
				view: {
					selectedMulti: false
				},
				async: {
					enable: true,
					url: "${baseurl}/item/cat/list.action",
					autoParam:["id", "name=n", "level=lv"],
					otherParam:{"parentUrl":"${baseurl}/item/query.action"}
				},
				callback: {
					beforeClick: beforeClick,
					beforeAsync: beforeAsync,
					onAsyncError: onAsyncError,
					onAsyncSuccess: onAsyncSuccess
				}
			};

				
			function beforeClick(treeId, treeNode) {
				return true;
			}

			function beforeAsync(treeId, treeNode) {
				return true;
			}
				
			function onAsyncError(event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown) {
				//console.log("error");
			}
				
			function onAsyncSuccess(event, treeId, treeNode, msg) {
				//
			}
		
		$('#modal_save').on('shown.bs.modal', function (e) {
			KindEditor.create('#editor_id');
		});
										
		$('#modal_save').on('hidden.bs.modal', function (e) {
			// 关闭Dialog前移除编辑器
		    KindEditor.remove('#editor_id');
		});
		
		$('#modal_cat').on('shown.bs.modal', function (e) {
			$.fn.zTree.init($("#tree_cat"), setting);
		});
										
		$('#modal_cat').on('hidden.bs.modal', function (e) {
			$.fn.zTree.destroy("tree_cat");
		});
		
		$("#catName").focus(function(){
			$('#modal_cat').modal('show');
		});
		
		$("#btn_select_cat").click(function(){
			var treeObj = $.fn.zTree.getZTreeObj("tree_cat");
			var nodes = treeObj.getSelectedNodes();
			if (nodes.length > 0) {
				$("#catName").val(nodes[0].name);
				$("#catId").val(nodes[0].id);
			}
			$('#modal_cat').modal('hide');
		});
		
		$("#form_save").validate({
        	rules: {
                title: {
                	required: true,
                	rangelength: [5, 20]
                },
                sellPoint: {
                	rangelength: [5, 20]
                },
                price:  {
                	required: true,
                	number: true
                },
                num: {
                	required: true,
                	number: true
                },
                catName: {
                	required: true
                }
            },
            messages: {
                title: {
                    required: "请输入商品标题",
                    rangelength: "商品标题必须5-20个字符以上"
                },
                sellPoint: {
                    rangelength: "商品卖点必须5-20个字符以上"
                },
                price: {
                    required: "请输入商品价格",
                    number: "商品价格必须为数字格式"
                },
                num: {
                    required: "请输入库存量",
                    number: "库存量必须为数字格式"
                },
                catName: {
                	required: "请输入商品类别"
                }
            },
            invalidHandler: function() {
            	//console.log(11);
                
            },
            submitHandler: function(form) {
                // some other code
                // maybe disabling submit button
                // then:
                // $(form).submit();
            	var $btn = $("#btn_save").button('loading');
                $.ajax({
                    type: 'post',
                    url: '${baseurl}/item/save.action',
                    data: $(form).serialize(),
                    dataType: 'json',
                    success: function (data, textStatus) {
                        $btn.button('reset');
                        if (data.status == '200') {
                        	
                        }
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        $btn.button('reset');
                        
                    }
                });
            }
        });
		<!--
		// 图片上传
		jQuery(function() {
		    var $ = jQuery,
		        $list = $('#fileList'),
		        // 优化retina, 在retina下这个值是2
		        ratio = window.devicePixelRatio || 1,

		        // 缩略图大小
		        thumbnailWidth = 100 * ratio,
		        thumbnailHeight = 100 * ratio,

		        // Web Uploader实例
		        uploader;

		    // 初始化Web Uploader
		    uploader = WebUploader.create({

		        // 自动上传。
		        auto: true,

		        // swf文件路径
		        //swf: '${baseurl}/assets/lib/webuploader/js/Uploader.swf',
		        swf: '${baseurl}/webuploader-0.1.5/Uploader.swf',

		        // 文件接收服务端。
		        server: '${baseurl}/pic/upload.action',

		        // 选择文件的按钮。可选。
		        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
		        pick: '#filePicker',

		        // 只允许选择文件，可选。
		        accept: {
		            title: 'Images',
		            extensions: 'gif,jpg,jpeg,bmp,png',
		            mimeTypes: 'image/*'
		        }
		    });

		    // 当有文件添加进来的时候
		    uploader.on( 'fileQueued', function( file ) {
		        var $li = $(
		                '<div id="' + file.id + '" class="file-item thumbnail">' +
		                    '<img>' +
		                    '<div class="info">' + file.name + '</div>' +
		                '</div>'
		                ),
		            $img = $li.find('img');

		        $list.append( $li );

		        // 创建缩略图
		        uploader.makeThumb( file, function( error, src ) {
		            if ( error ) {
		                $img.replaceWith('<span>不能预览</span>');
		                return;
		            }

		            $img.attr( 'src', src );
		        }, thumbnailWidth, thumbnailHeight );
		    });

		    // 文件上传过程中创建进度条实时显示。
		    uploader.on( 'uploadProgress', function( file, percentage ) {
		        var $li = $( '#'+file.id ),
		            $percent = $li.find('.progress span');

		        // 避免重复创建
		        if ( !$percent.length ) {
		            $percent = $('<p class="progress"><span></span></p>')
		                    .appendTo( $li )
		                    .find('span');
		        }

		        $percent.css( 'width', percentage * 100 + '%' );
		    });

		    // 文件上传成功，给item添加成功class, 用样式标记上传成功。
		    uploader.on( 'uploadSuccess', function( file, response ) {
		        $( '#'+file.id ).addClass('upload-state-done');
		        $('#image').val(response.data);
		    });

		    // 文件上传失败，现实上传出错。
		    uploader.on( 'uploadError', function( file ) {
		        var $li = $( '#'+file.id ),
		            $error = $li.find('div.error');

		        // 避免重复创建
		        if ( !$error.length ) {
		            $error = $('<div class="error"></div>').appendTo( $li );
		        }

		        $error.text('上传失败');
		    });

		    // 完成上传完了，成功或者失败，先删除进度条。
		    uploader.on( 'uploadComplete', function( file ) {
		        $( '#'+file.id ).find('.progress').remove();
		    });
		});
		 -->

		
	</script>
	



</body>
</html>