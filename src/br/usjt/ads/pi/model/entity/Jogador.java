package br.usjt.ads.pi.model.entity;

import java.sql.Date;

import javax.persistence.Entity;

public class Jogador extends Pessoa {
	private int qtnAmarelos;
	private int qtnVermelhos;
	private int qtnGols;
	private int qtnGolsContra;

	public Jogador() {
	}

	public Jogador(int id, String nome, String cpf, String endereco, String telefone, Date dataNascimento,
			int qtnAmarelos, int qtnVermelhos, int qtnGols, int qtnGolsContra, float altura, float peso, String foto) {
		super(id, nome, cpf, endereco, telefone, dataNascimento, altura, peso, foto);
		this.qtnAmarelos = qtnAmarelos;
		this.qtnVermelhos = qtnVermelhos;
		this.qtnGols = qtnGols;
		this.qtnGolsContra = qtnGolsContra;
	}

	public int getQtnAmarelos() {
		return qtnAmarelos;
	}

	public void setQtnAmarelos(int qtnAmarelos) {
		this.qtnAmarelos = qtnAmarelos;
	}

	public int getQtnVermelhos() {
		return qtnVermelhos;
	}

	public void setQtnVermelhos(int qtnVermelhos) {
		this.qtnVermelhos = qtnVermelhos;
	}

	public int getQtnGols() {
		return qtnGols;
	}

	public void setQtnGols(int qtnGols) {
		this.qtnGols = qtnGols;
	}

	public int getQtnGolsContra() {
		return qtnGolsContra;
	}

	public void setQtnGolsContra(int qtnGolsContra) {
		this.qtnGolsContra = qtnGolsContra;
	}

	@Override
	public String toString() {
		return "Jogador [qtnAmarelos=" + qtnAmarelos + ", qtnVermelhos=" + qtnVermelhos + ", qtnGols=" + qtnGols
				+ ", qtnGolsContra=" + qtnGolsContra + "]";
	}

}
