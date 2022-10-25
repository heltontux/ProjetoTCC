package com.helton.tcc.gerenciamento.model.testes;

import java.util.ArrayList;
import java.util.List;

import com.helton.tcc.gerenciamento.controller.TurmaController;
import com.helton.tcc.gerenciamento.model.domain.Turma;

public class TurmaTeste {

	public static void main(String[] args) {
		/*
		Turma turma = new Turma();
		TurmaController turmaCtrl = new TurmaController();
		ArrayList<Turma> listaTurma = (ArrayList<Turma>) turmaCtrl.obterTodos();
		int n = listaTurma.size();
		turma = listaTurma.get(n-1);
		System.out.println(turma);
		*/
		
		TurmaController turmaCtrl = new TurmaController();
		turmaCtrl.removeById(3);
		System.out.println("ok!!");
		
	}

}
