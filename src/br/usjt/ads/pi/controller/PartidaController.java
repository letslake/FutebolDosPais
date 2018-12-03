package br.usjt.ads.pi.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.ads.pi.model.entity.Arbitro;
import br.usjt.ads.pi.model.entity.Campeonato;
import br.usjt.ads.pi.model.entity.Equipe;
import br.usjt.ads.pi.model.entity.Jogador;
import br.usjt.ads.pi.model.entity.Local;
import br.usjt.ads.pi.model.entity.Partida;
import br.usjt.ads.pi.model.entity.Turno;
import br.usjt.ads.pi.model.service.ArbitroService;
import br.usjt.ads.pi.model.service.CampeonatoService;
import br.usjt.ads.pi.model.service.EquipeService;
import br.usjt.ads.pi.model.service.FormacaoService;
import br.usjt.ads.pi.model.service.JogadorService;
import br.usjt.ads.pi.model.service.LocalService;
import br.usjt.ads.pi.model.service.PartidaService;
import br.usjt.ads.pi.model.service.TurnoService;

@Controller
public class PartidaController {
	@Autowired
	private PartidaService pService;
	@Autowired
	private ArbitroService aService;
	@Autowired
	private EquipeService eService;
	@Autowired
	private CampeonatoService cService;
	@Autowired
	private JogadorService jService;
	@Autowired
	private LocalService lService;
	@Autowired
	private TurnoService tService;
	@Autowired
	private FormacaoService fService;

