<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!--引入CSS-->
	<link rel="stylesheet" type="text/css" href="webuploader/webuploader.css">
	


	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	
</head>
<body>

	<div id="uploader-demo" class="wu-example">
	    <div id="fileList" class="uploader-list">
	    </div>
	    <div id="filePicker">选择图片</div>
	</div>
	
	<script type="text/javascript">
	// 初始化Web Uploader
	var uploader = WebUploader.create({

	    // 选完文件后，是否自动上传。
	    auto: true,

	    // swf文件路径
	    swf: BASE_URL + '/js/Uploader.swf',

	    // 文件接收服务端。
	    server: 'http://webuploader.duapp.com/server/fileupload.php',

	    // 选择文件的按钮。可选。
	    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	    pick: '#filePicker',

	    // 只允许选择图片文件。
	    accept: {
	        title: 'Images',
	        extensions: 'gif,jpg,jpeg,bmp,png',
	        mimeTypes: 'image/*'
	    }
	});
	
	</script>
	
	<!--引入JS-->
	<script type="text/javascript" src="/webuploader/webuploader.js"></script>
	
	<script type="text/javascript" src="/webuploader/js/getting-started.js"></script>
</body>
</html>