<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

			<c:if test="${not empty errors}">
				<c:forEach items="${errors}" var="error">
					${error.category} - ${error.message}<br/>
				</c:forEach>
			</c:if>
			
			<form action="${pageContext.request.contextPath}/lote" method="post">
			  
				<c:if test="${not empty lote.id}">
					<input type="hidden" name="lote.id" value="${lote.id}"/>
					<input type="hidden" name="_method" value="put"/>
				</c:if>
				
				<div class="controls controls-row">
					Loteamento:<br/>
					<select name="lote.loteamento.id" class="input-medium span8">
						<c:forEach items="${comboLoteamento}" var="loteamento">
							<option value="${loteamento.id}" label="${loteamento.nome}" ${lote.loteamento.id eq loteamento.id ? 'selected' : '' }>
						</c:forEach>
					</select>
				</div>
				<div class="controls controls-row">
					Nome:<br/>
					<input type="text" name="lote.nome" value="${lote.nome}" maxlength="60" class="input-medium span8" placeholder="Nome"/>
				</div>
				
			  	<div class="actions">
					<button class="btn btn-primary" type="submit">Salvar</button>
				</div>
			</form>
