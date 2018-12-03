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
		<h3 class="page-header">Atualizando Partida - ${ partida.id }</h3>
		<!-- Formulario para inclusao de clientes -->
		<form action="atualizar_partida" method="post">
			<input type="hidden" name="id" value="${partida.id}"> <input
				type="hidden" name="mandante.id" value="${partida.mandante.id}">
			<input type="hidden" name="visitante.id"
				value="${partida.visitante.id}"> <input type="hidden"
				name="local.id" value="${partida.local.id}"> <input
				type="hidden" name="arbitro.id" value="${partida.arbitro.id}">
			<input type="hidden" name="campeonato.id"
				value="${partida.campeonato.id}"> <input type="hidden"
				name="turno.id" value="${partida.turno.id}">
			<!-- area de campos do form -->
			<div class="row">
				<div class="form-group col-md-3">
					<label for="campeonato">Campeonato</label> <select
						class="form-control" name="campeonato.id" id="campeonato">
						<c:forEach var="campeonato" items="${campeonatos}">
							<c:if test="${campeonato.id != partida.campeonato.id}">
								<option value="${campeonato.id}">${campeonato.nome}</option>
							</c:if>
							<c:if test="${campeonato.id == partida.campeonato.id}">
								<option value="${campeonato.id}" selected>${campeonato.nome}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="turno">Turno</label> <select class="form-control"
						name="turno.id" id="turno">
						<c:forEach var="turno" items="${turnos}">
							<c:if test="${turno.id != partida.turno.id}">
								<option value="${turno.id}">${turno.nome}</option>
							</c:if>
							<c:if test="${turno.id == partida.turno.id}">
								<option value="${turno.id}" selected>${turno.nome}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="dataInicio">Data</label> <input type="text"
						class="form-control" name="dataInicio" id="dataInicio" required
						maxlength="100" placeholder="dd/MM/yyyy"
						value="<fmt:formatDate value="${partida.dataInicio}" pattern="dd/MM/yyyy"/>">
				</div>
				<div class="form-group col-md-3">
					<label for="hora_inicio">Horário</label> <input type="text"
						class="form-control" name="horaInicio" id="hora_inicio" required
						maxlength="100" value="${partida.horaInicio }">
				</div>

			</div>
			<div class="row">


				<div class="form-group col-md-6">
					<label for="local">Local</label> <select class="form-control"
						name="local.id" id="local">
						<c:forEach var="local" items="${locais}">
							<c:if test="${local.id != partida.local.id}">
								<option value="${local.id}">${local.nome}</option>
							</c:if>
							<c:if test="${local.id == partida.local.id}">
								<option value="${local.id}" selected>${local.nome}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-6">
					<label for="arbitro">Árbitro</label> <select class="form-control"
						name="arbitro.id" id="arbitro">
						<c:forEach var="arbitro" items="${arbitros}">
							<c:if test="${arbitro.id != partida.arbitro.id}">
								<option value="${arbitro.id}">${arbitro.nome}</option>
							</c:if>
							<c:if test="${arbitro.id == partida.arbitro.id}">
								<option value="${arbitro.id}" selected>${arbitro.nome}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
			</div>
			<hr />
			<h3>Mandante</h3>
			<div class="row">
				<div class="form-group col-md-12">
					<label for="qtnTimes">Equipe</label> <select class="form-control"
						name="mandante.equipe.id" id="equipe">
						<c:forEach var="equipe" items="${equipes}">
							<c:if test="${equipe.id != partida.mandante.equipe.id}">
								<option value="${equipe.id}">${equipe.nome}</option>
							</c:if>
							<c:if test="${equipe.id == partida.mandante.equipe.id}">
								<option value="${equipe.id}" selected>${equipe.nome}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<label for="goleiro">Goleiro</label> <select class="form-control"
						name="mandante.goleiro.id" id="goleiro">
						<c:forEach var="jogador" items="${jogadores}">
							<c:if test="${jogador.id != partida.mandante.goleiro.id}">
								<option value="${jogador.id}">${jogador.nome}</option>
							</c:if>
							<c:if test="${jogador.id == partida.mandante.goleiro.id}">
								<option value="${jogador.id}" selected>${jogador.nome}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="le">Lateral Esquerdo</label> <select
						class="form-control" name="mandante.lateralEsquerdo.id"
						id="goleiro">
						<c:forEach var="jogador" items="${jogadores}">
							<c:if test="${jogador.id != partida.mandante.lateralEsquerdo.id}">
								<option value="${jogador.id}">${jogador.nome}</option>
							</c:if>
							<c:if test="${jogador.id == partida.mandante.lateralEsquerdo.id}">
								<option value="${jogador.id}" selected>${jogador.nome}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="zagueiro1">Zagueiro 1</label> <select
						class="form-control" name="mandante.zagueiro1.id" id="zagueiro1">
						<c:forEach var="jogador" items="${jogadores}">
							<c:if test="${jogador.id != partida.mandante.zagueiro1.id}">
								<option value="${jogador.id}">${jogador.nome}</option>
							</c:if>
							<c:if test="${jogador.id == partida.mandante.zagueiro1.id}">
								<option value="${jogador.id}" selected>${jogador.nome}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="zagueiro2">Zagueiro 2</label> <select
						class="form-control" name="mandante.zagueiro2.id" id="zagueiro2">
						<c:forEach var="jogador" items="${jogadores}">
							<c:if test="${jogador.id != partida.mandante.zagueiro2.id}">
								<option value="${jogador.id}">${jogador.nome}</option>
							</c:if>
							<c:if test="${jogador.id == partida.mandante.zagueiro2.id}">
								<option value="${jogador.id}" selected>${jogador.nome}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>

			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<label for="ld">Lateral Direito</label> <select
						class="form-control" name="mandante.lateralDireito.id"
						id="goleiro">
						<c:forEach var="jogador" items="${jogadores}">
							<c:if test="${jogador.id != partida.mandante.lateralDireito.id}">
								<option value="${jogador.id}">${jogador.nome}</option>
							</c:if>
							<c:if test="${jogador.id == partida.mandante.lateralDireito.id}">
								<option value="${jogador.id}" selected>${jogador.nome}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="volante">Volante</label> <select class="form-control"
						name="mandante.volante.id" id="volante">
						<c:forEach var="jogador" items="${jogadores}">
							<c:if test="${jogador.id != partida.mandante.volante.id}">
								<option value="${jogador.id}">${jogador.nome}</option>
							</c:if>
							<c:if test="${jogador.id == partida.mandante.volante.id}">
								<option value="${jogador.id}" selected>${jogador.nome}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="meioCampo1">Meio Campo 1</label> <select
						class="form-control" name="mandante.meioCampo1.id" id="meioCampo1">
						<c:forEach var="jogador" items="${jogadores}">
							<c:if test="${jogador.id != partida.mandante.meioCampo1.id}">
								<option value="${jogador.id}">${jogador.nome}</option>
							</c:if>
							<c:if test="${jogador.id == partida.mandante.meioCampo1.id}">
								<option value="${jogador.id}" selected>${jogador.nome}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="meioCampo2">Meio Campo 2</label> <select
						class="form-control" name="mandante.meioCampo2.id" id="meioCampo2">
						<c:forEach var="jogador" items="${jogadores}">
							<c:if test="${jogador.id != partida.mandante.meioCampo2.id}">
								<option value="${jogador.id}">${jogador.nome}</option>
							</c:if>
							<c:if test="${jogador.id == partida.mandante.meioCampo2.id}">
								<option value="${jogador.id}" selected>${jogador.nome}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>

			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<label for="pontaEsquerda">Ponta Esquerda</label> <select
						class="form-control" name="mandante.pontaEsquerda.id"
						id="pontaEsquerda">
						<c:forEach var="jogador" items="${jogadores}">
							<c:if test="${jogador.id != partida.mandante.pontaEsquerda.id}">
								<option value="${jogador.id}">${jogador.nome}</option>
							</c:if>
							<c:if test="${jogador.id == partida.mandante.pontaEsquerda.id}">
								<option value="${jogador.id}" selected>${jogador.nome}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="atacante">CentroAvante</label> <select
						class="form-control" name="mandante.atacante.id" id="atacante">
						<c:forEach var="jogador" items="${jogadores}">
							<c:if test="${jogador.id != partida.mandante.atacante.id}">
								<option value="${jogador.id}">${jogador.nome}</option>
							</c:if>
							<c:if test="${jogador.id == partida.mandante.atacante.id}">
								<option value="${jogador.id}" selected>${jogador.nome}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="pontaDireito">Ponta Direira</label> <select
						class="form-control" name="mandante.pontaDireita.id"
						id="pontaDireita">
						<c:forEach var="jogador" items="${jogadores}">
							<c:if test="${jogador.id != partida.mandante.pontaDireita.id}">
								<option value="${jogador.id}">${jogador.nome}</option>
							</c:if>
							<c:if test="${jogador.id == partida.mandante.pontaDireita.id}">
								<option value="${jogador.id}" selected>${jogador.nome}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
			</div>
			<hr />
			<h3>Visitante</h3>
			<div class="row">
				<div class="form-group col-md-12">
					<label for="qtnTimes">Equipe</label> <select class="form-control"
						name="visitante.equipe.id" id="equipe">
						<c:forEach var="equipe" items="${equipes}">
							<c:if test="${equipe.id != partida.visitante.equipe.id}">
								<option value="${equipe.id}">${equipe.nome}</option>
							</c:if>
							<c:if test="${equipe.id == partida.visitante.equipe.id}">
								<option value="${equipe.id}" selected>${equipe.nome}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<label for="goleiro">Goleiro</label> <select class="form-control"
						name="visitante.goleiro.id" id="goleiro">
						<c:forEach var="jogador" items="${jogadores}">
							<c:if test="${jogador.id != partida.visitante.goleiro.id}">
								<option value="${jogador.id}">${jogador.nome}</option>
							</c:if>
							<c:if test="${jogador.id == partida.visitante.goleiro.id}">
								<option value="${jogador.id}" selected>${jogador.nome}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="le">Lateral Esquerdo</label> <select
						class="form-control" name="visitante.lateralEsquerdo.id"
						id="goleiro">
						<c:forEach var="jogador" items="${jogadores}">
							<c:if
								test="${jogador.id != partida.visitante.lateralEsquerdo.id}">
								<option value="${jogador.id}">${jogador.nome}</option>
							</c:if>
							<c:if
								test="${jogador.id == partida.visitante.lateralEsquerdo.id}">
								<option value="${jogador.id}" selected>${jogador.nome}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="zagueiro1">Zagueiro 1</label> <select
						class="form-control" name="visitante.zagueiro1.id" id="zagueiro1">
						<c:forEach var="jogador" items="${jogadores}">
							<c:if test="${jogador.id != partida.visitante.zagueiro1.id}">
								<option value="${jogador.id}">${jogador.nome}</option>
							</c:if>
							<c:if test="${jogador.id == partida.visitante.zagueiro1.id}">
								<option value="${jogador.id}" selected>${jogador.nome}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="zagueiro2">Zagueiro 2</label> <select
						class="form-control" name="visitante.zagueiro2.id" id="zagueiro2">
						<c:forEach var="jogador" items="${jogadores}">
							<c:if test="${jogador.id != partida.visitante.zagueiro2.id}">
								<option value="${jogador.id}">${jogador.nome}</option>
							</c:if>
							<c:if test="${jogador.id == partida.visitante.zagueiro2.id}">
								<option value="${jogador.id}" selected>${jogador.nome}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>

			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<label for="ld">Lateral Direito</label> <select
						class="form-control" name="visitante.lateralDireito.id"
						id="goleiro">
						<c:forEach var="jogador" items="${jogadores}">
							<c:if test="${jogador.id != partida.visitante.lateralDireito.id}">
								<option value="${jogador.id}">${jogador.nome}</option>
							</c:if>
							<c:if test="${jogador.id == partida.visitante.lateralDireito.id}">
								<option value="${jogador.id}" selected>${jogador.nome}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="volante">Volante</label> <select class="form-control"
						name="visitante.volante.id" id="volante">
						<c:forEach var="jogador" items="${jogadores}">
							<c:if test="${jogador.id != partida.visitante.volante.id}">
								<option value="${jogador.id}">${jogador.nome}</option>
							</c:if>
							<c:if test="${jogador.id == partida.visitante.volante.id}">
								<option value="${jogador.id}" selected>${jogador.nome}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="meioCampo1">Meio Campo 1</label> <select
						class="form-control" name="visitante.meioCampo1.id"
						id="meioCampo1">
						<c:forEach var="jogador" items="${jogadores}">
							<c:if test="${jogador.id != partida.visitante.meioCampo1.id}">
								<option value="${jogador.id}">${jogador.nome}</option>
							</c:if>
							<c:if test="${jogador.id == partida.visitante.meioCampo1.id}">
								<option value="${jogador.id}" selected>${jogador.nome}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="meioCampo2">Meio Campo 2</label> <select
						class="form-control" name="visitante.meioCampo2.id"
						id="meioCampo2">
						<c:forEach var="jogador" items="${jogadores}">
							<c:if test="${jogador.id != partida.visitante.meioCampo2.id}">
								<option value="${jogador.id}">${jogador.nome}</option>
							</c:if>
							<c:if test="${jogador.id == partida.visitante.meioCampo2.id}">
								<option value="${jogador.id}" selected>${jogador.nome}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>

			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<label for="pontaEsquerda">Ponta Esquerda</label> <select
						class="form-control" name="visitante.pontaEsquerda.id"
						id="pontaEsquerda">
						<c:forEach var="jogador" items="${jogadores}">
							<c:if test="${jogador.id != partida.visitante.pontaEsquerda.id}">
								<option value="${jogador.id}">${jogador.nome}</option>
							</c:if>
							<c:if test="${jogador.id == partida.visitante.pontaEsquerda.id}">
								<option value="${jogador.id}" selected>${jogador.nome}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="atacante">CentroAvante</label> <select
						class="form-control" name="visitante.atacante.id" id="atacante">
						<c:forEach var="jogador" items="${jogadores}">
							<c:if test="${jogador.id != partida.visitante.atacante.id}">
								<option value="${jogador.id}">${jogador.nome}</option>
							</c:if>
							<c:if test="${jogador.id == partida.visitante.atacante.id}">
								<option value="${jogador.id}" selected>${jogador.nome}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-3">
					<label for="pontaDireito">Ponta Direira</label> <select
						class="form-control" name="visitante.pontaDireita.id"
						id="pontaDireita">
						<c:forEach var="jogador" items="${jogadores}">
							<c:if test="${jogador.id != partida.visitante.pontaDireita.id}">
								<option value="${jogador.id}">${jogador.nome}</option>
							</c:if>
							<c:if test="${jogador.id == partida.visitante.pontaDireita.id}">
								<option value="${jogador.id}" selected>${jogador.nome}</option>
							</c:if>
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