	@RequestMapping("/nova_partida")
	public String novaPartida(HttpSession session) {
		List<Equipe> equipes;
		List<Arbitro> arbitros;
		List<Campeonato> campeonatos;
		List<Jogador> jogadores;
		List<Local> locais;
		List<Turno> turnos;
		try {
			equipes = eService.listarEquipes();
			arbitros = aService.listarArbitros();
			campeonatos = cService.listarCampeonatos();
			jogadores = jService.listarJogadores();
			locais = lService.listarLocais();
			turnos = tService.listarTurnos();
			session.setAttribute("equipes", equipes);
			session.setAttribute("arbitros", arbitros);
			session.setAttribute("locais", locais);
			session.setAttribute("turnos", turnos);
			session.setAttribute("campeonatos", campeonatos);
			session.setAttribute("jogadores", jogadores);
			return "NovaPartida";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	@RequestMapping("/inserir_partida")
	public String inserirPartida(Partida partida, BindingResult result, Model model, HttpSession session) {
		try {

			// Campeonato
			Campeonato campeonato = cService.buscarCampeonato(partida.getCampeonato().getId());
			partida.setCampeonato(campeonato);

			// Turno
			Turno turno = tService.buscarTurno(partida.getTurno().getId());
			partida.setTurno(turno);

			// Local
			Local local = lService.buscarLocal(partida.getLocal().getId());
			partida.setLocal(local);

			// Arbitro
			Arbitro arbitro = aService.buscarArbitro(partida.getArbitro().getId());
			partida.setArbitro(arbitro);

			// Mandante
			partida.getMandante().setEquipe(eService.buscarEquipe(partida.getMandante().getEquipe().getId()));
			partida.getMandante().setGoleiro(jService.buscarJogador(partida.getMandante().getGoleiro().getId()));
			partida.getMandante()
					.setLateralDireito(jService.buscarJogador(partida.getMandante().getLateralDireito().getId()));
			partida.getMandante().setZagueiro1(jService.buscarJogador(partida.getMandante().getZagueiro1().getId()));
			partida.getMandante().setZagueiro2(jService.buscarJogador(partida.getMandante().getZagueiro2().getId()));
			partida.getMandante()
					.setLateralEsquerdo(jService.buscarJogador(partida.getMandante().getLateralEsquerdo().getId()));
			partida.getMandante().setVolante(jService.buscarJogador(partida.getMandante().getVolante().getId()));
			partida.getMandante().setMeioCampo1(jService.buscarJogador(partida.getMandante().getMeioCampo1().getId()));
			partida.getMandante().setMeioCampo2(jService.buscarJogador(partida.getMandante().getMeioCampo2().getId()));
			partida.getMandante()
					.setPontaDireita(jService.buscarJogador(partida.getMandante().getPontaDireita().getId()));
			partida.getMandante().setAtacante(jService.buscarJogador(partida.getMandante().getAtacante().getId()));
			partida.getMandante()
					.setPontaEsquerda(jService.buscarJogador(partida.getMandante().getPontaEsquerda().getId()));
			partida.getMandante().setId(fService.cadastrarMandante(partida));

			// Visitante
			partida.getVisitante().setEquipe(eService.buscarEquipe(partida.getVisitante().getEquipe().getId()));
			partida.getVisitante().setGoleiro(jService.buscarJogador(partida.getVisitante().getGoleiro().getId()));
			partida.getVisitante()
					.setLateralDireito(jService.buscarJogador(partida.getVisitante().getLateralDireito().getId()));
			partida.getVisitante().setZagueiro1(jService.buscarJogador(partida.getVisitante().getZagueiro1().getId()));
			partida.getVisitante().setZagueiro2(jService.buscarJogador(partida.getVisitante().getZagueiro2().getId()));
			partida.getVisitante()
					.setLateralEsquerdo(jService.buscarJogador(partida.getVisitante().getLateralEsquerdo().getId()));
			partida.getVisitante().setVolante(jService.buscarJogador(partida.getVisitante().getVolante().getId()));
			partida.getVisitante()
					.setMeioCampo1(jService.buscarJogador(partida.getVisitante().getMeioCampo1().getId()));
			partida.getVisitante()
					.setMeioCampo2(jService.buscarJogador(partida.getVisitante().getMeioCampo2().getId()));
			partida.getVisitante()
					.setPontaDireita(jService.buscarJogador(partida.getVisitante().getPontaDireita().getId()));
			partida.getVisitante().setAtacante(jService.buscarJogador(partida.getVisitante().getAtacante().getId()));
			partida.getVisitante()
					.setPontaEsquerda(jService.buscarJogador(partida.getVisitante().getPontaEsquerda().getId()));
			partida.getVisitante().setId(fService.cadastrarVisitante(partida));
			System.out.println(partida);

			model.addAttribute("partida", partida);
			pService.cadastrarPartida(partida);
			return "redirect:listar_partidas";
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "index";
	}

	@RequestMapping("/listar_partidas")
	public String partidasIndex(HttpSession session) {
		try {
			List<Partida> partidas = pService.listarPartidas();
			session.setAttribute("partidas", partidas);
			return "listarPartidas";

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}

	}

	@RequestMapping("/editar_partida")
	public String editarCampeonato(Partida partida, HttpSession session, Model model) {
		List<Equipe> equipes;
		List<Arbitro> arbitros;
		List<Campeonato> campeonatos;
		List<Jogador> jogadores;
		List<Local> locais;
		List<Turno> turnos;
		try {
			equipes = eService.listarEquipes();
			arbitros = aService.listarArbitros();
			campeonatos = cService.listarCampeonatos();
			jogadores = jService.listarJogadores();
			locais = lService.listarLocais();
			turnos = tService.listarTurnos();
			session.setAttribute("equipes", equipes);
			session.setAttribute("arbitros", arbitros);
			session.setAttribute("locais", locais);
			session.setAttribute("turnos", turnos);
			session.setAttribute("campeonatos", campeonatos);
			session.setAttribute("jogadores", jogadores);

			Partida match = pService.buscarPartida(partida.getId());
			model.addAttribute("partida", match);
			return "AlterarPartida";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	@RequestMapping("/atualizar_partida")
	public String gravarAtualizacaoEquipe(Partida partida, Model model, HttpSession session) {
		try {
			// Campeonato
			Campeonato campeonato = cService.buscarCampeonato(partida.getCampeonato().getId());
			partida.setCampeonato(campeonato);

			// Turno
			Turno turno = tService.buscarTurno(partida.getTurno().getId());
			partida.setTurno(turno);

			// Local
			Local local = lService.buscarLocal(partida.getLocal().getId());
			partida.setLocal(local);

			// Arbitro
			Arbitro arbitro = aService.buscarArbitro(partida.getArbitro().getId());
			partida.setArbitro(arbitro);
			// Formacao Mandante
			partida.getMandante().setEquipe(eService.buscarEquipe(partida.getMandante().getEquipe().getId()));
			partida.getMandante().setId(partida.getMandante().getId());
			partida.getMandante().setGoleiro(jService.buscarJogador(partida.getMandante().getGoleiro().getId()));
			partida.getMandante()
					.setLateralDireito(jService.buscarJogador(partida.getMandante().getLateralDireito().getId()));
			partida.getMandante().setZagueiro1(jService.buscarJogador(partida.getMandante().getZagueiro1().getId()));
			partida.getMandante().setZagueiro2(jService.buscarJogador(partida.getMandante().getZagueiro2().getId()));
			partida.getMandante()
					.setLateralEsquerdo(jService.buscarJogador(partida.getMandante().getLateralEsquerdo().getId()));
			partida.getMandante().setVolante(jService.buscarJogador(partida.getMandante().getVolante().getId()));
			partida.getMandante().setMeioCampo1(jService.buscarJogador(partida.getMandante().getMeioCampo1().getId()));
			partida.getMandante().setMeioCampo2(jService.buscarJogador(partida.getMandante().getMeioCampo2().getId()));
			partida.getMandante()
					.setPontaDireita(jService.buscarJogador(partida.getMandante().getPontaDireita().getId()));
			partida.getMandante().setAtacante(jService.buscarJogador(partida.getMandante().getAtacante().getId()));
			partida.getMandante()
					.setPontaEsquerda(jService.buscarJogador(partida.getMandante().getPontaEsquerda().getId()));
			fService.atualizarFormacao(partida.getMandante());

			// Visitante
			partida.getVisitante().setId(partida.getVisitante().getId());
			partida.getVisitante().setEquipe(eService.buscarEquipe(partida.getVisitante().getEquipe().getId()));
			partida.getVisitante().setGoleiro(jService.buscarJogador(partida.getVisitante().getGoleiro().getId()));
			partida.getVisitante()
					.setLateralDireito(jService.buscarJogador(partida.getVisitante().getLateralDireito().getId()));
			partida.getVisitante().setZagueiro1(jService.buscarJogador(partida.getVisitante().getZagueiro1().getId()));
			partida.getVisitante().setZagueiro2(jService.buscarJogador(partida.getVisitante().getZagueiro2().getId()));
			partida.getVisitante()
					.setLateralEsquerdo(jService.buscarJogador(partida.getVisitante().getLateralEsquerdo().getId()));
			partida.getVisitante().setVolante(jService.buscarJogador(partida.getVisitante().getVolante().getId()));
			partida.getVisitante()
					.setMeioCampo1(jService.buscarJogador(partida.getVisitante().getMeioCampo1().getId()));
			partida.getVisitante()
					.setMeioCampo2(jService.buscarJogador(partida.getVisitante().getMeioCampo2().getId()));
			partida.getVisitante()
					.setPontaDireita(jService.buscarJogador(partida.getVisitante().getPontaDireita().getId()));
			partida.getVisitante().setAtacante(jService.buscarJogador(partida.getVisitante().getAtacante().getId()));
			partida.getVisitante()
					.setPontaEsquerda(jService.buscarJogador(partida.getVisitante().getPontaEsquerda().getId()));
			fService.atualizarFormacao(partida.getVisitante());
			
			pService.atualizarPartida(partida);

			model.addAttribute("partida", partida);
			List<Partida> partidas = (List<Partida>) session.getAttribute("partidas");
			session.setAttribute("partidas", atualizarDaLista(partida, partidas));

			return "listarPartidas";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}

	@RequestMapping("/excluir_partida")
	public String excluirCampeonato(Partida partida, HttpSession session, Model model) {
		try {
			pService.excluirPartida(partida.getId());
			List<Partida> partidas = (List<Partida>) session.getAttribute("partidas");
			session.setAttribute("partidas", removerDaLista(partida, partidas));
			return "listarPartidas";

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}

	}
	
	private List<Partida> atualizarDaLista(Partida partida, List<Partida> partidas){
		for(int i = 0; i < partidas.size(); i++) {
			if(partida.getId() == partidas.get(i).getId()) {
				partidas.remove(i);
				partidas.add(i, partida);
				break;
			}
		}
		return partidas;
	}
	
	private List<Partida> removerDaLista(Partida partida, List<Partida> partidas) {
		for (int i = 0; i < partidas.size(); i++) {
			if (partida.getId() == partidas.get(i).getId()) {
				partidas.remove(i);
				break;
			}
		}
		return partidas;
	}
}
