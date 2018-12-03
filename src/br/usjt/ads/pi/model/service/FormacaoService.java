package br.usjt.ads.pi.model.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ads.pi.model.dao.FormacaoDAO;
import br.usjt.ads.pi.model.entity.Formacao;
import br.usjt.ads.pi.model.entity.Partida;

@Service
public class FormacaoService {
	@Autowired
	private FormacaoDAO formacaoDAO;

	@Transactional
	public int cadastrarMandante(Partida partida) throws IOException {
		return formacaoDAO.cadastrarMandante(partida);
	}

	@Transactional
	public int cadastrarVisitante(Partida partida) throws IOException {
		return formacaoDAO.cadastrarVisitante(partida);
	}

	public Formacao buscarFormacao(int id) throws IOException {
		return formacaoDAO.buscarFormacao(id);
	}

	public List<Formacao> listarFormacoes() throws IOException {
		return formacaoDAO.listarFormacao();
	}

	@Transactional
	public void atualizarFormacao(Formacao formacao) throws IOException {
		formacaoDAO.atualizarFormacao(formacao);
		return;
	}

	@Transactional
	public void excluirFormacao(int id) throws IOException {
		formacaoDAO.excluirFormacao(id);
		return;
	}
}
