package br.usjt.ads.pi.model.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.ads.pi.model.entity.Equipe;

@Repository
public class EquipeDAO {
	@PersistenceContext
	EntityManager manager;

	public int cadastrarEquipe(Equipe equipe) throws IOException {
		manager.persist(equipe);
		return equipe.getId();
	}

	@SuppressWarnings("unchecked")
	public List<Equipe> listarEquipes() throws IOException {
		return manager.createQuery("select e from Equipe e").getResultList();
	}

	public Equipe buscarEquipe(int id) throws IOException {
		return manager.find(Equipe.class, id);
	}

	public void atualizarEquipe(Equipe equipe) throws IOException {
		manager.merge(equipe);
	}

	public void excluirEquipe(int id) throws IOException {
		manager.remove(manager.find(Equipe.class, id));
	}

}
