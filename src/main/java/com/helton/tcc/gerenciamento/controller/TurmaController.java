package com.helton.tcc.gerenciamento.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.helton.tcc.gerenciamento.model.domain.Curso;
import com.helton.tcc.gerenciamento.model.domain.Turma;

@Controller
public class TurmaController {
	
	public void salvar(Turma turma){
        
        String sqlTurma = "INSERT INTO turmas (descricao, curso_id, data_inicio, data_fim)"
                + "VALUES (?, ?, ?, ?)";
        String sqlTurmaCurso = "INSERT INTO turma_curso (turma_id, curso_id) VALUES (?, ?)";
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(sqlTurma);
            stmt.setString(1, turma.getDescricao());
            stmt.setInt(2, turma.getCurso_id());
            stmt.setString(3, turma.getData_inicio());
            stmt.setString(4, turma.getData_fim());
            stmt.execute();
            
            //Inicio...
            //Preparando e executando a segunda SQL para gravar na tabela turma_curso:
            stmt = conn.prepareStatement(sqlTurmaCurso);
            ArrayList<Turma> listaTurma = (ArrayList<Turma>) obterTodos();
            int n = listaTurma.size();
            Turma turmaSalva = listaTurma.get(n-1);
            stmt.setInt(1, turmaSalva.getIdTurma());
            stmt.setInt(2, turmaSalva.getCurso_id());
            stmt.execute();
            //Fim!
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar a turma" +ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }
	
	public void atualizar(Turma turma){
        
        String sql = "UPDATE turmas SET descricao = ?, curso_id = ?,"
                + "data_inicio = ?, data_fim = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            //Estabelecendo a conexão com o banco de dodos
            conn = ConnectionFactory.getConnection();
            
            //Preparando a query
            stmt = conn.prepareStatement(sql);
            
            //Setando os valores do statement
            stmt.setString(1, turma.getDescricao());
            stmt.setInt(2, turma.getCurso_id());
            stmt.setString(3, turma.getData_inicio());
            stmt.setString(3, turma.getData_fim());
            
            //Executando a query
            stmt.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar a turma "+ ex.getMessage(), ex);
        }           
    }

	public void removeById(int idTurma){ 
        
        String sql= "DELETE FROM turmas WHERE id = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            //Criação da conexão com o banco de dados
            conn = ConnectionFactory.getConnection();
            
            //Preparando a query
            stmt = conn.prepareStatement(sql);
            
            //Setando os valores
            stmt.setInt(1, idTurma);
            
            //Executando a query
            stmt.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar a turma" + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }
	
	public Turma buscaTurma(int idTurma) {
		
		String sql = "SELECT * FROM turmas WHERE idTurma = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        
        Turma turma = new Turma();
        
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idTurma);
            //Executando a query
            rset = stmt.executeQuery();
            if (rset.next()) {
            	turma.setIdTurma(rset.getInt("idTurma"));
            	turma.setDescricao(rset.getString("descricao"));
            	turma.setCurso_id(rset.getInt("curso_id"));
            	turma.setData_inicio(rset.getString("data_inicio"));
            	turma.setData_fim(rset.getString("data_fim"));
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar a turma "+ ex.getMessage(), ex);
      }           	
		return turma;
	}
	
	
	
	
	public List<Turma> obterTodos(){
        
        //Preparando a query e atribuindo à variavel sql
        String sql = "SELECT * FROM turmas";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        
        //Criando a lista vazia para receber os Cursos
        List<Turma> turmas = new ArrayList<Turma>();
        
        try {
            
            //Estabelecendo a conexão com o banco de dados
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(sql);
            
            //ResultSet é o objeto que recebe a execução da query
            rset = stmt.executeQuery();
                      
            //Enquanto houverem valores a serem percorridos no ResultSet...
            while(rset.next()) {
                
                //Cria uma turma vazia
                Turma turma = new Turma();
                
                //Seta os valores recebidos pelo rset na tarefa criada
                turma.setIdTurma(rset.getInt("idTurma"));
                turma.setDescricao(rset.getString("descricao"));
                turma.setCurso_id(rset.getInt("curso_id"));
                turma.setData_inicio(rset.getString("data_inicio"));
                turma.setData_fim(rset.getString("data_fim"));
                
                //Adiciona o curso com os valores preenchidos na lista
                turmas.add(turma);
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar a turma" + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rset);
        }
        //Após o while, retorna a lista com os valore preenchidos (os cursos) 
        return turmas;
    }

}

