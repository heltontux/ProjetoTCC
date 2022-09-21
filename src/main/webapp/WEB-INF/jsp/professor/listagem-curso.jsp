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
    	<c:import  url="/WEB-INF/jsp/professor/cabecalho-professor.jsp"></c:import>
    		
			<div id="bloco">	
				<c:import  url="/WEB-INF/jsp/professor/menu-professor.jsp"></c:import>
				<c:import  url="/WEB-INF/jsp/cabecalho-comum.jsp"></c:import>
	
			<div class="homework">
		
	<c:if test="${not empty mensagem}">
		<div class="alert alert-success alert-dismissible">
    		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    		<strong>Sucesso!</strong> ${mensagem}
  		</div>
	</c:if>
	
	<h3><a href="inicio">Voltar</a></h3>
	
	<c:if test="${not empty cursos}"> 
		
		<p>
		Existem ${cursos.size()} cursos cadastrados</h2>
		<form action="" method="post">
    		<div class="input-group">
    				
		<table class="table table-striped conteudo-lista-aluno" >
    <thead>
      <tr>
      	<th>ID</th>
      	<th>Curso</th>
      	<th>Professor</th>
        <th>Duração</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="curso" items="${cursos}">
      <tr>
      	<td>${curso.idCurso}</td>
      	<td>${curso.descricao}</td>
      	<td>${curso.professor_id}</td>
      	<td>${curso.duracao} horas</td>
        <td><a href="/professor/${curso.idCurso}/exibir-conteudo">Conteúdo</a></td>
      </tr>
       </c:forEach>
    </tbody>
  </table>
  
  </c:if>
  
  <c:if test="${empty cursos}">
  	<h2>Não existem cursos cadastrados!!!</h2>
  </c:if>
		
		</div>
		</div>
    </body>
</html>