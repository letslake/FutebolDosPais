package br.usjt.ads.pi.model.service;

import java.io.IOException;

import br.usjt.ads.pi.model.dao.AdministradorDAO;
import br.usjt.ads.pi.model.entity.Administrador;

public class AuthentificationService {
	private AdministradorDAO admDAO;
	
	public AuthentificationService() {
		admDAO = new AdministradorDAO();
	}
	
	public Administrador buscarAdministrador(String username) throws IOException {
		return admDAO.buscarAdmin(username);
	}
	
}
