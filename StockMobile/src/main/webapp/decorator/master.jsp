<!DOCTYPE html>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>

<html lang="pt-BR">
	<head>
		<title><decorator:title>Stock Mobile - Genial Sistemas</decorator:title></title>
		<meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
		
		<jsp:include page="/template/styles.jsp" />
		<jsp:include page="/template/scripts.jsp" />
		
		<!-- atributos injetados pelo sitemesh -->
		<decorator:head />
	</head>

	<body>
		<div id="contextpath" style="display: none;">${pageContext.request.contextPath}</div>
	
		<div data-role="page">
		
			<decorator:body />
		
			<div data-role="footer" data-position="fixed">
        		<h3>Genial Estoque - Todos os direitos reservados</h3>    
        	</div>
        	
		</div>	
		
	</body>
	
</html>