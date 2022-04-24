<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Entre na plataforma</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
</head>
<body>

<div class="container">
	  <h2>Login</h2>
	  <form action="/">
	    <div class="form-group">
	      <label for="matricula">Matricula:</label>
	      <input type="matricula" class="form-control" id="matricula" placeholder="Insira a matricula" name="matricula">
	    </div>
	    <div class="form-group">
	      <label for="pwd">Senha:</label>
	      <input type="password" class="form-control" id="pwd" placeholder="Insira a senha" name="pwd">
	    </div>
	    <div class="checkbox">
	      <label><input type="checkbox" name="remember"> Lembrar meu login</label>
	    </div>
	    <button type="submit" class="btn btn-default">Enviar</button>
	    <button class="btn btn-default" onclick="window.location.href='/'">Voltar</button> 
	  </form>
</div>

	</form> 

</body>
</html>