package com.helton.tcc.gerenciamento.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.helton.tcc.gerenciamento.model.domain.Curso;

@Controller
public class CursoController {

	public void salvar(Curso curso){
        
        String sql = "INSERT INTO cursos (descricao, professor_id, duracao)"
                + "VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getDescricao());
            stmt.setInt(2, curso.getProfessor_id());
            stmt.setFloat(3, curso.getDuracao());
            stmt.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar o curso" +ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }
	
	public void atualizar(Curso curso){
        
        String sql = "UPDATE alunos SET descricao = ?, professor_id = ?,"
                + "duracao = ?,";
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            //Estabelecendo a conexão com o banco de dodos
            conn = ConnectionFactory.getConnection();
            
            //Preparando a query
            stmt = conn.prepareStatement(sql);
            
            //Setando os valores do statement
            stmt.setString(1, curso.getDescricao());
            stmt.setInt(2, curso.getProfessor_id());
            stmt.setFloat(3, curso.getDuracao());
            
            //Executando a query
            stmt.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar o curso "+ ex.getMessage(), ex);
        }           
    }

	public void removeById(int idCurso){ 
        
        String sql= "DELETE FROM cursos WHERE id = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            //Criação da conexão com o banco de dados
            conn = ConnectionFactory.getConnection();
            
            //Preparando a query
            stmt = conn.prepareStatement(sql);
            
            //Setando os valores
            stmt.setInt(1, idCurso);
            
            //Executando a query
            stmt.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar o curso" + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }
	
	public Curso buscaCurso(int idCurso) {
		
		String sql = "SELECT * FROM cursos WHERE idCurso = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        
        Curso curso = new Curso();
        
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idCurso);
            //Executando a query
            rset = stmt.executeQuery();
            if (rset.next()) {
            	curso.setIdCurso(rset.getInt("idCurso"));
            	curso.setDescricao(rset.getString("descricao"));
            	curso.setProfessor_id(rset.getInt("professor_id"));
            	curso.setDuracao(rset.getFloat("duracao"));
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar o cursoo "+ ex.getMessage(), ex);
      }           	
		return curso;
	}
	
	public List<Curso> obterTodos(){
        
        //Preparando a query e atribuindo à variavel sql
        String sql = "SELECT * FROM cursos";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        
        //Criando a lista vazia para receber os Cursos
        List<Curso> cursos = new ArrayList<Curso>();
        
        try {
            
            //Estabelecendo a conexão com o banco de dados
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(sql);
            
            //ResultSet é o objeto que recebe a execução da query
            rset = stmt.executeQuery();
                      
            //Enquanto houverem valores a serem percorridos no ResultSet...
            while(rset.next()) {
                
                //Cria um curso vazio
                Curso curso = new Curso();
                
                //Seta os valores recebidos pelo rset na tarefa criada
                curso.setIdCurso(rset.getInt("idCurso"));
                curso.setDescricao(rset.getString("descricao"));
                curso.setProfessor_id(rset.getInt("professor_id"));
                curso.setDuracao(rset.getInt("duracao"));
                
                //Adiciona o curso com os valores preenchidos na lista
                cursos.add(curso);
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar o curso" + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rset);
        }
        //Após o while, retorna a lista com os valore preenchidos (os cursos) 
        return cursos;
    }

}
