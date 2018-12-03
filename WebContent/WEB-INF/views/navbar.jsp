<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp" />


<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="inicio">Futebol dos Pais</a> <img
		class="mr-4" src="imagens/logo.png" width="30" height="30" alt="">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarColor01" aria-controls="navbarColor01"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarColor01">
		<ul class="navbar-nav mr-auto">
			<c:if test="${adm != null}">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" id="navbarDropdownMenuLink"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Campeonato</a>
					<div class="dropdown-menu dropdown-primary"
						aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="novo_campeonato">Novo
							Campeonato</a> <a class="dropdown-item" href="listar_campeonatos">Campeonatos</a>

					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" id="navbarDropdownMenuLink"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Equipes</a>
					<div class="dropdown-menu dropdown-primary"
						aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="nova_equipe">Nova Equipe</a> <a
							class="dropdown-item" href="listar_equipes">Equipes</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="index.html"
					id="navbarDropdownMenuLink" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> Jogadores </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="novo_jogador">Novo Jogador</a> <a
							class="dropdown-item" href="listar_jogadores">Jogadores</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="index.html"
					id="navbarDropdownMenuLink" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> Arbitros </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="novo_arbitro">Novo Arbitro</a> <a
							class="dropdown-item" href="listar_arbitros">Arbitros</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="index.html"
					id="navbarDropdownMenuLink" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> Partidas </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="nova_partida">Nova Partida</a> <a
							class="dropdown-item" href="listar_partidas">Partidas</a>
					</div></li>
			</c:if>
		</ul>
		<c:if test="${adm == null}">
			<ul class="navbar-nav mr-auto"></ul>
			<form class="form-inline">
				<button type="button" class="btn blue-gradient" data-toggle="modal"
					data-target="#modalLoginForm">Administrador</button>
			</form>
		</c:if>
		<c:if test="${adm != null}">
			<ul class="navbar-nav"></ul>
			<li class="nav-item">
				<div class="d-flex align-items-center justify-content-center">
					<p class="my-auto mr-2 text-white">${adm.usuario}</p>
					<a class="btn blue-gradient btn-sm" href="fazer_logout"> <i
						class="fas fa-sign-out-alt"></i>
					</a>
				</div>
			</li>
			</ul>
		</c:if>
	</div>
</nav>