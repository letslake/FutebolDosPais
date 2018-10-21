package br.usjt.ads.pi.model.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ads.pi.model.dao.AdministradorDAO;
import br.usjt.ads.pi.model.entity.Administrador;

@Service
public class AuthentificationService {
	
	@Autowired
	private AdministradorDAO admDAO;
	
	
	public Administrador buscarAdministrador(String username) throws IOException {
		System.out.println(username);
		return admDAO.buscarAdmin(username);
	}
	
}
