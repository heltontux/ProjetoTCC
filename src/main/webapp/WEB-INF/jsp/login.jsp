<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Entre na plataforma</title>

	<c:import url="/WEB-INF/jsp/estilo.jsp"></c:import>

</head>
</head>
<body>

		<c:import url = "/WEB-INF/jsp/menu.jsp"/>

	<div class="login">	  
	  <form action="/" class="formulario">
	  	<div class="form-cabecalho">
	  		<h2>Login</h2>
	  	</div>
	    <div class="form-conteudo">
	      <label for="usuario">Usuário:</label>
	      <input type="usuario" class="form-control" id="usuario" placeholder="Insira o usuário" name="usuario">
	    </div>
	    <div class="form-conteudo">
	      <label for="pwd">Senha:</label>
	      <input type="password" class="form-control" id="pwd" placeholder="Insira a senha" name="pwd">
	    </div>
	    <div class="checkbox">
	      <label><input type="checkbox" name="remember"> Lembrar meu login</label>
	    </div>
	    <button type="submit" class="btn btn-default">Enviar</button>
	    <button type="submit" class="btn btn-default">Voltar</button>
	   </form>
	  	 
</div>

	</form> 

</body>
</html>