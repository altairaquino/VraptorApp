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
	<h1>Lista de Clientes</h1>

	<table class="table table-condensed table-striped table-bordered" id="data-table">
		<thead>
			<tr>
				<th>id</th>
				<th>Nome</th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${clienteList}" var="cliente">
				<tr>
					<td>${cliente.id}</td>
					<td>${cliente.nome}</td>
					<td><a href="${pageContext.request.contextPath}/cliente/${cliente.id}">show</a></td>
					<td><a href="${pageContext.request.contextPath}/cliente/${cliente.id}/edit">edit</a></td>
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

	<a class="btn btn-primary" href="#modal-content" onclick="showModal()">Novo Cliente</a>
	
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
			
			<form action="${pageContext.request.contextPath}/clientes" method="post">
			  
				<c:if test="${not empty product.id}">
					<input type="hidden" name="product.id" value="${cliente.id}"/>
					<input type="hidden" name="_method" value="put"/>
				</c:if>
				
				<div class="field">
					Nome:<br />
					<input type="text" name="cliente.nome" value="${cliente.nome}"/>
				</div>
				
				
			  	<div class="actions">
					<button class="btn btn-primary" type="submit">save</button>
				</div>
			</form>
			<!-- fim do conteudo do modal -->	
		</div>
		<div class="modal-footer">
			<a href="#" class="btn" data-dismiss="modal" aria-hidden="true"> Cancel </a> 
		</div>
	</div>	

</body>