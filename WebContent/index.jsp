<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String mensagem = null;
	String codMensagem = request.getParameter("mensagam");
	
	if ("1".equals(codMensagem))
		mensagem = "Usuário incorreto";
	else if ("2".equals(codMensagem))
		mensagem = "Erro";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>SisGreja</title>

<link rel="stylesheet" href="css/style.css"/>

<link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
/>
<style type="text/css">

#apDiv1 {
	position: absolute;
	width: 382px;
	height: 199px;
	z-index: 1;
	left: 349px;
	top: -72px;
}
#apDiv2 {
	position: absolute;
	width: 200px;
	height: 52px;
	z-index: 2;
	left: 111px;
	top: 357px;
}
#apDiv3 {
	position: absolute;
	width: 247px;
	height: 230px;
	z-index: 1;
	top: 82px;
	left: 413px;
	background-color: #FFFFFF;
}
</style>
</head>
<body>
	<div class="card animate__animated animate__zoomInDown">
	
		<form action="LoginServletUsuario" method="post">

			<h1 class="sisgreja animate__animated animate__fadeIn animate__delay-1s">SISGREJA</h1>

			<div class="card-grup">

					<label class="animate__animated animate__flipInX animate__delay-1s">Login</label> 
					<input type="text" name="login" placeholder="Dígite seu login" /> 
                    
                    <label class="animate__animated animate__flipInX animate__delay-1s">Senha</label> 
					<input type="text" name="senha" placeholder="Dígite sua senha" /> 

				<button type="submit">Entrar</button>

			</div>
		</form>
		
		<div class="erro animate__animated animate__shakeX animate__delay-1s">
			<%
				if(mensagem != null)
					out.print(mensagem);
			%>
		</div>
		
	</div>
</body>
</html>