package br.usjt.ads.pi.model.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ads.pi.model.dao.TecnicoDAO;
import br.usjt.ads.pi.model.entity.Tecnico;

@Service
public class TecnicoService {
	@Autowired
	private TecnicoDAO tecnicoDAO;

	public int cadastrarTecnico(Tecnico tecnico) throws IOException {
		return tecnicoDAO.cadastrarTecnico(tecnico);
	}

	public Tecnico buscarTecnico(int id) throws IOException {
		return tecnicoDAO.buscarTecnico(id);
	}

	public ArrayList<Tecnico> listarTecnicos() throws IOException {
		return tecnicoDAO.listarTecnicos();
	}

	public void atualizarTecnico(Tecnico tecnico) throws IOException {
		tecnicoDAO.alterarTecnico(tecnico);
		return;
	}

	public void excluirTecnico(int id) throws IOException {
		tecnicoDAO.excluirTecnico(id);
		return;
	}
}
