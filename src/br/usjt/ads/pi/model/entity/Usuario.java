package br.usjt.ads.pi.model.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Usuario {
	private int id;
	@NotNull
	@Size(min = 5, max = 50)
	private String nome;
	@NotNull
	@Size(min = 5, max = 50)
	private String email;
	@NotNull
	@Size(min = 5, max = 50)
	private String senha;
	@NotNull
	@Size(min = 5, max = 50)
	private String username;

	public Usuario() {

	}

	public Usuario(int id, String nome, String email, String senha, String username) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Administrador [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", username="
				+ username + "]";
	}

}
