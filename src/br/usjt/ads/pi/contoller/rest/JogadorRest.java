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
import br.usjt.ads.pi.model.entity.Jogador;
import br.usjt.ads.pi.model.service.CategoriaService;
import br.usjt.ads.pi.model.service.JogadorService;

@RestController
public class JogadorRest {
	@Autowired
	private JogadorService jService;
	@Autowired
	private CategoriaService categoriaService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET, value = "api/jogadores")
	public ResponseEntity<List<Jogador>> listarJogadores() {
		try {
			List<Jogador> lista = jService.listarJogadores();
			return new ResponseEntity<List<Jogador>>(lista, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "api/jogadores/{id}")
	public @ResponseBody Jogador listarJogador(@PathVariable("id") Long id) {
		Jogador jogador = null, param;
		try {
			jogador = jService.buscarJogador(id.intValue());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return jogador;
	}

	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "api/jogadores")
	public ResponseEntity<Jogador> cadastrarJogador(@RequestBody Jogador jogador) {
		try {
			// Categoria
			Categoria categoria = categoriaService.buscarCategoria(jogador.getCategoria().getId());
			jogador.setCategoria(categoria);

			Jogador refreshJogador = jService.buscarJogador(jService.cadastrarJogador(jogador));
			return new ResponseEntity<Jogador>(refreshJogador, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "api/jogadores")
	public @ResponseBody Jogador atualizarJogador(@RequestBody Jogador jogador) {
		try {
			jService.atualizarJogador(jogador);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return jogador;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "api/jogadores/{id}")
	public @ResponseBody int deleteCampeonato(@PathVariable("id") Long id) {
		try {
			jService.excluirJogador(id.intValue());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return id.intValue();
	}
}
