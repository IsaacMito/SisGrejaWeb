<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ include file="../seguranca.jsp" %>

<%@page import="com.isaac.sisgreja.persist.UsuariosDao"%>
<%@page import="com.isaac.sisgreja.domain.Usuario"%>
<%@page import="com.isaac.sisgreja.util.Funcoes"%>

<%	

	String mensagem = null;
	String codMensagem = request.getParameter("m");
	String login = request.getParameter("login");
	
	Usuario usuario = null;
	if (login != null) {
		UsuariosDao dao = new UsuariosDao();
		usuario = dao.buscar(login);
	}

	if ("1".equals(codMensagem))
		mensagem = "Conta já registrada";
	else if ("2".equals(codMensagem))
		mensagem = "Erro";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/principal.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Language" content="pt-br"/>
<title>SysGreja</title>
<link rel="stylesheet" href="../css/style.css"/>

<link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
/>
</head>
<body>

<div class="card-centralizado"> 
<div class="card-grup">

<h1 class="sisgreja animate__animated animate__fadeIn animate__delay-1s">SISGREJA</h1>
    
<div class="center"> 
    
  	<hr class="hr-horizontal">
  
  <nobr class="nobr-vertical animate__animated animate__fadeIn animate__delay-1.5s"> <a href="../fiel/lista.jsp">Fiel</a></nobr>
  
  <nobr class="nobr-vertical animate__animated animate__fadeIn animate__delay-1.5s"> <a href="../pastor/lista.jsp">Pastor</a></nobr>
  
  <nobr class="nobr-vertical animate__animated animate__fadeIn animate__delay-1.5s"> <a href="lista.jsp"> Usuario</a></nobr>
  
  <nobr class="animate__animated animate__fadeIn animate__delay-1.5s"> <a href="../index.jsp">Sair</a></nobr>
  
  <hr class="hr-horizontal">
  
  </div>
  
<div class="center pading"><!-- InstanceBeginEditable name="conteudo" -->
        
        <form action="<%if(usuario != null) out.print("AlterarUsuarioServlet"); else out.print("CadastrarUsuarioServlet"); %>" >
        <table width="100%" border="1">
            <tr>
              <td align="center">Cadastro de Usuario</td>
            </tr>
            <tr>
              <td><table width="100%" border="0">
                <tr>
                  <td width="29%" align="left">LOGIN:</td>
                  <td width="71%" align="left"><label for="cpf"></label>
                    <input name="login" type="text" id="login" value="<%if(usuario != null) out.print(usuario.getLogin()); %>" size="20%" <% if(usuario != null) out.print("readonly=\"readonly\"");%>/></td>
                </tr>
                <tr>
                  <td align="left">SENHA:</td>
                  <td align="left"><label for="senha"></label>
                    <input name="senha" type="text" id="senha" size="50%" value="<%if(usuario != null) out.print(usuario.getSenha()); %>" /></td>
                </tr>
                </table></td>
            </tr>
            <tr>
              <td height="61" align="right"><input type="reset" name="Reset" id="button" value="Cancelar" />
                <input type="submit" name="button2" id="button2" value="Salva" /></td>
            </tr>
          </table>
          </form>
          <!-- InstanceEndEditable --></div>
 
    <div class="center pading" height="16">
      <h4>Todos os direitos reservados</h4>
    </div>
<div/>
<div/>
</body>
<!-- InstanceEnd --></html>
