package br.usjt.ads.pi.model.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ads.pi.model.dao.LocalDAO;
import br.usjt.ads.pi.model.entity.Local;

@Service
public class LocalService {
	@Autowired
	private LocalDAO lDAO;

	@Transactional
	public Local buscarLocal(int id) throws IOException {
		return lDAO.buscarLocal(id);
	}

	@Transactional
	public List<Local> listarLocais() throws IOException {
		return lDAO.listarLocais();
	}
}
