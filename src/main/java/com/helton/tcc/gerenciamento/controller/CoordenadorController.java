package com.helton.tcc.gerenciamento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoordenadorController {
	
	@GetMapping(value = "/coordenador/inicio")
	public String inicioCoordenador() {
		return "coordenador/telainicial";
	}

}
