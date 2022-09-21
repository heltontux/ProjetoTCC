<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <c:import url="/WEB-INF/jsp/meuestilo.jsp"></c:import>     
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cadastrar Curso</title>
    </head>
    <body>
    	<c:import  url="/WEB-INF/jsp/coordenador/cabecalho-coordenador.jsp"></c:import>
    	<c:import  url="/WEB-INF/jsp/coordenador/menu-coordenador.jsp"></c:import>
		<c:import  url="/WEB-INF/jsp/cabecalho-comum.jsp"></c:import>
    
		<div class="homework">
			<h2>Cadastro de Curso</h2>
			
			<form method="post" action="/coordenador/actionCadastrarCurso">
				<label for="descricao">Descrição:</label><br>
				<input type="text" id="descricao" name="descricao"><br>

				<label for="professor_id">Professor:</label><br>
					<select name="professor_id">
						<c:forEach var="professor" items="${professores}"> 
						  <option value="${professor.idProfessor}">${professor.nome}</option>						  
						</c:forEach>
					</select><br>

				<label for="duracao">Duração (em) horas:</label><br>
				<input type="number" id="duracao" name="duracao"><br>
				
			 	<input type="submit" value="Cadastrar">
			 	<input type="button" value=Voltar javascript:onclick="/coordenandor/inicio"> 
			</form>
		</div>
    </body>
</html>