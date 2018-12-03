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
import br.usjt.ads.pi.model.entity.Equipe;
import br.usjt.ads.pi.model.service.CategoriaService;
import br.usjt.ads.pi.model.service.CoordenadorService;
import br.usjt.ads.pi.model.service.EquipeService;
import br.usjt.ads.pi.model.service.TecnicoService;

@Controller
public class EquipeController {
	@Autowired
	private TecnicoService tecnicoService;
	@Autowired
	private CoordenadorService coordenadorService;
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private EquipeService equipeService;

	@RequestMapping("/listar_equipes")
	public String jogadoresIndex(HttpSession session) {
		try {
			List<Equipe> equipes = equipeService.listarEquipes();
			session.setAttribute("equipes", equipes);
			return "listarEquipes";

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}

	}
	
	@RequestMapping("/nova_equipe")
	public String novaEquipe(HttpSession session) {
		List<Categoria> categorias;
		try {
			categorias = categoriaService.listarCategorias();
			session.setAttribute("categorias", categorias);
			return "NovaEquipe";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	@RequestMapping("/inserir_equipe")
	public String cadastrarEquipe(Equipe equipe, BindingResult result, Model model, HttpSession session) {
		try {
			
			// Coordenador
			equipe.getCoordenador().setId(coordenadorService.cadastrarCoordenador(equipe));

			// Tecnico
			equipe.getTecnico().setId(tecnicoService.cadastrarTecnico(equipe));

			// Categoria
			Categoria categoria = categoriaService.buscarCategoria(equipe.getCategoria().getId());
			equipe.setCategoria(categoria);
			
			equipeService.cadastrarEquipe(equipe);
			
			List<Equipe> equipes = equipeService.listarEquipes();
			session.setAttribute("equipes", equipes);
			return "listarEquipes";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";

		}
	}

	@RequestMapping("/excluir_equipe")
	public String excluirEquipe(Equipe equipe, HttpSession session, Model model) {
		try {
			equipeService.excluirEquipe(equipe.getId());
			List<Equipe> equipes = (List<Equipe>) session.getAttribute("equipes");
			session.setAttribute("equipes", removerDaLista(equipe, equipes));
			return "listarEquipes";

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}

	}
	
	@RequestMapping("/atualizar_equipe")
	public String gravarAtualizacaoEquipe(Equipe equipe, Model model, HttpSession session) {
		try {
				System.out.println(equipe);
				//Categoria 
				Categoria categoria = new Categoria();
				categoria.setId(equipe.getCategoria().getId());
				categoria.setNome(categoriaService.buscarCategoria(categoria.getId()).getNome());
				equipe.setCategoria(categoria);
				

				equipeService.atualizarEquipe(equipe);
				

				model.addAttribute("equipe", equipe);
				List<Equipe> equipes = (List<Equipe>) session.getAttribute("equipes");
				session.setAttribute("equipes", atualizarDaLista(equipe, equipes));

				return "listarEquipes";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}
	
	@RequestMapping("/editar_equipe")
	public String editarCampeonato(Equipe equipe, HttpSession session, Model model) {
		try {
			System.out.println(equipe);
			List<Categoria> category = categoriaService.listarCategorias();
			session.setAttribute("categorias", category);
			
			Equipe team = equipeService.buscarEquipe(equipe.getId());
			model.addAttribute("equipe", team);
			return "AlterarEquipe";
		}
		catch(IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	private List<Equipe> atualizarDaLista(Equipe equipe, List<Equipe> equipes){
		for(int i = 0; i < equipes.size(); i++) {
			if(equipe.getId() == equipes.get(i).getId()) {
				equipes.remove(i);
				equipes.add(i, equipe);
				break;
			}
		}
		return equipes;
	}

	private List<Equipe> removerDaLista(Equipe equipe, List<Equipe> equipes) {
		for (int i = 0; i < equipes.size(); i++) {
			if (equipe.getId() == equipes.get(i).getId()) {
				equipes.remove(i);
				break;
			}
		}
		return equipes;
	}

}
