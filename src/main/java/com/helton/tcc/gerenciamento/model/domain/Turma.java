package com.helton.tcc.gerenciamento.model.domain;

public class Turma {
	
	private int idTurma;
	private String descricao;
	private int curso_id;
	private String data_inicio;
	private String data_fim;
	
	public int getIdTurma() {
		return idTurma;
	}
	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getCurso_id() {
		return curso_id;
	}
	public void setCurso_id(int curso_id) {
		this.curso_id = curso_id;
	}
	public String getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}
	public String getData_fim() {
		return data_fim;
	}
	public void setData_fim(String data_fim) {
		this.data_fim = data_fim;
	}
	@Override
	public String toString() {
		return "Turma [idTurma=" + idTurma + ", descricao=" + descricao + ", curso_id=" + curso_id + ", data_inicio="
				+ data_inicio + ", data_fim=" + data_fim + "]";
	}

}
