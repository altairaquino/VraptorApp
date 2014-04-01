<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
	<title>Menu</title>	
</head>
<body>

	<div data-role="header" data-theme="a" data-position="fixed">
		<a href="${pageContext.request.contextPath}/relatorio" class="ui-btn-left ui-btn ui-btn-b ui-btn-inline ui-mini ui-corner-all ui-btn-icon-left ui-icon-back">Relatórios</a>
        <h1>Relatórios de Vendas</h1>
        <a href="${pageContext.request.contextPath}/logoff" class="ui-btn-right ui-btn ui-btn-b ui-btn-inline ui-mini ui-corner-all ui-btn-icon-right ui-icon-check">Sair</a>
     </div>
     <br>
     <form action="${pageContext.request.contextPath}/relatorio/vendas" method="post">
     	<label for="select-choice-a" class="select">Loja:</label>
		<select name="select-choice-a" id="select-choice-a" data-native-menu="false">
		    <option>Escolha a loja</option>
		    <option value="standard">Loja 01</option>
		    <option value="standard">Loja 02</option>
		    <option value="rush">Estoque Central</option>
		</select>
		<label for="data-relatorio" class="select">Data:</label>
		<input type="text" name="data-relatorio" data-role="date">
		<button type="submit" class="ui-btn ui-btn-b ui-shadow ui-corner-all ui-btn-icon-right ui-icon-action">
			OK
		</button>
		
     </form>

	<table data-role="table" id="table-column-toggle"
		data-mode="columntoggle" class="ui-responsive table-stroke">
		<thead>
			<tr>
				<th>Vendedor</th>
				<th>Cliente</th>
				<th>Produto</th>
				<th>Quant.</th>
				<th>Valor</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>DAvid</th>
				<td>Consumidor Final</td>
				<td>Produto 01</td>
				<td>2</td>
				<td>R$ 10,00</td>
			</tr>
			<tr>
				<th>DAvid</th>
				<td>Consumidor Final</td>
				<td>Produto 03</td>
				<td>4</td>
				<td>R$ 50,00</td>
			</tr>
		</tbody>
	</table>

</body>