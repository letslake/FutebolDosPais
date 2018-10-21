package br.usjt.ads.pi.model.entity;

import javax.persistence.Entity;

@Entity
public class Campeonato {

	private int id;
	private String nome;
	private Categoria categoria;
	private Regulamento regulamento;
	
	public Campeonato() {}

	public Campeonato(int id, String nome, Categoria categoria, Regulamento regulamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.regulamento = regulamento;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Regulamento getRegulamento() {
		return regulamento;
	}

	public void setRegulamento(Regulamento regulamento) {
		this.regulamento = regulamento;
	}

	@Override
	public String toString() {
		return "Campeonato [id=" + id + ", nome=" + nome + ", categoria=" + categoria + ", regulamento=" + regulamento
				+ "]";
	}
	
	

}
