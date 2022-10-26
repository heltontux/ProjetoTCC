package com.helton.tcc.gerenciamento.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.helton.tcc.gerenciamento.model.domain.Aluno;
import com.helton.tcc.gerenciamento.model.domain.Curso;
import com.helton.tcc.gerenciamento.model.domain.Professor;
import com.helton.tcc.gerenciamento.model.domain.Turma;

@Controller
public class CoordenadorController {
	
	@GetMapping(value = "/coordenador/inicio")
	public String inicioCoordenador() {
		return "coordenador/telainicial";
	}
	
	@GetMapping(value = "/coordenador/cadastrar-aluno")
	public String cadastrarAluno(Model model) {
		TurmaController turmaCtrl = new TurmaController();
		model.addAttribute("turmas", turmaCtrl.obterTodos());
		return "coordenador/cadastrar-aluno";
	}
	
	@GetMapping(value = "/coordenador/cadastrar-curso")
	public String cadastraCurso(Model model) {
		ProfessorController professorCtrl = new ProfessorController();
		model.addAttribute("professores", professorCtrl.obterTodos());
		return "coordenador/cadastrar-curso";
	}
	
	@GetMapping(value = "/coordenador/cadastrar-professor")
	public String cadastrarProfessor() {
		return "coordenador/cadastrar-professor";
	}
	
	@GetMapping(value = "/coordenador/cadastrar-turma")
	public String cadastrarTurma(Model modelCurso) {
		CursoController cursoCtrl = new CursoController();
		modelCurso.addAttribute("cursos", cursoCtrl.obterTodos());
		return "coordenador/cadastrar-turma";
	}
	
	@PostMapping(value = "/coordenador/actionCadastrarAluno")
	public String actionCadastrarAluno(Model model, Aluno aluno) {
		AlunoController alunoCtrl = new AlunoController();
		alunoCtrl.salvar(aluno);
		model.addAttribute("mensagem1", "O(a) aluno(a) "+aluno.getNome()+" foi cadastrado com sucesso!!!");
		model.addAttribute("alunos", alunoCtrl.obterTodos());
		return "coordenador/listagem-aluno";
	}
	
	@PostMapping(value = "/coordenador/actionCadastrarCurso")
	public String actionCadastrarCurso(Model model, Curso curso) {
		CursoController cursoCtrl = new CursoController();
		cursoCtrl.salvar(curso);
		model.addAttribute("mensagem1", "O curso foi cadastrado com sucesso!!!");
		model.addAttribute("cursos", cursoCtrl.obterTodos());
		return "coordenador/listagem-curso";
	}
	
	@PostMapping(value = "/coordenador/actionCadastrarTurma")
	public String actionCadastrarTurma(Model model, Turma turma) {
		TurmaController turmaCtrl = new TurmaController();
		turmaCtrl.salvar(turma);
		model.addAttribute("mensagem1", "A turma "+turma.getDescricao()+" foi cadastrada com sucesso!!!");
		model.addAttribute("turmas", turmaCtrl.obterTodos());
		return "coordenador/listagem-turma";
	}
	
	@PostMapping(value = "/coordenador/actionCadastrarProfessor")
	public String actionCadastrarProfessor(Model model, Professor professor) {
		ProfessorController professorCtrl = new ProfessorController();
		professorCtrl.salvar(professor);
		model.addAttribute("mensagem1", "O(a) professor(a) "+professor.getNome()+" foi cadastrado com sucesso!!!");
		model.addAttribute("professores", professorCtrl.obterTodos());
		return "coordenador/listagem-professor";
	}

	@GetMapping(value = "/coordenador/pesquisar-aluno")
	public String pesquisarAluno() {
		return "coordenador/pesquisar-aluno";
	}
	
	@GetMapping(value = "/coordenador/listagem-aluno")
	public String listagemAluno(Model modelAluno, Model modelTurma) {
		AlunoController alunoCtrl = new AlunoController();
		TurmaController turmaCtrl = new TurmaController();
		modelAluno.addAttribute("alunos", alunoCtrl.obterTodos());
		modelTurma.addAttribute("turmas", turmaCtrl.obterTodos());
		return "coordenador/listagem-aluno";
	}
	
	@GetMapping(value = "/coordenador/listagem-curso")
	public String listagemCurso(Model modelCurso, Model modelProfessor) {
		CursoController cursoCtrl = new CursoController();
		ProfessorController professorCtrl = new ProfessorController();
		modelProfessor.addAttribute("professores", professorCtrl.obterTodos());
		modelCurso.addAttribute("cursos", cursoCtrl.obterTodos());
		return "coordenador/listagem-curso";
	}
	
	@GetMapping(value = "/coordenador/listagem-professor")
	public String listagemProfessor(Model model) {
		ProfessorController professorCtrl = new ProfessorController();
		model.addAttribute("professores", professorCtrl.obterTodos());
		return "coordenador/listagem-professor";
	}
	
	@GetMapping(value = "/coordenador/listagem-turma")
	public String listagemTurma(Model model) {
		TurmaController turmaCtrl = new TurmaController();
		model.addAttribute("turmas", turmaCtrl.obterTodos());
		return "coordenador/listagem-turma";
	}
	
	@GetMapping(value = "/coordenador/{id}/exibir-conteudo")
	public String exibirConteudo(Model modelCurso, Model modelConteudo, @PathVariable int id) {
		CursoController cursoCtrl = new CursoController();
		Curso cursoSelecionado = new Curso();
		cursoSelecionado = cursoCtrl.buscaCurso(id);
		modelCurso.addAttribute("mensagem", "Curso: " +cursoSelecionado.getDescricao());
		ConteudoController conteudoCtrl = new ConteudoController();
		modelCurso.addAttribute("conteudos", conteudoCtrl.buscaConteudoCurso(id));
		return "coordenador/curso-selecionado";
	}

	@GetMapping(value = "/coordenador/{id}/excluir-aluno")
	public String excluirAluno(Model model, @PathVariable int id) {
		AlunoController alunoCtrl = new AlunoController();
		Aluno alunoExcluido = new Aluno();
		alunoExcluido = alunoCtrl.buscaAluno(id);
		try {
			alunoCtrl.removeById(id);
			model.addAttribute("mensagem1", "O(a) aluno(a) " +alunoExcluido.getNome()+ " foi excluido com sucesso!!!");
		} catch (Exception e) {
			model.addAttribute("mensagem2", "O(a) aluno(a) "+alunoExcluido.getNome()+ " Não pode ser excluído! Existe restrição no banco de dados." );
		}
		model.addAttribute("alunos", alunoCtrl.obterTodos());
		return "coordenador/listagem-aluno";
	}
	
	@GetMapping(value = "/coordenador/{id}/excluir-turma")
	public String excluirTurma(Model model, @PathVariable int id) {
		TurmaController turmaCtrl = new TurmaController();
		Turma turmaExcluida = new Turma();
		turmaExcluida = turmaCtrl.buscaTurma(id);
		try {
			turmaCtrl.removeById(id);
			model.addAttribute("mensagem1", "Turma " +turmaExcluida.getDescricao()+ " excluida com sucesso!!");
		} catch (Exception e) {
			model.addAttribute("mensagem2", "A turma não pode ser excluida! Verifique as restrições do banco de dados.");
		}
		model.addAttribute("turmas", turmaCtrl.obterTodos());
		return "coordenador/listagem-turma";
	}
}
