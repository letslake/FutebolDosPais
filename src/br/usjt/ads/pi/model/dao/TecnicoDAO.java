package br.usjt.ads.pi.model.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.ads.pi.model.entity.Equipe;
import br.usjt.ads.pi.model.entity.Tecnico;

@Repository
public class TecnicoDAO {

	@PersistenceContext
	EntityManager manager;

	public int cadastrarTecnico(Equipe equipe) throws IOException {
		manager.persist(equipe.getTecnico());
		return equipe.getTecnico().getId();
	}

	public Tecnico buscarTecnico(int id) throws IOException {
		return manager.find(Tecnico.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Tecnico> listarTecnicos() throws IOException {
		return manager.createQuery("select t from Tecnico t").getResultList();
	}

	public void alterarTecnico(Tecnico tecnico) throws IOException {
		manager.merge(tecnico);
	}

	public void excluirTecnico(int id) throws IOException {
		manager.remove(manager.find(Tecnico.class, id));
	}

}
