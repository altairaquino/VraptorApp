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
					<td>${contrato.valorTotal}</td>					
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
			<%@include file="form.jsp"%>
			<!-- fim do conteudo do modal -->	
		</div>
		<div class="modal-footer">
			<a href="#" class="btn btn-danger" data-dismiss="modal" aria-hidden="true">Cancelar</a> 
		</div>
	</div>	

</body>