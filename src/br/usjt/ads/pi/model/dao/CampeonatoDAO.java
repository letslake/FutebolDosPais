package br.usjt.ads.pi.model.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.ads.pi.model.entity.Campeonato;

@Repository
public class CampeonatoDAO {
	@PersistenceContext
	EntityManager manager;

	public int cadastrarCampeonato(Campeonato campeonato) throws IOException {
		manager.persist(campeonato);
		return campeonato.getId();
	}

	@SuppressWarnings("unchecked")
	public List<Campeonato> listarCampeonatos() throws IOException {
		return manager.createQuery("select c from Campeonato c").getResultList();
	}

	public Campeonato buscarCampeonato(int id) throws IOException {
		return manager.find(Campeonato.class, id);
	}

	public void atualizarCampeonato(Campeonato campeonato) throws IOException {
		manager.merge(campeonato);
	}

	public void excluirCampeonato(int id) throws IOException {
		manager.remove(manager.find(Campeonato.class, id));
	}

}
