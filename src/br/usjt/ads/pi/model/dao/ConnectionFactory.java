package br.usjt.ads.pi.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static Connection getConnection() throws IOException {
		String servidor = "localhost";
		String porta = "3306";
		String database = "sys_futebol_pais";
		String usuario = "root";
		String senha = "Lima9608";
		try {
			return DriverManager.getConnection("jdbc:mysql://" + servidor + ":" + porta + "/" + database + "?user="
					+ usuario + "&password=" + senha);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}

	}
}
