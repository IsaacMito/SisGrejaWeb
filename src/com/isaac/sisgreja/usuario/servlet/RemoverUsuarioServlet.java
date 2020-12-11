package com.isaac.sisgreja.usuario.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isaac.sisgreja.persist.PastoresDao;
import com.isaac.sisgreja.persist.UsuariosDao;

/**
 * Servlet implementation class RemoverUsuarioServlet
 */
@WebServlet("/usuario/RemoverUsuarioServlet")
public class RemoverUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			UsuariosDao dao;
			dao = new UsuariosDao();
			dao.remove(request.getParameter("login"));
			
			response.sendRedirect("lista.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
