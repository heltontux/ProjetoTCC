package com.helton.tcc.gerenciamento.model.domain;

public class Conteudo {
	
	private int idConteudo;
	private int idCurso;
	private String topico;
	private String detalhes;
	private String dia;
	private String hora;
	
	public int getIdConteudo() {
		return idConteudo;
	}
	public void setIdConteudo(int idConteudo) {
		this.idConteudo = idConteudo;
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public String getTopico() {
		return topico;
	}
	public void setTopico(String topico) {
		this.topico = topico;
	}
	public String getDetalhes() {
		return detalhes;
	}
	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	@Override
	public String toString() {
		return "Conteudo [idConteudo=" + idConteudo + ", idCurso=" + idCurso + ", topico=" + topico + ", detalhes="
				+ detalhes + ", dia=" + dia + ", hora=" + hora + "]";
	}
	
	

}
