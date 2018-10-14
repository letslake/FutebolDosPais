<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:import url="header.jsp" />

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="inicio">Futebol dos Pais</a> <img class="mr-4"
		src="imagens/logo.png" width="30" height="30" alt="">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarColor01" aria-controls="navbarColor01"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarColor01">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link"
				href="inicio">Informações<span class="sr-only">(current)</span></a>
			</li>
			<li class="nav-item"><a class="nav-link" href="listar_equipes">Equipes</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="listar_jogadores">Jogadores</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="listar_arbitros">Árbitros</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="listar_campeonatos">Campeonatos</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="listar_tecnicos">Técnicos</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="listar_turnos">Turnos</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="listar_categorias">Categoria</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="listar_rodadas">Rodadas</a>
			</li>
		</ul>
		<form class="form-inline">
			<a class="btn btn-success my-2 my-sm-0" href="login"
				type="submit">Administrador</a>
		</form>
	</div>
</nav>