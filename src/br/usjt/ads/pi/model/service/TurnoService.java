package br.usjt.ads.pi.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ads.pi.model.dao.TurnoDAO;
import br.usjt.ads.pi.model.entity.Turno;

@Service
public class TurnoService {
	@Autowired
	private TurnoDAO tDAO;
	
	public Turno buscarTurno(int id) throws IOException {
		return tDAO.buscarTurno(id);
	}

	public List<Turno> listarTurnos() throws IOException {
		return tDAO.listarTurnos();
	}
}
