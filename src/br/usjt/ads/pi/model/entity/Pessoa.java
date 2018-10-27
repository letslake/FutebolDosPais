package br.usjt.ads.pi.model.entity;

import java.sql.Date;

import javax.persistence.Entity;

public class Pessoa {

	private int id;
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	private Date dataNascimento;
	private float altura;
	private float peso;
	private String foto;

	public Pessoa() {
		super();
	}

	public Pessoa(int id, String nome, String cpf, String endereco, String telefone, Date dataNascimento, float altura,
			float peso, String foto) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.altura = altura;
		this.peso = peso;
		this.foto = foto;
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + ", telefone="
				+ telefone + ", dataNascimento=" + dataNascimento + ", altura=" + altura + ", peso=" + peso + ", foto="
				+ foto + "]";
	}

}
