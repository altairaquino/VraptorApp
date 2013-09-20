<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
	<title>Clientes</title>
	
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
	                body: 'click on confirm button to destroy this cliente',
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
	<h3>Rela��o de Clientes</h3>

	<table class="table table-condensed table-striped table-bordered" id="data-table">
		<thead>
			<tr>
				<th>C�digo</th>
				<th>Nome</th>
				<th>CPF</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${clienteList}" var="cliente">
				<tr>
					<td>${cliente.id}</td>
					<td>${cliente.nome}</td>
					<td>${cliente.cpf}</td>
					<td>
						<a href="${pageContext.request.contextPath}/cliente/${cliente.id}"><img class="icon-eye-open" border="0"> show</a>
						<a href="${pageContext.request.contextPath}/cliente/${cliente.id}/edit"><img class="icon-edit" border="0"> edit</a>
					</td>
					<td>
						<!-- 
						<form id="destroy-form" action="${pageContext.request.contextPath}/products/${product.id}" method="post">
							<input type="hidden" name="_method" value="delete"/>
							<button id="confirmButton" type="button">destroy</button>
						</form>
						 -->
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div id="confirmDiv"></div>

	<br />

	<a class="btn btn-primary" href="#modal-content" onclick="showModal()"><img class="icon-plus-sign"> Novo Cliente</a>
	
	<!-- div de cadastro de novo produto -->
	<div class="modal hide fade" id="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h3>Novo Cliente</h3>
		</div>
		<div class="modal-body">
		<!-- inicio do conteudo do modal -->			
			<c:if test="${not empty errors}">
				<c:forEach items="${errors}" var="error">
					${error.category} - ${error.message}<br/>
				</c:forEach>
			</c:if>
			
			<form action="${pageContext.request.contextPath}/cliente" method="post">
			  
				<c:if test="${not empty cliente.id}">
					<input type="hidden" name="cliente.id" value="${cliente.id}"/>
					<input type="hidden" name="_method" value="put"/>
				</c:if>
				
				<div class="controls controls-row">
					Nome:<br/>
					<input type="text" name="cliente.nome" value="${cliente.nome}" maxlength="40" class="input-medium span8" placeholder="Nome"/>
					<input type="text" name="cliente.cpf" value="${cliente.cpf}" maxlength="11" class="input-medium span3" placeholder="CPF"/>
				</div>
				<div class="controls controls-row">
					Contatos:<br/>
					<input type="text" name="cliente.email" value="${cliente.email}" maxlength="60" class="input-medium span8" placeholder="E-mail"/>
					<input type="text" name="cliente.fone" value="${cliente.fone}" maxlength="10" class="input-medium span3" placeholder="Fone"/>
				</div>
				<div class="controls controls-row">
					Endere�o:<br/>
					<input type="text" name="cliente.logradouro" value="${cliente.logradouro}" maxlength="60" class="input-medium span8" placeholder="Logradouro"/>
					<input type="text" name="cliente.numeroLogradouro" value="${cliente.numeroLogradouro}" maxlength="10" class="input-medium span3" placeholder="N�mero"/>
				</div>
				<div class="controls controls-row">
					<input type="text" name="cliente.bairro" value="${cliente.bairro}" maxlength="60"   class="input-medium span4" placeholder="Bairro"/>
					<input type="text" name="cliente.cidade" value="${cliente.cidade}" maxlength="50"  class="input-medium span5" placeholder="Cidade"/>
					<input type="text" name="cliente.estado" value="${cliente.estado}" maxlength="2"  class="input-medium span2" style="text-transform: uppercase;" placeholder="UF"/>
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