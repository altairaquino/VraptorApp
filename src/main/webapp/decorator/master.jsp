<!DOCTYPE html>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>

<html lang="pt-BR">

	<!-- paulirish.com/2008/conditional-stylesheets-vs-css-hacks-answer-neither/ -->
	<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
	<!--[if IE 7]>    <html class="no-js lt-ie9 lt-ie8" lang="en"> <![endif]-->
	<!--[if IE 8]>    <html class="no-js lt-ie9" lang="en"> <![endif]-->
	<!--[if gt IE 8]><!-->
	<html class="no-js" lang="en">
	<!--<![endif]-->
	
	<head>
		<title><decorator:title>Absoluta Modas</decorator:title></title>
		<meta charset="utf-8">
        
        <!-- Set the viewport width to device width for mobile -->
        <meta name="viewport" content="width=device-width" />
		
		<jsp:include page="/template/styles.jsp" />
		<jsp:include page="/template/scripts.jsp" />
		
		<!-- atributos injetados pelo sitemesh -->
		<decorator:head />
		
		<!-- Google fonts -->
		<link href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300|Playfair+Display:400italic' rel='stylesheet' type='text/css' />
		
	</head>

	<body>
		
		<div class="row page_wrap">
		
			<div class="twelve columns">
			
			<jsp:include page="/template/header.jsp" />
			
			<decorator:body />
			
			<div class="row">
				<div class="twelve columns">
					<ul id="menu3" class="footer_menu horizontal">
						<li class=""><a href="index.html">Home</a></li>
					</ul>
				</div>
				</div>
	
				<script type="text/javascript">
		          //<![CDATA[
		          	$('ul#menu3').nav-bar();
		          //]]>
	          	</script>
	
			</div>
	
		</div>
		
		<!-- end page wrap) -->
		<!-- Included JS Files (Compressed) -->
		<script src="template/js/foundation.min.js" type="text/javascript"></script>
		<!-- Initialize JS Plugins -->
		<script src="template/js/app.js" type="text/javascript"></script>	
				
		</body>
	
</html>