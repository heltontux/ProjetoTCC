package com.helton.tcc.gerenciamento.model.domain;

public class Professor {
	
	private String nome;
	private int idade;
	private float salario;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	@Override
	public String toString() {
		return "Sou professor " +nome+ " e tenho " +idade+ " anos";
	}

}
