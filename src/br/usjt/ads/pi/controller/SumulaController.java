package br.usjt.ads.pi.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.ads.pi.model.entity.Equipe;
import br.usjt.ads.pi.model.entity.Jogador;
import br.usjt.ads.pi.model.entity.Partida;
import br.usjt.ads.pi.model.service.EquipeService;
import br.usjt.ads.pi.model.service.JogadorService;
import br.usjt.ads.pi.model.service.PartidaService;

@Controller
public class SumulaController {
	@Autowired
	private PartidaService pService;
	@Autowired
	private JogadorService jService;
	@Autowired
	private EquipeService eService;

	@RequestMapping("/cadastrar_sumula")
	public String cadastrarSumula(Partida partida, Model model, HttpSession session) {
		try {
			Partida match = pService.buscarPartida(partida.getId());
			model.addAttribute("partida", match);
			return "NovaSumula";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	@RequestMapping("/inserir_sumula")
	public String inserirSumula(Partida partida, BindingResult result, Model model, HttpSession session) {
		try {

			// Goleiro
			Jogador goleiroM = jService.buscarJogador(partida.getMandante().getGoleiro().getId());
			goleiroM.setQtn_gols(goleiroM.getQtn_gols() + partida.getMandante().getGoleiro().getQtn_gols());
			goleiroM.setQtn_cartao_amarelo(
					goleiroM.getQtn_cartao_amarelo() + partida.getMandante().getGoleiro().getQtn_cartao_amarelo());
			goleiroM.setQtn_cartao_vermelho(
					goleiroM.getQtn_cartao_vermelho() + partida.getMandante().getGoleiro().getQtn_cartao_vermelho());
			jService.atualizarJogador(goleiroM);

			// Zagueiro 1
			Jogador zagueiroM1 = jService.buscarJogador(partida.getMandante().getZagueiro1().getId());
			zagueiroM1.setQtn_gols(zagueiroM1.getQtn_gols() + partida.getMandante().getZagueiro1().getQtn_gols());
			zagueiroM1.setQtn_cartao_amarelo(
					zagueiroM1.getQtn_cartao_amarelo() + partida.getMandante().getZagueiro1().getQtn_cartao_amarelo());
			zagueiroM1.setQtn_cartao_vermelho(zagueiroM1.getQtn_cartao_vermelho()
					+ partida.getMandante().getZagueiro1().getQtn_cartao_vermelho());
			jService.atualizarJogador(zagueiroM1);

			// Zagueiro2
			Jogador zagueiroM2 = jService.buscarJogador(partida.getMandante().getZagueiro2().getId());
			zagueiroM2.setQtn_gols(zagueiroM2.getQtn_gols() + partida.getMandante().getZagueiro2().getQtn_gols());
			zagueiroM2.setQtn_cartao_amarelo(
					zagueiroM2.getQtn_cartao_amarelo() + partida.getMandante().getZagueiro2().getQtn_cartao_amarelo());
			zagueiroM2.setQtn_cartao_vermelho(zagueiroM2.getQtn_cartao_vermelho()
					+ partida.getMandante().getZagueiro2().getQtn_cartao_vermelho());
			jService.atualizarJogador(zagueiroM2);

			// Lateral E
			Jogador leM = jService.buscarJogador(partida.getMandante().getLateralEsquerdo().getId());
			leM.setQtn_gols(leM.getQtn_gols() + partida.getMandante().getLateralEsquerdo().getQtn_gols());
			leM.setQtn_cartao_amarelo(
					leM.getQtn_cartao_amarelo() + partida.getMandante().getLateralEsquerdo().getQtn_cartao_amarelo());
			leM.setQtn_cartao_vermelho(
					leM.getQtn_cartao_vermelho() + partida.getMandante().getLateralEsquerdo().getQtn_cartao_vermelho());
			jService.atualizarJogador(leM);

			// Lateral D
			Jogador ldM = jService.buscarJogador(partida.getMandante().getLateralDireito().getId());
			ldM.setQtn_gols(ldM.getQtn_gols() + partida.getMandante().getLateralDireito().getQtn_gols());
			ldM.setQtn_cartao_amarelo(
					ldM.getQtn_cartao_amarelo() + partida.getMandante().getLateralDireito().getQtn_cartao_amarelo());
			ldM.setQtn_cartao_vermelho(
					ldM.getQtn_cartao_vermelho() + partida.getMandante().getLateralDireito().getQtn_cartao_vermelho());
			jService.atualizarJogador(ldM);

			// Volante
			Jogador volanteM = jService.buscarJogador(partida.getMandante().getVolante().getId());
			volanteM.setQtn_gols(volanteM.getQtn_gols() + partida.getMandante().getVolante().getQtn_gols());
			volanteM.setQtn_cartao_amarelo(
					volanteM.getQtn_cartao_amarelo() + partida.getMandante().getVolante().getQtn_cartao_amarelo());
			volanteM.setQtn_cartao_vermelho(
					volanteM.getQtn_cartao_vermelho() + partida.getMandante().getVolante().getQtn_cartao_vermelho());
			jService.atualizarJogador(volanteM);

			// Meio campo 1
			Jogador mcM1 = jService.buscarJogador(partida.getMandante().getMeioCampo1().getId());
			mcM1.setQtn_gols(mcM1.getQtn_gols() + partida.getMandante().getMeioCampo1().getQtn_gols());
			mcM1.setQtn_cartao_amarelo(
					mcM1.getQtn_cartao_amarelo() + partida.getMandante().getMeioCampo1().getQtn_cartao_amarelo());
			mcM1.setQtn_cartao_vermelho(
					mcM1.getQtn_cartao_vermelho() + partida.getMandante().getMeioCampo1().getQtn_cartao_vermelho());
			jService.atualizarJogador(mcM1);

			// Meio campo 2
			Jogador mcM2 = jService.buscarJogador(partida.getMandante().getMeioCampo2().getId());
			mcM2.setQtn_gols(mcM2.getQtn_gols() + partida.getMandante().getMeioCampo2().getQtn_gols());
			mcM2.setQtn_cartao_amarelo(
					mcM2.getQtn_cartao_amarelo() + partida.getMandante().getMeioCampo2().getQtn_cartao_amarelo());
			mcM2.setQtn_cartao_vermelho(
					mcM2.getQtn_cartao_vermelho() + partida.getMandante().getMeioCampo2().getQtn_cartao_vermelho());
			jService.atualizarJogador(mcM2);

			// Ponta Esquerda
			Jogador peM = jService.buscarJogador(partida.getMandante().getPontaEsquerda().getId());
			peM.setQtn_gols(peM.getQtn_gols() + partida.getMandante().getPontaEsquerda().getQtn_gols());
			peM.setQtn_cartao_amarelo(
					peM.getQtn_cartao_amarelo() + partida.getMandante().getPontaEsquerda().getQtn_cartao_amarelo());
			peM.setQtn_cartao_vermelho(
					peM.getQtn_cartao_vermelho() + partida.getMandante().getPontaEsquerda().getQtn_cartao_vermelho());
			jService.atualizarJogador(peM);

			// Ponta Direita
			Jogador pdM = jService.buscarJogador(partida.getMandante().getPontaDireita().getId());
			pdM.setQtn_gols(pdM.getQtn_gols() + partida.getMandante().getPontaDireita().getQtn_gols());
			pdM.setQtn_cartao_amarelo(
					pdM.getQtn_cartao_amarelo() + partida.getMandante().getPontaDireita().getQtn_cartao_amarelo());
			pdM.setQtn_cartao_vermelho(
					pdM.getQtn_cartao_vermelho() + partida.getMandante().getPontaDireita().getQtn_cartao_vermelho());
			jService.atualizarJogador(pdM);

			// Atacante
			Jogador aM = jService.buscarJogador(partida.getMandante().getAtacante().getId());
			aM.setQtn_gols(aM.getQtn_gols() + partida.getMandante().getAtacante().getQtn_gols());
			aM.setQtn_cartao_amarelo(
					aM.getQtn_cartao_amarelo() + partida.getMandante().getAtacante().getQtn_cartao_amarelo());
			aM.setQtn_cartao_vermelho(
					aM.getQtn_cartao_vermelho() + partida.getMandante().getAtacante().getQtn_cartao_vermelho());
			jService.atualizarJogador(aM);

			// Goleiro
			Jogador goleiroV = jService.buscarJogador(partida.getVisitante().getGoleiro().getId());
			goleiroV.setQtn_gols(goleiroV.getQtn_gols() + partida.getVisitante().getGoleiro().getQtn_gols());
			goleiroV.setQtn_cartao_amarelo(
					goleiroV.getQtn_cartao_amarelo() + partida.getVisitante().getGoleiro().getQtn_cartao_amarelo());
			goleiroV.setQtn_cartao_vermelho(
					goleiroV.getQtn_cartao_vermelho() + partida.getVisitante().getGoleiro().getQtn_cartao_vermelho());
			jService.atualizarJogador(goleiroV);

			// Zagueiro 1
			Jogador zagueiroV1 = jService.buscarJogador(partida.getVisitante().getZagueiro1().getId());
			zagueiroV1.setQtn_gols(zagueiroV1.getQtn_gols() + partida.getVisitante().getZagueiro1().getQtn_gols());
			zagueiroV1.setQtn_cartao_amarelo(
					zagueiroV1.getQtn_cartao_amarelo() + partida.getVisitante().getZagueiro1().getQtn_cartao_amarelo());
			zagueiroV1.setQtn_cartao_vermelho(zagueiroV1.getQtn_cartao_vermelho()
					+ partida.getVisitante().getZagueiro1().getQtn_cartao_vermelho());
			jService.atualizarJogador(zagueiroV1);

			// Zagueiro2
			Jogador zagueiroV2 = jService.buscarJogador(partida.getVisitante().getZagueiro2().getId());
			zagueiroV2.setQtn_gols(zagueiroV2.getQtn_gols() + partida.getVisitante().getZagueiro2().getQtn_gols());
			zagueiroV2.setQtn_cartao_amarelo(
					zagueiroV2.getQtn_cartao_amarelo() + partida.getVisitante().getZagueiro2().getQtn_cartao_amarelo());
			zagueiroV2.setQtn_cartao_vermelho(zagueiroV2.getQtn_cartao_vermelho()
					+ partida.getVisitante().getZagueiro2().getQtn_cartao_vermelho());
			jService.atualizarJogador(zagueiroV2);

			// Lateral E
			Jogador leV = jService.buscarJogador(partida.getVisitante().getLateralEsquerdo().getId());
			leV.setQtn_gols(leV.getQtn_gols() + partida.getVisitante().getLateralEsquerdo().getQtn_gols());
			leV.setQtn_cartao_amarelo(
					leV.getQtn_cartao_amarelo() + partida.getVisitante().getLateralEsquerdo().getQtn_cartao_amarelo());
			leV.setQtn_cartao_vermelho(leV.getQtn_cartao_vermelho()
					+ partida.getVisitante().getLateralEsquerdo().getQtn_cartao_vermelho());
			jService.atualizarJogador(leV);

			// Lateral D
			Jogador ldV = jService.buscarJogador(partida.getVisitante().getLateralDireito().getId());
			ldV.setQtn_gols(ldV.getQtn_gols() + partida.getVisitante().getLateralDireito().getQtn_gols());
			ldV.setQtn_cartao_amarelo(
					ldV.getQtn_cartao_amarelo() + partida.getVisitante().getLateralDireito().getQtn_cartao_amarelo());
			ldV.setQtn_cartao_vermelho(
					ldV.getQtn_cartao_vermelho() + partida.getVisitante().getLateralDireito().getQtn_cartao_vermelho());
			jService.atualizarJogador(ldV);

			// Volante
			Jogador volanteV = jService.buscarJogador(partida.getVisitante().getVolante().getId());
			volanteV.setQtn_gols(volanteV.getQtn_gols() + partida.getVisitante().getVolante().getQtn_gols());
			volanteV.setQtn_cartao_amarelo(
					volanteV.getQtn_cartao_amarelo() + partida.getVisitante().getVolante().getQtn_cartao_amarelo());
			volanteV.setQtn_cartao_vermelho(
					volanteV.getQtn_cartao_vermelho() + partida.getVisitante().getVolante().getQtn_cartao_vermelho());
			jService.atualizarJogador(volanteV);

			// Meio campo 1
			Jogador mcV1 = jService.buscarJogador(partida.getVisitante().getMeioCampo1().getId());
			mcV1.setQtn_gols(mcV1.getQtn_gols() + partida.getVisitante().getMeioCampo1().getQtn_gols());
			mcV1.setQtn_cartao_amarelo(
					mcV1.getQtn_cartao_amarelo() + partida.getVisitante().getMeioCampo1().getQtn_cartao_amarelo());
			mcV1.setQtn_cartao_vermelho(
					mcV1.getQtn_cartao_vermelho() + partida.getVisitante().getMeioCampo1().getQtn_cartao_vermelho());
			jService.atualizarJogador(mcV1);

			// Meio campo 2
			Jogador mcV2 = jService.buscarJogador(partida.getVisitante().getMeioCampo2().getId());
			mcV2.setQtn_gols(mcV2.getQtn_gols() + partida.getVisitante().getMeioCampo2().getQtn_gols());
			mcV2.setQtn_cartao_amarelo(
					mcV2.getQtn_cartao_amarelo() + partida.getVisitante().getMeioCampo2().getQtn_cartao_amarelo());
			mcV2.setQtn_cartao_vermelho(
					mcV2.getQtn_cartao_vermelho() + partida.getVisitante().getMeioCampo2().getQtn_cartao_vermelho());
			jService.atualizarJogador(mcV2);

			// Ponta Esquerda
			Jogador peV = jService.buscarJogador(partida.getVisitante().getPontaEsquerda().getId());
			peV.setQtn_gols(peV.getQtn_gols() + partida.getVisitante().getPontaEsquerda().getQtn_gols());
			peV.setQtn_cartao_amarelo(
					peV.getQtn_cartao_amarelo() + partida.getVisitante().getPontaEsquerda().getQtn_cartao_amarelo());
			peV.setQtn_cartao_vermelho(
					peV.getQtn_cartao_vermelho() + partida.getVisitante().getPontaEsquerda().getQtn_cartao_vermelho());
			jService.atualizarJogador(peV);

			// Ponta Direita
			Jogador pdV = jService.buscarJogador(partida.getVisitante().getPontaDireita().getId());
			pdV.setQtn_gols(pdV.getQtn_gols() + partida.getVisitante().getPontaDireita().getQtn_gols());
			pdV.setQtn_cartao_amarelo(
					pdV.getQtn_cartao_amarelo() + partida.getVisitante().getPontaDireita().getQtn_cartao_amarelo());
			pdV.setQtn_cartao_vermelho(
					pdV.getQtn_cartao_vermelho() + partida.getVisitante().getPontaDireita().getQtn_cartao_vermelho());
			jService.atualizarJogador(pdV);

			// Atacante
			Jogador aV = jService.buscarJogador(partida.getVisitante().getAtacante().getId());
			aV.setQtn_gols(aV.getQtn_gols() + partida.getVisitante().getAtacante().getQtn_gols());
			aV.setQtn_cartao_amarelo(
					aV.getQtn_cartao_amarelo() + partida.getVisitante().getAtacante().getQtn_cartao_amarelo());
			aV.setQtn_cartao_vermelho(
					aV.getQtn_cartao_vermelho() + partida.getVisitante().getAtacante().getQtn_cartao_vermelho());
			jService.atualizarJogador(aV);

			// Mandante
			// Gols Partida
			Equipe mandante = eService.buscarEquipe(partida.getMandante().getEquipe().getId());

			// Visitante
			Equipe visitante = eService.buscarEquipe(partida.getVisitante().getEquipe().getId());

			if (partida.getGolsMandante() > partida.getGolsVisitante()) {
				System.out.println("Mandante Wins");
				mandante.setVitorias(mandante.getVitorias() + 1);
				visitante.setDerrotas(visitante.getDerrotas() + 1);
			} else if (partida.getGolsMandante() < partida.getGolsVisitante()) {
				System.out.println("Visitante Wins");
				mandante.setDerrotas(mandante.getDerrotas() + 1);
				visitante.setVitorias(visitante.getVitorias() + 1);
			} else {
				System.out.println("Empate");
				mandante.setEmpates(mandante.getEmpates() + 1);
				visitante.setEmpates(visitante.getEmpates() + 1);
			}

			mandante.setGolsFeitos(partida.getGolsMandante());
			mandante.setGolsSofridos(partida.getGolsVisitante());
			visitante.setGolsFeitos(partida.getGolsVisitante());
			visitante.setGolsSofridos(partida.getGolsMandante());

			eService.atualizarEquipe(visitante);
			eService.atualizarEquipe(mandante);

			Partida match = pService.buscarPartida(partida.getId());
			match.setGolsMandante(partida.getGolsMandante());
			match.setGolsVisitante(partida.getGolsVisitante());
			pService.atualizarPartida(match);

			return "redirect:listar_partidas";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
}
