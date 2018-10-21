package br.usjt.ads.pi.model.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ads.pi.model.dao.CategoriaDAO;
import br.usjt.ads.pi.model.entity.Categoria;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaDAO categoriaDAO;

	public Categoria buscarCategoria(int id) throws IOException {
		return categoriaDAO.buscarCategoria(id);
	}

	public ArrayList<Categoria> listarCategorias() throws IOException {
		return categoriaDAO.listarCategorias();
	}
}
