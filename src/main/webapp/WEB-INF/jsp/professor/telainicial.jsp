<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Meu Projeto TCC</title>

	<c:import url="/WEB-INF/jsp/estilo.jsp"></c:import>

</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Gerenciamento de Alunos</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="/professor/obterAlunos">Alunos</a></li>
    </ul>
  </div>
</nav>

<div class="jumbotron text-center">
  <h1>Pagina principal do professor</h1>
  <p>Resize this responsive page to see the effect!</p> 
</div>

</body>
</html>