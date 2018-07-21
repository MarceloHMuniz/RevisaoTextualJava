package br.edu.ifg.proi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ifg.proi.Connection.ConnectionFactory;
import br.edu.ifg.proi.modelo.Servico;

public class ServicoDAO {
	
	private Connection connection;

	public ServicoDAO() throws SQLException {
		this.connection = new ConnectionFactory().getConnection();
		
		//Cria a tabela no banco caso nao exista
		criarTabela();
	}
	
	public void criarTabela() throws SQLException{
		try {
			String sql = "CREATE TABLE IF NOT EXISTS servico (" + "id BIGINT NOT NULL AUTO_INCREMENT,"
					+ "descricao TEXT," + "caracteristicas TEXT," + "formasCobranca VARCHAR(255)," + "valor DECIMAL," 
					+ "primary key (id)" + ");";

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
	
	public void create(Servico servico) {
		String sql = "insert into servico " + "(descricao,caracteristicas,formasCobranca,valor)" + " values (?,?,?,?)";
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, servico.getDescricao());
			stmt.setString(2, servico.getCaracteristicas());
			stmt.setString(3, servico.getFormasCobranca());
			stmt.setFloat(4, servico.getValor());
			

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Servico servico) {
		try {
			String sql = "UPDATE servico SET descricao = ?, caracteristicas = ?, formasCobranca = ?, valor = ? WHERE descricao = ?;";

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, servico.getDescricao());
			stmt.setString(2, servico.getCaracteristicas());
			stmt.setString(3, servico.getFormasCobranca());
			stmt.setFloat(4, servico.getValor());
			stmt.setString(5, servico.getDescricao());

			stmt.execute();
			stmt.close();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void delete(Servico servico){
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from servico where descricao=?");
			stmt.setString(1, servico.getDescricao());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
