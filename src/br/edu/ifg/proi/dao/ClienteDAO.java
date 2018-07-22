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
import br.edu.ifg.proi.modelo.Endereco;

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
					+ "usuario VARCHAR(255)," + "senha VARCHAR(100),"+ "endereco MEDIUMINT(9)," + "primary key (id)," 
					+ " CONSTRAINT `endereco_fk` FOREIGN KEY (`endereco`) REFERENCES `endereco` (`id`)" + ");";

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
	
	public void create(Cliente cliente, int idEndereco) {
		String sql = "insert into cliente " + "(cpf,nome,contato,email,endereco,usuario,senha)" + " values (?,?,?,?,?,?,?)";
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, cliente.getCpf());
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getContato());
			stmt.setString(4, cliente.getEmail());
			stmt.setInt(5, idEndereco);
			stmt.setString(6, cliente.getUsuario());
			stmt.setString(7, cliente.getSenha());

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Cliente cliente) {
		try {
			String sql = "UPDATE CLIENTE SET cpf = ?, nome = ?, contato = ?, email = ?, endereco= ?, senha = ? WHERE cpf = ?;";

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, cliente.getCpf());
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getContato());
			stmt.setString(4, cliente.getEmail());
			stmt.setString(5, cliente.getEndereco().toString());
			//stmt.setString(6, cliente.getUsuario());
			stmt.setString(6, cliente.getSenha());
			
			stmt.setString(7, cliente.getCpf());

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
		Long idEndereco = 1L;
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
				idEndereco = Long.parseLong(resultado.getString("endereco"));
				
			}
			String sql2 = "select * from endereco where id=?";
			PreparedStatement stm = connection.prepareStatement(sql2);
			stm.setLong(1, idEndereco);
			ResultSet result = stm.executeQuery();
			
			if(result.next()){
				
				
				Endereco end = new Endereco();
				end.setBairro(result.getString("bairro"));
				end.setCEP(result.getString("cep"));
				end.setCidade(result.getString("cidade"));
				end.setUF(result.getString("uf"));
				end.setLogradouro(result.getString("logradouro"));
				
				
				//System.out.println(cliente.getEndereco());
				
				retorno.setEndereco(end);
				

				
			}
		} catch (SQLException e) {
			System.out.println("Erro de SQL: " + e.getMessage());
		}
		return retorno;
		
		
		
		
	}
}