
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
	
	<c:if test="${not empty mensagem2}">
		<div class="alert alert-success alert-dismissible">
	   		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	  	 	<strong>Erro!</strong> ${mensagem2}
	  	</div>
	</c:if>
	
	<h3><a href="/coordenador/cadastrar-turma">Cadastrar turma</a></h3>
	
	<c:if test="${not empty turmas}"> 
		
		<h2>Existem ${turmas.size()} turmas cadastradas</h2>
		<form action="" method="post">
    		<div class="input-group">
    				
		<table class="table table-striped conteudo-lista-aluno" >
    <thead>
      <tr>
      	<th>ID</th>
      	<th>Descriçao</th>
        <th>Data inicial</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="turma" items="${turmas}">
      <tr>
      	<td>${turma.idTurma}</td>
      	<td>${turma.descricao}</td>
      	<td>${turma.data_inicio}</td>
      	<td><a href="/coordenador/${turma.idTurma}/excluir-turma">Excluir</a></td>
        <td><a href="/coordenador/${turma.idTurma}/turma-detalhes">Detalhes dos cursos</a></td>
      </tr>
       </c:forEach>
    </tbody>
  </table>
  
  </c:if>
  
  <c:if test="${empty turmas}">
  	<h2>Não existem turmas cadastrados!!!</h2>
  </c:if>
		
		</div>
		</div>
    </body>
</html>