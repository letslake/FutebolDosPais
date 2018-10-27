package br.usjt.ads.pi.model.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ads.pi.model.dao.CategoriaDAO;
import br.usjt.ads.pi.model.entity.Categoria;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaDAO categoriaDAO;

	@Transactional
	public Categoria buscarCategoria(int id) throws IOException {
		return categoriaDAO.buscarCategoria(id);
	}

	@Transactional
	public List<Categoria> listarCategorias() throws IOException {
		return categoriaDAO.listarCategorias();
	}
}
