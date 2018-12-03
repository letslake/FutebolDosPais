package br.usjt.ads.pi.model.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.ads.pi.model.entity.Arbitro;

@Repository
public class ArbitroDAO {
	@PersistenceContext
	EntityManager manager;

	public int cadastrarArbitro(Arbitro arbitro) throws IOException {
		manager.persist(arbitro);
		return arbitro.getId();
	}

	@SuppressWarnings("unchecked")
	public List<Arbitro> listarArbitros() throws IOException {
		return manager.createQuery("select a from Arbitro a").getResultList();
	}

	public Arbitro buscarArbitro(int id) throws IOException {
		return manager.find(Arbitro.class, id);
	}

	public void atualizarArbitro(Arbitro arbitro) throws IOException {
		manager.merge(arbitro);
	}

	public void excluirArbitro(int id) throws IOException {
		manager.remove(manager.find(Arbitro.class, id));
	}
}
