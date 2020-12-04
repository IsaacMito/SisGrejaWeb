package com.isaac.sisgreja.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isaac.sisgreja.domain.Fiel;
import com.isaac.sisgreja.persist.FieisDao;
import com.isaac.sisgreja.util.Funcoes;

/**
 * Servlet implementation class RemoverFielServlet
 */
@WebServlet("/fiel/RemoverFielServlet")
public class RemoverFielServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			FieisDao dao = new FieisDao();

			dao.remove(Integer.parseInt(request.getParameter("cpf")));

			response.sendRedirect("lista.jsp");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new ServletException(e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

	}

}
