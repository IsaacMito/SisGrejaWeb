package com.isaac.sisgreja.usuario.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isaac.sisgreja.domain.Pastor;
import com.isaac.sisgreja.domain.Usuario;
import com.isaac.sisgreja.persist.PastoresDao;
import com.isaac.sisgreja.persist.UsuariosDao;
import com.isaac.sisgreja.util.Funcoes;

/**
 * Servlet implementation class CadastrarUsuarioServlet
 */
@WebServlet("/usuario/CadastrarUsuarioServlet")
public class CadastrarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			Usuario usuario = new Usuario();
			UsuariosDao dao = new UsuariosDao();

			usuario.setLogin(request.getParameter("login"));
			usuario.setSenha(request.getParameter("senha"));

			dao.adiciona(usuario);

			response.sendRedirect("lista.jsp");

		} catch (java.sql.SQLIntegrityConstraintViolationException p4) {
			response.sendRedirect("formulario.jsp");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new ServletException(e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new ServletException(e);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

	}

}
