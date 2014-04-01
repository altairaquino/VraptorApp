<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
	<title>Menu</title>
	
</head>
<body>

	<div data-role="header" data-theme="a">
         <h1>Menu - StockMobile</h1>
         <a href="${pageContext.request.contextPath}/logoff" class="ui-btn-right ui-btn ui-btn-b ui-btn-inline ui-mini ui-corner-all ui-btn-icon-right ui-icon-check">Sair</a>
     </div>
     
     <div class="ui-grid-b">
     	<div class="ui-input-btn ui-btn ui-icon-edit ui-btn-icon-top">
            Vendas
            <input type="button" data-enhanced="true">
        </div>
        <div class="ui-input-btn ui-btn ui-icon-calendar ui-btn-icon-top">
            Relatórios
            <input type="button" data-enhanced="true" onclick="window.location = '${pageContext.request.contextPath}/relatorio'">
        </div>
        <div class="ui-input-btn ui-btn ui-icon-heart ui-btn-icon-top">
            Caixa
            <input type="button" data-enhanced="true">
        </div>
        <div class="ui-input-btn ui-btn ui-icon-grid ui-btn-icon-top">
            Consulta Estoque
            <input type="button" data-enhanced="true">
        </div>
        <div class="ui-input-btn ui-btn ui-icon-delete ui-btn-icon-top">
            Sair do Sistema
            <input type="button" data-enhanced="true" onclick="window.location = '${pageContext.request.contextPath}/logoff'">
        </div>
     </div>               
	 
</body>