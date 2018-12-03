package br.usjt.ads.pi.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "partida")
public class Partida {

	@Id
	@Column(name = "id")
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_campeonato")
	private Campeonato campeonato;

	@ManyToOne
	@JoinColumn(name = "id_formacao_mandante")
	private Formacao mandante;
	@ManyToOne
	@JoinColumn(name = "id_formacao_visitante")
	private Formacao visitante;

	@ManyToOne
	@JoinColumn(name = "id_arbitro")
	private Arbitro arbitro;

	@ManyToOne
	@JoinColumn(name = "id_turno")
	private Turno turno;

	@ManyToOne
	@JoinColumn(name = "id_local")
	private Local local;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	@Temporal(TemporalType.DATE)
	@Column(name = "data_inicio")
	private Date dataInicio;

	@Column(name = "hora_inicio")
	@NotNull
	private String horaInicio;

	@Column(name = "gols_mandante")
	private int golsMandante;
	@Column(name = "gols_visitante")
	private int golsVisitante;

	public Partida() {
		super();
	}

	public Partida(int id, Campeonato campeonato, Formacao mandante, Formacao visitante, Arbitro arbitro, Turno turno,
			Local local, Date dataInicio, String horaInicio, int golsMandante, int golsVisitante) {
		super();
		this.id = id;
		this.campeonato = campeonato;
		this.mandante = mandante;
		this.visitante = visitante;
		this.arbitro = arbitro;
		this.turno = turno;
		this.local = local;
		this.dataInicio = dataInicio;
		this.horaInicio = horaInicio;
		this.golsMandante = golsMandante;
		this.golsVisitante = golsVisitante;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	public Formacao getMandante() {
		return mandante;
	}

	public void setMandante(Formacao mandante) {
		this.mandante = mandante;
	}

	public Formacao getVisitante() {
		return visitante;
	}

	public void setVisitante(Formacao visitante) {
		this.visitante = visitante;
	}

	public Arbitro getArbitro() {
		return arbitro;
	}

	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public int getGolsMandante() {
		return golsMandante;
	}

	public void setGolsMandante(int golsMandante) {
		this.golsMandante = golsMandante;
	}

	public int getGolsVisitante() {
		return golsVisitante;
	}

	public void setGolsVisitante(int golsVisitante) {
		this.golsVisitante = golsVisitante;
	}

	@Override
	public String toString() {
		return "Partida [id=" + id + ", campeonato=" + campeonato + ", mandante=" + mandante + ", visitante="
				+ visitante + ", arbitro=" + arbitro + ", turno=" + turno + ", local=" + local + ", dataInicio="
				+ dataInicio + ", horaInicio=" + horaInicio + ", golsMandante=" + golsMandante + ", golsVisitantes="
				+ golsVisitante + "]";
	}

}
