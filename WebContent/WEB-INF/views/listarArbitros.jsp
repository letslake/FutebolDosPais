<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp" />

<body>
	<!-- Barra superior com os menus de navegaÃ§Ã£o -->
	<c:import url="navbar.jsp" />

	<div class="container">
		<h2 class="h2-equipes">Árbitros</h2>
		<p>Grupos das 4as de finais - Master</p>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Número</th>
					<th>Nome</th>
					<th>Categoria</th>
					<th>Jogos</th>
					<th>Média por jogo</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>Doe</td>
					<td>john@example.com</td>
					<td>Dooley</td>
					<td>july@example.com</td>
				</tr>
				<tr>
					<td>2</td>
					<td>Moe</td>
					<td>mary@example.com</td>
					<td>Dooley</td>
					<td>july@example.com</td>
				</tr>
				<tr>
					<td>3</td>
					<td>Dooley</td>
					<td>july@example.com</td>
					<td>Dooley</td>
					<td>july@example.com</td>
				</tr>
				<tr>
					<td>4</td>
					<td>Dooley</td>
					<td>july@example.com</td>
					<td>Dooley</td>
					<td>july@example.com</td>
				</tr>
				<tr>
					<td>5</td>
					<td>Dooley</td>
					<td>july@example.com</td>
					<td>Dooley</td>
					<td>july@example.com</td>
				</tr>
			</tbody>
		</table>
	</div>
	<c:import url="footer.jsp" />