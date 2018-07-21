package br.edu.ifg.proi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifg.proi.Connection.ConnectionFactory;
import br.edu.ifg.proi.modelo.Cliente;

public class ClienteDAO {

	private Connection connection;

	public ClienteDAO() throws SQLException {
		this.connection = new ConnectionFactory().getConnection();
		
		//Cria a tabela no banco caso nao exista
		criarTabela();
	}
	
	public void criarTabela() throws SQLException{
		try {
			String sql = "CREATE TABLE IF NOT EXISTS cliente (" + "id BIGINT NOT NULL AUTO_INCREMENT,"
					+ "cpf VARCHAR(14)," + "nome VARCHAR(255)," + "contato VARCHAR(255)," + "email VARCHAR(255)," 
					+ "usuario VARCHAR(255)," + "senha VARCHAR(100),"	+ "primary key (id)" + ");";

			// Criando o statement
			Statement st = connection.createStatement();

			// Executando a consulta
			int i = st.executeUpdate(sql);
			if (i == -1) {
				throw new RuntimeException("db error : " + sql);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void create(Cliente cliente) {
		String sql = "insert into cliente " + "(cpf,nome,contato,email,usuario,senha)" + " values (?,?,?,?,?,?)";
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, cliente.getCpf());
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getContato());
			stmt.setString(4, cliente.getEmail());
			stmt.setString(5, cliente.getUsuario());
			stmt.setString(6, cliente.getSenha());

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Cliente cliente) {
		try {
			String sql = "UPDATE CLIENTE SET cpf = ?, nome = ?, contato = ?, email = ?, senha = ? WHERE cpf = ?;";

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, cliente.getCpf());
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getContato());
			stmt.setString(4, cliente.getEmail());
			//stmt.setString(5, cliente.getUsuario());
			stmt.setString(5, cliente.getSenha());
			stmt.setString(6, cliente.getCpf());

			stmt.execute();
			stmt.close();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void delete(Cliente cliente){
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from cliente where nome=?");
			stmt.setString(1, cliente.getNome());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Cliente autenticacao(Cliente cliente){
		Cliente retorno = null;
		String sql = "select * from cliente where usuario=? and senha=?";
		
		try {
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, cliente.getUsuario());
			pst.setString(2, cliente.getSenha());
			
			ResultSet resultado = pst.executeQuery();
			
			if(resultado.next()){
				
				retorno = new Cliente();
				retorno.setUsuario(resultado.getString("usuario"));
				retorno.setSenha(resultado.getString("senha"));
				retorno.setNome(resultado.getString("nome"));
				retorno.setContato(resultado.getString("contato"));
				retorno.setCpf(resultado.getString("cpf"));
				retorno.setEmail(resultado.getString("email"));
				

				
			}
		} catch (SQLException e) {
			System.out.println("Erro de SQL: " + e.getMessage());
		}
		return retorno;
		
		
		
		
	}
}