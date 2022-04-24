package com.helton.tcc.gerenciamento.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfessorController {
	
	@GetMapping(value = "/professor/inicio")
	public String listaTurma() {
		return "professor/inicio";
	}
	
	@GetMapping(value = "/professor/obterAlunos")
	public String obterAlunos(Model model) {
		
		List<String> colecaoAlunos = new ArrayList<String>();
		colecaoAlunos.add("Maria");
		colecaoAlunos.add("Fabio");
		colecaoAlunos.add("Henrique");
		colecaoAlunos.add("Ana Paula");
		
		model.addAttribute("alunos", colecaoAlunos);
		
		return "professor/alunos";
	}
}
