<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
	<title>Menu</title>	
</head>
<body>

	<div data-role="header" data-theme="a" data-position="fixed">
		<a href="${pageContext.request.contextPath}/menu" class="ui-btn-left ui-btn ui-btn-b ui-btn-inline ui-mini ui-corner-all ui-btn-icon-left ui-icon-back">Menu</a>
        <h1>Relatórios - StockMobile</h1>
        <a href="${pageContext.request.contextPath}/logoff" class="ui-btn-right ui-btn ui-btn-b ui-btn-inline ui-mini ui-corner-all ui-btn-icon-right ui-icon-check">Sair</a>
     </div>
     
     <div class="ui-grid-b">
     	<div class="ui-input-btn ui-btn ui-icon-delete ui-btn-icon-top">
            Vendas
            <input type="button" data-enhanced="true" onclick="window.location = '${pageContext.request.contextPath}/relatorio/vendas'">
        </div>
        <div class="ui-input-btn ui-btn ui-icon-delete ui-btn-icon-top">
            Produtos mais vendidos
            <input type="button" data-enhanced="true">
        </div>
        <div class="ui-input-btn ui-btn ui-icon-delete ui-btn-icon-top">
            Estoque total (Inventário)
            <input type="button" data-enhanced="true">
        </div>
     </div>               
	 
</body>