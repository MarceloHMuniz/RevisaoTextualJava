package br.edu.ifg.proi.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifg.proi.dao.ServicoDAO;
import br.edu.ifg.proi.modelo.Servico;

/**
 * Servlet implementation class AlteraServico
 */
@WebServlet("/AlteraServico")
public class AlteraServico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlteraServico() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String descricao = request.getParameter("descricao");
			String caracteristicas = request.getParameter("caracteristicas");
			String cobranca = request.getParameter("cobranca");
			String preco = request.getParameter("valorPg");
			String preco2 = request.getParameter("valorLd");
			String preco3 = request.getParameter("valorPl");
			
			float valorPg = Float.parseFloat(preco);
			float valorLd = Float.parseFloat(preco2);
			float valorPl = Float.parseFloat(preco3);
			
			
					

				try {
					ServicoDAO dao = new ServicoDAO();
					Servico novo = new Servico();
					novo.setCaracteristicas(caracteristicas);
					novo.setDescricao(descricao);
					novo.setFormasCobranca(cobranca);
					novo.setValorPg(valorPg);
					novo.setValorLd(valorLd);
					novo.setValorPl(valorPl);
					
					request.getRequestDispatcher("paginaServico.jsp").forward(request, response);
					
					dao.update(novo);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					request.getRequestDispatcher("erro.jsp");
				}
					} 

}
