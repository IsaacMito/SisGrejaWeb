<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Usuario</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<div class="card">
		

		<h1 class="sisgreja">SISGREJA</h1>

		<div class="card-grup">

			<label>CPF</label> 
			<input type="text" name="cpf"placeholder="Dígite seu nome" /> 

		</div>
		
		<form action="CadastrarServlet">

			<div class="card-grup">
				<button type="submit">Salva</button>

			</div>
		</form>
	</div>

</body>
</html>