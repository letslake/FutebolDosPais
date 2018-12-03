package br.usjt.ads.pi.model.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ads.pi.model.dao.ArbitroDAO;
import br.usjt.ads.pi.model.entity.Arbitro;

@Service
public class ArbitroService {
	@Autowired
	private ArbitroDAO aDAO;
	
	@Transactional
	public int cadastrarArbitro(Arbitro arbitro) throws IOException {
		return aDAO.cadastrarArbitro(arbitro);
	}

	public Arbitro buscarArbitro(int id) throws IOException {
		return aDAO.buscarArbitro(id);
	}

	public List<Arbitro> listarArbitros() throws IOException {
		return aDAO.listarArbitros();
	}
	@Transactional
	public void atualizarArbitros(Arbitro arbitro) throws IOException {
		aDAO.atualizarArbitro(arbitro);
		return;
	}
	
	@Transactional
	public void excluirArbitro(int id) throws IOException {
		aDAO.excluirArbitro(id);
		return;
	}
}
