package br.usjt.ads.pi.model.entity;

import javax.persistence.Entity;

public class Equipe {
	private int id;
	private Coordenador coordenador;
	private Tecnico tecnico;
	private String nome;
	private String bandeira;
	private String uniformeCasa;
	private String uniformeFora;
	private String terceiroUniforme;
	private int vitorias;
	private int derrotas;
	private int empates;
	private int qtnGols;
	private int qtnGolsSofridos;
	private int qtnJogos;
	private float mediaJogos;
	private int totalPontos;


	public Equipe() {
		super();
	}

	public Equipe(int id, Coordenador coordenador, Tecnico tecnico, String nome, String bandeira, String uniformeCasa,
			String uniformeFora, String terceiroUniforme, int vitorias, int derrotas, int empates, int qtnGols,
			int qtnGolsSofridos, int qtnJogos, float mediaJogos, int totalPontos) {
		super();
		this.id = id;
		this.coordenador = coordenador;
		this.tecnico = tecnico;
		this.nome = nome;
		this.bandeira = bandeira;
		this.uniformeCasa = uniformeCasa;
		this.uniformeFora = uniformeFora;
		this.terceiroUniforme = terceiroUniforme;
		this.vitorias = vitorias;
		this.derrotas = derrotas;
		this.empates = empates;
		this.qtnGols = qtnGols;
		this.qtnGolsSofridos = qtnGolsSofridos;
		this.qtnJogos = qtnJogos;
		this.mediaJogos = mediaJogos;
		this.totalPontos = totalPontos;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Coordenador getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Coordenador coordenador) {
		this.coordenador = coordenador;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public String getUniformeCasa() {
		return uniformeCasa;
	}

	public void setUniformeCasa(String uniformeCasa) {
		this.uniformeCasa = uniformeCasa;
	}

	public String getUniformeFora() {
		return uniformeFora;
	}

	public void setUniformeFora(String uniformeFora) {
		this.uniformeFora = uniformeFora;
	}

	public String getTerceiroUniforme() {
		return terceiroUniforme;
	}

	public void setTerceiroUniforme(String terceiroUniforme) {
		this.terceiroUniforme = terceiroUniforme;
	}

	public int getVitorias() {
		return vitorias;
	}

	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}

	public int getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}

	public int getEmpates() {
		return empates;
	}

	public void setEmpates(int empates) {
		this.empates = empates;
	}

	public int getQtnGols() {
		return qtnGols;
	}

	public void setQtnGols(int qtnGols) {
		this.qtnGols = qtnGols;
	}

	public int getQtnGolsSofridos() {
		return qtnGolsSofridos;
	}

	public void setQtnGolsSofridos(int qtnGolsSofridos) {
		this.qtnGolsSofridos = qtnGolsSofridos;
	}

	public int getQtnJogos() {
		return qtnJogos;
	}

	public void setQtnJogos(int qtnJogos) {
		this.qtnJogos = qtnJogos;
	}

	public float getMediaJogos() {
		return mediaJogos;
	}

	public void setMediaJogos(float mediaJogos) {
		this.mediaJogos = mediaJogos;
	}
	
	
	public int getTotalPontos() {
		return totalPontos;
	}

	public void setTotalPontos(int totalPontos) {
		this.totalPontos = totalPontos;
	}

	@Override
	public String toString() {
		return "Equipe [id=" + id + ", coordenador=" + coordenador + ", tecnico=" + tecnico + ", nome=" + nome
				+ ", bandeira=" + bandeira + ", uniformeCasa=" + uniformeCasa + ", uniformeFora=" + uniformeFora
				+ ", terceiroUniforme=" + terceiroUniforme + ", vitorias=" + vitorias + ", derrotas=" + derrotas
				+ ", empates=" + empates + ", qtnGols=" + qtnGols + ", qtnGolsSofridos=" + qtnGolsSofridos
				+ ", qtnJogos=" + qtnJogos + ", mediaJogos=" + mediaJogos + ", totalPontos=" + totalPontos + "]";
	}

}
