package br.usjt.ads.pi.model.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.ads.pi.model.entity.Partida;

@Repository
public class PartidaDAO {
	@PersistenceContext
	EntityManager manager;

	public int cadastrarPartida(Partida partida) throws IOException {
		System.out.println(partida);
		manager.persist(partida);
		return partida.getId();
	}

	@SuppressWarnings("unchecked")
	public List<Partida> listarPartidas() throws IOException {
		return manager.createQuery("select p from Partida p").getResultList();
	}

	public Partida buscarPartida(int id) throws IOException {
		return manager.find(Partida.class, id);
	}

	public void atualizarPartida(Partida partida) throws IOException {
		manager.merge(partida);
	}

	public void excluirPartida(int id) throws IOException {
		manager.remove(manager.find(Partida.class, id));
	}
}
