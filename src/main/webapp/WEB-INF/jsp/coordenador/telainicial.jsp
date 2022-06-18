<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
    
    <c:import url="/WEB-INF/jsp/meuestilo.jsp"></c:import>
    
     <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- <link rel="stylesheet" type="text/css" href="/WEB-INF/jsp/meuestilo.css">  -->	
        <title>Sistema de Ensino Online</title> 
    
    </head>
    <body>
		<div id="cabecalho-inicial">
			<div class="cabecalho-conteudo">
				<h2>Dasboard - Coordenador</h2>
			</div>
		</div>
		<div id="bloco">
		<div class="menu">
			<div class="menu-conteudo">
				<button>Alunos</button><p>
					<ul>
						<li><a href="pesquisa-aluno.html">Pesquisar</a></li>
						<li><a href="cadastra-aluno.html">Cadastrar</a></li>
						<li><a href="exclui-aluno.html">Excluir</a></li>
					</ul>
				<button>Professores</button><p>
					<ul>
						<li><a href="#41">Pesquisar</a></li>
						<li><a href="#51">Cadastrar</a></li>
						<li><a href="#61">Excluir</a></li>
					</ul>
				<button>Cursos</button><p>	
					<ul>
						<li><a href="#71">Pesquisar</a></li>
						<li><a href="#81">Cadastrar</a></li>
						<li><a href="#91">Excluir</a></li>
					</ul>
				<button>Turmas</button><p>
					<ul>
						<li><a href="#101">Pesquisar</a></li>
						<li><a href="#111">Cadastrar</a></li>
						<li><a href="#121">Excluir</a></li>
					</ul>
			</div>
		</div>
		<div class="cabecalho-info">
			<h2>Sistema de Gestão de Aulas</h2>
		</div>
		<div class="homework">
			<h2>Bem vindo!</h2>
		</div>
		</div>
    </body>
</html>

