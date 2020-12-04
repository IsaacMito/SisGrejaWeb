<%@page import="com.isaac.sisgreja.persist.FieisDao"%>
<%@page import="com.isaac.sisgreja.domain.Fiel"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<% 
	FieisDao dao = new FieisDao();
	List<Fiel> fieis = dao.getListar();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
</head>

<body>
<table width="779" border="1" align="center">
  <tr>
    <td align="center"><h1>SisGreja</h1></td>
  </tr>
  <tr>
    <td><table width="768" border="0">
      <tr align="center" valign="top">
        <td width="125"><table width="100%" border="1">
          <tr align="center">
            <td width="164"><a href="../bem-vindo.jsp">Home</a></td>
          </tr>
          <tr>
            <td align="center">Fiel</td>
          </tr>
          <tr>
            <td align="center">Pastor</td>
          </tr>
          <tr>
            <td align="center">Usuario</td>
          </tr>
          <tr>
            <td align="center">Sair</td>
          </tr>
        </table></td>
        <td width="617"><table width="100%" border="1">
          <tr align="center">
            <td>Lista de fieis</td>
          </tr>
          <tr>
            <td align="right"><a href="formulario.jsp">Novo</a></td>
          </tr>
          <tr>
            <td><table width="100%" border="1">
              <tr>
                <td width="10%">CPF</td>
                <td width="21%">Nome</td>
                <td width="22%">Data de Nascimento</td>
                <td width="17%">Dizimo</td>
                <td width="13%">Alterar</td>
                <td width="17%">Revomer</td>
              </tr>
              <% for(Fiel fiel : fieis) { %>
              <tr>
                <td><% out.print(fiel.getCpf());%></td>
                <td><% out.print(fiel.getNome());%></td>
                <td><% out.print(fiel.getDataNacimento());%></td>
                <td><% out.print(fiel.getDisimo());%></td>
                <td align="center"><a href="formulario.jsp">alterar</a></td>
                <td align="center"><a href="RemoverFielServlet?cpf=<% out.print(fiel.getCpf());%>">remover</a></td>
              </tr>
              <% } %>
            </table></td>
          </tr>
        </table>          <h2>&nbsp;</h2></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><h6>Todos os direitos reservados</h6></td>
  </tr>
</table>
</body>
</html>