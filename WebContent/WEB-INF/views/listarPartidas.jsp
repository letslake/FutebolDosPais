<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:import url="header.jsp" />

<body>
	<!-- Barra superior com os menus de navegaÃ§Ã£o -->
	<c:import url="navbar.jsp" />
	<div class="container">
		<div class="card mt-5">
			<h3
				class="card-header text-center font-weight-bold text-uppercase py-4">Partidas</h3>
			<div class="card-body">
				<div id="table" class="table-editable">
					<!-- <button type="button" class="btn btn-default">Excel</button>
					<button type="button" class="btn btn-default">Imprimir</button> -->
					<span class="table-add float-right mb-3 mr-2"><a href="nova_partida"
						class="text-success"><i class="fa fa-plus fa-2x"
							aria-hidden="true" data-toggle="modal"
							data-target="#modalCampeonato"></i></a></span>
					<c:if test="${partidas != null}">

						<table
							class="table table-bordered table-responsive-md table-striped text-center">
							<tr>
								<th class="text-center">Campeonato</th>
								<th class="text-center">Mandante</th>
								<th class="text-center">Visitante</th>
								<th class="text-center">Placar</th>
								<th class="text-center">Árbitro</th>
								<th class="text-center">Data</th>
								<th class="text-center">Hora</th>
								<th class="text-center">Ações</th>
							</tr>
							<c:forEach var="partida" items="${partidas}">

								<tr>
									<td class="pt-3-half" contenteditable="false">${partida.campeonato.nome}</td>
									<td class="pt-3-half" contenteditable="false">${partida.mandante.equipe.nome }</td>
									<td class="pt-3-half" contenteditable="false">${partida.visitante.equipe.nome}</td>
									<td class="pt-3-half" contenteditable="false">${partida.golsMandante} x ${ partida.golsVisitante }</td>
									<td class="pt-3-half" contenteditable="false">${partida.arbitro.nome }</td>
									<td class="pt-3-half" contenteditable="false"><fmt:formatDate value="${ partida.dataInicio }" pattern="dd/MM/yyyy"/></td>
									<td class="pt-3-half" contenteditable="false">${partida.horaInicio }</td>
									<td>
										<a class="btn btn-info btn-rounded btn-sm my-0"
											href="cadastrar_sumula?id=${partida.id }">
											Sumula
										</a> 
										<a class="btn btn-success btn-rounded btn-sm my-0"
											href="editar_partida?id=${partida.id }">
											Editar
										</a> 
										<a
											class="btn btn-danger btn-rounded btn-sm my-0"
											href="excluir_partida?id=${partida.id}">
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