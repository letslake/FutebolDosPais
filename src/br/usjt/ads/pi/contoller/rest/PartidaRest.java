package br.usjt.ads.pi.contoller.rest;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.ads.pi.model.entity.Arbitro;
import br.usjt.ads.pi.model.entity.Campeonato;
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

@RestController
public class PartidaRest {
	@Autowired
	private PartidaService pService;
	@Autowired
	private ArbitroService aService;
	@Autowired
	private TurnoService tService;
	@Autowired
	private LocalService lService;
	@Autowired
	private CampeonatoService cService;
	@Autowired
	private EquipeService eService;
	@Autowired
	private JogadorService jService;
	@Autowired
	private FormacaoService fService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET, value = "api/partidas")
	public ResponseEntity<List<Partida>> listarPartida() {
		try {

			List<Partida> lista = pService.listarPartidas();
			return new ResponseEntity<List<Partida>>(lista, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "api/partidas/{id}")
	public @ResponseBody Partida listarPartida(@PathVariable("id") Long id) {
		Partida partida = null, param;
		try {
			partida = pService.buscarPartida(id.intValue());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return partida;
	}

	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "api/partidas")
	public ResponseEntity<Partida> cadastrarJogador(@RequestBody Partida partida) {
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
			
			int idPartida = pService.cadastrarPartida(partida);
			
			System.out.println(idPartida);
			Partida refreshPartida = pService.buscarPartida(pService.cadastrarPartida(partida));
			return new ResponseEntity<Partida>(refreshPartida, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "api/partidas")
	public @ResponseBody Partida atualizarPartida(@RequestBody Partida partida) {
		try {
			pService.atualizarPartida(partida);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return partida;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "api/partidas/{id}")
	public @ResponseBody int deletePartida(@PathVariable("id") Long id) {
		try {
			pService.excluirPartida(id.intValue());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return id.intValue();
	}
}
