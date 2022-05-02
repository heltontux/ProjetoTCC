package com.helton.tcc.gerenciamento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlunoController {
	
	@GetMapping(value = "/aluno/inicio")
	public String inicioAluno() {
		return "aluno/telainicial";
	}

}
