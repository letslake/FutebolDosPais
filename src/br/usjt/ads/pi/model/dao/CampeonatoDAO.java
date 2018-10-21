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

import br.usjt.ads.pi.model.entity.Campeonato;
import br.usjt.ads.pi.model.entity.Categoria;
import br.usjt.ads.pi.model.entity.Regulamento;

@Repository
public class CampeonatoDAO {
	Connection conn;

	@Autowired
	public CampeonatoDAO(DataSource dataSource) throws IOException {
		try {
			conn = dataSource.getConnection();
		} catch (SQLException err) {
			err.printStackTrace();
			throw new IOException(err);
		}
	}

	public int cadastrarCampeonato(Campeonato campeonato) throws IOException {
		int id = -1;
		String sql = "insert into campeonato (nome, id_categoria, id_regulamento) value (?, ?, ?)";
		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setString(1, campeonato.getNome());
			stm.setInt(2, campeonato.getCategoria().getId());
			stm.setInt(3, campeonato.getRegulamento().getId());

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

	public ArrayList<Campeonato> listarCampeonatos() throws IOException {
		ArrayList<Campeonato> campeonatos = new ArrayList<>();
		String sql = "select c.id, c.nome, r.id, r.qtn_times, r.pontos_vitoria, r.pontos_empate, r.tempo_jogo, r.tempo_intervalo, r.data_inicio, r.data_termino, cg.id, cg.nome from campeonato c "
				+ "inner join regulamento r on c.id_regulamento = r.id inner join categoria cg on c.id_categoria = cg.id ";

		try (PreparedStatement stm = conn.prepareStatement(sql); ResultSet rs = stm.executeQuery()) {
			while (rs.next()) {
				Campeonato campeonato = new Campeonato();
				campeonato.setId(rs.getInt("c.id"));
				campeonato.setNome(rs.getString("c.nome"));

				// Regulamento
				Regulamento regulamento = new Regulamento();
				regulamento.setId(rs.getInt("r.id"));
				regulamento.setPonstoEmpate(rs.getInt("r.pontos_empate"));
				regulamento.setPontosVitoria(rs.getInt("r.pontos_vitoria"));
				regulamento.setTempoJogo(rs.getInt("r.tempo_jogo"));
				regulamento.setTempoIntervalo(rs.getInt("r.tempo_intervalo"));
				regulamento.setQtnTimes(rs.getInt("r.qtn_times"));
				regulamento.setDataInicio(rs.getDate("r.data_inicio"));
				regulamento.setDataTermino(rs.getDate("r.data_termino"));

				campeonato.setRegulamento(regulamento);

				// Categoria
				Categoria categoria = new Categoria();
				categoria.setId(rs.getInt("cg.id"));
				categoria.setNome(rs.getString("cg.nome"));

				campeonato.setCategoria(categoria);

				campeonatos.add(campeonato);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}

		return campeonatos;
	}

	public Campeonato buscarCampeonato(int id) throws IOException {
		Campeonato campeonato = null;
		String sql = "select c.id, c.nome, r.id, r.qtn_times, r.pontos_vitoria, r.pontos_empate, r.tempo_jogo, r.tempo_intervalo, r.data_inicio, r.data_termino, cg.id, cg.nome from campeonato c "
				+ "inner join regulamento r on c.id_regulamento = r.id inner join categoria cg on c.id_categoria = cg.id where c.id = ?";

		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery()) {
				if (rs.next()) {
					// Set Categoria
					Categoria categoria = new Categoria();
					categoria.setId(rs.getInt("cg.id"));
					categoria.setNome(rs.getString("cg.nome"));

					// Set Regulamento
					Regulamento regulamento = new Regulamento();
					regulamento.setId(rs.getInt("r.id"));
					regulamento.setPonstoEmpate(rs.getInt("r.pontos_empate"));
					regulamento.setPontosVitoria(rs.getInt("r.pontos_vitoria"));
					regulamento.setTempoJogo(rs.getInt("r.tempo_jogo"));
					regulamento.setTempoIntervalo(rs.getInt("r.tempo_intervalo"));
					regulamento.setQtnTimes(rs.getInt("r.qtn_times"));
					regulamento.setDataInicio(rs.getDate("r.data_inicio"));
					regulamento.setDataTermino(rs.getDate("r.data_termino"));

					campeonato = new Campeonato();
					campeonato.setId(rs.getInt("c.id"));
					campeonato.setNome(rs.getString("c.nome"));
					campeonato.setCategoria(categoria);
					campeonato.setRegulamento(regulamento);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}

		return campeonato;
	}
}
