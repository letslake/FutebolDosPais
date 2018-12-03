package br.usjt.ads.pi.model.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ads.pi.model.dao.CoordenadorDAO;
import br.usjt.ads.pi.model.entity.Coordenador;
import br.usjt.ads.pi.model.entity.Equipe;

@Service
public class CoordenadorService {

	@Autowired
	private CoordenadorDAO coordenadorDAO;

	@Transactional
	public int cadastrarCoordenador(Equipe equipe) throws IOException {
		return coordenadorDAO.cadastrarCoordenador(equipe);
	}

//	public int cadastrarCoordenador(Coordenador coordenador) throws IOException {
//		return coordenadorDAO.cadastrarCoordenador(coordenador);
//	}

	public Coordenador buscarCoordenador(int id) throws IOException {
		return coordenadorDAO.buscarCoordenador(id);
	}

	public List<Coordenador> listarCoordenadores() throws IOException {
		return coordenadorDAO.listarCoordenadores();
	}

	@Transactional
	public void alterarCoordenador(Coordenador coordenador) throws IOException {
		coordenadorDAO.alterarCoordenador(coordenador);
		return;
	}

	@Transactional
	public void excluirCoordenador(int id) throws IOException {
		coordenadorDAO.excluirCoordenador(id);
		return;
	}
}
