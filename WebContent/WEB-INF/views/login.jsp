<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp" />

<body>
	<!-- Barra superior com os menus de navegaÃ§Ã£o -->
	<c:import url="navbar.jsp" />

	<h1 class="h1-login">LOGIN</h1>
	<form class="form-login">
		<div class="form-group">
			<label for="exampleInputEmail1">Usuário</label> <input type="text"
				class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp" placeholder="Insira seu usuário">
			<small id="emailHelp" class="form-text text-muted">Letras
				maiúsculas dão diferença.</small> <label for="exampleInputPassword1">Senha</label>
			<input type="password" class="form-control"
				id="exampleInputPassword1" placeholder="Senha"> <input
				type="checkbox" class="form-check-input" id="exampleCheck1">
			<label class="form-check-label" for="exampleCheck1">Lembrar-me</label>
			<button type="submit" class="btn btn-success" id="button-login">Entrar</button>
			<button type="submit" class="btn btn-success" id="button-apagar">Apagar</button>
			<a class="esqueci-senha" href="redefinirSenha.jsp">Esqueci
				minha senha</a>
		</div>
	</form>
	<c:import url="footer.jsp" />