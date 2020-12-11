<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@page import="com.isaac.sisgreja.domain.Usuario"%>
<%
	Usuario u = (Usuario) session.getAttribute("usuario");

	if( u == null ) {
		response.sendRedirect("index.jsp");
	}
%>