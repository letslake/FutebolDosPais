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
				class="card-header text-center font-weight-bold text-uppercase py-4">Equipes</h3>
			<div class="card-body">
				<div id="table" class="table-editable">
					<!-- <button type="button" class="btn btn-default">Excel
					</button>
					<button type="button" class="btn btn-default">Imprimir</button> -->
					<span class="table-add float-right mb-3 mr-2"><a href="nova_equipe"
						class="text-success"><i class="fa fa-plus fa-2x"
							aria-hidden="true" data-toggle="modal"
							data-target="#modalCampeonato"></i></a></span>
					<c:if test="${equipes != null}">

						<table
							class="table table-bordered table-responsive-md table-striped text-center">
							<tr>
								<th class="text-center">Categoria</th>
								<th class="text-center">Nome</th>
								<th class="text-center">Coordenador</th>
								<th class="text-center">Técnico</th>
								<th class="text-center">Vitórias</th>
								<th class="text-center">Empates</th>
								<th class="text-center">Derrotas</th>
								<th class="text-center">Ações</th>
							</tr>
							<c:forEach var="equipe" items="${equipes}">

								<tr>
									<td class="pt-3-half" contenteditable="false">${equipe.categoria.nome }</td>
									<td class="pt-3-half" contenteditable="false">${equipe.nome}</td>
									<td class="pt-3-half" contenteditable="false">${equipe.coordenador.nome}</td>
									<td class="pt-3-half" contenteditable="false">${equipe.tecnico.nome}</td>
									<td class="pt-3-half" contenteditable="false">${equipe.vitorias}</td>
									<td class="pt-3-half" contenteditable="false">${equipe.empates }</td>
									<td class="pt-3-half" contenteditable="false">${equipe.derrotas }</td>
									<td>
										<%-- <a class="btn btn-info btn-rounded btn-sm my-0"
											href="visualizar_equipe?id=${equipe.id }">
											Visualizar
										</a>  --%>
										<a class="btn btn-success btn-rounded btn-sm my-0"
											href="editar_equipe?id=${equipe.id }">
											Editar
										</a> 
										<a
											class="btn btn-danger btn-rounded btn-sm my-0"
											href="excluir_equipe?id=${equipe.id}">
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