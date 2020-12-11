package com.isaac.sisgreja.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static Connection conn = null;

	public static Connection getConnection() throws Exception {

		if (conn == null) {
			System.out.println("Carregando classe");
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			System.out.print("Conectando com o BD");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/sisgreja.web?useTimezone=true&serverTimezone=UTC", "root", "123456");
			System.out.println(" ok");
		}

		return conn;
	}
}
