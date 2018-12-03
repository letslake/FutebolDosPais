package br.usjt.ads.pi.model.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ads.pi.model.dao.TecnicoDAO;
import br.usjt.ads.pi.model.entity.Equipe;
import br.usjt.ads.pi.model.entity.Tecnico;

@Service
public class TecnicoService {
	@Autowired
	private TecnicoDAO tecnicoDAO;
	@Transactional
	public int cadastrarTecnico(Equipe equipe) throws IOException {
		return tecnicoDAO.cadastrarTecnico(equipe);
	}

	public Tecnico buscarTecnico(int id) throws IOException {
		return tecnicoDAO.buscarTecnico(id);
	}

	public List<Tecnico> listarTecnicos() throws IOException {
		return tecnicoDAO.listarTecnicos();
	}
	@Transactional
	public void atualizarTecnico(Tecnico tecnico) throws IOException {
		tecnicoDAO.alterarTecnico(tecnico);
		return;
	}
	@Transactional
	public void excluirTecnico(int id) throws IOException {
		tecnicoDAO.excluirTecnico(id);
		return;
	}
}
