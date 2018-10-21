package br.usjt.ads.pi.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.usjt.ads.pi.model.entity.Administrador;
import br.usjt.ads.pi.model.entity.Campeonato;
import br.usjt.ads.pi.model.entity.Categoria;
import br.usjt.ads.pi.model.service.AuthentificationService;
import br.usjt.ads.pi.model.service.CampeonatoService;
import br.usjt.ads.pi.model.service.CategoriaService;
import br.usjt.ads.pi.model.service.RegulamentoService;

@Controller
public class ManterCampeonatoController {
	@Autowired
	private AuthentificationService authService;
	@Autowired
	private CampeonatoService campeonatoService;
	@Autowired
	private RegulamentoService regulamentoService;
	@Autowired
	private CategoriaService categoriaService;

	public ManterCampeonatoController() {
		authService = new AuthentificationService();
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
			Administrador adm = authService.buscarAdministrador(username);
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

	@RequestMapping("/campeonato_index")
	public String campeonatoIndex(HttpSession session) {
		return "CampeonatoDashboard";
	}

	@RequestMapping("/cadastrar_campeonato")
	public String cadastrarCampeonato(Campeonato campeonato, Model model, HttpSession session) {
		try {
			// Categoria
			Categoria categoria = categoriaService.buscarCategoria(campeonato.getCategoria().getId());
			campeonato.setCategoria(categoria);
			
			// Regulamento
			campeonato.getRegulamento().setId(regulamentoService.cadastrarRegulamento(campeonato));
			
			model.addAttribute("campeonato", campeonato);
			campeonatoService.cadastrarCampeonato(campeonato);
			return "redirect:campeonatos";
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "index";
	}

	@RequestMapping("/campeonatos")
	public String campeonatos(HttpSession session) {
		try {
			ArrayList<Campeonato> lista = campeonatoService.listarCampeonatos();
			session.setAttribute("campeonatos", lista);
			return "Campeonatos";
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "index";
	}

}
