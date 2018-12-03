package br.usjt.ads.pi.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.ads.pi.model.entity.Categoria;
import br.usjt.ads.pi.model.entity.Jogador;
import br.usjt.ads.pi.model.service.CategoriaService;
import br.usjt.ads.pi.model.service.JogadorService;

@Controller
public class JogadorController {
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private JogadorService jogadorService;

	@RequestMapping("/novo_jogador")
	public String novaEquipe(HttpSession session) {
		List<Categoria> categorias;
		try {
			categorias = categoriaService.listarCategorias();
			session.setAttribute("categorias", categorias);
			return "NovoJogador";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	@RequestMapping("/inserir_jogador")
	public String cadastrarEquipe(Jogador jogador, BindingResult result, Model model, HttpSession session) {
		try {

			// Categoria
			Categoria categoria = categoriaService.buscarCategoria(jogador.getCategoria().getId());
			jogador.setCategoria(categoria);
			
			jogadorService.cadastrarJogador(jogador);

			List<Jogador> jogadores = jogadorService.listarJogadores();
			session.setAttribute("jogadores", jogadores);
			return "listarJogadores";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";

		}
	}

	@RequestMapping("/listar_jogadores")
	public String jogadoresIndex(HttpSession session) {
		try {
			List<Jogador> jogadores = jogadorService.listarJogadores();
			session.setAttribute("jogadores", jogadores);
			return "listarJogadores";

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}

	}
	
	@RequestMapping("/atualizar_jogador")
	public String gravarAtualizacaoEquipe(Jogador jogador, Model model, HttpSession session) {
		try {
				//Categoria 
				Categoria categoria = new Categoria();
				categoria.setId(jogador.getCategoria().getId());
				categoria.setNome(categoriaService.buscarCategoria(categoria.getId()).getNome());
				jogador.setCategoria(categoria);
				
				jogadorService.atualizarJogador(jogador);
				

				model.addAttribute("jogador", jogador);
				List<Jogador> jogadores = (List<Jogador>) session.getAttribute("jogadores");
				session.setAttribute("jogadores", atualizarDaLista(jogador, jogadores));

				return "listarJogadores";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}
	
	@RequestMapping("/editar_jogador")
	public String editarCampeonato(Jogador jogador, HttpSession session, Model model) {
		try {
			List<Categoria> category = categoriaService.listarCategorias();
			session.setAttribute("categorias", category);
			
			Jogador player = jogadorService.buscarJogador(jogador.getId());
			model.addAttribute("jogador", player);
			return "AlterarJogador";
		}
		catch(IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	private List<Jogador> atualizarDaLista(Jogador jogador, List<Jogador> jogadores){
		for(int i = 0; i < jogadores.size(); i++) {
			if(jogador.getId() == jogadores.get(i).getId()) {
				jogadores.remove(i);
				jogadores.add(i, jogador);
				break;
			}
		}
		return jogadores;
	}

	@RequestMapping("/excluir_jogador")
	public String excluirCampeonato(Jogador jogador, HttpSession session, Model model) {
		try {
			jogadorService.excluirJogador(jogador.getId());
			List<Jogador> jogadores = (List<Jogador>) session.getAttribute("jogadores");
			session.setAttribute("jogadores", removerDaLista(jogador, jogadores));
			return "listarJogadores";

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}

	}

	private List<Jogador> removerDaLista(Jogador jogador, List<Jogador> jogadores) {
		for (int i = 0; i < jogadores.size(); i++) {
			if (jogador.getId() == jogadores.get(i).getId()) {
				jogadores.remove(i);
				break;
			}
		}
		return jogadores;
	}
}
