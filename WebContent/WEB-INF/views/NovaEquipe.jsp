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
		<h3 class="page-header">Incluir Campeonato</h3>
		<!-- Formulario para inclusao de clientes -->
		<form action="inserir_equipe" method="post">
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
					<label for="nome">Nome Equipe</label> <input type="text"
						class="form-control" name="nome" id="nome" required
						maxlength="100">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="bandeira">Logotipo</label> <input type="text"
						class="form-control" name="bandeira" id="bandeira" maxlength="100"
						placeholder="Caminho para o arquivo">
				</div>
				<div class="form-group col-md-6">
					<label for="uniformeCasa">Primeiro uniforme</label> <input
						type="text" class="form-control" name="uniforme_casa"
						id="uniformeCasa" maxlength="100"
						placeholder="Caminho para o arquivo">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="uniformeFora">Segundo uniforme</label> <input
						type="text" class="form-control" name="uniforme_fora"
						id="uniformeFora" maxlength="100"
						placeholder="Caminho para o arquivo">
				</div>
				<div class="form-group col-md-6">
					<label for="terceiro_uniforme">Terceiro uniforme</label> <input
						type="text" class="form-control" name="terceiro_uniforme"
						id="terceiro_uniforme" maxlength="100"
						placeholder="Caminho para o arquivo">
				</div>
			</div>
			<hr />
			<h3>Técnico</h3>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="tecnicoNome">Nome</label> <input type="text"
						class="form-control" name="tecnico.nome" id="tecnicoNome" required
						maxlength="100">
				</div>
				<div class="form-group col-md-6">
					<label for="cpfTecnico">CPF</label> <input type="text"
						class="form-control" name="tecnico.cpf" id="cpfTecnico"
						maxlength="60">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="endereco">Endereço</label> <input type="text"
						class="form-control" name="tecnico.endereco" id="enderecoTecnico"
						required maxlength="100">
				</div>
				<div class="form-group col-md-6">
					<label for="telefoneTecnico">Telefone</label> <input type="text"
						class="form-control" name="tecnico.telefone" id="telefoneTecnico"
						required maxlength="100">
				</div>
			</div>
			<hr />
			<h3>Coordenador</h3>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="coordenadorNome">Nome</label> <input type="text"
						class="form-control" name="coordenador.nome" id="coordenadorNome"
						required maxlength="100">
				</div>
				<div class="form-group col-md-6">
					<label for="cpfCoordenador">CPF</label> <input type="text"
						class="form-control" name="coordenador.cpf" id="cpfCoordenador"
						maxlength="60">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="enderecoCoordenador">Endereço</label> <input
						type="text" class="form-control" name="coordenador.endereco"
						id="enderecoCoordenador" required maxlength="100">
				</div>
				<div class="form-group col-md-6">
					<label for="telefoneCoordenador">Telefone</label> <input
						type="text" class="form-control" name="coordenador.telefone"
						id="telefoneCoordenador" required maxlength="100">
				</div>
			</div>
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-success">Salvar</button>
					<a href="/inicio" class="btn btn-light">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
	<c:import url="footer.jsp" />