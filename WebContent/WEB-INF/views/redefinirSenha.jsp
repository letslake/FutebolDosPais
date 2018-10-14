<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp" />

<body>
	<h1 class="h1-login">REDEFINIR SENHA</h1>
	<form class="form-login">
		<div class="form-group">
			<label for="exampleInputEmail1">Nova Senha</label> <input type="text"
				class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp" placeholder="Insira sua nova senha">
			<label for="exampleInputPassword1" class="label-senha">Nova
				Senha novamente</label> <input type="password" class="form-control"
				id="exampleInputPassword1" placeholder="Insira a senha novamente">
			<button type="submit" class="btn btn-success" id="button-login">Redefinir</button>
			<button type="submit" class="btn btn-success" id="button-apagar">Apagar</button>
		</div>
	</form>
	<c:import url="footer.jsp" />