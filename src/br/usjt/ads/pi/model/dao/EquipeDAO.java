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
import br.usjt.ads.pi.model.entity.Equipe;
import br.usjt.ads.pi.model.entity.Tecnico;
import br.usjt.ads.pi.model.service.CoordenadorService;
import br.usjt.ads.pi.model.service.TecnicoService;

@Repository
public class EquipeDAO {

	Connection conn;

	@Autowired
	public EquipeDAO(DataSource connectionFactory) throws IOException {
		try {
			conn = connectionFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}

	@Autowired
	private TecnicoService tecService;
	@Autowired
	private CoordenadorService coordenadorService;

	public int cadastrarEquipe(Equipe equipe) throws IOException {
		int id = -1;
		String sql = "insert into equipe (id_coordenador, id_tecnico, nome) values (?, ?,?)";

		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setInt(1, equipe.getCoordenador().getId());
			stm.setInt(2, equipe.getTecnico().getId());
			stm.setString(3, equipe.getNome());

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

	public Equipe buscarEquipe(int id) throws IOException {
		Equipe equipe = null;
		String sql = "select e.nome, e.vitorias, e.empates, e.derrotas, e.gols, e.gols_sofridos, e.total_pontos, t.id, c.id from equipe e inner join coordenador c on e.id_coordenador = c.id inner join tecnico t on e.id_tecnico = t.id where id = ?";

		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setInt(1, id);

			try (ResultSet rs = stm.executeQuery()) {
				if (rs.next()) {
					equipe = new Equipe();
					// Tecnico
					Tecnico tecnico = tecService.buscarTecnico(rs.getInt("t.id"));
					equipe.setTecnico(tecnico);

					// Coordenador
					Coordenador coordenador = coordenadorService.buscarCoordenador(rs.getInt("c.id"));
					equipe.setCoordenador(coordenador);

					// Equipe
					equipe.setNome(rs.getString("e.nome"));
					equipe.setVitorias(rs.getInt("e.vitorias"));
					equipe.setEmpates(rs.getInt("e.empates"));
					equipe.setDerrotas(rs.getInt("e.derrotas"));
					equipe.setQtnGols(rs.getInt("e.qtn_gols"));
					equipe.setQtnGolsSofridos(rs.getInt("e.qtn_gols_sofridos"));
					equipe.setTotalPontos(rs.getInt("e.total_pontos"));

				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return equipe;
	}

	public ArrayList<Equipe> listarEquipes() throws IOException {
		ArrayList<Equipe> lista = new ArrayList<>();
		String sql = "select e.nome, e.vitorias, e.empates, e.derrotas, e.gols, e.gols_sofridos, e.total_pontos, t.id, c.id from equipe e inner join coordenador c on e.id_coordenador = c.id inner join tecnico t on e.id_tecnico = t.id";

		try (PreparedStatement stm = conn.prepareStatement(sql); ResultSet rs = stm.executeQuery()) {
			while (rs.next()) {
				Equipe equipe = new Equipe();
				// Tecnico
				Tecnico tecnico = tecService.buscarTecnico(rs.getInt("t.id"));
				equipe.setTecnico(tecnico);

				// Coordenador
				Coordenador coordenador = coordenadorService.buscarCoordenador(rs.getInt("c.id"));
				equipe.setCoordenador(coordenador);

				// Equipe
				equipe.setNome(rs.getString("e.nome"));
				equipe.setVitorias(rs.getInt("e.vitorias"));
				equipe.setEmpates(rs.getInt("e.empates"));
				equipe.setDerrotas(rs.getInt("e.derrotas"));
				equipe.setQtnGols(rs.getInt("e.gols"));
				equipe.setQtnGolsSofridos(rs.getInt("e.gols_sofridos"));
				equipe.setTotalPontos(rs.getInt("e.total_pontos"));

				lista.add(equipe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}

		return lista;
	}

	public void alterarEquipe(Equipe equipe) throws IOException {
		String sql = "update equipe set id_coordenador = ?, id_tecnico = ?, nome = ?, bandeira =?, uniforme_casa = ?, uniforme_fora = ?, terceiro_uniforme =?, vitorias =?, derrotas =?"
				+ "empates = ? , qtn_jogos = ?, media_jogos = ?, gols = ?, gols_sofidos = ?, total_pontos =?";

		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setInt(1, equipe.getCoordenador().getId());
			stm.setInt(2, equipe.getTecnico().getId());
			stm.setString(3, equipe.getNome());
			stm.setString(4, equipe.getBandeira());
			stm.setString(5, equipe.getUniformeCasa());
			stm.setString(6, equipe.getUniformeFora());
			stm.setString(7, equipe.getTerceiroUniforme());
			stm.setInt(8, equipe.getVitorias());
			stm.setInt(9, equipe.getDerrotas());
			stm.setInt(10, equipe.getEmpates());
			stm.setInt(11, equipe.getQtnJogos());
			stm.setFloat(12, equipe.getMediaJogos());
			stm.setInt(13, equipe.getQtnGols());
			stm.setInt(14, equipe.getQtnGolsSofridos());
			stm.setInt(15, equipe.getTotalPontos());

			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}

	public void excluirEquipe(int id) throws IOException {
		String sql = "delete from equipe where id = ?";

		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setInt(1, id);

			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}
}
