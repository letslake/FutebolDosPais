package br.usjt.ads.pi.model.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ads.pi.model.dao.EquipeDAO;
import br.usjt.ads.pi.model.entity.Equipe;

@Service
public class EquipeService {

	@Autowired
	private EquipeDAO equipeDAO;

	@Transactional
	public int cadastrarEquipe(Equipe equipe) throws IOException {
		return equipeDAO.cadastrarEquipe(equipe);
	}

	public Equipe buscarEquipe(int id) throws IOException {
		return equipeDAO.buscarEquipe(id);
	}

	public List<Equipe> listarEquipes() throws IOException {
		return equipeDAO.listarEquipes();
	}

	@Transactional
	public void atualizarEquipe(Equipe equipe) throws IOException {
		equipeDAO.atualizarEquipe(equipe);
		return;
	}

	@Transactional
	public void excluirEquipe(int id) throws IOException {
		equipeDAO.excluirEquipe(id);
		return;
	}
}
