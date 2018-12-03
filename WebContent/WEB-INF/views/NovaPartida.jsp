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
		<h3 class="page-header">Incluir Partida</h3>
		<!-- Formulario para inclusao de clientes -->
		<form action="inserir_partida" method="post">
			<!-- area de campos do form -->
			<div class="row">
				<div class="form-group col-md-3">
					<label for="campeonato">Campeonato</label> <select
						class="form-control" name="campeonato.id" id="campeonato">
						<c:forEach var="campeonato" items="${campeonatos}">
							<option value="${campeonato.id}">${campeonato.nome}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="turno">Turno</label> <select class="form-control"
						name="turno.id" id="turno">
						<c:forEach var="turno" items="${turnos}">
							<option value="${turno.id}">${turno.nome}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="dataInicio">Data</label> <input type="text"
						class="form-control" name="dataInicio" id="dataInicio"
						required maxlength="100" placeholder="dd/MM/yyyy">
				</div>
				<div class="form-group col-md-3">
					<label for="hora_inicio">Horário</label> <input type="text"
						class="form-control" name="horaInicio" id="hora_inicio"
						required maxlength="100">
				</div>
				
			</div>
			<div class="row">
				
				
				<div class="form-group col-md-6">
					<label for="local">Local</label> <select class="form-control"
						name="local.id" id="local">
						<c:forEach var="local" items="${locais}">
							<option value="${local.id}">${local.nome}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-6">
					<label for="arbitro">Árbitro</label> <select class="form-control"
						name="arbitro.id" id="arbitro">
						<c:forEach var="arbitro" items="${arbitros}">
							<option value="${arbitro.id}">${arbitro.nome}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<hr />
			<h3>Mandante Titulares</h3>
			<div class="row">
				<div class="form-group col-md-12">
					<label for="qtnTimes">Equipe</label> <select class="form-control"
						name="mandante.equipe.id" id="equipe">
						<c:forEach var="equipe" items="${equipes}">
							<option value="${equipe.id}">${equipe.nome}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<label for="goleiro">Titular 1</label> <select class="form-control"
						name="mandante.goleiro.id" id="goleiro">
						<c:forEach var="jogador" items="${jogadores}">
							<option value="${jogador.id}">${jogador.nome}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="le">Titular 2</label> <select
						class="form-control" name="mandante.lateralEsquerdo.id"
						id="goleiro">
						<c:forEach var="jogador" items="${jogadores}">
							<option value="${jogador.id}">${jogador.nome}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="zagueiro1">Titular 3</label> <select
						class="form-control" name="mandante.zagueiro1.id" id="zagueiro1">
						<c:forEach var="jogador" items="${jogadores}">
							<option value="${jogador.id}">${jogador.nome}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="zagueiro2">Titular 4</label> <select
						class="form-control" name="mandante.zagueiro2.id" id="zagueiro2">
						<c:forEach var="jogador" items="${jogadores}">
							<option value="${jogador.id}">${jogador.nome}</option>
						</c:forEach>
					</select>
				</div>

			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<label for="ld">Titular 5</label> <select
						class="form-control" name="mandante.lateralDireito.id"
						id="goleiro">
						<c:forEach var="jogador" items="${jogadores}">
							<option value="${jogador.id}">${jogador.nome}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="volante">Titular 6</label> <select class="form-control"
						name="mandante.volante.id" id="volante">
						<c:forEach var="jogador" items="${jogadores}">
							<option value="${jogador.id}">${jogador.nome}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="meioCampo1">Titular 7</label> <select
						class="form-control" name="mandante.meioCampo1.id" id="meioCampo1">
						<c:forEach var="jogador" items="${jogadores}">
							<option value="${jogador.id}">${jogador.nome}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="meioCampo2">Titular 8</label> <select
						class="form-control" name="mandante.meioCampo2.id" id="meioCampo2">
						<c:forEach var="jogador" items="${jogadores}">
							<option value="${jogador.id}">${jogador.nome}</option>
						</c:forEach>
					</select>
				</div>

			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<label for="pontaEsquerda">Titular 9</label> <select
						class="form-control" name="mandante.pontaEsquerda.id"
						id="pontaEsquerda">
						<c:forEach var="jogador" items="${jogadores}">
							<option value="${jogador.id}">${jogador.nome}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="atacante">Titular 10</label> <select
						class="form-control" name="mandante.atacante.id" id="goleiro">
						<c:forEach var="jogador" items="${jogadores}">
							<option value="${jogador.id}">${jogador.nome}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="pontaDireito">Titular 11</label> <select
						class="form-control" name="mandante.pontaDireita.id" id="goleiro">
						<c:forEach var="jogador" items="${jogadores}">
							<option value="${jogador.id}">${jogador.nome}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<hr />
			<h3>Visitante Titulares</h3>
			<div class="row">
				<div class="form-group col-md-12">
					<label for="qtnTimes">Equipe</label> <select class="form-control"
						name="visitante.equipe.id" id="equipe">
						<c:forEach var="equipe" items="${equipes}">
							<option value="${equipe.id}">${equipe.nome}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<label for="goleiro">Titular 1</label> <select class="form-control"
						name="visitante.goleiro.id" id="goleiro">
						<c:forEach var="jogador" items="${jogadores}">
							<option value="${jogador.id}">${jogador.nome}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="le">Titular 2</label> <select
						class="form-control" name="visitante.lateralEsquerdo.id"
						id="goleiro">
						<c:forEach var="jogador" items="${jogadores}">
							<option value="${jogador.id}">${jogador.nome}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="zagueiro1">Titular 3</label> <select
						class="form-control" name="visitante.zagueiro1.id" id="zagueiro1">
						<c:forEach var="jogador" items="${jogadores}">
							<option value="${jogador.id}">${jogador.nome}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="zagueiro2">Titular 4</label> <select
						class="form-control" name="visitante.zagueiro2.id" id="zagueiro2">
						<c:forEach var="jogador" items="${jogadores}">
							<option value="${jogador.id}">${jogador.nome}</option>
						</c:forEach>
					</select>
				</div>

			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<label for="ld">Titular 5</label> <select
						class="form-control" name="visitante.lateralDireito.id"
						id="goleiro">
						<c:forEach var="jogador" items="${jogadores}">
							<option value="${jogador.id}">${jogador.nome}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="volante">Titular 6</label> <select class="form-control"
						name="visitante.volante.id" id="volante">
						<c:forEach var="jogador" items="${jogadores}">
							<option value="${jogador.id}">${jogador.nome}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="meioCampo1">Titular 7</label> <select
						class="form-control" name="visitante.meioCampo1.id" id="meioCampo1">
						<c:forEach var="jogador" items="${jogadores}">
							<option value="${jogador.id}">${jogador.nome}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="meioCampo2">Titular 8</label> <select
						class="form-control" name="visitante.meioCampo2.id" id="meioCampo2">
						<c:forEach var="jogador" items="${jogadores}">
							<option value="${jogador.id}">${jogador.nome}</option>
						</c:forEach>
					</select>
				</div>

			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<label for="pontaEsquerda">Titular 9</label> <select
						class="form-control" name="visitante.pontaEsquerda.id"
						id="pontaEsquerda">
						<c:forEach var="jogador" items="${jogadores}">
							<option value="${jogador.id}">${jogador.nome}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="atacante">Titular 10</label> <select
						class="form-control" name="visitante.atacante.id" id="goleiro">
						<c:forEach var="jogador" items="${jogadores}">
							<option value="${jogador.id}">${jogador.nome}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="pontaDireito">Titular 11</label> <select
						class="form-control" name="visitante.pontaDireita.id" id="goleiro">
						<c:forEach var="jogador" items="${jogadores}">
							<option value="${jogador.id}">${jogador.nome}</option>
						</c:forEach>
					</select>
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