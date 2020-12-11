package com.isaac.sisgreja.pastor.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isaac.sisgreja.persist.FieisDao;
import com.isaac.sisgreja.persist.PastoresDao;

@WebServlet("/pastor/RemoverPastorServlet")
public class RemoverPastorServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			PastoresDao dao = new PastoresDao();
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
