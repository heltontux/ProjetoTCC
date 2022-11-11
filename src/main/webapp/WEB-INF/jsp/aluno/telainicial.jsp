<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
    
    <c:import url="/WEB-INF/jsp/meuestilo.jsp"></c:import>
    
     <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sistema de Ensino Online</title> 
    
    </head>
    <body>
    	<c:import  url="/WEB-INF/jsp/aluno/cabecalho-aluno.jsp"></c:import>
    		
		<div id="bloco">	
			<c:import  url="/WEB-INF/jsp/aluno/menu-aluno.jsp"></c:import>
			<c:import  url="/WEB-INF/jsp/cabecalho-comum.jsp"></c:import>
		<div class="homework">
			<h2>Bem vindo, Aluno!</h2>
		</div>
		</div>
    </body>
</html>