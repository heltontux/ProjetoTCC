<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <c:import url="/WEB-INF/jsp/meuestilo.jsp"></c:import>     
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cadastrar Aluno</title>
    </head>
    <body>
    	<c:import  url="/WEB-INF/jsp/coordenador/cabecalho-coordenador.jsp"></c:import>
    	<c:import  url="/WEB-INF/jsp/coordenador/menu-coordenador.jsp"></c:import>
		<c:import  url="/WEB-INF/jsp/cabecalho-comum.jsp"></c:import>
    
		<div class="homework">
			<h2>Cadastro de aluno</h2>
			<form action="#">
				<label for="nome">Nome completo:</label><br>
				<input type="text" id="nome" name="nome" placeholder="Nome completo"><br>

				<label for="email">Email:</label><br>
				<input type="text" id="email" name="email" placeholder="nome@exemplo.com"><br>

				<label for="cpf">CPF:</label><br>
				<input type="text" id="cpf" name="cpf" placeholder="Somente números"><br>
				
				<label for="turma">Turma:</label><br>
				<input type="text" id="turma" name="turma" placeholder="Código da turma"><br>

				<label for="senha">Senha:</label><br>
				<input type="password" id="senha" name="senha"><br>

			 	<input type="submit" value="Cadastrar">
			</form>
		</div>
    </body>
</html>

