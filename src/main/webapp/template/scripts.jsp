<script type="text/javascript" src="${pageContext.request.contextPath}/template/js/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/template/js/jquery.mobile-1.4.2.min.js"></script>

<script type="text/javascript">
	$( document ).on( "mobileinit", function() {
	  $.mobile.loader.prototype.options.text = "loading";
	  $.mobile.loader.prototype.options.textVisible = true;
	  $.mobile.loader.prototype.options.theme = "b";
	  $.mobile.loader.prototype.options.html = "";
	});
</script>