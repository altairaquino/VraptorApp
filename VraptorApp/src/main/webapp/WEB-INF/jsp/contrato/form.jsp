<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
							<option value="${cliente.id}" label="${cliente.nome}" ${contrato.cliente.id eq cliente.id ? 'selected' : '' }>
						</c:forEach>
					</select>
				</div>
				<div class="controls controls-row">
					Lote:<br/>
					<select name="contrato.lote.id" class="input-medium span8">
						<c:forEach items="${comboLote}" var="lote">
							<option value="${lote.id}" label="${lote.nome}" ${contrato.lote.id eq lote.id ? 'selected' : '' }>
						</c:forEach>		
					</select>
				</div>
				<div class="controls controls-row">
					Forma de Pagamento:<br/>
					<select name="contrato.formaPagamento.id" class="input-medium span6">
						<c:forEach items="${comboFormaPagamento}" var="formaPagamento">
							<option value="${formaPagamento.id}" label="${formaPagamento.nome}" ${contrato.formaPagamento.id eq formaPagamento.id ? 'selected' : '' }>
						</c:forEach>
					</select>
					<select name="contrato.quantidadeParcelas" class="span2">
						<option value="12" label="12 parcelas">
						<option value="24" label="24 parcelas">
						<option value="36" label="36 parcelas">
						<option value="48" label="48 parcelas">
					</select>
				</div>
				<div class="controls controls-row">
					Valor:<br/>
					<input type="text" name="contrato.valorTotal" value="${contrato.valorTotal}" maxlength="60" class="input-medium span8" placeholder="Valor"/>
				</div>
				
			  	<div class="actions">
					<button class="btn btn-primary" type="submit">Salvar</button>
				</div>
			</form>
