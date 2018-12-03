package br.usjt.ads.pi.model.service;

import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ads.pi.model.dao.RegulamentoDAO;
import br.usjt.ads.pi.model.entity.Campeonato;

@Service
public class RegulamentoService {
	@Autowired
	private RegulamentoDAO regulamentoDAO;

	@Transactional
	public int cadastrarRegulamento(Campeonato campeonato) throws IOException {
		System.out.println("REGULAMENTO SERVICE");
		return regulamentoDAO.cadastrarRegulamento(campeonato);
	}
}
