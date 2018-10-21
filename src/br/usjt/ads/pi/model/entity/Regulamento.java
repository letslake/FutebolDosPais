package br.usjt.ads.pi.model.entity;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Regulamento {

	private int id;
	private int qtnTimes;
	private int pontosVitoria;
	private int ponstoEmpate;
	private int tempoJogo;
	private int tempoIntervalo;
	private Date dataInicio;
	private Date dataTermino;

	public Regulamento() {
	}

	public Regulamento(int id, int qtnTimes, int pontosVitoria, int ponstoEmpate, int tempoJogo, int tempoIntervalo,
			Date dataInicio, Date dataTermino) {
		this.id = id;
		this.qtnTimes = qtnTimes;
		this.pontosVitoria = pontosVitoria;
		this.ponstoEmpate = ponstoEmpate;
		this.tempoJogo = tempoJogo;
		this.tempoIntervalo = tempoIntervalo;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQtnTimes() {
		return qtnTimes;
	}

	public void setQtnTimes(int qtnTimes) {
		this.qtnTimes = qtnTimes;
	}

	public int getPontosVitoria() {
		return pontosVitoria;
	}

	public void setPontosVitoria(int pontosVitoria) {
		this.pontosVitoria = pontosVitoria;
	}

	public int getPonstoEmpate() {
		return ponstoEmpate;
	}

	public void setPonstoEmpate(int ponstoEmpate) {
		this.ponstoEmpate = ponstoEmpate;
	}

	public int getTempoJogo() {
		return tempoJogo;
	}

	public void setTempoJogo(int tempoJogo) {
		this.tempoJogo = tempoJogo;
	}

	public int getTempoIntervalo() {
		return tempoIntervalo;
	}

	public void setTempoIntervalo(int tempoIntervalo) {
		this.tempoIntervalo = tempoIntervalo;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	@Override
	public String toString() {
		return "Regulamento [id=" + id + ", qtnTimes=" + qtnTimes + ", pontosVitoria=" + pontosVitoria
				+ ", ponstoEmpate=" + ponstoEmpate + ", tempoJogo=" + tempoJogo + ", tempoIntervalo=" + tempoIntervalo
				+ ", dataInicio=" + dataInicio + ", dataTermino=" + dataTermino + "]";
	}

}
