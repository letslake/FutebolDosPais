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

import br.usjt.ads.pi.model.entity.Jogador;

@Repository
public class JogadorDAO {
	Connection conn;

	@Autowired
	public JogadorDAO(DataSource connectionFactory) throws IOException {
		try {
			conn = connectionFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}

	public Jogador buscarJogador(int id) throws IOException {
		Jogador jogador = null;
		String sql = "select * from jogador where id = ?";

		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setInt(1, id);

			try (ResultSet rs = stm.executeQuery()) {
				if (rs.next()) {
					jogador = new Jogador();
					jogador.setId(rs.getInt("id"));
					jogador.setNome(rs.getString("nome"));
					jogador.setDataNascimento(rs.getDate("data_nascimento"));
					jogador.setCpf(rs.getString("cpf"));
					jogador.setEndereco(rs.getString("endereco"));
					jogador.setTelefone(rs.getString("telefone"));
					jogador.setAltura(rs.getFloat("altura"));
					jogador.setPeso(rs.getFloat("peso"));
					jogador.setFoto(rs.getString("foto"));
					jogador.setQtnAmarelos(rs.getInt("qtn_cartao_amarelo"));
					jogador.setQtnGols(rs.getInt("qtn_gols"));
					jogador.setQtnGolsContra(rs.getInt("qtn_gols_contra"));
					jogador.setQtnVermelhos(rs.getInt("qtn_cartao_vermelho"));

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return jogador;
	}

	public ArrayList<Jogador> listarJogadores() throws IOException {
		ArrayList<Jogador> lista = new ArrayList<>();
		String sql = "select * from jodador";

		try (PreparedStatement stm = conn.prepareStatement(sql); ResultSet rs = stm.executeQuery()) {
			while (rs.next()) {
				Jogador jogador = new Jogador();
				jogador.setId(rs.getInt("id"));
				jogador.setNome(rs.getString("nome"));
				jogador.setDataNascimento(rs.getDate("data_nascimento"));
				jogador.setCpf(rs.getString("cpf"));
				jogador.setEndereco(rs.getString("endereco"));
				jogador.setTelefone(rs.getString("telefone"));
				jogador.setAltura(rs.getFloat("altura"));
				jogador.setPeso(rs.getFloat("peso"));
				jogador.setFoto(rs.getString("foto"));
				jogador.setQtnAmarelos(rs.getInt("qtn_cartao_amarelo"));
				jogador.setQtnGols(rs.getInt("qtn_gols"));
				jogador.setQtnGolsContra(rs.getInt("qtn_gols_contra"));
				jogador.setQtnVermelhos(rs.getInt("qtn_cartao_vermelho"));

				lista.add(jogador);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return lista;
	}

	public int cadastrarJogador(Jogador jogador) throws IOException {
		int id = -1;
		String sql = "insert into jogador (nome, cpf, endereco, telefone, data_nascimento, qtn_cartao_vermelho, qtn_cartao_amarelo, qtn_gols, qtn_gols_contra, altura, peso, foto)"
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?)";

		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setString(1, jogador.getNome());
			stm.setString(2, jogador.getCpf());
			stm.setString(3, jogador.getEndereco());
			stm.setString(4, jogador.getTelefone());
			stm.setDate(5, jogador.getDataNascimento());
			stm.setInt(6, jogador.getQtnVermelhos());
			stm.setInt(7, jogador.getQtnAmarelos());
			stm.setInt(8, jogador.getQtnGols());
			stm.setInt(9, jogador.getQtnGolsContra());
			stm.setFloat(10, jogador.getAltura());
			stm.setFloat(11, jogador.getPeso());
			stm.setString(12, jogador.getFoto());

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

	public void atualizarJogador(Jogador jogador) throws IOException {
		String sql = "update jogador set nome = ?, cpf = ?, endereco=?, telefone=?, data_nascimento = ?, qtn_cartao_vermelho =?, qtn_cartao_amarelo=?, qtn_gols=?, qtn_gols_contra=?, altura =?, peso=?, foto=? where id = ?";

		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setString(1, jogador.getNome());
			stm.setString(2, jogador.getCpf());
			stm.setString(3, jogador.getEndereco());
			stm.setString(4, jogador.getTelefone());
			stm.setDate(5, jogador.getDataNascimento());
			stm.setInt(6, jogador.getQtnVermelhos());
			stm.setInt(7, jogador.getQtnAmarelos());
			stm.setInt(8, jogador.getQtnGols());
			stm.setInt(9, jogador.getQtnGolsContra());
			stm.setFloat(10, jogador.getAltura());
			stm.setFloat(11, jogador.getPeso());
			stm.setString(12, jogador.getFoto());
			stm.setInt(13, jogador.getId());
			
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}

	public void excluirJogador(int id) throws IOException {
		String sql = "delete from jogador where id = ? ";

		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setInt(1, id);

			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}
}
