package br.usjt.ads.pi.model.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ads.pi.model.dao.JogadorDAO;
import br.usjt.ads.pi.model.entity.Jogador;

@Service
public class JogadorService {

	@Autowired
	private JogadorDAO jogadorDAO;

	@Transactional
	public int cadastrarJogador(Jogador jogador) throws IOException {
		return jogadorDAO.cadastrarJogador(jogador);
	}

	public Jogador buscarJogador(int id) throws IOException {
		return jogadorDAO.buscarJogador(id);
	}

	public List<Jogador> listarJogadores() throws IOException {
		return jogadorDAO.listarJogadores();
	}
	@Transactional
	public void atualizarJogador(Jogador jogador) throws IOException {
		jogadorDAO.atualizarJogador(jogador);
		return;
	}
	
	@Transactional
	public void excluirJogador(int id) throws IOException {
		jogadorDAO.excluirJogador(id);
		return;
	}
}
