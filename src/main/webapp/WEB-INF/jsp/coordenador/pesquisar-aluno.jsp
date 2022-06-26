<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
    	<c:import url="/WEB-INF/jsp/meuestilo.jsp"></c:import>     
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Pesquisar Aluno</title>
    </head>
    <body>
    	<c:import  url="/WEB-INF/jsp/coordenador/cabecalho-coordenador.jsp"></c:import>
    	<c:import  url="/WEB-INF/jsp/coordenador/menu-coordenador.jsp"></c:import>
		<c:import  url="/WEB-INF/jsp/cabecalho-comum.jsp"></c:import>
		<div class="homework">
			<h2>Pesquisar Aluno</h2>
			Insira o nome, matrícula ou CPF<p>
			<input type="text" id="pesquisa" name="pesquisa">
			<input type="submit" value="Buscar">
		</div>
    </body>

</html>

