<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <c:import url="/WEB-INF/jsp/meuestilo.jsp"></c:import>     
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cadastrar Turma</title>
    </head>
    <body>
    	<c:import  url="/WEB-INF/jsp/coordenador/cabecalho-coordenador.jsp"></c:import>
    	<c:import  url="/WEB-INF/jsp/coordenador/menu-coordenador.jsp"></c:import>
		<c:import  url="/WEB-INF/jsp/cabecalho-comum.jsp"></c:import>
    
		<div class="homework">
			<h2>Cadastro de Turma</h2>
			
			<form method="post" action="/coordenador/actionCadastrarTurma">
				<label for="descricao">Descrição:</label><br>
				<input type="text" id="descricao" name="descricao"><br>

				<label for="curso_id">Curso:</label><br>
					<select name="curso_id">
						<c:forEach var="curso" items="${cursos}">
							<option value="${curso.idCurso}">${curso.descricao}</option>
						</c:forEach>
					</select><br>
					
				<label for="data_inicio">Data inicial</label><br>
				<input type="text" id="data_inicio" name="data_inicio"><br>
				
			 	<input type="submit" value="Cadastrar">
			 	<input type="button" value=Voltar javascript:onclick="/coordenandor/inicio"> 
			</form>
		</div>
    </body>
</html>