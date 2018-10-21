package br.usjt.ads.pi.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.ads.pi.model.entity.Administrador;

@Repository
public class AdministradorDAO {
	Connection conn;

	@Autowired
	public AdministradorDAO(DataSource connectionFactory) throws IOException {
		try {
			conn = connectionFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}

	public Administrador buscarAdmin(String username) throws IOException {
		Administrador admin = null;
		String sql = "select * from administrador where username like ?";

		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setString(1, username);

			try (ResultSet rs = stm.executeQuery()) {
				if (rs.next()) {
					// Set Admin
					admin = new Administrador();
					admin.setId(rs.getInt("id"));
					admin.setEmail(rs.getString("email"));
					admin.setNome(rs.getString("nome"));
					admin.setUsername(rs.getString("username"));
					admin.setSenha(rs.getString("senha"));

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return admin;
	}
}
