package br.usjt.ads.pi.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.usjt.ads.pi.model.entity.Administrador;
import br.usjt.ads.pi.model.service.AuthentificationService;

@Controller
public class ManterCampeonatoController {
	private AuthentificationService authService;

	public ManterCampeonatoController() {
		authService = new AuthentificationService();
	}

	@RequestMapping("/")
	public String inicio() {
		return "index";
	}

	@RequestMapping("/inicio")
	public String inicio1() {
		return "index";
	}

	@RequestMapping("/listar_equipes")
	public String listarEquipes() {
		return "listarEquipes";
	}

	@RequestMapping("/listar_jogadores")
	public String listarJogadores() {
		return "listarJogadores";
	}

	@RequestMapping("/listar_arbitros")
	public String listarArbitros() {
		return "listarJogadores";
	}

	@RequestMapping("/listar_campeonatos")
	public String listarCampeonatos() {
		return "listarJogadores";
	}

	@RequestMapping("/listar_tecnicos")
	public String listarTecnicos() {
		return "listarJogadores";
	}

	@RequestMapping("/listar_turnos")
	public String listarTurnos() {
		return "listarJogadores";
	}

	@RequestMapping("/listar_categorias")
	public String listarCategorias() {
		return "listarJogadores";
	}

	@RequestMapping("/listar_rodadas")
	public String listarRodadas() {
		return "listarJogadores";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/entrar")
	public String Authentification(HttpSession session, @RequestParam String username, @RequestParam String senha) {
		System.out.println(username);
		System.out.println(senha);
		try {
			Administrador adm = authService.buscarAdministrador(username);
			System.out.println(adm);
			if(adm != null) {
				if(senha.equals(adm.getSenha())) {
					session.setAttribute("adm", adm);
					return "loginSuccess";
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "index";
	}

}
