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
@Table(name = "jogador")
public class Jogador {
	@Id
	@Column(name = "id")
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

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

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	@NotNull
	private Date data_nascimento;

	@Column(name = "altura")
	@NotNull
	private float altura;

	@Column(name = "peso")
	@NotNull
	private float peso;

	@Column(name = "qtn_cartao_vermelho")
	private int qtn_cartao_vermelho;

	@Column(name = "qtn_cartao_amarelo")
	private int qtn_cartao_amarelo;

	@Column(name = "qtn_gols")
	private int qtn_gols;

	@Column(name = "qtn_gols_contra")
	private int qtn_gols_contra;

	@Column(name = "numero")
	private int numero;

	@Column(name = "titular")
	private boolean titular;

	@Column(name = "capitao")
	private boolean capitao;

	public Jogador() {
	}

	public Jogador(int id, Categoria categoria, String nome, String cpf, String endereco, String telefone,
			Date data_nascimento, float altura, float peso, int qtn_cartao_vermelho, int qtn_cartao_amarelo,
			int qtn_gols, int qtn_gols_contra, int numero, boolean titular, boolean capitao) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.data_nascimento = data_nascimento;
		this.altura = altura;
		this.peso = peso;
		this.qtn_cartao_vermelho = qtn_cartao_vermelho;
		this.qtn_cartao_amarelo = qtn_cartao_amarelo;
		this.qtn_gols = qtn_gols;
		this.qtn_gols_contra = qtn_gols_contra;
		this.numero = numero;
		this.titular = titular;
		this.capitao = capitao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
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

	public int getQtn_gols() {
		return qtn_gols;
	}

	public void setQtn_gols(int qtn_gols) {
		this.qtn_gols = qtn_gols;
	}

	public int getQtn_gols_contra() {
		return qtn_gols_contra;
	}

	public void setQtn_gols_contra(int qtn_gols_contra) {
		this.qtn_gols_contra = qtn_gols_contra;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isTitular() {
		return titular;
	}

	public void setTitular(boolean titular) {
		this.titular = titular;
	}

	public boolean isCapitao() {
		return capitao;
	}

	public void setCapitao(boolean capitao) {
		this.capitao = capitao;
	}

	@Override
	public String toString() {
		return "Jogador [id=" + id + ", categoria=" + categoria + ", nome=" + nome + ", cpf=" + cpf + ", endereco="
				+ endereco + ", telefone=" + telefone + ", data_nascimento=" + data_nascimento + ", altura=" + altura
				+ ", peso=" + peso + ", qtn_cartao_vermelho=" + qtn_cartao_vermelho + ", qtn_cartao_amarelo="
				+ qtn_cartao_amarelo + ", qtn_gols=" + qtn_gols + ", qtn_gols_contra=" + qtn_gols_contra + ", numero="
				+ numero + ", titular=" + titular + ", capitao=" + capitao + "]";
	}

}
