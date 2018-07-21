package br.edu.ifg.proi.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifg.proi.dao.ClienteDAO;
import br.edu.ifg.proi.modelo.Cliente;



/**
 * Servlet implementation class UsuarioCadastro
 */
@WebServlet("/UsuarioCadastro")
public class UsuarioCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioCadastro() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		String sconf = request.getParameter("confirma_senha");
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String contato = request.getParameter("contato");
		String email = request.getParameter("email");
		
		
		
		if (senha.equals(sconf)) {
			Cliente novo = new Cliente();
			novo.setNome(nome);
			novo.setCpf(cpf);
			novo.setSenha(senha);
			novo.setUsuario(usuario);
			novo.setContato(contato);
			novo.setEmail(email);
			

			try {
				ClienteDAO dao = new ClienteDAO();
				dao.create(novo);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.getRequestDispatcher("login.html").forward(request, response);

		} else {
			System.out.println("Senhas não conferem");
			request.getRequestDispatcher("PaginaCadastro.html").forward(request, response);
		}

	}

}
