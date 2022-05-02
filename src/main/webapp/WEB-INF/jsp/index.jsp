<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Projeto TCC CEDERJ</title>
  
	<c:import url="/WEB-INF/jsp/estilo.jsp"></c:import>
	
</head>
<body>

	<c:import url = "/WEB-INF/jsp/menu.jsp"/>

<div class="jumbotron text-center">
  <h1>Gerenciador de alunos e aulas online</h1>
  <p>Este sistema permite a efetivação de aulas online e acompanhamento de alunos. Escolha um perfil e comece a usar:</p>
  <BUTTON onclick="window.location.href='login'">ENTRAR</BUTTON>  
</div>

<div class="container">
  <div class="row">
    <div class="col-sm-4">
    <h3>Aluno</h3>
      <p>Se você é aluno, pode fazer um curso que já esteja cadastrado. Caso não seja cadastrado entre em contato com o cordenador</p>
    </div>
    <div class="col-sm-4">
      <h3>Professor</h3>
      <p>Acompanhe seus alunos, exponha conteúdo e aplique teste </p>
    </div>
    <div class="col-sm-4">
      <h3>Cordenador</h3>       
      <p>Cadastre professores, cursos, alunos e visualize status do cursos.</p>
    </div>
  </div>
</div>

</body>
</html>