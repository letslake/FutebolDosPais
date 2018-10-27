package br.usjt.ads.pi.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "campeonato")
public class Campeonato {
	@Id
	@Column(name = "id")
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nome")
	@NotNull
	private String nome;
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	@ManyToOne
	@JoinColumn(name = "id_regulamento")
	private Regulamento regulamento;

	public Campeonato() {
	}

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
