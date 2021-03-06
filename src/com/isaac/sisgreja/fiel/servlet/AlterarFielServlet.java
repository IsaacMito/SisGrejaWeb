package com.isaac.sisgreja.fiel.servlet;

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

@WebServlet("/fiel/AlterarFielServlet")
public class AlterarFielServlet extends HttpServlet {

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

			dao.altera(fiel);

			response.sendRedirect("lista.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
