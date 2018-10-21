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

import br.usjt.ads.pi.model.entity.Usuario;

@Repository
public class UserDAO {
	Connection conn;

	@Autowired
	public UserDAO(DataSource connectionFactory) throws IOException {
		try {
			conn = connectionFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}

	public int cadastrarUsuario(Usuario user) throws IOException {
		int id = -1;
		String sql = "insert into administrador (nome, username, email, senha) values (?,?,?,?)";
		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setString(1, user.getNome());
			stm.setString(2, user.getUsername());
			stm.setString(3, user.getEmail());
			stm.setString(4, user.getSenha());

			stm.execute();

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

	public ArrayList<Usuario> listarUsuarios() throws IOException {
		ArrayList<Usuario> lista = new ArrayList<>();
		String sql = "select * from administrador";
		try (PreparedStatement stm = conn.prepareStatement(sql); ResultSet rs = stm.executeQuery()) {
			while (rs.next()) {
				Usuario user = new Usuario();
				user.setId(rs.getInt("id"));
				user.setNome(rs.getString("nome"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setSenha(rs.getString("senha"));

				lista.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return lista;
	}

	public Usuario buscarUsuario(String username) throws IOException {
		Usuario user = null;
		String sql = "select * from administrador where username like ?";

		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setString(1, username);

			try (ResultSet rs = stm.executeQuery()) {
				if (rs.next()) {
					// Set Admin
					user = new Usuario();
					user.setId(rs.getInt("id"));
					user.setEmail(rs.getString("email"));
					user.setNome(rs.getString("nome"));
					user.setUsername(rs.getString("username"));
					user.setSenha(rs.getString("senha"));

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return user;
	}

	public void atualizarUsuario(Usuario user) throws IOException {
		String sql = "update administrador set nome=?, username=?, email=?, senha=? where id = ?";

		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setString(1, user.getNome());
			stm.setString(2, user.getUsername());
			stm.setString(3, user.getEmail());
			stm.setString(4, user.getSenha());
			stm.setInt(5, user.getId());

			stm.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}

	public void excluirAdmin(int id) throws IOException {
		String sql = "delete from administrador where id =? ";

		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setInt(1, id);

			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}
}
