package com.isaac.sisgreja.pastor.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isaac.sisgreja.domain.Pastor;
import com.isaac.sisgreja.persist.FieisDao;
import com.isaac.sisgreja.persist.PastoresDao;
import com.isaac.sisgreja.util.Funcoes;

@WebServlet("/pastor/CadastrarPastorServlet")
public class CadastrarPastorServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			Pastor pastor = new Pastor();
			PastoresDao dao = new PastoresDao();

			pastor.setCpf(Integer.parseInt(request.getParameter("cpf")));
			pastor.setNome(request.getParameter("nome"));
			pastor.setDataNacimento(Funcoes.stringToDate(request.getParameter("data")));
			pastor.setSalario(Double.parseDouble(request.getParameter("salario")));

			dao.adiciona(pastor);

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
