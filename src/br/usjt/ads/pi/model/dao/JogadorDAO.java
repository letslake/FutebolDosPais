package br.usjt.ads.pi.model.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.ads.pi.model.entity.Jogador;

@Repository
public class JogadorDAO {
	@PersistenceContext
	EntityManager manager;

	public int cadastrarJogador(Jogador jogador) throws IOException {
		manager.persist(jogador);
		return jogador.getId();
	}

	@SuppressWarnings("unchecked")
	public List<Jogador> listarJogadores() throws IOException {
		return manager.createQuery("select j from Jogador j").getResultList();
	}

	public Jogador buscarJogador(int id) throws IOException {
		return manager.find(Jogador.class, id);
	}

	public void atualizarJogador(Jogador jogador) throws IOException {
		manager.merge(jogador);
	}

	public void excluirJogador(int id) throws IOException {
		manager.remove(manager.find(Jogador.class, id));
	}

}
