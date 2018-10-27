package br.usjt.ads.pi.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.ads.pi.model.entity.Campeonato;

@Repository
public class RegulamentoDAO {
	@PersistenceContext
	EntityManager manager;

	public int cadastrarRegulamento(Campeonato campeonato) throws IOException {
		manager.persist(campeonato);
		return campeonato.getId();
	}
}
