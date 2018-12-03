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
		<h3 class="page-header">Atualizar Campeonato - ${campeonato.id }</h3>
		<!-- Formulario para inclusao de clientes -->
		<form action="atualizar_campeonato" method="post">
			<!-- area de campos do form -->
			<div class="row">
				<div class="form-group col-md-4">
				<input type="hidden" name="id" value="${campeonato.id}">
				<input type="hidden" name="regulamento.id" value="${campeonato.regulamento.id}">
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
					<label for="nome">Nome Campeonato</label> <input type="text"
						class="form-control" name="nome" id="nome" maxlength="100" value="${campeonato.nome }">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-4">
					<label for="qtnTimes">Quantidade de Times</label> <input
						type="text" class="form-control" name="regulamento.qtnTimes"
						id="qtnTimes" maxlength="100" value="${campeonato.regulamento.qtnTimes }">
				</div>
				<div class="form-group col-md-4">
					<label for="diretor">Pontos por Vitória</label> <input type="text"
						class="form-control" name="regulamento.pontosVitoria"
						id="pontosVitoria" maxlength="60" value="${campeonato.regulamento.pontosVitoria }">
				</div>
				<div class="form-group col-md-4">
					<label for="dataLancamento">Pontos por Empate</label> <input
						type="text" class="form-control" name="regulamento.pontosEmpate"
						id="pontosEmpate" value="${campeonato.regulamento.pontosEmpate }">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<label for="tempoJogo">Tempo de Jogo</label> <input type="text"
						class="form-control" name="regulamento.tempoJogo" id="tempoJogo"
						required maxlength="100" value="${campeonato.regulamento.tempoJogo }">
				</div>
				<div class="form-group col-md-3">
					<label for="tempoIntervalo">Tempo de Intervalo</label> <input
						type="text" class="form-control" name="regulamento.tempoIntervalo"
						id="tempoIntervalo" required maxlength="100" value="${campeonato.regulamento.tempoIntervalo }">
				</div>
				<div class="form-group col-md-3">
					<label for="dataInicio">Data Inicio</label> <input type="text"
						class="form-control" name="regulamento.dataInicio" id="dataInicio"
						required maxlength="100" placeholder="dd/MM/aaaa" value="<fmt:formatDate value="${campeonato.regulamento.dataInicio}" pattern="dd/MM/yyyy"/>">
				</div>
				<div class="form-group col-md-3">
					<label for="dataTermino">Data Término</label> <input type="text"
						class="form-control" name="regulamento.dataTermino"
						id="dataTermino" maxlength="60" placeholder="dd/MM/aaaa" value="<fmt:formatDate value="${campeonato.regulamento.dataTermino}" pattern="dd/MM/yyyy"/>">
				</div>
			</div>
			<hr />
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-success">Salvar</button>
					<a href="inicio" class="btn btn-light">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
	<c:import url="footer.jsp" />