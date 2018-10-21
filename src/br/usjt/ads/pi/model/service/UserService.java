package br.usjt.ads.pi.model.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ads.pi.model.dao.UserDAO;
import br.usjt.ads.pi.model.entity.Usuario;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public int cadastrarUsuario(Usuario user) throws IOException {
		return userDAO.cadastrarUsuario(user);
	}
	
	public ArrayList<Usuario> listarUsuarios() throws IOException {
		return userDAO.listarUsuarios();
	}
	
	public Usuario buscarUsuario(String username) throws IOException {
		return userDAO.buscarUsuario(username);
	}
	
	public void atualizarUsuario(Usuario user) throws IOException {
		userDAO.atualizarUsuario(user);
		return;
	}
	
	public void excluirUsuario(int id) throws IOException {
		userDAO.excluirAdmin(id);
		return;
	}
	
	
	
}
