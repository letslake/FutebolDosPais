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
				<li class="nav-item"><a class="nav-link"
					href="campeonato_index">Novo Campeonato</a></li>
			</c:if>

			<li class="nav-item"><a class="nav-link" href="listar_equipes">Equipes</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="listar_jogadores">Jogadores</a></li>
			<li class="nav-item"><a class="nav-link" href="listar_arbitros">Árbitros</a>
			</li>
			<li class="nav-item"><a class="nav-link"
				href="listar_campeonatos">Campeonatos</a></li>
			<li class="nav-item"><a class="nav-link" href="listar_tecnicos">Técnicos</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="listar_turnos">Turnos</a>
			</li>
			<li class="nav-item"><a class="nav-link"
				href="listar_categorias">Categoria</a></li>
			<li class="nav-item"><a class="nav-link" href="listar_rodadas">Rodadas</a>
			</li>
		</ul>
		<c:if test="${adm == null}">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="login">Login</a></li>
			</ul>
		</c:if>
		<c:if test="${adm != null}">
			<ul class="navbar-nav">
				<li class="nav-item">
					<div class="d-flex align-items-center justify-content-center">
						<p class="my-auto mr-2 text-white">Logado como:
							${adm.username}</p>
						<a class="btn-sair" href="fazer_logout"> <i
							class="fas fa-sign-out-alt fa-2x"></i>
						</a>
					</div>
				</li>
			</ul>
		</c:if>
	</div>
</nav>