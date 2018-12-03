package br.usjt.ads.pi.model.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ads.pi.model.dao.TipoArbitroDAO;
import br.usjt.ads.pi.model.entity.TipoArbitro;

@Service
public class TipoArbitroService {
	@Autowired
	private TipoArbitroDAO taDAO;

	@Transactional
	public TipoArbitro buscarTipoArbitro(int id) throws IOException {
		return taDAO.buscarTipoArbitro(id);
	}

	@Transactional
	public List<TipoArbitro> listarTiposArbitro() throws IOException {
		return taDAO.listarTiposArbitro();
	}
}
