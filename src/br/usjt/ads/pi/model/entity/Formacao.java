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
@Table(name = "formacao")
public class Formacao {
	@Id
	@Column(name = "id")
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_equipe")
	private Equipe equipe;

	@ManyToOne
	@JoinColumn(name = "goleiro")
	private Jogador goleiro;

	@ManyToOne
	@JoinColumn(name = "lateral_direito")
	private Jogador lateralDireito;

	@ManyToOne
	@JoinColumn(name = "lateral_esquerdo")
	private Jogador lateralEsquerdo;

	@ManyToOne
	@JoinColumn(name = "zagueiro1")
	private Jogador zagueiro1;
	@ManyToOne
	@JoinColumn(name = "zagueiro2")
	private Jogador zagueiro2;

	@ManyToOne
	@JoinColumn(name = "volante")
	private Jogador volante;

	@ManyToOne
	@JoinColumn(name = "meio_campo1")
	private Jogador meioCampo1;
	@ManyToOne
	@JoinColumn(name = "meio_campo2")
	private Jogador meioCampo2;

	@ManyToOne
	@JoinColumn(name = "ponta_esquerda")
	private Jogador pontaEsquerda;

	@ManyToOne
	@JoinColumn(name = "ponta_direita")
	private Jogador pontaDireita;

	@ManyToOne
	@JoinColumn(name = "atacante")
	private Jogador atacante;

	public Formacao() {
		super();
	}

	public Formacao(int id, Equipe equipe, Jogador goleiro, Jogador lateralDireito, Jogador lateralEsquerdo,
			Jogador zagueiro1, Jogador zagueiro2, Jogador volante, Jogador meioCampo1, Jogador meioCampo2,
			Jogador pontaEsquerda, Jogador pontaDireita, Jogador atacante) {
		super();
		this.id = id;
		this.equipe = equipe;
		this.goleiro = goleiro;
		this.lateralDireito = lateralDireito;
		this.lateralEsquerdo = lateralEsquerdo;
		this.zagueiro1 = zagueiro1;
		this.zagueiro2 = zagueiro2;
		this.volante = volante;
		this.meioCampo1 = meioCampo1;
		this.meioCampo2 = meioCampo2;
		this.pontaEsquerda = pontaEsquerda;
		this.pontaDireita = pontaDireita;
		this.atacante = atacante;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Jogador getGoleiro() {
		return goleiro;
	}

	public void setGoleiro(Jogador goleiro) {
		this.goleiro = goleiro;
	}

	public Jogador getLateralDireito() {
		return lateralDireito;
	}

	public void setLateralDireito(Jogador lateralDireito) {
		this.lateralDireito = lateralDireito;
	}

	public Jogador getLateralEsquerdo() {
		return lateralEsquerdo;
	}

	public void setLateralEsquerdo(Jogador lateralEsquerdo) {
		this.lateralEsquerdo = lateralEsquerdo;
	}

	public Jogador getZagueiro1() {
		return zagueiro1;
	}

	public void setZagueiro1(Jogador zagueiro1) {
		this.zagueiro1 = zagueiro1;
	}

	public Jogador getZagueiro2() {
		return zagueiro2;
	}

	public void setZagueiro2(Jogador zagueiro2) {
		this.zagueiro2 = zagueiro2;
	}

	public Jogador getVolante() {
		return volante;
	}

	public void setVolante(Jogador volante) {
		this.volante = volante;
	}

	public Jogador getMeioCampo1() {
		return meioCampo1;
	}

	public void setMeioCampo1(Jogador meioCampo1) {
		this.meioCampo1 = meioCampo1;
	}

	public Jogador getMeioCampo2() {
		return meioCampo2;
	}

	public void setMeioCampo2(Jogador meioCampo2) {
		this.meioCampo2 = meioCampo2;
	}

	public Jogador getPontaEsquerda() {
		return pontaEsquerda;
	}

	public void setPontaEsquerda(Jogador pontaEsquerda) {
		this.pontaEsquerda = pontaEsquerda;
	}

	public Jogador getPontaDireita() {
		return pontaDireita;
	}

	public void setPontaDireita(Jogador pontaDireita) {
		this.pontaDireita = pontaDireita;
	}

	public Jogador getAtacante() {
		return atacante;
	}

	public void setAtacante(Jogador atacante) {
		this.atacante = atacante;
	}

	@Override
	public String toString() {
		return "Formacao [id=" + id + ", equipe=" + equipe + ", goleiro=" + goleiro + ", lateralDireito="
				+ lateralDireito + ", lateralEsquerdo=" + lateralEsquerdo + ", zagueiro1=" + zagueiro1 + ", zagueiro2="
				+ zagueiro2 + ", volante=" + volante + ", meioCampo1=" + meioCampo1 + ", meioCampo2=" + meioCampo2
				+ ", pontaEsquerda=" + pontaEsquerda + ", pontaDireita=" + pontaDireita + ", atacante=" + atacante
				+ "]";
	}

}
