package br.edu.ifg.proi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifg.proi.dao.ClienteDAO;
import br.edu.ifg.proi.modelo.Cliente;

/**
 * Servlet implementation class TestaSessao
 */
@WebServlet("/TestaSessao")
public class TestaSessao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestaSessao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		HttpSession session = request.getSession(true);
		
		
		
		//System.out.println(retornoLista.toString());
		
		//Usuario temporario = (Usuario)
		Cliente temporario = (Cliente)session.getAttribute("usuarioAutenticado");
		
		//System.out.println(temporario);
		
		
		
		PrintWriter out = response.getWriter();
		
		
	
		out.println("<html>");
		
		out.println("<head>");
		out.println("<title>Selecione a opção</title>");
		out.println("</head>");
		
		
		
		
		out.println("<body>");
		
		out.println("<h1>");		
		out.println("Seja Bem Vindo");
		out.println("<th>"+temporario.getUsuario()+"</th>");
		out.println("</h1>");
		
		out.println("<h1>");		
		out.println("Nome");
		out.println("<th>"+temporario.getNome()+"</th>");
		out.println("</h1>");
		
		out.println("<h1>");		
		out.println("CPF");
		out.println("<th>"+temporario.getCpf()+"</th>");
		out.println("</h1>");
		
			
	
		
		out.println("</body>");
		out.println("</html>");
		
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
