package com.isaac.sisgreja.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isaac.sisgreja.domain.Usuario;
import com.isaac.sisgreja.persist.UsuariosDao;

@WebServlet("/LoginServletUsuario")
public class LoginServletUsuario extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");

			UsuariosDao usuariosDao = new UsuariosDao();

			Usuario usuario = usuariosDao.buscar(login);

			if ( usuario != null && usuario.getSenha().equals(senha) ) {
				response.sendRedirect("bem-vindo.jsp");
			} else {
				response.sendRedirect("index.jsp?mensagam=1");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("index.jsp?mensagam=2");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("index.jsp?mensagam=2");
		}
	}
}
