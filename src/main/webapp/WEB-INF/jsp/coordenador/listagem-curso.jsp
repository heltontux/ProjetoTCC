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
    	<c:import  url="/WEB-INF/jsp/coordenador/cabecalho-coordenador.jsp"></c:import>
    		
			<div id="bloco">	
				<c:import  url="/WEB-INF/jsp/coordenador/menu-coordenador.jsp"></c:import>
				<c:import  url="/WEB-INF/jsp/cabecalho-comum.jsp"></c:import>
	
			<div class="homework">
		
	<c:if test="${not empty mensagem1}">
		<div class="alert alert-success alert-dismissible">
    		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    		<strong>Sucesso!</strong> ${mensagem1}
  		</div>
	</c:if>
	
	<h3><a href="inicio">Voltar</a></h3>
	
	<c:if test="${not empty cursos}"> 
		<p>
		<h2>Existem ${cursos.size()} cursos cadastrados</h2>
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
      	
      	<c:forEach var="professor" items="${professores}">
      		<c:if test="${curso.professor_id eq professor.idProfessor}">
      			<td>${professor.nome}</td>
      		</c:if>
      	</c:forEach>
      	   	
      	<td>${curso.duracao} horas</td>
        <td><a href="/coordenador/${curso.idCurso}/exibir-conteudo">Detalhes</a></td>
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