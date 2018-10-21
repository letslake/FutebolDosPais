package br.usjt.ads.pi.model.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ads.pi.model.dao.CampeonatoDAO;
import br.usjt.ads.pi.model.entity.Campeonato;

@Service
public class CampeonatoService {
	@Autowired
	private CampeonatoDAO campeonatoDAO;

	public int cadastrarCampeonato(Campeonato campeonato) throws IOException {
		return campeonatoDAO.cadastrarCampeonato(campeonato);
	}

	public void atualizarCampeonato(Campeonato campeonato) throws IOException {
		campeonatoDAO.atualizarCampeonato(campeonato);
		return;
	}

	public ArrayList<Campeonato> listarCampeonatos() throws IOException {
		return campeonatoDAO.listarCampeonatos();
	}

	public Campeonato buscarCampeonato(int id) throws IOException {
		return campeonatoDAO.buscarCampeonato(id);

	}

	public void excluirCampeonato(int id) throws IOException {
		campeonatoDAO.excluirCampeonato(id);
		return;
	}
}
