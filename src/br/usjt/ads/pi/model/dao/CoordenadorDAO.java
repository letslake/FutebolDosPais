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

import br.usjt.ads.pi.model.entity.Coordenador;

@Repository
public class CoordenadorDAO {

	Connection conn;

	@Autowired
	public CoordenadorDAO(DataSource connectionFactory) throws IOException {
		try {
			conn = connectionFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}

	public int cadastrarCoordenador(Coordenador coordenador) throws IOException {
		int id = -1;
		String sql = "insert into coordenador (nome, cpf, endereco, telefone) values (?, ?, ?, ?)";

		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setString(1, coordenador.getNome());
			stm.setString(2, coordenador.getCpf());
			stm.setString(3, coordenador.getEndereco());
			stm.setString(4, coordenador.getTelefone());

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

	public Coordenador buscarCoordenador(int id) throws IOException {
		Coordenador coordenador = null;
		String sql = "select * from coordenador where id = ?";

		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setInt(1, id);

			try (ResultSet rs = stm.executeQuery()) {
				if (rs.next()) {
					coordenador = new Coordenador();
					coordenador.setNome(rs.getString("nome"));
					coordenador.setCpf(rs.getString("cpf"));
					coordenador.setEndereco(rs.getString("endereco"));
					coordenador.setTelefone(rs.getString("telefone"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}

		return coordenador;
	}

	public ArrayList<Coordenador> listarCoordenadores() throws IOException {
		ArrayList<Coordenador> lista = new ArrayList<>();
		String sql = "select * from coordenador";

		try (PreparedStatement stm = conn.prepareStatement(sql); ResultSet rs = stm.executeQuery()) {
			while (rs.next()) {
				Coordenador coordenador = new Coordenador();
				coordenador.setNome(rs.getString("nome"));
				coordenador.setCpf(rs.getString("cpf"));
				coordenador.setEndereco(rs.getString("endereco"));
				coordenador.setTelefone(rs.getString("telefone"));

				lista.add(coordenador);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return lista;
	}

	public void alterarCoordenador(Coordenador coordenador) throws IOException {
		String sql = "update coordenador set nome = ?, cpf=?, endereco=?, telefone=? where id = ?";

		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setString(1, coordenador.getNome());
			stm.setString(2, coordenador.getCpf());
			stm.setString(3, coordenador.getEndereco());
			stm.setString(4, coordenador.getTelefone());
			stm.setInt(5, coordenador.getId());

			stm.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}

	public void excluirCoordenador(int id) throws IOException {
		String sql = "delete from coordenador where id = ?";

		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setInt(1, id);

			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}

}
