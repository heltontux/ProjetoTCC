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
	
	<h3><a href="/coordenador/cadastrar-professor">Cadastrar professor</a></h3>
	
	<c:if test="${not empty professores}"> 
		
		<h2>Existem ${professores.size()} professores na base de dados </h2>
    				
		<table class="table table-striped conteudo-lista-aluno" >
    <thead>
      <tr>
        <th>ID</th>
      	<th>Nome</th>
        <th>CPF</th>
        <th>Email</th>
        <th></th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="professor" items="${professores}">
      <tr>
        <td>${professor.idProfessor}</td>
      	<td>${professor.nome}</td>
      	<td>${professor.cpf}</td>
      	<td>${professor.email}</td>
        <td><a href="/coordenador/${professor.idProfessor}/detalhes-professor">Detalhar</a></td>
        <td><a href="/coordenador/${professor.idProfessor}/excluir-professor">Excluir</a></td>
      </tr>
       </c:forEach>
    </tbody>
  </table>
  
  </c:if>
  
  <c:if test="${empty professores}">
  	<h2>Não existem cursos cadastrados!!!</h2>
  </c:if>
		
		</div>
		</div>
    </body>
</html>