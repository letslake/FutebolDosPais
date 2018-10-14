package br.usjt.ads.pi.model.entity;

public class Administrador {
	private int id;
	private String nome;
	private String email;
	private String senha;
	private String username;
	
	public Administrador() {
		
		
	}
	
	public Administrador(int id, String nome, String email, String senha, String username) {
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
		return "Administrador [id=" + id  + ", nome=" + nome + ", email=" + email
				+ ", senha=" + senha + ", username=" + username + "]";
	}
	
	
	
	
}
