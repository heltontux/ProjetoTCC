<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de alunos nos cursos</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<c:import url = "/WEB-INF/jsp/menu.jsp"/>

	<div class ="container">
		<h2> Listagem de Alunos: ${alunos.size()}</h2>
			
		
			 <table class="table">
			    <thead>
			      <tr>
			        <th>Firstname</th>
			        <th>Turma</th>
			        <th>Curso</th>
			      </tr>
			    </thead>
			    <tbody>
			    	<c:forEach var="aluno" items="${alunos}">
				      <tr>
				        <td>${aluno}</td>
				      </tr>
			      </c:forEach>
			    </tbody>
		  	</table>	
	</div>

</body>
</html>