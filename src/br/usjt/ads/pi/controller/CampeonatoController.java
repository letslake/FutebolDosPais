package br.usjt.ads.pi.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.usjt.ads.pi.model.entity.Campeonato;
import br.usjt.ads.pi.model.entity.Categoria;
import br.usjt.ads.pi.model.entity.Regulamento;
import br.usjt.ads.pi.model.entity.Usuario;
import br.usjt.ads.pi.model.service.CampeonatoService;
import br.usjt.ads.pi.model.service.CategoriaService;
import br.usjt.ads.pi.model.service.RegulamentoService;
import br.usjt.ads.pi.model.service.UserService;

@Controller
public class CampeonatoController {
	@Autowired
	private UserService authService;
	@Autowired
	private CampeonatoService campeonatoService;
	@Autowired
	private RegulamentoService regulamentoService;
	@Autowired
	private CategoriaService categoriaService;

	public CampeonatoController() {
		authService = new UserService();
	}

	@RequestMapping("/")
	public String inicio() {
		return "index";
	}

	@RequestMapping("/inicio")
	public String inicio1() {
		return "redirect:/";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/fazer_login")
	public String Authentification(HttpSession session, @RequestParam String username, @RequestParam String senha) {
		System.out.println(username);
		System.out.println(senha);
		try {
			Usuario adm = authService.buscarUsuario(username);
			System.out.println(adm);
			if (adm != null) {
				if (senha.equals(adm.getSenha())) {
					session.setAttribute("adm", adm);
					return "index";
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:inicio";
	}

	@RequestMapping("/fazer_logout")
	public String sair(HttpSession session) {
		session.removeAttribute("adm");
		return "redirect:inicio";
	}

	@RequestMapping("/listar_campeonatos")
	public String campeonatoIndex(HttpSession session) {
		try {
			List<Campeonato> campeonatos = campeonatoService.listarCampeonatos();
			session.setAttribute("campeonatos", campeonatos);
			return "listarCampeonatos";

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}

	}
	
	@RequestMapping("/atualizar_campeonato")
	public String gravarAtualizacaoCampeonato(Campeonato campeonato, Model model, HttpSession session) {
		try {
				//Categoria 
				Categoria categoria = new Categoria();
				categoria.setId(campeonato.getCategoria().getId());
				categoria.setNome(categoriaService.buscarCategoria(categoria.getId()).getNome());
				campeonato.setCategoria(categoria);

				// Regulamento
				campeonatoService.atualizarCampeonato(campeonato);

				model.addAttribute("campeonato", campeonato);
				List<Campeonato> campeonatos = (List<Campeonato>) session.getAttribute("campeonatos");
				session.setAttribute("campeonatos", atualizarDaLista(campeonato, campeonatos));

				return "listarCampeonatos";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}
	
	@RequestMapping("/editar_campeonato")
	public String editarCampeonato(Campeonato campeonato, HttpSession session, Model model) {
		try {
			System.out.println(campeonato);
			List<Categoria> category = categoriaService.listarCategorias();
			session.setAttribute("categorias", category);
			
			Campeonato tournament = campeonatoService.buscarCampeonato(campeonato.getId());
			model.addAttribute("campeonato", tournament);
			return "AlterarCampeonato";
		}
		catch(IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	@RequestMapping("/excluir_campeonato")
	public String excluirCampeonato(Campeonato campeonato, HttpSession session, Model model) {
		try {
			campeonatoService.excluirCampeonato(campeonato.getId());
			List<Campeonato> campeonatos = (List<Campeonato>) session.getAttribute("campeonatos");
			session.setAttribute("campeonatos", removerDaLista(campeonato, campeonatos));
			return "listarCampeonatos";

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}

	}

	private List<Campeonato> removerDaLista(Campeonato campeonato, List<Campeonato> campeonatos) {
		for (int i = 0; i <= campeonatos.size(); i++) {
			if (campeonato.getId() == campeonatos.get(i).getId()) {
				campeonatos.remove(i);
				break;
			}
		}
		return campeonatos;
	}
	
	private List<Campeonato> atualizarDaLista(Campeonato campeonato, List<Campeonato> campeonatos){
		for(int i = 0; i < campeonatos.size(); i++) {
			if(campeonato.getId() == campeonatos.get(i).getId()) {
				campeonatos.remove(i);
				campeonatos.add(i, campeonato);
				break;
			}
		}
		return campeonatos;
	}

	@RequestMapping("/novo_campeonato")
	public String novoCampeonato(HttpSession session) {
		try {
			List<Categoria> categorias = categoriaService.listarCategorias();
			session.setAttribute("categorias", categorias);
			return "NovoCampeonato";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	@RequestMapping("/inserir_campeonato")
	public String cadastrarCampeonato(Campeonato campeonato, BindingResult result, Model model, HttpSession session) {
		try {
			System.out.println(campeonato);
			System.out.println(campeonato.getRegulamento());
			// Categoria
			Categoria categoria = categoriaService.buscarCategoria(campeonato.getCategoria().getId());
			campeonato.setCategoria(categoria);

			// Regulamento
			campeonato.getRegulamento().setId(regulamentoService.cadastrarRegulamento(campeonato));
			
			model.addAttribute("campeonato", campeonato);
			campeonatoService.cadastrarCampeonato(campeonato);
			return "redirect:listar_campeonatos";
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "index";
	}

}
