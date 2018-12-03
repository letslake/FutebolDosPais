package br.usjt.ads.pi.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tecnico")
public class Tecnico {
	@Id
	@Column(name = "id")
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nome")
	@NotNull
	private String nome;
	@Column(name = "cpf")
	@NotNull
	private String cpf;
	@Column(name = "endereco")
	@NotNull
	private String endereco;
	@Column(name = "telefone")
	@NotNull
	private String telefone;

	public Tecnico() {

	}

	public Tecnico(int id, String nome, String cpf, String endereco, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Tecnico [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + ", telefone="
				+ telefone + "]";
	}

}
