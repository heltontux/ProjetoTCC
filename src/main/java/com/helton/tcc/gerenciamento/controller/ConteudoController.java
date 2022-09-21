package com.helton.tcc.gerenciamento.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.helton.tcc.gerenciamento.model.domain.Aluno;
import com.helton.tcc.gerenciamento.model.domain.Conteudo;

public class ConteudoController {


public void salvar(Conteudo conteudo){
    
    String sql = "INSERT INTO conteudos (curso_id, topico, detalhes, dia, hora)"
            + "VALUES (?, ?, ?, ?, ?)";
    Connection conn = null;
    PreparedStatement stmt = null;
    
    try {
        conn = ConnectionFactory.getConnection();
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, conteudo.getIdCurso());
        stmt.setString(2, conteudo.getTopico());
        stmt.setString(3, conteudo.getDetalhes());
        stmt.setString(4, conteudo.getDia());
        stmt.setString(5, conteudo.getHora());
        stmt.execute();
        
    } catch (SQLException ex) {
        throw new RuntimeException("Erro ao salvar o conteúdo " +ex.getMessage(), ex);
    } finally {
        ConnectionFactory.closeConnection(conn, stmt);
    }
}

public void atualizar(Conteudo conteudo){
    
    String sql = "UPDATE conteudos SET curso_id = ?, topico = ?, detalhes = ?,"
            + "dia = ?,"
            + "hora = ?"
            + "WHERE idConteudo = ?";
    
    Connection conn = null;
    PreparedStatement stmt = null;
    
    try {
        //Estabelecendo a conexão com o banco de dodos
        conn = ConnectionFactory.getConnection();
        
        //Preparando a query
        stmt = conn.prepareStatement(sql);
        
        //Setando os valores do statement
        stmt.setInt(1, conteudo.getIdCurso());
        stmt.setString(2, conteudo.getTopico());
        stmt.setString(3, conteudo.getDetalhes());
        stmt.setString(4, conteudo.getDia());
        stmt.setString(5, conteudo.getHora());
        stmt.setInt(6, conteudo.getIdConteudo());
   
        //Executando a query
        stmt.execute();
        
    } catch (SQLException ex) {
        throw new RuntimeException("Erro ao atualizar o conteudo "+ ex.getMessage(), ex);
    }           
}

public void removeById(int idConteudo){ 
    
    String sql= "DELETE FROM conteudos WHERE idConteudo = ?";
    Connection conn = null;
    PreparedStatement stmt = null;
    
    try {
        //Criação da conexão com o banco de dados
        conn = ConnectionFactory.getConnection();
        
        //Preparando a query
        stmt = conn.prepareStatement(sql);
        
        //Setando os valores
        stmt.setInt(1, idConteudo);
        
        //Executando a query
        stmt.execute();
        
    } catch (SQLException ex) {
        throw new RuntimeException("Erro ao deletar o conteudo" + ex.getMessage(), ex);
    } finally {
        ConnectionFactory.closeConnection(conn, stmt);
    }
}

public Conteudo buscaConteudo(int idConteudo) {
	
	String sql = "SELECT * FROM conteudos WHERE idConteudo = ?";
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rset = null;
    
    Conteudo conteudo = new Conteudo();
    
    try {
        conn = ConnectionFactory.getConnection();
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idConteudo);
        //Executando a query
        rset = stmt.executeQuery();
        if (rset.next()) {
            conteudo.setIdConteudo(rset.getInt("idConteudo"));
            conteudo.setIdCurso(rset.getInt("curso_id"));
            conteudo.setTopico(rset.getString("topico"));
            conteudo.setDetalhes(rset.getString("detalhes"));
            conteudo.setDia(rset.getString("dia"));
            conteudo.setHora(rset.getString("hora"));
        }
        
    } catch (SQLException ex) {
        throw new RuntimeException("Erro ao buscar o conteudo "+ ex.getMessage(), ex);
  }           	
	return conteudo;
}

public List<Conteudo> buscaConteudoCurso(int idCurso) {
	
	String sql = "SELECT * FROM conteudos WHERE curso_id = ?";
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rset = null;
    
    List<Conteudo> conteudos = new ArrayList<Conteudo>();
    
    try {
        conn = ConnectionFactory.getConnection();
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idCurso);
        //Executando a query
        rset = stmt.executeQuery();
        while (rset.next()) {
            Conteudo conteudo = new Conteudo();
            conteudo.setIdConteudo(rset.getInt("idConteudo"));
            conteudo.setIdCurso(rset.getInt("curso_id"));
            conteudo.setTopico(rset.getString("topico"));
            conteudo.setDetalhes(rset.getString("detalhes"));
            conteudo.setDia(rset.getString("dia"));
            conteudo.setHora(rset.getString("hora"));
            conteudos.add(conteudo);
        }
        
    } catch (SQLException ex) {
        throw new RuntimeException("Erro ao buscar o conteudo "+ ex.getMessage(), ex);
  }           	
	return conteudos;
}

public List<Conteudo> obterTodos(){
    
    //Preparando a query e atribuindo à variavel sql
    String sql = "SELECT * FROM conteudos";
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rset = null;
    
    //Criando a lista vazia para receber as tarefas
    List<Conteudo> conteudos = new ArrayList<Conteudo>();
    
    try {
        
        //Estabelecendo a conexão com o banco de dados
        conn = ConnectionFactory.getConnection();
        stmt = conn.prepareStatement(sql);
        
        //ResultSet é o objeto que recebe a execução da query
        rset = stmt.executeQuery();
                  
        //Enquanto houverem valores a serem percorridos no ResultSet...
        while(rset.next()) {
            
            //Cria um projeto vazia
            Conteudo conteudo = new Conteudo();
            
            //Seta os valores recebidos pelo rset na tarefa criada
            conteudo.setIdConteudo(rset.getInt("idConteudo"));
            conteudo.setIdCurso(rset.getInt("curso_id"));
            conteudo.setTopico(rset.getString("topico"));
            conteudo.setDetalhes(rset.getString("detalhes"));
            conteudo.setDia(rset.getString("dia"));
            conteudo.setHora(rset.getString("hora"));
            
            //Adiciona o projeto com os valores preenchidos na lista
            conteudos.add(conteudo);
        }
        
    } catch (SQLException ex) {
        throw new RuntimeException("Erro ao buscar o conteudo" + ex.getMessage(), ex);
    } finally {
        ConnectionFactory.closeConnection(conn, stmt, rset);
    }
    //Após o while, retorna a lista com os valore preenchidos (as tarefas) 
    return conteudos;
}

}
