package br.usjt.ads.pi.model.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.ads.pi.model.entity.TipoArbitro;

@Repository
public class TipoArbitroDAO {
	@PersistenceContext
	EntityManager manager;
	
	public TipoArbitro buscarTipoArbitro(int id) throws IOException {
		return manager.find(TipoArbitro.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<TipoArbitro> listarTiposArbitro() throws IOException {
		return manager.createQuery("select ta from TipoArbitro ta").getResultList();
	}
}
