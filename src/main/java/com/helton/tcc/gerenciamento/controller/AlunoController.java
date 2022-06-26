package com.helton.tcc.gerenciamento.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.helton.tcc.gerenciamento.model.domain.Aluno;

@Controller
public class AlunoController {
	
	@GetMapping(value = "/aluno/inicio")
	public String inicioAluno() {
		return "aluno/telainicial";
	}

public void salvar(Aluno aluno){
        
        String sql = "INSERT INTO alunos (nome, email, cpf, turma, senha)"
                + "VALUES (?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getCpf());
            stmt.setInt(4, aluno.getTurma());
            stmt.setString(5, aluno.getSenha());
            stmt.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar o aluno" +ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }
	
	public void atualizar(Aluno aluno){
        
        String sql = "UPDATE alunos SET nome = ?, email = ?,"
                + "cpf = ?,"
                + "turma = ?,"
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
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getCpf());
            stmt.setInt(4, aluno.getTurma());
            stmt.setString(5, aluno.getSenha());
            stmt.setInt(6, aluno.getID());
       
            //Executando a query
            stmt.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar o aluno "+ ex.getMessage(), ex);
        }           
    }

	public void removeById(int idAluno){ 
        
        String sql= "DELETE FROM alunos WHERE id = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            //Criação da conexão com o banco de dados
            conn = ConnectionFactory.getConnection();
            
            //Preparando a query
            stmt = conn.prepareStatement(sql);
            
            //Setando os valores
            stmt.setInt(1, idAluno);
            
            //Executando a query
            stmt.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar o aluno" + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }
	
	public Aluno buscaAluno(int idAluno) {
		
		String sql = "SELECT * FROM alunos WHERE ID = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        
        Aluno aluno = new Aluno();
        
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idAluno);
            //Executando a query
            rset = stmt.executeQuery();
            if (rset.next()) {
	            aluno.setID(rset.getInt("ID"));
	            aluno.setNome(rset.getString("nome"));
	            aluno.setEmail(rset.getString("email"));
	            aluno.setCpf(rset.getString("cpf"));
	            aluno.setTurma(rset.getInt("turma"));
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar o aluno "+ ex.getMessage(), ex);
      }           	
		return aluno;
	}
	
	public List<Aluno> obterTodos(){
        
        //Preparando a query e atribuindo à variavel sql
        String sql = "SELECT * FROM alunos";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        
        //Criando a lista vazia para receber as tarefas
        List<Aluno> alunos = new ArrayList<Aluno>();
        
        try {
            
            //Estabelecendo a conexão com o banco de dados
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(sql);
            
            //ResultSet é o objeto que recebe a execução da query
            rset = stmt.executeQuery();
                      
            //Enquanto houverem valores a serem percorridos no ResultSet...
            while(rset.next()) {
                
                //Cria um projeto vazia
                Aluno aluno = new Aluno();
                
                //Seta os valores recebidos pelo rset na tarefa criada
                aluno.setID(rset.getInt("ID"));   
                aluno.setNome(rset.getString("nome"));
                aluno.setEmail(rset.getString("email"));
                aluno.setCpf(rset.getString("cpf"));
                aluno.setTurma(rset.getInt("turma"));
                
                //Adiciona o projeto com os valores preenchidos na lista
                alunos.add(aluno);
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar o aluno" + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rset);
        }
        //Após o while, retorna a lista com os valore preenchidos (as tarefas) 
        return alunos;
    }

}
