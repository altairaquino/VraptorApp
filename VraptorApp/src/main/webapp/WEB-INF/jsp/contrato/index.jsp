<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
	<title>Contratos</title>
	
	<script>
		function showModal() {
		    $('#modal-content').modal('show');
		    $('#modal-content').on('shown', function() {
		        $("#txtname").focus();
		    })
		};

	    $(function () {
	        $("#confirmButton").click(function () {
	            openConfirmModal();
	        });
	        function openConfirmModal() {
	            $("#confirmDiv").confirmModal({
	                heading: 'Are you sure?',
	                body: 'click on confirm button to destroy this contrato',
	                callback: function () {
	                    $('#destroy-form').submit();
	                }
	            });
	        }
	    });
	    
	    $(document).ready(function() {
			$('#data-table').dataTable();
		});
	    
    </script>
</head>
<body>
	<h3>Relação de Contratos</h3>

	<table class="table table-condensed table-striped table-bordered" id="data-table">
		<thead>
			<tr>
				<th>Código</th>
				<th>Cliente</th>
				<th>Lote</th>
				<th>Valor</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contratoList}" var="contrato">
				<tr>
					<td>${contrato.id}</td>
					<td>${contrato.cliente.nome}</td>
					<td>${contrato.lote.nome}</td>
					<td>${contrato.valor}</td>					
					<td>
						<a href="${pageContext.request.contextPath}/contrato/${contrato.id}"><img class="icon-eye-open" border="0"> show</a>
						<a href="${pageContext.request.contextPath}/contrato/${contrato.id}/edit"><img class="icon-edit" border="0"> edit</a>
					</td>					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div id="confirmDiv"></div>

	<br />

	<a class="btn btn-primary" href="#modal-content" onclick="showModal()"><img class="icon-plus-sign"> Novo Contrato</a>
	
	<!-- div de cadastro de novo produto -->
	<div class="modal hide fade" id="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h3>Novo Contrato</h3>
		</div>
		<div class="modal-body">
		<!-- inicio do conteudo do modal -->			
			<c:if test="${not empty errors}">
				<c:forEach items="${errors}" var="error">
					${error.category} - ${error.message}<br/>
				</c:forEach>
			</c:if>
			
			<form action="${pageContext.request.contextPath}/contrato" method="post">
			  
				<c:if test="${not empty contrato.id}">
					<input type="hidden" name="contrato.id" value="${contrato.id}"/>
					<input type="hidden" name="_method" value="put"/>
				</c:if>
				
				<div class="controls controls-row">
					Cliente:<br/>
					<select name="contrato.cliente.id" class="input-medium span8">
						<c:forEach items="${comboCliente}" var="cliente">
							<option value="${cliente.id}" label="${cliente.nome}">
						</c:forEach>
					</select>
				</div>
				<div class="controls controls-row">
					Lote:<br/>
					<select name="contrato.lote.id" class="input-medium span8">
						<c:forEach items="${comboLote}" var="lote">
							<option value="${lote.id}" label="${lote.nome}">
						</c:forEach>		
					</select>
				</div>
				<div class="controls controls-row">
					Forma de Pagamento:<br/>
					<select name="contrato.formaPagamento.id" class="input-medium span8">
						<c:forEach items="${comboFormaPagamento}" var="formaPagamento">
							<option value="${formaPagamento.id}" label="${formaPagamento.nome}">
						</c:forEach>
					</select>
					<select name="contrato.quantidadeParcelas">
						<option value="12" label="12 parcelas">
						<option value="24" label="24 parcelas">
						<option value="36" label="36 parcelas">
						<option value="48" label="48 parcelas">
					</select>
				</div>
				<div class="controls controls-row">
					Valor:<br/>
					<input type="text" name="contrato.valor" value="${contrato.valor}" maxlength="60" class="input-medium span8" placeholder="Valor"/>
				</div>
				
			  	<div class="actions">
					<button class="btn btn-primary" type="submit">Salvar</button>
				</div>
			</form>
			<!-- fim do conteudo do modal -->	
		</div>
		<div class="modal-footer">
			<a href="#" class="btn btn-danger" data-dismiss="modal" aria-hidden="true">Cancelar</a> 
		</div>
	</div>	

</body>