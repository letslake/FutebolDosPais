package br.usjt.ads.pi.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "regulamento")
public class Regulamento {
	@Id
	@Column(name = "id")
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "qtn_times")
	@NotNull
	private int qtn_times;
	@Column(name = "pontos_vitoria")
	@NotNull
	private int pontos_vitoria;
	@Column(name = "pontos_empate")
	@NotNull
	private int ponto_empates;

	@Column(name = "tempo_jogo")
	@NotNull
	private int tempo_jogo;
	@Column(name = "tempo_intervalo")
	@NotNull
	private int tempo_intervalo;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	@Temporal(TemporalType.DATE)
	@Column(name = "data_inicio")
	@NotNull
	private Date data_inicio;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	@Temporal(TemporalType.DATE)
	@Column(name = "data_termino")
	@NotNull
	private Date data_termino;

	public Regulamento() {
	}

	public Regulamento(int id, int qtnTimes, int pontosVitoria, int pontosEmpate, int tempoJogo, int tempoIntervalo,
			Date dataInicio, Date dataTermino) {
		this.id = id;
		this.qtn_times = qtnTimes;
		this.pontos_vitoria = pontosVitoria;
		this.ponto_empates = pontosEmpate;
		this.tempo_jogo = tempoJogo;
		this.tempo_intervalo = tempoIntervalo;
		this.data_inicio = dataInicio;
		this.data_termino = dataTermino;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQtnTimes() {
		return qtn_times;
	}

	public void setQtnTimes(int qtnTimes) {
		this.qtn_times = qtnTimes;
	}

	public int getPontosVitoria() {
		return pontos_vitoria;
	}

	public void setPontosVitoria(int pontosVitoria) {
		this.pontos_vitoria = pontosVitoria;
	}

	public int getPontosEmpate() {
		return ponto_empates;
	}

	public void setPontosEmpate(int pontosEmpate) {
		this.ponto_empates = pontosEmpate;
	}

	public int getTempoJogo() {
		return tempo_jogo;
	}

	public void setTempoJogo(int tempoJogo) {
		this.tempo_jogo = tempoJogo;
	}

	public int getTempoIntervalo() {
		return tempo_intervalo;
	}

	public void setTempoIntervalo(int tempoIntervalo) {
		this.tempo_intervalo = tempoIntervalo;
	}

	public Date getDataInicio() {
		return data_inicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.data_inicio = dataInicio;
	}

	public Date getDataTermino() {
		return data_termino;
	}

	public void setDataTermino(Date dataTermino) {
		this.data_termino = dataTermino;
	}

	@Override
	public String toString() {
		return "Regulamento [id=" + id + ", qtnTimes=" + qtn_times + ", pontosVitoria=" + pontos_vitoria
				+ ", ponstoEmpate=" + ponto_empates + ", tempoJogo=" + tempo_jogo + ", tempoIntervalo="
				+ tempo_intervalo + ", dataInicio=" + data_inicio + ", dataTermino=" + data_termino + "]";
	}

}
