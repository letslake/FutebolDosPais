package br.usjt.ads.pi.model.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.ads.pi.model.entity.Tecnico;
import br.usjt.ads.pi.model.entity.Turno;

@Repository
public class TurnoDAO {

	@PersistenceContext
	EntityManager manager;

	public Turno buscarTurno(int id) throws IOException {
		return manager.find(Turno.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Turno> listarTurnos() throws IOException {
		return manager.createQuery("select t from Turno t").getResultList();
	}
}
