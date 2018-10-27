package br.usjt.ads.pi.controller;

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

import br.usjt.ads.pi.model.entity.Campeonato;
import br.usjt.ads.pi.model.entity.Categoria;
import br.usjt.ads.pi.model.service.CampeonatoService;
import br.usjt.ads.pi.model.service.CategoriaService;
import br.usjt.ads.pi.model.service.RegulamentoService;

@RestController
public class ManterCampeonatoControllerRest {
	@Autowired
	private CampeonatoService campeonatoService;
	@Autowired
	private RegulamentoService regulamentoService;
	@Autowired
	private CategoriaService categoriaService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET, value = "api/campeonatos")
	public ResponseEntity<List<Campeonato>> listarCampeonatos() {
		try {
			List<Campeonato> lista = campeonatoService.listarCampeonatos();
			return new ResponseEntity<List<Campeonato>>(lista, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "api/campeonatos/{id}")
	public @ResponseBody Campeonato listarCampeonato(@PathVariable("id") Long id) {
		Campeonato campeonato = null, param;
		try {
			campeonato = campeonatoService.buscarCampeonato(id.intValue());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return campeonato;
	}

	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "api/campeonatos")
	public ResponseEntity<Campeonato> cadastrarCampeonato(@RequestBody Campeonato campeonato) {
		try {
			// Categoria
			Categoria categoria = categoriaService.buscarCategoria(campeonato.getCategoria().getId());
			campeonato.setCategoria(categoria);

			// Regulamento
			campeonato.getRegulamento().setId(regulamentoService.cadastrarRegulamento(campeonato));

			Campeonato refreshCamp = campeonatoService
					.buscarCampeonato(campeonatoService.cadastrarCampeonato(campeonato));
			return new ResponseEntity<Campeonato>(refreshCamp, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "api/campeonatos")
	public @ResponseBody Campeonato atualizarCampeonato(@RequestBody Campeonato campeonato) {
		try {
			campeonatoService.atualizarCampeonato(campeonato);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return campeonato;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "api/campeonatos/{id}")
	public @ResponseBody int deleteCampeonato(@PathVariable("id") Long id) {
		try {
			campeonatoService.excluirCampeonato(id.intValue());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return id.intValue();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET, value = "api/categorias")
	public ResponseEntity<List<Categoria>> listarCategorias() {
		try {
			List<Categoria> lista = categoriaService.listarCategorias();
			return new ResponseEntity<List<Categoria>>(lista, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "api/categorias/{id}")
	public @ResponseBody Categoria listarCategoria(@PathVariable("id") Long id) {
		Categoria categoria = null;
		try {
			categoria = categoriaService.buscarCategoria(id.intValue());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return categoria;
	}
}
