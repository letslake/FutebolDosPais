package br.usjt.ads.pi.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.ads.pi.model.entity.Categoria;

@Repository
public class CategoriaDAO {
	Connection conn;

	@Autowired
	public CategoriaDAO(DataSource connectionFactory) throws IOException {
		try {
			conn = connectionFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}

	public Categoria buscarCategoria(int id) throws IOException {
		Categoria categoria = null;
		String sql = "select id, nome from categoria where id = ?";

		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setInt(1, id);

			try (ResultSet rs = stm.executeQuery()) {
				if (rs.next()) {
					categoria = new Categoria();
					categoria.setId(rs.getInt("id"));
					categoria.setNome(rs.getString("nome"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}

		return categoria;
	}

	public ArrayList<Categoria> listarCategorias() throws IOException {
		ArrayList<Categoria> categorias = new ArrayList<>();
		String sql = "select id, nome from categoria";

		try (PreparedStatement stm = conn.prepareStatement(sql); ResultSet rs = stm.executeQuery()) {
			while (rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setId(rs.getInt("id"));
				categoria.setNome(rs.getString("nome"));

				categorias.add(categoria);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return categorias;
	}
}
