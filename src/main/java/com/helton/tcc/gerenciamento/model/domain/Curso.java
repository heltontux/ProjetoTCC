package com.helton.tcc.gerenciamento.model.domain;

public class Curso {
	
	private int 	idCurso;
	private String 	descricao;
	private int 	professor_id;
	private float	duracao;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getDuracao() {
		return duracao;
	}
	public void setDuracao(float duracao) {
		this.duracao = duracao;
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public int getProfessor_id() {
		return professor_id;
	}
	public void setProfessor_id(int professor_id) {
		this.professor_id = professor_id;
	}
	
	@Override
	public String toString() {
		return "Curso [idCurso=" + idCurso + ", descricao=" + descricao + ", professor_id=" + professor_id
				+ ", duracao=" + duracao + "]";
	}
	
	

}
