package br.usjt.ads.pi.model.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.ads.pi.model.entity.Categoria;

@Repository
public class CategoriaDAO {
	@PersistenceContext
	EntityManager manager;

	public Categoria buscarCategoria(int id) throws IOException {
		return manager.find(Categoria.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Categoria> listarCategorias() throws IOException {
		return manager.createQuery("select c from Categoria c").getResultList();
	}

}
