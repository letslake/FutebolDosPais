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
@Table(name = "equipe")
public class Equipe {
	@Id
	@Column(name = "id")
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "id_coordenador")
	private Coordenador coordenador;
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	@ManyToOne
	@JoinColumn(name = "id_tecnico")
	private Tecnico tecnico;
	@Column(name = "nome")
	@NotNull
	private String nome;
	@Column(name = "bandeira")
	private String bandeira;
	@Column(name = "uniforme_casa")
	private String uniforme_casa;
	@Column(name = "uniforme_fora")
	private String uniforme_fora;
	@Column(name = "terceiro_uniforme")
	private String terceiro_uniforme;
	@Column(name = "vitorias")
	private int vitorias;
	@Column(name = "derrotas")
	private int derrotas;
	@Column(name = "empates")
	private int empates;
	@Column(name = "qtn_jogos")
	private int qtn_jogos;
	@Column(name = "gols_feitos")
	private int golsFeitos;
	@Column(name = "gols_sofridos")
	private int golsSofridos;

	@Column(name = "media_jogos")
	private float media_jogos;

	public Equipe() {
		super();
	}

	public Equipe(int id, Coordenador coordenador, Categoria categoria, Tecnico tecnico, String nome, String bandeira,
			String uniforme_casa, String uniforme_fora, String terceiro_uniforme, int vitorias, int derrotas,
			int empates, int qtn_jogos, int golsFeitos, int golsSofridos, float media_jogos) {
		super();
		this.id = id;
		this.coordenador = coordenador;
		this.categoria = categoria;
		this.tecnico = tecnico;
		this.nome = nome;
		this.bandeira = bandeira;
		this.uniforme_casa = uniforme_casa;
		this.uniforme_fora = uniforme_fora;
		this.terceiro_uniforme = terceiro_uniforme;
		this.vitorias = vitorias;
		this.derrotas = derrotas;
		this.empates = empates;
		this.qtn_jogos = qtn_jogos;
		this.golsFeitos = golsFeitos;
		this.golsSofridos = golsSofridos;
		this.media_jogos = media_jogos;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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

	public String getUniforme_casa() {
		return uniforme_casa;
	}

	public void setUniforme_casa(String uniforme_casa) {
		this.uniforme_casa = uniforme_casa;
	}

	public String getUniforme_fora() {
		return uniforme_fora;
	}

	public void setUniforme_fora(String uniforme_fora) {
		this.uniforme_fora = uniforme_fora;
	}

	public String getTerceiro_uniforme() {
		return terceiro_uniforme;
	}

	public void setTerceiro_uniforme(String terceiro_uniforme) {
		this.terceiro_uniforme = terceiro_uniforme;
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

	public int getQtn_jogos() {
		return qtn_jogos;
	}

	public void setQtn_jogos(int qtn_jogos) {
		this.qtn_jogos = qtn_jogos;
	}

	public int getGolsFeitos() {
		return golsFeitos;
	}

	public void setGolsFeitos(int golsFeitos) {
		this.golsFeitos = golsFeitos;
	}

	public int getGolsSofridos() {
		return golsSofridos;
	}

	public void setGolsSofridos(int golsSofridos) {
		this.golsSofridos = golsSofridos;
	}

	public float getMedia_jogos() {
		return media_jogos;
	}

	public void setMedia_jogos(float media_jogos) {
		this.media_jogos = media_jogos;
	}

	@Override
	public String toString() {
		return "Equipe [id=" + id + ", coordenador=" + coordenador + ", categoria=" + categoria + ", tecnico=" + tecnico
				+ ", nome=" + nome + ", bandeira=" + bandeira + ", uniforme_casa=" + uniforme_casa + ", uniforme_fora="
				+ uniforme_fora + ", terceiro_uniforme=" + terceiro_uniforme + ", vitorias=" + vitorias + ", derrotas="
				+ derrotas + ", empates=" + empates + ", qtn_jogos=" + qtn_jogos + ", golsFeitos=" + golsFeitos
				+ ", golsSofridos=" + golsSofridos + ", media_jogos=" + media_jogos + "]";
	}

}
