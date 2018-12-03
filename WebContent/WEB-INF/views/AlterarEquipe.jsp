<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<c:import url="header.jsp" />

<body>
	<!-- Barra superior com os menus de navegação -->
	<c:import url="navbar.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container mt-4">
		<h3 class="page-header">Atualizar Equipe - ${equipe.id }</h3>
		<!-- Formulario para inclusao de clientes -->
		<form action="atualizar_equipe" method="post">
			<!-- area de campos do form -->
			<input type="hidden" name="id" value="${equipe.id}"> <input
				type="hidden" name="tecnico.id" value="${equipe.tecnico.id}">
			<input type="hidden" name="coordenador.id"
				value="${equipe.coordenador.id}">
			<div class="row">
				<div class="form-group col-md-4">
					<label for="categoria">Categoria</label> <select
						class="form-control" name="categoria.id" id="categoria">
						<c:forEach var="categoria" items="${categorias}">
							<c:if test="${categoria.id != campeonato.categoria.id}">
								<option value="${categoria.id}">${categoria.nome}</option>
							</c:if>
							<c:if test="${categoria.id == campeonato.categoria.id}">
								<option value="${categoria.id}" selected>${categoria.nome}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-8">
					<label for="nome">Nome Equipe</label> <input type="text"
						class="form-control" name="nome" id="nome" required
						maxlength="100" value="${equipe.nome }">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="bandeira">Logotipo</label> <input type="text"
						class="form-control" name="bandeira" id="bandeira" maxlength="100"
						placeholder="Caminho para o arquivo" value="${equipe.bandeira }">
				</div>
				<div class="form-group col-md-6">
					<label for="uniformeCasa">Primeiro uniforme</label> <input
						type="text" class="form-control" name="uniforme_casa"
						id="uniformeCasa" maxlength="100"
						placeholder="Caminho para o arquivo" value="${equipe.uniforme_casa }">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="uniformeFora">Segundo uniforme</label> <input
						type="text" class="form-control" name="uniforme_fora"
						id="uniformeFora" maxlength="100"
						placeholder="Caminho para o arquivo"  value="${equipe.uniforme_fora }">
				</div>
				<div class="form-group col-md-6">
					<label for="terceiro_uniforme">Terceiro uniforme</label> <input
						type="text" class="form-control" name="terceiro_uniforme"
						id="terceiro_uniforme" maxlength="100"
						placeholder="Caminho para o arquivo"  value="${equipe.terceiro_uniforme }">
				</div>
			</div>
			<hr />
			<h3>Técnico</h3>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="tecnicoNome">Nome</label> <input type="text"
						class="form-control" name="tecnico.nome" id="tecnicoNome" required
						maxlength="100"  value="${equipe.tecnico.nome }">
				</div>
				<div class="form-group col-md-6">
					<label for="cpfTecnico">CPF</label> <input type="text"
						class="form-control" name="tecnico.cpf" id="cpfTecnico"
						maxlength="60" value="${equipe.tecnico.cpf }">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="endereco">Endereço</label> <input type="text"
						class="form-control" name="tecnico.endereco" id="enderecoTecnico"
						required maxlength="100" value="${equipe.tecnico.endereco }">
				</div>
				<div class="form-group col-md-6">
					<label for="telefoneTecnico">Telefone</label> <input type="text"
						class="form-control" name="tecnico.telefone" id="telefoneTecnico"
						required maxlength="100" value="${equipe.tecnico.telefone }">
				</div>
			</div>
			<hr />
			<h3>Coordenador</h3>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="coordenadorNome">Nome</label> <input type="text"
						class="form-control" name="coordenador.nome" id="coordenadorNome"
						required maxlength="100" value="${equipe.coordenador.nome }">
				</div>
				<div class="form-group col-md-6">
					<label for="cpfCoordenador">CPF</label> <input type="text"
						class="form-control" name="coordenador.cpf" id="cpfCoordenador"
						maxlength="60" value="${equipe.coordenador.cpf }">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="enderecoCoordenador">Endereço</label> <input
						type="text" class="form-control" name="coordenador.endereco"
						id="enderecoCoordenador" required maxlength="100" value="${equipe.coordenador.endereco }">
				</div>
				<div class="form-group col-md-6">
					<label for="telefoneCoordenador">Telefone</label> <input
						type="text" class="form-control" name="coordenador.telefone"
						id="telefoneCoordenador" required maxlength="100" value="${equipe.coordenador.telefone }">
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