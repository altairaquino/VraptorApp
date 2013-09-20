<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
					Endereço:<br/>
					<input type="text" name="cliente.logradouro" value="${cliente.logradouro}" maxlength="60" class="input-medium span8" placeholder="Logradouro"/>
					<input type="text" name="cliente.numeroLogradouro" value="${cliente.numeroLogradouro}" maxlength="10" class="input-medium span3" placeholder="Número"/>
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

<a href="${pageContext.request.contextPath}/cliente">Voltar</a>
