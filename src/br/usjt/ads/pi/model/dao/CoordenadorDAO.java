package br.usjt.ads.pi.model.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.ads.pi.model.entity.Coordenador;
import br.usjt.ads.pi.model.entity.Equipe;

@Repository
public class CoordenadorDAO {

	@PersistenceContext
	EntityManager manager;

	public int cadastrarCoordenador(Equipe equipe) throws IOException {
		manager.persist(equipe.getCoordenador());
		return equipe.getCoordenador().getId();
	}

//	public int cadastrarCoordenador(Coordenador coordenador) throws IOException {
//		manager.persist(coordenador);
//		return coordenador.getId();
//	}

	public Coordenador buscarCoordenador(int id) throws IOException {
		return manager.find(Coordenador.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Coordenador> listarCoordenadores() throws IOException {
		return manager.createQuery("select c from Coordenador c").getResultList();
	}

	public void alterarCoordenador(Coordenador coordenador) throws IOException {
		manager.merge(coordenador);
	}

	public void excluirCoordenador(int id) throws IOException {
		manager.remove(manager.find(Coordenador.class, id));
	}

}
