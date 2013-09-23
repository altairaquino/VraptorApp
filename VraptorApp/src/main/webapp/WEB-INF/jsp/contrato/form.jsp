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
					Nome:<br/>
					<input type="text" name="contrato.nome" value="${contrato.nome}" maxlength="40" class="input-medium span8" placeholder="Nome"/>
					<input type="text" name="contrato.cpf" value="${contrato.cpf}" maxlength="11" class="input-medium span3" placeholder="CPF"/>
				</div>
				<div class="controls controls-row">
					Contatos:<br/>
					<input type="text" name="contrato.email" value="${contrato.email}" maxlength="60" class="input-medium span8" placeholder="E-mail"/>
					<input type="text" name="contrato.fone" value="${contrato.fone}" maxlength="10" class="input-medium span3" placeholder="Fone"/>
				</div>
				<div class="controls controls-row">
					Endereço:<br/>
					<input type="text" name="contrato.logradouro" value="${contrato.logradouro}" maxlength="60" class="input-medium span8" placeholder="Logradouro"/>
					<input type="text" name="contrato.numeroLogradouro" value="${contrato.numeroLogradouro}" maxlength="10" class="input-medium span3" placeholder="Número"/>
				</div>
				<div class="controls controls-row">
					<input type="text" name="contrato.bairro" value="${contrato.bairro}" maxlength="60"   class="input-medium span4" placeholder="Bairro"/>
					<input type="text" name="contrato.cidade" value="${contrato.cidade}" maxlength="50"  class="input-medium span5" placeholder="Cidade"/>
					<input type="text" name="contrato.estado" value="${contrato.estado}" maxlength="2"  class="input-medium span2" style="text-transform: uppercase;" placeholder="UF"/>
				</div>				
				
			  	<div class="actions">
					<button class="btn btn-primary" type="submit">Salvar</button>
				</div>
			</form>

<a href="${pageContext.request.contextPath}/contrato">Voltar</a>
