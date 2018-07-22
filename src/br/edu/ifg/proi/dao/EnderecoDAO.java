package br.edu.ifg.proi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ifg.proi.Connection.ConnectionFactory;
import br.edu.ifg.proi.modelo.Endereco;


public class EnderecoDAO  {
	
	private Connection connection;

	public EnderecoDAO() throws SQLException {
      
this.connection = new ConnectionFactory().getConnection();
		
		//Cria a tabela no banco caso nao exista
		criarTabela();
	}

	public void criarTabela() {
		try {
			String expression = "CREATE TABLE IF NOT EXISTS endereco (" + "id MEDIUMINT NOT NULL AUTO_INCREMENT,"
					+ "logradouro VARCHAR(255)," + "cep VARCHAR(8)," + "cidade VARCHAR(100)," + "bairro VARCHAR(100),"
					+ "uf CHAR(2)," +  "primary key (id)" + ");";

			// Criando o statement
			Statement st = connection.createStatement();

			// Executando a consulta
			int i = st.executeUpdate(expression);
			if (i == -1) {
				throw new RuntimeException("db error : " + expression);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public int create(Endereco endereco) {
		String sql = "insert into endereco " + "(logradouro,cep,cidade,bairro,uf)"
				+ " values (?,?,?,?,?)";
		int last_inserted_id = 0;
		try {
			// prepared statement
			PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			// seta os valores
			
			stmt.setString(1, endereco.getLogradouro());
			stmt.setString(2, endereco.getCEP());
			stmt.setString(3, endereco.getCidade());
			stmt.setString(4, endereco.getBairro());
			stmt.setString(5, endereco.getUF());
			

			// executa
			stmt.executeUpdate();
			// Logica para obter o id 
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				last_inserted_id = rs.getInt(1);
			}
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return last_inserted_id;
	}

	public void delete(Long idEndereco) {

		try {
			String sql = "DELETE FROM endereco WHERE ID = ?;";

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, idEndereco);

			stmt.execute();
			stmt.close();

		} catch (Exception e) {
			System.out.println("Erro sql" + e.getMessage());
		}

	}

	public void alterarEndereco(Endereco endereco, Long idEndereco) {
		//int last_inserted_id = 0;
		try {
			String sql = "UPDATE ENDERECO SET logradouro = ?, cep = ?, cidade = ?,"
					+ "bairro = ?, uf = ? WHERE id = ? ;";

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, endereco.getLogradouro());
			stmt.setString(2, endereco.getCEP());
			stmt.setString(3, endereco.getCidade());
			stmt.setString(4, endereco.getBairro());
			stmt.setString(5, endereco.getUF());
			
			stmt.setLong(6, idEndereco);

			stmt.execute();
		
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		

	}

	public Endereco buscaEndereco(Long id) {
		Endereco end = new Endereco();
		try {
			String sql = "SELECT * FROM ENDERECO WHERE ID = ?;";

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				end.setId(rs.getLong("id"));
				end.setLogradouro(rs.getString("logadouro"));
				end.setCEP(rs.getString("cep"));
				end.setCidade(rs.getString("cidade"));
				end.setBairro(rs.getString("bairro"));
				end.setUF(rs.getString("uf"));

			}
			stmt.execute();
			stmt.close();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return end;
	}

}
