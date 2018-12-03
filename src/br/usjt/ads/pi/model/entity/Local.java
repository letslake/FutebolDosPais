package br.usjt.ads.pi.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "local_partida")
public class Local {
	@Id
	@Column(name = "id")
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nome")
	@NotNull
	private String nome;
	@Column(name = "rua")
	@NotNull
	private String rua;
	@Column(name = "numero")
	@NotNull
	private int numero;
	@Column(name = "complemento")
	private String complemento;
	@Column(name = "bairro")
	@NotNull
	private String bairro;
	@Column(name = "cidade")
	@NotNull
	private String cidade;
	@Column(name = "estado")
	@NotNull
	private String estado;
	@Column(name = "cep")
	@NotNull
	private String cep;
	@Column(name = "referencias")
	private String referencias;

	public Local() {
		super();
	}

	public Local(int id, String nome, String rua, int numero, String complemento, String bairro, String cidade,
			String estado, String cep, String referencias) {
		super();
		this.id = id;
		this.nome = nome;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.referencias = referencias;
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

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getReferencias() {
		return referencias;
	}

	public void setReferencias(String referencias) {
		this.referencias = referencias;
	}

	@Override
	public String toString() {
		return "Local [id=" + id + ", nome=" + nome + ", rua=" + rua + ", numero=" + numero + ", complemento="
				+ complemento + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", cep=" + cep
				+ ", referencias=" + referencias + "]";
	}

}
