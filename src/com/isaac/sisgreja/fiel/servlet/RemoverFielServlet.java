package com.isaac.sisgreja.fiel.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isaac.sisgreja.persist.FieisDao;

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
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

	}

}
