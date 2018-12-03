<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<c:import url="header.jsp" />

<body>
	<!-- Barra superior com os menus de navegação -->
	<c:import url="navbar.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container text-center mt-4">
		<h3 class="page-header ">Sumula</h3>
		<!-- Formulario para inclusao de clientes -->
		<form action="inserir_sumula" method="post">
			<input type="hidden" name="id" value="${partida.id }" /> <input
				type="hidden" name="mandante.id" value="${partida.mandante.id }" />
			<input type="hidden" name="visitante.id"
				value="${partida.visitante.id }" />
			<div class="row mt-5">
				<div class="form-group col-md-4">
					<h2>${ partida.mandante.equipe.nome}</h2>

				</div>
				<div class="form-group col-md-1">
					<input type="hidden" name="mandante.equipe.id"
						value="${partida.mandante.equipe.id}" /> <input type="text"
						style="width: 30px" id="golsMandante" name="golsMandante"
						value="${partida.golsMandante }" />
				</div>
				<div class="form-group col-md-2">
					<h2>X</h2>
				</div>
				<div class="form-group col-md-1">
					<input type="hidden" name="visitante.equipe.id"
						value="${partida.visitante.equipe.id}" /> <input type="text"
						style="width: 30px" id="golsVisitantes" name="golsVisitante"
						value="${partida.golsVisitante }" />
				</div>
				<div class="form-group col-md-4">
					<h2>${ partida.visitante.equipe.nome}</h2>
				</div>
			</div>
			<div class="row text-left mt-5" style="margin-left: 85px">
				<div class="col-md-6">
					<div class="col-md-1 " style="display: inline;">Nome</div>
					<div class="col-md-1 ml-2 float-right mr-5"
						style="display: inline;">CV</div>
					<div class="col-md-1 ml-2 float-right mr-5"
						style="display: inline;">CA</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">Gol</div>
				</div>
				<div class="col-md-6">
					<div class="col-md-1" style="display: inline;">Nome</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">CV</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">CA</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">Gol</div>
				</div>
			</div>

			<hr />
			<div class="row text-left mt-5" style="margin-left: 85px">
				<div class="col-md-6 ">
					<div class="col-md-1" style="display: inline;">${ partida.mandante.goleiro.nome }</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="hidden" name="mandante.goleiro.id"
							value="${partida.mandante.goleiro.id}" /> <input type="text"
							style="width: 30px" name="mandante.goleiro.qtn_cartao_vermelho" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="mandante.goleiro.qtn_cartao_amarelo" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="mandante.goleiro.qtn_gols" />

					</div>
				</div>
				<div class="col-md-6">
					<div class="col-md-1" style="display: inline;">${ partida.visitante.goleiro.nome }</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="hidden" name="visitante.goleiro.id"
							value="${partida.visitante.goleiro.id}" /> <input type="text"
							style="width: 30px" name="visitante.goleiro.qtn_cartao_vermelho" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="visitante.goleiro.qtn_cartao_amarelo" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="visitante.goleiro.qtn_gols" />
					</div>
				</div>
			</div>
			<div class="row text-left mt-5" style="margin-left: 85px">
				<div class="col-md-6 ">
					<div class="col-md-1" style="display: inline;">${ partida.mandante.lateralDireito.nome }</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="hidden" name="mandante.lateralDireito.id"
							value="${partida.mandante.lateralDireito.id}" /> <input
							type="text" style="width: 30px"
							name="mandante.lateralDireito.qtn_cartao_vermelho" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="mandante.lateralDireito.qtn_cartao_amarelo" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="mandante.lateralDireito.qtn_gols" />

					</div>
				</div>
				<div class="col-md-6">
					<div class="col-md-1" style="display: inline;">${ partida.visitante.lateralDireito.nome }</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="hidden" name="visitante.lateralDireito.id"
							value="${partida.visitante.lateralDireito.id}" /> <input
							type="text" style="width: 30px"
							name="visitante.lateralDireito.qtn_cartao_vermelho" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="visitante.lateralDireito.qtn_cartao_amarelo" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="visitante.lateralDireito.qtn_gols" />
					</div>
				</div>
			</div>
			<div class="row text-left mt-5" style="margin-left: 85px">
				<div class="col-md-6 ">
					<div class="col-md-1" style="display: inline;">${ partida.mandante.zagueiro1.nome }</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="hidden" name="mandante.zagueiro1.id"
							value="${partida.mandante.zagueiro1.id}" /> <input type="text"
							style="width: 30px" name="mandante.zagueiro1.qtn_cartao_vermelho" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="mandante.zagueiro1.qtn_cartao_amarelo" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="mandante.zagueiro1.qtn_gols" />

					</div>
				</div>
				<div class="col-md-6">
					<div class="col-md-1" style="display: inline;">${ partida.visitante.zagueiro1.nome }</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="hidden" name="visitante.zagueiro1.id"
							value="${partida.visitante.zagueiro1.id}" /> <input type="text"
							style="width: 30px"
							name="visitante.zagueiro1.qtn_cartao_vermelho" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="visitante.zagueiro1.qtn_cartao_amarelo" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="visitante.zagueiro1.qtn_gols" />
					</div>
				</div>
			</div>
			<div class="row text-left mt-5" style="margin-left: 85px">
				<div class="col-md-6 ">
					<div class="col-md-1" style="display: inline;">${ partida.mandante.zagueiro2.nome }</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="hidden" name="mandante.zagueiro2.id"
							value="${partida.mandante.zagueiro1.id}" /> <input type="text"
							style="width: 30px" name="mandante.zagueiro2.qtn_cartao_vermelho" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="mandante.zagueiro2.qtn_cartao_amarelo" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="mandante.zagueiro2.qtn_gols" />

					</div>
				</div>
				<div class="col-md-6">
					<div class="col-md-1" style="display: inline;">${ partida.visitante.zagueiro2.nome }</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="hidden" name="visitante.zagueiro2.id"
							value="${partida.visitante.zagueiro2.id}" /> <input type="text"
							style="width: 30px"
							name="visitante.zagueiro2.qtn_cartao_vermelho" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="visitante.zagueiro2.qtn_cartao_amarelo" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="visitante.zagueiro2.qtn_gols" />
					</div>
				</div>
			</div>
			<div class="row text-left mt-5" style="margin-left: 85px">
				<div class="col-md-6 ">
					<div class="col-md-1" style="display: inline;">${ partida.mandante.lateralEsquerdo.nome }</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="hidden" name="mandante.lateralEsquerdo.id"
							value="${partida.mandante.lateralEsquerdo.id}" /> <input
							type="text" style="width: 30px"
							name="mandante.lateralEsquerdo.qtn_cartao_vermelho" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="mandante.lateralEsquerdo.qtn_cartao_amarelo" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="mandante.lateralEsquerdo.qtn_gols" />

					</div>
				</div>
				<div class="col-md-6">
					<div class="col-md-1" style="display: inline;">${ partida.visitante.lateralEsquerdo.nome }</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="hidden" name="visitante.lateralEsquerdo.id"
							value="${partida.visitante.lateralEsquerdo.id}" /> <input
							type="text" style="width: 30px"
							name="visitante.lateralEsquerdo.qtn_cartao_vermelho" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="visitante.lateralEsquerdo.qtn_cartao_amarelo" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="visitante.lateralEsquerdo.qtn_gols" />
					</div>
				</div>
			</div>
			<div class="row text-left mt-5" style="margin-left: 85px">
				<div class="col-md-6 ">
					<div class="col-md-1" style="display: inline;">${ partida.mandante.volante.nome }</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="hidden" name="mandante.volante.id"
							value="${partida.mandante.volante.id}" /> <input type="text"
							style="width: 30px" name="mandante.volante.qtn_cartao_vermelho" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="mandante.volante.qtn_cartao_amarelo" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="mandante.volante.qtn_gols" />

					</div>
				</div>
				<div class="col-md-6">
					<div class="col-md-1" style="display: inline;">${ partida.visitante.volante.nome }</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="hidden" name="visitante.volante.id"
							value="${partida.visitante.volante.id}" /> <input type="text"
							style="width: 30px" name="visitante.volante.qtn_cartao_vermelho" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="visitante.volante.qtn_cartao_amarelo" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="visitante.volante.qtn_gols" />
					</div>
				</div>
			</div>
			<div class="row text-left mt-5" style="margin-left: 85px">
				<div class="col-md-6 ">
					<div class="col-md-1" style="display: inline;">${ partida.mandante.meioCampo1.nome }</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="hidden" name="mandante.meioCampo1.id"
							value="${partida.mandante.meioCampo1.id}" /> <input type="text"
							style="width: 30px"
							name="mandante.meioCampo1.qtn_cartao_vermelho" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="mandante.meioCampo1.qtn_cartao_amarelo" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="mandante.meioCampo1.qtn_gols" />
					</div>
				</div>
				<div class="col-md-6">
					<div class="col-md-1" style="display: inline;">${ partida.visitante.meioCampo1.nome }</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="hidden" name="visitante.meioCampo1.id"
							value="${partida.visitante.meioCampo1.id}" /> <input type="text"
							style="width: 30px"
							name="visitante.meioCampo1.qtn_cartao_vermelho" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="visitante.meioCampo1.qtn_cartao_amarelo" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="visitante.meioCampo1.qtn_gols" />
					</div>
				</div>
			</div>
			<div class="row text-left mt-5" style="margin-left: 85px">
				<div class="col-md-6 ">
					<div class="col-md-1" style="display: inline;">${ partida.mandante.meioCampo2.nome }</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="hidden" name="mandante.meioCampo2.id"
							value="${partida.mandante.meioCampo2.id}" /> <input type="text"
							style="width: 30px"
							name="mandante.meioCampo2.qtn_cartao_vermelho" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="mandante.meioCampo2.qtn_cartao_amarelo" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="mandante.meioCampo2.qtn_gols" />

					</div>
				</div>
				<div class="col-md-6">
					<div class="col-md-1" style="display: inline;">${ partida.visitante.meioCampo2.nome }</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="hidden" name="visitante.meioCampo2.id"
							value="${partida.visitante.meioCampo2.id}" /> <input type="text"
							style="width: 30px"
							name="visitante.meioCampo2.qtn_cartao_vermelho" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="visitante.meioCampo2.qtn_cartao_amarelo" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="visitante.meioCampo2.qtn_gols" />
					</div>
				</div>
			</div>
			<div class="row text-left mt-5" style="margin-left: 85px">
				<div class="col-md-6 ">
					<div class="col-md-1" style="display: inline;">${ partida.mandante.pontaEsquerda.nome }</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="hidden" name="mandante.pontaEsquerda.id"
							value="${partida.mandante.pontaEsquerda.id}" /> <input
							type="text" style="width: 30px"
							name="mandante.pontaEsquerda.qtn_cartao_vermelho" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="mandante.pontaEsquerda.qtn_cartao_amarelo" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="mandante.pontaEsquerda.qtn_gols" />

					</div>
				</div>
				<div class="col-md-6">
					<div class="col-md-1" style="display: inline;">${ partida.visitante.pontaEsquerda.nome }</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="hidden" name="visitante.pontaEsquerda.id"
							value="${partida.visitante.pontaEsquerda.id}" /> <input
							type="text" style="width: 30px"
							name="visitante.pontaEsquerda.qtn_cartao_vermelho" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="visitante.pontaEsquerda.qtn_cartao_amarelo" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="visitante.pontaEsquerda.qtn_gols" />
					</div>
				</div>
			</div>
			<div class="row text-left mt-5" style="margin-left: 85px">
				<div class="col-md-6 ">
					<div class="col-md-1" style="display: inline;">${ partida.mandante.atacante.nome }</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="hidden" name="mandante.atacante.id"
							value="${partida.mandante.atacante.id}" /> <input type="text"
							style="width: 30px" name="mandante.atacante.qtn_cartao_vermelho" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="mandante.atacante.qtn_cartao_amarelo" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="mandante.atacante.qtn_gols" />

					</div>
				</div>
				<div class="col-md-6">
					<div class="col-md-1" style="display: inline;">${ partida.visitante.atacante.nome }</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="hidden" name="visitante.atacante.id"
							value="${partida.visitante.atacante.id}" /> <input type="text"
							style="width: 30px" name="visitante.atacante.qtn_cartao_vermelho" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="visitante.atacante.qtn_cartao_amarelo" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="visitante.atacante.qtn_gols" />
					</div>
				</div>
			</div>
			<div class="row text-left mt-5" style="margin-left: 85px">
				<div class="col-md-6 ">
					<div class="col-md-1" style="display: inline;">${ partida.mandante.pontaDireita.nome }</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="hidden" name="mandante.pontaDireita.id"
							value="${partida.mandante.pontaDireita.id}" /> <input
							type="text" style="width: 30px"
							name="mandante.pontaDireita.qtn_cartao_vermelho" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="mandante.pontaDireita.qtn_cartao_amarelo" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="mandante.pontaDireita.qtn_gols" />

					</div>
				</div>
				<div class="col-md-6">
					<div class="col-md-1" style="display: inline;">${ partida.visitante.pontaDireita.nome }</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="hidden" name="visitante.pontaDireita.id"
							value="${partida.visitante.pontaDireita.id}" /> <input
							type="text" style="width: 30px"
							name="visitante.pontaDireita.qtn_cartao_vermelho" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="visitante.pontaDireita.qtn_cartao_amarelo" />
					</div>
					<div class="col-md-1 float-right mr-5" style="display: inline;">
						<input type="text" style="width: 30px"
							name="visitante.pontaDireita.qtn_gols" />
					</div>
				</div>
			</div>

			<div id="actions" class="row mt-5">
				<div class="col-md-12">
					<button type="submit" class="btn btn-success btn-block">Salvar</button>
				</div>
			</div>
		</form>
	</div>
	<c:import url="footer.jsp" />