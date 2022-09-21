package com.helton.tcc.gerenciamento.model.testes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.helton.tcc.gerenciamento.controller.ConteudoController;
import com.helton.tcc.gerenciamento.model.domain.Conteudo;

public class ConteudoTeste {
	
	public static void main(String[] args) {
		
		Conteudo c = new Conteudo();
		ConteudoController conteudoCtrl = new ConteudoController();
		
		//c.setIdConteudo(9);
		/*
		c.setIdCurso(4);
		c.setTopico("Teste 12");
		c.setDetalhes("Aula experimental de teste 12");
		c.setDia("10/10/2010");
		c.setHora("15:36");
		*/
		//System.out.println(c);
	
		c.setTopico("Teste 16:00");		
		
		conteudoCtrl.salvar(c);
		
		//conteudoCtrl.atualizar(c);
		
		//conteudoCtrl.removeById(9);
		
		Conteudo cont = conteudoCtrl.buscaConteudo(14);
		System.out.println(cont);
		
		/* //Inicio exibir conteudo ...
		List<Conteudo> conteudo = new ArrayList<Conteudo>();	
		conteudo = conteudoCtrl.obterTodos();
		
		Iterator it = conteudo.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	*/
	}

}
