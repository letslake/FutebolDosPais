package br.usjt.ads.pi.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tipo_arbitro")
public class TipoArbitro {
	@Id
	@Column(name = "id")
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "tipo")
	@NotNull
	private String tipo;

	public TipoArbitro() {
		super();
	}

	public TipoArbitro(int id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "TipoArbitro [id=" + id + ", tipo=" + tipo + "]";
	}

}
