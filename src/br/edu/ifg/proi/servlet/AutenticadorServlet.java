package br.edu.ifg.proi.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifg.proi.dao.ClienteDAO;
import br.edu.ifg.proi.modelo.Cliente;

/**
 * Servlet implementation class AutenticadorServlet
 */
@WebServlet("/AutenticadorServlet")
public class AutenticadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutenticadorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession sessao = request.getSession(false);
		//if(sessao!=null){
			//sessao.invalidate();
			
		//}
		//response.sendRedirect("login.html");
	
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		
		Cliente cliente = new Cliente();
		
		cliente.setUsuario(login);
		cliente.setSenha(senha);
		
		ClienteDAO dao;
		try {
			dao = new ClienteDAO();
			Cliente usuarioAutenticado = dao.autenticacao(cliente);
			
			if(usuarioAutenticado != null){
				
				HttpSession session = request.getSession();
				session.setAttribute("usuarioAutenticado", usuarioAutenticado);
				
				//System.out.println(session);
				
				
				request.getRequestDispatcher("menu_cliente.jsp").forward(request, response);
			}else{
					
		           RequestDispatcher rs = request.getRequestDispatcher("erro.html");
		           rs.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}