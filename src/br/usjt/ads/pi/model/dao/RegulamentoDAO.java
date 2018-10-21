package br.usjt.ads.pi.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.ads.pi.model.entity.Campeonato;

@Repository
public class RegulamentoDAO {
	Connection conn;

	@Autowired
	public RegulamentoDAO(DataSource connectionFectory) throws IOException {
		try {
			conn = connectionFectory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}

	public int cadastrarRegulamento(Campeonato campeonato) throws IOException {
		int id = -1;
		String sql = "insert into regulamento (qtn_times, pontos_vitoria, pontos_empate, tempo_jogo, tempo_intervalo, data_inicio, data_termino) values (?,?,?,?,?,?,?)";

		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setInt(1, campeonato.getRegulamento().getQtnTimes());
			stm.setInt(2, campeonato.getRegulamento().getPontosVitoria());
			stm.setInt(3, campeonato.getRegulamento().getPonstoEmpate());
			stm.setInt(4, campeonato.getRegulamento().getTempoJogo());
			stm.setInt(5, campeonato.getRegulamento().getTempoIntervalo());

			if (campeonato.getRegulamento().getDataInicio() != null) {
				stm.setDate(6, new java.sql.Date(campeonato.getRegulamento().getDataInicio().getTime()));
			} else {
				stm.setDate(6, null);
			}

			if (campeonato.getRegulamento().getDataTermino() != null) {
				stm.setDate(7, new java.sql.Date(campeonato.getRegulamento().getDataTermino().getTime()));
			} else {
				stm.setDate(7, null);
			}

			stm.execute();

			String query = "select LAST_INSERT_ID()";
			try (PreparedStatement stm1 = conn.prepareStatement(query); ResultSet rs = stm1.executeQuery();) {

				if (rs.next()) {
					id = rs.getInt(1);
				}

			} catch (Exception e) {
				e.printStackTrace();
				throw new IOException(e);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}

		return id;
	}
}
