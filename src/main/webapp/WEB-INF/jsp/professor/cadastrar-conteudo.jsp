<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <c:import url="/WEB-INF/jsp/meuestilo.jsp"></c:import>     
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cadastrar Conteúdo</title>
    </head>
    <body>
    	<c:import  url="/WEB-INF/jsp/professor/cabecalho-professor.jsp"></c:import>
    	<c:import  url="/WEB-INF/jsp/professor/menu-professor.jsp"></c:import>
		<c:import  url="/WEB-INF/jsp/cabecalho-comum.jsp"></c:import>
    
		<div class="homework">
			<h2>Cadastro de Conteúdo</h2>
			
			<form method="post" action="/professor/actionCadastrarConteudo">
				<label for="curso_id">Curso:</label><br>
				
				<select name="curso_id">
						<c:forEach var="curso" items="${cursos}">
							<option value="${curso.idCurso}">${curso.descricao}</option>
						</c:forEach>
				</select><br>
				<!-- <input type="text" id="idCurso" name="idCurso"><br>  -->

				<label for="topico">Tópico:</label><br>
				<input type="text" id="topico" name="topico"><br>

				<label for="detalhes">Detalhes</label><br>
				<input type="text" id="detalhes" name="detalhes"><br>
				
				<label for="dia">Dia</label><br>
				<input type="text" id="dia" name="dia"><br>
				
				<label for="hora">Hora</label><br>
				<input type="text" id="hora" name="hora"><br>
				
			 	<input type="submit" value="Cadastrar">
			 	<input type="button" value=Voltar javascript:onclick="/professor/inicio"> 
			</form>
		</div>
    </body>
</html>