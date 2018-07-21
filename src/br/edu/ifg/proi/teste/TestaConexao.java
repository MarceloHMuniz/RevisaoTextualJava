package br.edu.ifg.proi.teste;


import java.sql.Connection;
import java.sql.SQLException;

import br.edu.ifg.proi.Connection.ConnectionFactory;


public class TestaConexao {

	public static void main(String[] args) {
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conexao aberta!");
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}