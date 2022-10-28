package com.helton.tcc.gerenciamento.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.helton.tcc.gerenciamento.model.domain.Aluno;
import com.helton.tcc.gerenciamento.model.domain.Conteudo;
import com.helton.tcc.gerenciamento.model.domain.Curso;
import com.helton.tcc.gerenciamento.model.domain.Professor;

@Controller
public class ProfessorController {
	
	@GetMapping(value = "/professor/inicio")
	public String listaTurma() {
		return "professor/telainicial";
	}
	
	@GetMapping(value = "/professor/listagem-aluno")
	public String obterAlunos(Model modelAluno, Model modelTurma) {
		AlunoController alunoCtrl = new AlunoController();
		TurmaController turmaCtrl = new TurmaController();
		modelAluno.addAttribute("alunos", alunoCtrl.obterTodos());
		modelTurma.addAttribute("turmas", turmaCtrl.obterTodos());
		return "professor/listagem-aluno";
	}
	
	@GetMapping(value = "/professor/listagem-curso")
	public String listagemCurso(Model modelCurso, Model modelProfessor) {
		CursoController cursoCtrl = new CursoController();
		ProfessorController professorCtrl = new ProfessorController();
		modelProfessor.addAttribute("professores", professorCtrl.obterTodos());
		modelCurso.addAttribute("cursos", cursoCtrl.obterTodos());
		return "professor/listagem-curso";
	}
	
	@GetMapping(value = "/professor/cadastrar-conteudo")
	public String cadastraConteudo(Model model) {
		CursoController cursoCtrl = new CursoController();
		model.addAttribute("cursos", cursoCtrl.obterTodos());
		return "professor/cadastrar-conteudo";
	}
	
	@GetMapping(value = "/professor/{id}/exibir-conteudo")
	public String exibirConteudo(Model model, @PathVariable int id) {
		CursoController cursoCtrl = new CursoController();
		Curso cursoSelecionado = new Curso();
		cursoSelecionado = cursoCtrl.buscaCurso(id);
		model.addAttribute("mensagem", "Curso: " +cursoSelecionado.getDescricao());
		ConteudoController conteudoCtrl = new ConteudoController();
		model.addAttribute("conteudos", conteudoCtrl.buscaConteudoCurso(id));
		return "professor/curso-selecionado";
	}
	
	@PostMapping(value = "/professor/actionCadastrarConteudo")
	public String actionCadastrarConteudo(Model model, Conteudo conteudo) {
		
		ConteudoController conteudoCtrl = new ConteudoController();
		try {
			conteudoCtrl.salvar(conteudo);
			model.addAttribute("mensagem1", "Conteúdo cadastrado com sucesso!!!");
		} catch (Exception e) {
			model.addAttribute("mensagem2", "Verifique as restrições no banco de dados!!");
		}
		CursoController cursoCtrl = new CursoController();
		ProfessorController professorCtrl =  new ProfessorController();
		
		model.addAttribute("cursos", cursoCtrl.obterTodos());
		model.addAttribute("professores", professorCtrl.obterTodos());
		return "professor/listagem-curso";
	}
	
	
public void salvar(Professor professor){
        
        String sql = "INSERT INTO professores (nome, cpf, email, senha)"
                + "VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getCpf());
            stmt.setString(3, professor.getEmail());
            stmt.setInt(4, professor.getSenha());
            stmt.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar o professor" +ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }
	
	public void atualizar(Professor professor){
        
        String sql = "UPDATE professores SET nome = ?, cpf = ?,"
                + "email = ?,"
                + "senha = ?"
                + "WHERE ID = ?";
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            //Estabelecendo a conexão com o banco de dodos
            conn = ConnectionFactory.getConnection();
            
            //Preparando a query
            stmt = conn.prepareStatement(sql);
            
            //Setando os valores do statement
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getCpf());
            stmt.setString(3, professor.getEmail());
            stmt.setInt(4, professor.getSenha());
            stmt.setInt(5, professor.getIdProfessor());
       
            //Executando a query
            stmt.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar o professor "+ ex.getMessage(), ex);
        }           
    }

	public void removeById(int idProfessor){ 
        
        String sql= "DELETE FROM professores WHERE id = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            //Criação da conexão com o banco de dados
            conn = ConnectionFactory.getConnection();
            
            //Preparando a query
            stmt = conn.prepareStatement(sql);
            
            //Setando os valores
            stmt.setInt(1, idProfessor);
            
            //Executando a query
            stmt.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar o professor" + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }
	
	public Professor buscaProfessor(int idProfessor) {
		
		String sql = "SELECT * FROM professores WHERE ID = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        
        Professor professor = new Professor();
        
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idProfessor);
            //Executando a query
            rset = stmt.executeQuery();
            if (rset.next()) {
	            professor.setIdProfessor(rset.getInt("ID"));
	            professor.setNome(rset.getString("nome"));
	            professor.setCpf(rset.getString("cpf"));
	            professor.setEmail(rset.getString("email"));
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar o professor "+ ex.getMessage(), ex);
      }           	
		return professor;
	}
	
	public List<Professor> obterTodos(){
        
        //Preparando a query e atribuindo à variavel sql
        String sql = "SELECT * FROM professores";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        
        //Criando a lista vazia para receber as tarefas
        List<Professor> professores = new ArrayList<Professor>();
        
        try {
            
            //Estabelecendo a conexão com o banco de dados
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(sql);
            
            //ResultSet é o objeto que recebe a execução da query
            rset = stmt.executeQuery();
                      
            //Enquanto houverem valores a serem percorridos no ResultSet...
            while(rset.next()) {
                
                //Cria um objeto professor vazio
                Professor professor = new Professor();
                
                //Seta os valores recebidos pelo rset na tarefa criada
                professor.setIdProfessor(rset.getInt("ID"));   
                professor.setNome(rset.getString("nome"));
                professor.setCpf(rset.getString("cpf"));
                professor.setEmail(rset.getString("email"));

                professores.add(professor);
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar o professores" + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rset);
        }

        return professores;
    }

}

