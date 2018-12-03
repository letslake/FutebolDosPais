<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<c:import url="header.jsp" />

<body>
	<!-- Barra superior com os menus de navegação -->
	<c:import url="navbar.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container mt-4">
		<h3 class="page-header">Incluir Jogador</h3>
		<!-- Formulario para inclusao de clientes -->
		<form action="atualizar_jogador" method="post">
			<input type="hidden" name="id" value="${jogador.id}">
			<!-- area de campos do form -->
			<div class="row">
				<div class="form-group col-md-4">
					<label for="categoria">Categoria</label> <select
						class="form-control" name="categoria.id" id="categoria">
						<c:forEach var="categoria" items="${categorias}">
							<c:if test="${categoria.id != jogador.categoria.id}">
								<option value="${categoria.id}">${categoria.nome}</option>
							</c:if>
							<c:if test="${categoria.id == jogador.categoria.id}">
								<option value="${categoria.id}" selected>${categoria.nome}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-8">
					<label for="nome">Nome</label> <input type="text"
						class="form-control" name="nome" id="nome" required
						maxlength="100" value="${jogador.nome }">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="cpf">CPF</label> <input type="text"
						class="form-control" name="cpf" id="cpf"
						maxlength="60" value="${jogador.cpf }">
				</div>
				<div class="form-group col-md-6">
					<label for="telefone">Telefone</label> <input type="text"
						class="form-control" name="telefone" id="telefone"
						required maxlength="100" value=${jogador.telefone }>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label for="endereco">Endereço</label> <input type="text"
						class="form-control" name="endereco" id="endereco"
						required maxlength="100" value="${jogador.endereco }">
				</div>
				
			</div>
			<div class="row">
				<div class="form-group col-md-4">
					<label for="data_nascimento">Data Nascimento</label> <input type="text"
						class="form-control" name="data_nascimento" id="data_nascimento"
						required maxlength="100" placeholder="dd/MM/yyyy" value="<fmt:formatDate value="${jogador.data_nascimento}" pattern="dd/MM/yyyy"/>">
				</div>
				<div class="form-group col-md-4">
					<label for="altura">Altura</label> <input type="text"
						class="form-control" name="altura" id="altura"
						required maxlength="100" value="${jogador.altura }">
				</div>
				<div class="form-group col-md-4">
					<label for="peso">Peso</label> <input type="text"
						class="form-control" name="peso" id="peso"
						required maxlength="100" value="${jogador.peso }">
				</div>
				
			</div>
			
			<hr />
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-success">Salvar</button>
					<a href="/inicio" class="btn btn-light">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
	<c:import url="footer.jsp" />