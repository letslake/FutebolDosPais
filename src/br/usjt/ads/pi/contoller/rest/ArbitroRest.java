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
import br.usjt.ads.pi.model.service.ArbitroService;

@RestController
public class ArbitroRest {
	@Autowired
	private ArbitroService aService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET, value = "api/arbitros")
	public ResponseEntity<List<Arbitro>> listarArbitro() {
		try {
			List<Arbitro> lista = aService.listarArbitros();
			return new ResponseEntity<List<Arbitro>>(lista, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "api/arbitros/{id}")
	public @ResponseBody Arbitro buscarArbitro(@PathVariable("id") Long id) {
		Arbitro arbitro = null, param;
		try {
			
			arbitro = aService.buscarArbitro(id.intValue());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return arbitro;
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "api/arbitros")
	public ResponseEntity<Arbitro> cadastrarArbitro(@RequestBody Arbitro arbitro) {
		try {
			Arbitro a = aService.buscarArbitro(aService.cadastrarArbitro(arbitro));
			return new ResponseEntity<Arbitro>(a, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "api/arbitros")
	public @ResponseBody Arbitro atualizarArbitro(@RequestBody Arbitro arbitro) {
		Arbitro newArbitro = null, params;
		try {
			aService.atualizarArbitros(arbitro);
			newArbitro = aService.buscarArbitro(arbitro.getId());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return newArbitro;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "api/arbitros/{id}")
	public @ResponseBody int deleteArbitro(@PathVariable("id") Long id) {
		try {
			aService.excluirArbitro(id.intValue());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return id.intValue();
	}
}
