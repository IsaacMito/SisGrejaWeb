package com.isaac.sisgreja.usuario.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isaac.sisgreja.domain.Fiel;
import com.isaac.sisgreja.domain.Pastor;
import com.isaac.sisgreja.domain.Usuario;
import com.isaac.sisgreja.persist.FieisDao;
import com.isaac.sisgreja.persist.PastoresDao;
import com.isaac.sisgreja.persist.UsuariosDao;
import com.isaac.sisgreja.util.Funcoes;

@WebServlet("/usuario/AlterarUsuarioServlet")
public class AlterarUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Usuario usuario = new Usuario();
			UsuariosDao dao = new UsuariosDao();

			usuario.setLogin(request.getParameter("login"));
			usuario.setSenha(request.getParameter("senha"));
			
			dao.altera(usuario);

			response.sendRedirect("lista.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
