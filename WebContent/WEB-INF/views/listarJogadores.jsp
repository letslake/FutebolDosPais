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
				class="card-header text-center font-weight-bold text-uppercase py-4">Jogadores</h3>
			<div class="card-body">
				<div id="table" class="table-editable">
				<!-- <button type="button" class="btn btn-default">Excel</button>
            <button type="button" class="btn btn-default">Imprimir</button> -->
					<span class="table-add float-right mb-3 mr-2"><a href="novo_jogador"
						class="text-success"><i class="fa fa-plus fa-2x"
							aria-hidden="true" data-toggle="modal"
							data-target="#modalCampeonato"></i></a></span>
					<c:if test="${jogadores != null}">

						<table
							class="table table-bordered table-responsive-md table-striped text-center">
							<tr>
								<th class="text-center">Nome</th>
								<th class="text-center">Categoria</th>
								<th class="text-center">Altura</th>
								<th class="text-center">Peso</th>
								<th class="text-center">Cartões Vermelhos</th>
								<th class="text-center">Cartões Amarelos</th>
								<th class="text-center">Gols</th>
								<th class="text-center">Ações</th>
							</tr>
							<c:forEach var="jogador" items="${jogadores}">

								<tr>
									<td class="pt-3-half" contenteditable="false">${jogador.nome}</td>
									<td class="pt-3-half" contenteditable="false">${jogador.categoria.nome }</td>
									<td class="pt-3-half" contenteditable="false">${jogador.altura}</td>
									<td class="pt-3-half" contenteditable="false">${jogador.peso }</td>
									<td class="pt-3-half" contenteditable="false">${jogador.qtn_cartao_vermelho }</td>
									<td class="pt-3-half" contenteditable="false">${jogador.qtn_cartao_amarelo }</td>
									<td class="pt-3-half" contenteditable="false">${jogador.qtn_gols }</td>
									<td>
										<%-- <a class="btn btn-info btn-rounded btn-sm my-0" href="visualizar_jogador?id=${jogador.id }">
											Visualizar
										</a> --%>
										<a class="btn btn-success btn-rounded btn-sm my-0" href="editar_jogador?id=${jogador.id }">
											Editar
										</a>
										<a class="btn btn-danger btn-rounded btn-sm my-0" href="excluir_jogador?id=${jogador.id}">
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