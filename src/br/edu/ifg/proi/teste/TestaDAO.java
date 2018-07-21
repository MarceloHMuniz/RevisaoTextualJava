package br.edu.ifg.proi.teste;

import java.sql.SQLException;

import br.edu.ifg.proi.dao.ClienteDAO;
import br.edu.ifg.proi.modelo.Cliente;


public class TestaDAO {

	public static void main(String[] args) throws SQLException {
		ClienteDAO dao = new ClienteDAO();
		
		//criando o Cliente
		Cliente cliente = new Cliente();
		cliente.setCpf("70257613030");
		cliente.setNome("Candelario");
		cliente.setContato("6232109898");
		cliente.setEmail("candi@email.com");
		cliente.setUsuario("gssilva");
		cliente.setSenha("1234");
		
		//dao.create(cliente);

		//System.out.println(cliente.getNome() + " inserido(a) com sucesso!");
		
		//Alterando o Cliente
		/*cliente.setCpf("99372073040");
		cliente.setNome("Candelario");
		cliente.setContato("6232109898");
		cliente.setEmail("guilhermina@email.com");
		cliente.setUsuario("gssilva");
		cliente.setSenha("1234");
		//cliente.setId(3L);*/
		
		//dao.update(cliente);
		
		
		dao.delete(cliente);
		
		
		//System.out.println(cliente.getNome() + " alterado(a) com sucesso!");
		
	}

}