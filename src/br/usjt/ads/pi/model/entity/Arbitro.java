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
@Table(name = "arbitro")
public class Arbitro {
	@Id
	@Column(name = "id")
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "id_tipo_arbitro")
	private TipoArbitro tipoArbitro;

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

	@Column(name = "media_nota")
	private float mediaNota;

	@Column(name = "qtn_cartao_vermelho")
	private int qtn_cartao_vermelho;
	@Column(name = "qtn_cartao_amarelo")
	private int qtn_cartao_amarelo;

	public Arbitro() {
		super();
	}

	public Arbitro(int id, TipoArbitro tipoArbitro, String nome, String cpf, String endereco, String telefone,
			float mediaNota, int qtn_cartao_vermelho, int qtn_cartao_amarelo) {
		super();
		this.id = id;
		this.tipoArbitro = tipoArbitro;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.mediaNota = mediaNota;
		this.qtn_cartao_vermelho = qtn_cartao_vermelho;
		this.qtn_cartao_amarelo = qtn_cartao_amarelo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TipoArbitro getTipoArbitro() {
		return tipoArbitro;
	}

	public void setTipoArbitro(TipoArbitro tipoArbitro) {
		this.tipoArbitro = tipoArbitro;
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

	public float getMediaNota() {
		return mediaNota;
	}

	public void setMediaNota(float mediaNota) {
		this.mediaNota = mediaNota;
	}

	public int getQtn_cartao_vermelho() {
		return qtn_cartao_vermelho;
	}

	public void setQtn_cartao_vermelho(int qtn_cartao_vermelho) {
		this.qtn_cartao_vermelho = qtn_cartao_vermelho;
	}

	public int getQtn_cartao_amarelo() {
		return qtn_cartao_amarelo;
	}

	public void setQtn_cartao_amarelo(int qtn_cartao_amarelo) {
		this.qtn_cartao_amarelo = qtn_cartao_amarelo;
	}

	@Override
	public String toString() {
		return "Arbitro [id=" + id + ", tipoArbitro=" + tipoArbitro + ", nome=" + nome + ", cpf=" + cpf + ", endereco="
				+ endereco + ", telefone=" + telefone + ", mediaNota=" + mediaNota + ", qtn_cartao_vermelho="
				+ qtn_cartao_vermelho + ", qtn_cartao_amarelo=" + qtn_cartao_amarelo + "]";
	}

}
