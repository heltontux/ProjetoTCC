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
		
	<c:if test="${not empty mensagem}">
		<div class="alert alert-success alert-dismissible">
    		<h2>${mensagem}</h2>
  		</div>
	</c:if>
	
	<h3>
		<a href="/coordenador/listagem-curso">Voltar</a>
	</h3>
    				
	<table class="table table-striped conteudo-lista-aluno" >
    <thead>
      <tr>
      	<th>ID Conteudo</th>
        <th>ID Curso</th>
        <th>Tópico</th>
        <th>Detalhes</th>
        <th>Dia</th>
        <th>Hora</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
     <c:forEach var="conteudo" items="${conteudos}">
      <tr>
      	<td>${conteudo.idConteudo}</td>
      	<td>${conteudo.idCurso}</td>
      	<td>${conteudo.topico}</td>
      	<td>${conteudo.detalhes}</td>
      	<td>${conteudo.dia}</td>
      	<td>${conteudo.hora}</td>
        <td><a href="/coordenador/${conteudo.idConteudo}/exibir-conteudo">Editar</a></td>
      </tr>
      </c:forEach>
    </tbody>
  	</table>
	
	<c:if test="${empty conteudos}">
  	<h2>Não existem conteúdos cadastrados!!!</h2>
  </c:if>
  
		</div>
		</div>
    </body>
</html>