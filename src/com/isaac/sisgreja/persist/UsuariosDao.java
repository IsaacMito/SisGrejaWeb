package com.isaac.sisgreja.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.isaac.sisgreja.domain.Usuario;
import com.isaac.sisgreja.jdbc.ConnectionFactory;

public class UsuariosDao {

	private Connection con;

	public UsuariosDao() throws Exception {
		con = ConnectionFactory.getConnection();
	}

	public Usuario buscar(String login) throws SQLException {

		PreparedStatement stmt = con.prepareStatement("select * from usuario where login=?"); 
		stmt.setString(1, login);
		ResultSet rs = stmt.executeQuery();
		
		Usuario usuario = null;
		if ( rs.next()) {
			usuario = new Usuario();
			usuario.setLogin(rs.getString("login"));
			usuario.setSenha(rs.getString("senha"));
		}
		return usuario;
	}

	public void adiciona(Usuario usuario) throws SQLException {

		String sql = "insert into usuario " + "(senha,login)" + " values (?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);

		// prepared statement para inser��o

		// seta os valores
		stmt.setString(1, usuario.getSenha());
		stmt.setString(2, usuario.getLogin());

		// executa
		stmt.execute();
		stmt.close();
	}

	public List<Usuario> getListar() throws SQLException {

		List<Usuario> usuarios = new ArrayList<Usuario>();

		PreparedStatement stmt = con.prepareStatement("select * from usuario");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			Usuario usuario = new Usuario();

			usuario.setLogin(rs.getString("login"));
			usuario.setSenha(rs.getString("senha"));

			usuarios.add(usuario);
		}
		rs.close();
		stmt.close();
		return usuarios;

	}

	public void altera(Usuario usuario) {

		String sql = "update usuario set senha=? where login=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario.getSenha());
			stmt.setString(2, usuario.getLogin());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(String login) {

		try {
			PreparedStatement stmt = con.prepareStatement("delete from usuario where login=?");
			stmt.setString(1, login);

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
