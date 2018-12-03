<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<c:import url="header.jsp" />

<body>
	<!-- Barra superior com os menus de navegação -->
	<c:import url="navbar.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container mt-4">
		<h3 class="page-header">Incluir Jogador</h3>
		<!-- Formulario para inclusao de clientes -->
		<form action="inserir_jogador" method="post">
			<!-- area de campos do form -->
			<div class="row">
				<div class="form-group col-md-4">
					<label for="categoria">Categoria</label> <select
						class="form-control" name="categoria.id" id="categoria">
						<c:forEach var="categoria" items="${categorias}">
							<option value="${categoria.id}">${categoria.nome}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-8">
					<label for="nome">Nome</label> <input type="text"
						class="form-control" name="nome" id="nome" required
						maxlength="100">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="cpf">CPF</label> <input type="text"
						class="form-control" name="cpf" id="cpf"
						maxlength="60">
				</div>
				<div class="form-group col-md-6">
					<label for="telefone">Telefone</label> <input type="text"
						class="form-control" name="telefone" id="telefone"
						required maxlength="100">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label for="endereco">Endereço</label> <input type="text"
						class="form-control" name="endereco" id="endereco"
						required maxlength="100">
				</div>
				
			</div>
			<div class="row">
				<div class="form-group col-md-4">
					<label for="data_nascimento">Data Nascimento</label> <input type="text"
						class="form-control" name="data_nascimento" id="data_nascimento"
						required maxlength="100" placeholder="dd/MM/yyyy">
				</div>
				<div class="form-group col-md-4">
					<label for="altura">Altura</label> <input type="text"
						class="form-control" name="altura" id="altura"
						required maxlength="100">
				</div>
				<div class="form-group col-md-4">
					<label for="peso">Peso</label> <input type="text"
						class="form-control" name="peso" id="peso"
						required maxlength="100">
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