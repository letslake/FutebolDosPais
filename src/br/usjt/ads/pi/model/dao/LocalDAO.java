package br.usjt.ads.pi.model.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.ads.pi.model.entity.Local;

@Repository
public class LocalDAO {
	@PersistenceContext
	EntityManager manager;

	public int cadastrarLocal(Local local) throws IOException {
		manager.persist(local);
		return local.getId();
	}

	@SuppressWarnings("unchecked")
	public List<Local> listarLocais() throws IOException {
		return manager.createQuery("select l from Local l").getResultList();
	}

	public Local buscarLocal(int id) throws IOException {
		return manager.find(Local.class, id);
	}

	public void atualizarLocal(Local local) throws IOException {
		manager.merge(local);
	}

	public void excluirLocal(int id) throws IOException {
		manager.remove(manager.find(Local.class, id));
	}
}
