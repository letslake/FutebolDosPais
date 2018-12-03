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

import br.usjt.ads.pi.model.entity.Categoria;
import br.usjt.ads.pi.model.entity.Coordenador;
import br.usjt.ads.pi.model.entity.Equipe;
import br.usjt.ads.pi.model.entity.Tecnico;
import br.usjt.ads.pi.model.service.CategoriaService;
import br.usjt.ads.pi.model.service.CoordenadorService;
import br.usjt.ads.pi.model.service.EquipeService;
import br.usjt.ads.pi.model.service.TecnicoService;

@RestController
public class EquipeRest {

	@Autowired
	private EquipeService equipeService;
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private CoordenadorService coordenadorService;
	@Autowired
	private TecnicoService tecnicoService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET, value = "api/equipes")
	public ResponseEntity<List<Equipe>> listarEquipes() {
		try {
			List<Equipe> lista = equipeService.listarEquipes();
			return new ResponseEntity<List<Equipe>>(lista, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "api/equipes/{id}")
	public @ResponseBody Equipe listarEquipe(@PathVariable("id") Long id) {
		Equipe equipe = null, param;
		try {
			equipe = equipeService.buscarEquipe(id.intValue());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return equipe;
	}

	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "api/equipes")
	public ResponseEntity<Equipe> cadastrarEquipe(@RequestBody Equipe equipe) {
		try {
			// Coordenador
			equipe.getCoordenador().setId(coordenadorService.cadastrarCoordenador(equipe));

			// Tecnico
			equipe.getTecnico().setId(tecnicoService.cadastrarTecnico(equipe));

			// Categoria
			Categoria categoria = categoriaService.buscarCategoria(equipe.getCategoria().getId());
			equipe.setCategoria(categoria);
			
			Equipe refreshEquipe = equipeService.buscarEquipe(equipeService.cadastrarEquipe(equipe));
			return new ResponseEntity<Equipe>(refreshEquipe, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "api/equipes")
	public @ResponseBody Equipe atualizarEquipe(@RequestBody Equipe equipe) {
		try {
			equipeService.atualizarEquipe(equipe);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return equipe;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "api/equipes/{id}")
	public @ResponseBody int deleteCampeonato(@PathVariable("id") Long id) {
		try {
			equipeService.excluirEquipe(id.intValue());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return id.intValue();
	}
}
