package br.usjt.ads.pi.model.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.ads.pi.model.entity.Formacao;
import br.usjt.ads.pi.model.entity.Partida;

@Repository
public class FormacaoDAO {

	@PersistenceContext
	EntityManager manager;

	public int cadastrarMandante(Partida partida) throws IOException {
		manager.persist(partida.getMandante());
		return partida.getMandante().getId();
	}

	public int cadastrarVisitante(Partida partida) throws IOException {
		manager.persist(partida.getVisitante());
		return partida.getVisitante().getId();
	}

	@SuppressWarnings("unchecked")
	public List<Formacao> listarFormacao() throws IOException {
		return manager.createQuery("select f from Formacao f").getResultList();
	}

	public Formacao buscarFormacao(int id) throws IOException {
		return manager.find(Formacao.class, id);
	}

	public void atualizarFormacao(Formacao formacao) throws IOException {
		manager.merge(formacao);
	}

	public void excluirFormacao(int id) throws IOException {
		manager.remove(manager.find(Formacao.class, id));
	}
}
