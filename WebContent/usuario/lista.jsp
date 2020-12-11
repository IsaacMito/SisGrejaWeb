<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ include file="../seguranca.jsp" %>

<%@page import="com.isaac.sisgreja.domain.Usuario"%>
<%@page import="com.isaac.sisgreja.persist.UsuariosDao"%>
<%@page import="com.isaac.sisgreja.util.Funcoes"%>
<%@page import="java.util.List"%>
<% 
	UsuariosDao dao = new UsuariosDao();
	List<Usuario> usuarios = dao.getListar();
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
  
<div class="center pading"><!-- InstanceBeginEditable name="conteudo" --><table width="100%" border="0">
          <tr align="center">
            <td>Lista de Usuarios</td>
          </tr>
          <tr>
            <td align="right"><a href="formulario.jsp?l=1">Novo</a></td>
          </tr>
          <tr>
            <td><table width="100%" border="1">
              <tr>
                <td width="26%">Login</td>
                <td width="33%">senha</td>
                <td width="21%">Alterar</td>
                <td width="20%">Remover</td>
                </tr>
              <% for(Usuario usuario : usuarios) { %>
              <tr>
                <td><% out.print(usuario.getLogin());%></td>
                <td><% out.print(usuario.getSenha());%></td>
                <td align="center"><a href="formulario.jsp?l=1&login=<% out.print(usuario.getLogin());%>">alterar</a></td>
                <td align="center"><a href="RemoverUsuarioServlet?l=1&login=<% out.print(usuario.getLogin());%>">remover</a></td>
                </tr>
                
              <% } %>
            </table></td>
          </tr>
</table><!-- InstanceEndEditable --></div>
 
    <div class="center pading" height="16">
      <h4>Todos os direitos reservados</h4>
    </div>
<div/>
<div/>
</body>
<!-- InstanceEnd --></html>
