package br.usjt.ads.pi.model.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ads.pi.model.dao.PartidaDAO;
import br.usjt.ads.pi.model.entity.Partida;

@Service
public class PartidaService {
	@Autowired
	private PartidaDAO pDAO;

	@Transactional
	public int cadastrarPartida(Partida partida) throws IOException {
		System.out.println(partida);
		return pDAO.cadastrarPartida(partida);
	}

	@Transactional
	public void atualizarPartida(Partida partida) throws IOException {
		pDAO.atualizarPartida(partida);
		return;
	}

	public List<Partida> listarPartidas() throws IOException {
		return pDAO.listarPartidas();
	}

	public Partida buscarPartida(int id) throws IOException {
		return pDAO.buscarPartida(id);

	}

	@Transactional
	public void excluirPartida(int id) throws IOException {
		pDAO.excluirPartida(id);
		return;
	}
}
