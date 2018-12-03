package br.usjt.ads.pi.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "turno")
public class Turno {
	@Id
	@Column(name = "id")
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nome")
	@NotNull
	private String nome;

	public Turno() {
		super();
	}

	public Turno(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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

	@Override
	public String toString() {
		return "Turno [id=" + id + ", nome=" + nome + "]";
	}

}
