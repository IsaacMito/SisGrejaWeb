package com.isaac.sisgreja.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.isaac.sisgreja.domain.Fiel;
import com.isaac.sisgreja.persist.FieisDao;
import com.isaac.sisgreja.util.Funcoes;

/**
 * Servlet implementation class CadastraFielServlet
 */
@WebServlet("/fiel/CadastraFielServlet")
public class CadastraFielServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			Fiel fiel = new Fiel();
			FieisDao dao = new FieisDao();

			fiel.setCpf(Integer.parseInt(request.getParameter("cpf")));
			fiel.setNome(request.getParameter("nome"));
			fiel.setDataNacimento(Funcoes.stringToDate(request.getParameter("data")));
			fiel.setDisimo(Double.parseDouble(request.getParameter("dizimo")));
			
			dao.adiciona(fiel);
			
			response.sendRedirect("lista.jsp");
			
		} catch (java.sql.SQLIntegrityConstraintViolationException p4) {
			response.sendRedirect("formulario.jsp?m=1");	
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
