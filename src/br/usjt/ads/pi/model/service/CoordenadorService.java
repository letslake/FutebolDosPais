package br.usjt.ads.pi.model.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ads.pi.model.dao.CoordenadorDAO;
import br.usjt.ads.pi.model.entity.Coordenador;

@Service
public class CoordenadorService {

	@Autowired
	private CoordenadorDAO coordenadorDAO;

	public int cadastrarCoordenador(Coordenador coordenador) throws IOException {
		return coordenadorDAO.cadastrarCoordenador(coordenador);
	}

	public Coordenador buscarCoordenador(int id) throws IOException {
		return coordenadorDAO.buscarCoordenador(id);
	}

	public ArrayList<Coordenador> listarCoordenadores() throws IOException {
		return coordenadorDAO.listarCoordenadores();
	}

	public void alterarCoordenador(Coordenador coordenador) throws IOException {
		coordenadorDAO.alterarCoordenador(coordenador);
		return;
	}

	public void excluirCoordenador(int id) throws IOException {
		coordenadorDAO.excluirCoordenador(id);
		return;
	}
}
