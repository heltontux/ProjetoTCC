package com.helton.tcc.gerenciamento.model.testes;

import com.helton.tcc.gerenciamento.model.domain.Professor;

public class ProfessorTeste {
	
	public static void main(String[] args) {

		Professor professor = new Professor();
		professor.setNome("Helton");
		professor.setIdade(42);
		System.out.println(professor);
		
	}
	

}
