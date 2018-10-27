package br.usjt.ads.pi.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@Column(name = "id")
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="usuario")
	@NotNull
	@Size(min = 5, max = 50)
	private String usuario;
	@Column(name="senha")
	@NotNull
	@Size(min = 5, max = 50)
	private String senha;

	public Usuario() {

	}

	public Usuario(int id, String usuario, String senha) {
		this.id = id;
		this.usuario = usuario;
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	@Override
	public String toString() {
		return "Administrador [id=" + id + ", nome=" + usuario + ", senha=" + senha + "]";
	}

}
