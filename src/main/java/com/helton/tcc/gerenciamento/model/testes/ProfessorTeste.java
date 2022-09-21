package com.helton.tcc.gerenciamento.model.testes;

import com.helton.tcc.gerenciamento.controller.ProfessorController;
import com.helton.tcc.gerenciamento.model.domain.Professor;

public class ProfessorTeste {

	public static void main(String[] args) {

		Professor prof = new Professor();
		ProfessorController profCtrl = new ProfessorController();
		prof = profCtrl.buscaProfessor(5);
		System.out.println(prof.getNome());
	}

}
