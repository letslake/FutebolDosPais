<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp" />

<body>
	<!-- Barra superior com os menus de navegaÃ§Ã£o -->
	<c:import url="navbar.jsp" />
	<div class="container">
		<div class="card mt-5">
			<h3
				class="card-header text-center font-weight-bold text-uppercase py-4">Campeonatos</h3>
			<div class="card-body">
				<div id="table" class="table-editable">
					<!-- <button type="button" class="btn btn-default">Excel</button>
					<button type="button" class="btn btn-default">Imprimir</button> -->
					<span class="table-add float-right mb-3 mr-2"><a href="novo_campeonato"
						class="text-success"><i class="fa fa-plus fa-2x"
							aria-hidden="true" data-toggle="modal"
							data-target="#modalCampeonato"></i></a></span>
					<c:if test="${campeonatos != null}">

						<table
							class="table table-bordered table-responsive-md table-striped text-center">
							<tr>
								<th class="text-center">Nome</th>
								<th class="text-center">Categoria</th>
								<th class="text-center">Times</th>
								<th class="text-center">Pontos por vitória</th>
								<th class="text-center">Pontos por empate</th>
								<th class="text-center">Tempo de jogo</th>
								<th class="text-center">Tempo de intervalo</th>
								<th class="text-center">Ações</th>
							</tr>
							<c:forEach var="campeonato" items="${campeonatos}">

								<tr>
									<td class="pt-3-half" contenteditable="false">${campeonato.nome}</td>
									<td class="pt-3-half" contenteditable="false">${campeonato.categoria.nome }</td>
									<td class="pt-3-half" contenteditable="false">${campeonato.regulamento.qtnTimes}</td>
									<td class="pt-3-half" contenteditable="false">${campeonato.regulamento.pontosVitoria }</td>
									<td class="pt-3-half" contenteditable="false">${campeonato.regulamento.pontosEmpate }</td>
									<td class="pt-3-half" contenteditable="false">${campeonato.regulamento.tempoJogo }
										min</td>
									<td class="pt-3-half" contenteditable="false">${campeonato.regulamento.tempoIntervalo }
										min</td>
									<td>
										<%-- <a class="btn btn-info btn-rounded btn-sm my-0"
										href="visualizar_campeonato?id=${campeonato.id }">
											Visualizar
										</a>  --%>
										<a class="btn btn-success btn-rounded btn-sm my-0"
										href="editar_campeonato?id=${campeonato.id }">
											Editar
										</a> 
										<a
										class="btn btn-danger btn-rounded btn-sm my-0"
										href="excluir_campeonato?id=${campeonato.id}">
											Remover
										</a>
									</td>

								</tr>
							</c:forEach>
						</table>
					</c:if>
				</div>
			</div>
		</div>
	</div>

	<c:import url="footer.jsp" />