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

import br.usjt.ads.pi.model.entity.Tecnico;

@Repository
public class TecnicoDAO {

	Connection conn;

	@Autowired
	public TecnicoDAO(DataSource connectionFactory) throws IOException {
		try {
			conn = connectionFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}

	public int cadastrarTecnico(Tecnico tecnico) throws IOException {
		int id = -1;
		String sql = "insert into tecnico (nome, cpf, endereco, telefone) values (?, ?, ?, ?)";

		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setString(1, tecnico.getNome());
			stm.setString(2, tecnico.getCpf());
			stm.setString(3, tecnico.getEndereco());
			stm.setString(4, tecnico.getTelefone());

			stm.executeQuery();

			String query = "select LAST_INSERT_ID()";
			try (PreparedStatement pst = conn.prepareStatement(query); ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					id = rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return id;
	}

	public Tecnico buscarTecnico(int id) throws IOException {
		Tecnico tecnico = null;
		String sql = "select * from tecnico where id = ?";

		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setInt(1, id);

			try (ResultSet rs = stm.executeQuery()) {
				if (rs.next()) {
					tecnico = new Tecnico();
					tecnico.setNome(rs.getString("nome"));
					tecnico.setCpf(rs.getString("cpf"));
					tecnico.setEndereco(rs.getString("endereco"));
					tecnico.setTelefone(rs.getString("telefone"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}

		return tecnico;
	}

	public ArrayList<Tecnico> listarTecnicos() throws IOException {
		ArrayList<Tecnico> lista = new ArrayList<>();
		String sql = "select * from tecnico";

		try (PreparedStatement stm = conn.prepareStatement(sql); ResultSet rs = stm.executeQuery()) {
			while (rs.next()) {
				Tecnico tecnico = new Tecnico();
				tecnico.setNome(rs.getString("nome"));
				tecnico.setCpf(rs.getString("cpf"));
				tecnico.setEndereco(rs.getString("endereco"));
				tecnico.setTelefone(rs.getString("telefone"));

				lista.add(tecnico);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return lista;
	}

	public void alterarTecnico(Tecnico tecnico) throws IOException {
		String sql = "update tecnico set nome = ?, cpf=?, endereco=?, telefone=? where id = ?";

		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setString(1, tecnico.getNome());
			stm.setString(2, tecnico.getCpf());
			stm.setString(3, tecnico.getEndereco());
			stm.setString(4, tecnico.getTelefone());
			stm.setInt(5, tecnico.getId());

			stm.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}

	public void excluirTecnico(int id) throws IOException {
		String sql = "delete from tecnico where id = ?";

		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setInt(1, id);

			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}

}
