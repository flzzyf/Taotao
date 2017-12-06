<!-- Mainly scripts -->
<script src="${baseurl}/assets/lib/jquery/jquery-2.1.1.min.js"></script>
<script src="${baseurl}/assets/lib/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<script src="${baseurl}/assets/lib/metisMenu/jquery.metisMenu.js"></script>
<script src="${baseurl}/assets/lib/jquery/jquery.slimscroll.min.js"></script>
<!-- Custom and plugin javascript -->
<script src="${baseurl}/assets/js/hplus.js?v=2.2.0"></script>
<script src="${baseurl}/assets/lib/pace/pace.min.js"></script>
<script src="${baseurl}/assets/lib/jquery/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="${baseurl}/assets/js/common.js"></script>

<script>
	$(document).ready(function() {
		$("title").text("${nav2}");
		$("#${menu1}").addClass("active");
		$("#${menu2}").addClass("active");
		$("#${menu1}>ul").addClass("in");
		$("#nav1").text("${nav1}");
		$("#nav2").text("${nav2}");
	});
</script>
