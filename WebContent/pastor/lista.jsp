<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ include file="../seguranca.jsp" %>

<%@page import="com.isaac.sisgreja.domain.Pastor"%>
<%@page import="com.isaac.sisgreja.persist.PastoresDao"%>
<%@page import="com.isaac.sisgreja.util.Funcoes"%>
<%@page import="java.util.List"%>
<%

	PastoresDao dao = new PastoresDao();
	List<Pastor> pastores = dao.getListar();
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
  
  <nobr class="nobr-vertical animate__animated animate__fadeIn animate__delay-1.5s"> <a href="lista.jsp">Pastor</a></nobr>
  
  <nobr class="nobr-vertical animate__animated animate__fadeIn animate__delay-1.5s"> <a href="../usuario/lista.jsp"> Usuario</a></nobr>
  
  <nobr class="animate__animated animate__fadeIn animate__delay-1.5s"> <a href="../index.jsp">Sair</a></nobr>
  
  <hr class="hr-horizontal">
  
  </div>
  
<div class="center pading"><!-- InstanceBeginEditable name="conteudo" --><table width="100%" border="0">
          <tr align="center">
            <td>Lista de Pastores</td>
          </tr>
          <tr>
            <td align="right"><a href="formulario.jsp?login=1">Novo</a></td>
          </tr>
          <tr>
            <td><table width="100%" border="1">
              <tr>
                <td width="10%">CPF</td>
                <td width="21%">Nome</td>
                <td width="22%">Data de Nascimento</td>
                <td width="17%">Salario</td>
                <td width="13%">Alterar</td>
                <td width="17%">Revomer</td>
              </tr>
              <% for(Pastor pastor : pastores) { %>
              <tr>
                <td><% out.print(pastor.getCpf());%></td>
                <td><% out.print(pastor.getNome());%></td>
                <td><% out.print(Funcoes.dateToString(pastor.getDataNacimento()));%></td>
                <td><% out.print(pastor.getSalario());%></td>
                <td align="center"><a href="formulario.jsp?login=1&cpf=<% out.print(pastor.getCpf());%>">alterar</a></td>
                <td align="center"><a href="RemoverPastorServlet?login=1&cpf=<% out.print(pastor.getCpf());%>">remover</a></td>
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
