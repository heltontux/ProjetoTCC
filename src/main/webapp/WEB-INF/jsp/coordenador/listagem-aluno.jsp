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
    		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    		<strong>Sucesso!</strong> ${mensagem}
  		</div>
	</c:if>
	
	<h3><a href="/coordenador/cadastrar-aluno">Incluir um novo aluno</a></h3>
	
	<c:if test="${not empty alunos}"> 
		
		<h2>Existem ${alunos.size()} alunos cadastrados</h2>
		<form action="" method="post">
    		<div class="input-group">
		
	<table class="table table-striped conteudo-lista-aluno" >
    <thead>
      <tr>
      	<th>ID</th>
        <th>Nome</th>
        <th>Email</th>
        <th>Turma</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="aluno" items="${alunos}">
      <tr>
      	<td>${aluno.ID}</td>
      	<td>${aluno.nome}</td>
        <td>${aluno.email}</td>
        
         <c:forEach var="turma" items="${turmas}">
	      	<c:if test="${aluno.turma eq turma.idTurma}">
	       		<td>${turma.descricao}</td>
	       	</c:if>
	     </c:forEach>
        
       <!--  <td>${aluno.turma}</td>  -->
        <td><a href="/coordenador/${aluno.ID}/excluir-aluno">Excluir</a></td>
        <td><a href="/coordenador/${aluno.ID}/consultar">Detalhar</a></td>
      </tr>
       </c:forEach>
    </tbody>
  </table>
  
  </c:if>
  
  <c:if test="${empty alunos}">
  	<h2>Não existem alunos cadastrados!!!</h2>
  </c:if>
		
		</div>
		</div>
    </body>
</html>

