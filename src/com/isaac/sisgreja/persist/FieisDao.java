package com.isaac.sisgreja.persist;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.isaac.sisgreja.domain.Fiel;
import com.isaac.sisgreja.jdbc.ConnectionFactory;


public class FieisDao {

	private Connection con = null;

	public FieisDao() throws Exception {
		con = ConnectionFactory.getConnection();
	}

	public Fiel buscar(String cpf) throws SQLException {
		
		PreparedStatement stmt = con.prepareStatement("select * from fiel where cpf=?");
		stmt.setString(1, cpf);
		ResultSet rs = stmt.executeQuery();
		
		Fiel fiel = null;
		if ( rs.next() ) {
			fiel = new Fiel();	
			fiel.setCpf(rs.getInt("cpf"));
			fiel.setNome(rs.getString("nome"));
			fiel.setDataNacimento(rs.getDate("data"));
			fiel.setDisimo(rs.getDouble("dizimo"));
		}
		
		return fiel;
	}
	
	public void adiciona(Fiel fiel) throws SQLException {
		
		String sql = "insert into fiel " + "(cpf,nome,data, dizimo)" + " values (?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);

		stmt.setInt(1, fiel.getCpf());

		stmt.setString(2, fiel.getNome());

		stmt.setDate(3, new Date(fiel.getDataNacimento().getTime()));

		stmt.setDouble(4, fiel.getDisimo());

		stmt.execute();
		stmt.close();

	}

	public List<Fiel> getListar() throws SQLException {

		List<Fiel> fieis = new ArrayList<Fiel>();

		PreparedStatement stmt = con.prepareStatement("select * from fiel");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			Fiel fiel = new Fiel();

			fiel.setCpf(rs.getInt("cpf"));
			fiel.setNome(rs.getString("nome"));
			fiel.setDataNacimento(rs.getDate("data"));
			fiel.setDisimo(rs.getDouble("dizimo"));

			fieis.add(fiel);
		}
		rs.close();
		stmt.close();
		return fieis;

	}

	public void altera(Fiel fiel) {

		String sql = "update fiel set nome=?, data=?," + "dizimo=? where cpf=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(4, fiel.getCpf());

			stmt.setString(1, fiel.getNome());
			stmt.setDate(2, new Date(fiel.getDataNacimento().getTime()));
			stmt.setDouble(3, fiel.getDisimo());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(int cpf) {

		try {
			PreparedStatement stmt = con.prepareStatement("delete from fiel where cpf=?");
			stmt.setInt(1, cpf);

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean verificaFiel(Fiel fielParaVerificar) throws SQLException {
		
		List<Fiel> fieis = new ArrayList<Fiel>();

		PreparedStatement stmt = con.prepareStatement("select * from fiel");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			Fiel fiel = new Fiel();

			fiel.setCpf(rs.getInt("cpf"));
			fiel.setNome(rs.getString("nome"));
			fiel.setDataNacimento(rs.getDate("data"));
			fiel.setDisimo(rs.getDouble("dizimo"));

			fieis.add(fiel);
		}
		
		if(fieis.contains(fielParaVerificar)) {
			return true;
		} else {
			return false;
		}
	}

}
