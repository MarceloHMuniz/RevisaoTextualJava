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
 * Servlet implementation class AdicionaServico
 */
@WebServlet("/AdicionaServico")
public class AdicionaServico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionaServico() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String descricao = request.getParameter("descricao");
		String caracteristicas = request.getParameter("caracteristicas");
		String cobranca = request.getParameter("cobranca");
		String preco = request.getParameter("preco");
		
		float valor = Float.parseFloat(preco);
		
		
				

			try {
				ServicoDAO dao = new ServicoDAO();
				Servico novo = new Servico();
				novo.setCaracteristicas(caracteristicas);
				novo.setDescricao(descricao);
				novo.setFormasCobranca(cobranca);
				novo.setValor(valor);
				
				dao.create(novo);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				} 

	}