package br.usjt.ads.pi.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.ads.pi.model.entity.Usuario;
import br.usjt.ads.pi.model.service.UserService;

@RestController
public class ManterAdminControllerRest {
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET, value = "api/usuarios")
	public @ResponseBody ArrayList<Usuario> listarUsuarios() {
		ArrayList<Usuario> lista = null;
		try {
			lista = userService.listarUsuarios();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@RequestMapping(method = RequestMethod.GET, value = "api/usuarios/{username}")
	public @ResponseBody Usuario listarUsuario(@PathVariable("username") String username) {
		Usuario user = null;
		try {
			user = userService.buscarUsuario(username);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "api/usuarios")
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario user) {
		try {
			userService.cadastrarUsuario(user);
			return new ResponseEntity<Usuario>(user, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="api/usuarios/{id}")
	public void excluirUsuario(@PathVariable("id") Long id) {
		try {
			userService.excluirUsuario(id.intValue());
			
		} catch (IOException e ) {
			e.printStackTrace();
		}
	}
	
}
