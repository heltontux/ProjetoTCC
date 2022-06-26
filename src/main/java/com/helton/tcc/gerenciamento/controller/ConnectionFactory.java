package com.helton.tcc.gerenciamento.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
    
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/webapptcc";
    public static final String USER = "root";
    public static final String PASS = "";
    
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception ex){
            throw new RuntimeException("Erro na conexão com o banco de dados ", ex);
        }
    }
    
    public static void closeConnection(Connection connection){
        try {
            if (connection != null){
                connection.close();
            }
        } catch (Exception ex){
          throw new RuntimeException("Erro ao fechar a conexão com o banco de dados ", ex);
        }

    }
    
    public static void closeConnection(Connection conn, PreparedStatement stmt){
        try {
            if (conn != null){
                conn.close();
            }
            
            if (stmt != null){
                stmt.close();
            }
        } catch (Exception ex){
          throw new RuntimeException("Erro ao fechaer a conexão com o banco de dados ", ex);
        }

    }
    
    public static void closeConnection(Connection conn, PreparedStatement stmt, ResultSet rset){
        try {
            if (conn != null){
                conn.close();
            }
            
            if (stmt != null){
                stmt.close();
            }
            
            if (rset != null){
                rset.close();
            }
        } catch (Exception ex){
          throw new RuntimeException("Erro ao fechar a conexão com o banco de dados ", ex);
        }

    }
}
