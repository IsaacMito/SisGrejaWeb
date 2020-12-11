package com.isaac.sisgreja.pastor.servlet;

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
import com.isaac.sisgreja.persist.FieisDao;
import com.isaac.sisgreja.persist.PastoresDao;
import com.isaac.sisgreja.util.Funcoes;

@WebServlet("/pastor/AlterarPastorServlet")
public class AlterarPastorServlet extends HttpServlet {

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

			dao.altera(pastor);

			response.sendRedirect("lista.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
