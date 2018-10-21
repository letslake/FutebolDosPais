package br.usjt.ads.pi.model.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ads.pi.model.dao.RegulamentoDAO;
import br.usjt.ads.pi.model.entity.Campeonato;

@Service
public class RegulamentoService {
	@Autowired
	private RegulamentoDAO regulamentoDAO;

	public int cadastrarRegulamento(Campeonato campeonato) throws IOException {
		return regulamentoDAO.cadastrarRegulamento(campeonato);
	}
}
