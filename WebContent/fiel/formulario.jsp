<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

<%
	String mensagem = null;
	String codMensagem = request.getParameter("m");

	if ("1".equals(codMensagem))
		mensagem = "Conta já registrada";
	else if ("2".equals(codMensagem))
		mensagem = "Erro";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
</head>

<body>
<table width="768" border="1" align="center">
  <tr>
    <td align="center"><h1>SisGreja</h1></td>
  </tr>
  <tr>
    <td><table width="768" border="0">
      <tr align="center" valign="top">
        <td width="125" height="229"><table width="100%" border="1">
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
        <td width="617"><form id="form1" name="form1" method="post" action="CadastraFielServlet">
          <table width="100%" border="1">
            <tr>
              <td>Cadastro de Fiel</td>
            </tr>
            <tr>
              <td><table width="100%" border="0">
                <tr>
                  <td width="29%">CPF:</td>
                  <td width="71%"><label for="cpf"></label>
                    <input name="cpf" type="text" id="cpf" size="20%" /></td>
                </tr>
                <tr>
                  <td>NOME:</td>
                  <td><label for="nome"></label>
                    <input name="nome" type="text" id="nome" size="50%" /></td>
                </tr>
                <tr>
                  <td>DATA NASCIMENTO:</td>
                  <td><label for="data"></label>
                    <input name="data" type="text" id="data" size="20%" /></td>
                </tr>
                <tr>
                  <td>DÍZIMO</td>
                  <td><label for="dizimo"></label>
                    <input name="dizimo" type="text" id="dizimo" size="20%" /></td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td height="61" align="right"><input type="reset" name="Reset" id="button" value="Cancelar" />
                <input type="submit" name="button2" id="button2" value="Salva" /></td>
            </tr>
          </table>
        </form></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><h6>Todos os direitos reservados</h6></td>
  </tr>
</table>
</body>
</html>