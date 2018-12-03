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
import br.usjt.ads.pi.model.entity.TipoArbitro;
import br.usjt.ads.pi.model.service.ArbitroService;
import br.usjt.ads.pi.model.service.TipoArbitroService;

@Controller
public class ArbitroController {
	@Autowired
	private TipoArbitroService tipoService;
	@Autowired
	private ArbitroService arbitroService;

	@RequestMapping("/novo_arbitro")
	public String novaEquipe(HttpSession session) {
		List<TipoArbitro> tipoArbitros;
		try {
			tipoArbitros = tipoService.listarTiposArbitro();
			session.setAttribute("tipos", tipoArbitros);
			return "NovoArbitro";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	@RequestMapping("/listar_arbitros")
	public String arbitrosIndex(HttpSession session) {
		try {
			List<Arbitro> arbitros = arbitroService.listarArbitros();
			session.setAttribute("arbitros", arbitros);
			return "listarArbitros";

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}

	}

	@RequestMapping("/inserir_arbitro")
	public String cadastrarEquipe(Arbitro arbitro, BindingResult result, Model model, HttpSession session) {
		try {

			// TIPO
			TipoArbitro tipoArbitro = tipoService.buscarTipoArbitro(arbitro.getTipoArbitro().getId());
			arbitro.setTipoArbitro(tipoArbitro);

			arbitroService.cadastrarArbitro(arbitro);

			List<Arbitro> arbitros = arbitroService.listarArbitros();
			session.setAttribute("arbitros", arbitros);
			return "listarArbitros";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";

		}
	}
	
	@RequestMapping("/editar_arbitro")
	public String editarCampeonato(Arbitro arbitro, HttpSession session, Model model) {
		try {
			
			List<TipoArbitro> types = tipoService.listarTiposArbitro();
			session.setAttribute("tipos", types);
			
			Arbitro refree = arbitroService.buscarArbitro(arbitro.getId());
			model.addAttribute("arbitro", refree);
			return "AlterarArbitro";
		}
		catch(IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("/atualizar_arbitro")
	public String gravarAtualizacaoEquipe(Arbitro arbitro, Model model, HttpSession session) {
		try {
				// Tipo
				TipoArbitro type = new TipoArbitro();
				type.setId(arbitro.getTipoArbitro().getId());
				type.setTipo(tipoService.buscarTipoArbitro(type.getId()).getTipo());
				arbitro.setTipoArbitro(type);
				
				arbitroService.atualizarArbitros(arbitro);

				model.addAttribute("arbitro", arbitro);
				List<Arbitro> arbitros = (List<Arbitro>) session.getAttribute("arbitros");
				session.setAttribute("arbitros", atualizarDaLista(arbitro, arbitros));

				return "listarArbitros";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}

	@RequestMapping("/excluir_arbitro")
	public String excluirArbitro(Arbitro arbitro, HttpSession session, Model model) {
		try {
			arbitroService.excluirArbitro(arbitro.getId());
			List<Arbitro> arbitros = (List<Arbitro>) session.getAttribute("arbitros");
			session.setAttribute("jogadores", removerDaLista(arbitro, arbitros));
			return "listarArbitros";

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}

	}
	
	private List<Arbitro> atualizarDaLista(Arbitro arbitro, List<Arbitro> arbitros){
		for(int i = 0; i < arbitros.size(); i++) {
			if(arbitro.getId() == arbitros.get(i).getId()) {
				arbitros.remove(i);
				arbitros.add(i, arbitro);
				break;
			}
		}
		return arbitros;
	}

	private List<Arbitro> removerDaLista(Arbitro arbitro, List<Arbitro> arbitros) {
		for (int i = 0; i < arbitros.size(); i++) {
			if (arbitro.getId() == arbitros.get(i).getId()) {
				arbitros.remove(i);
				break;
			}
		}
		return arbitros;
	}
}
