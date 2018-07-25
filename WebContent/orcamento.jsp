<%@page import="br.edu.ifg.proi.modelo.Servico"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="br.edu.ifg.proi.dao.ServicoDAO"%> 
     <%@page import="br.edu.ifg.proi.modelo.Servico"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="cabecalho.jsp"%>
</head>
<body>

<% String abnt = request.getParameter("ABNT"); 
String gramatical = request.getParameter("gramatical"); 
String formatacao = request.getParameter("formatacao"); 
String textualGramatical = request.getParameter("textualGramatical"); 
String Npaginas = request.getParameter("paginas"); 
String Npalavras = request.getParameter("palavras"); 
String Ncaracteres = request.getParameter("caracteres"); 

ServicoDAO dao = new ServicoDAO();
Servico rg = dao.consulta("Revisão gramatical");
Servico rn = dao.consulta("Adequação às normas da ABNT");
Servico rtg = dao.consulta("Textual-gramatical");
Servico ref = dao.consulta("Edição/formatação");


int paginas = Integer.parseInt(Npaginas); 
int palavras = Integer.parseInt(Npalavras); 
int caracteres = Integer.parseInt(Ncaracteres); 
int lauda = (caracteres/1250) + 1; 


float valorPaginas = 0;
float valorPalavra = 0;
float valorLauda = 0;

if(abnt != null){
	valorPaginas += paginas * rn.getValorPg();
	valorPalavra += palavras * rn.getValorPl();
	valorLauda += lauda * rn.getValorLd();
}
if(gramatical != null){
	valorPaginas += paginas * rtg.getValorPg();
	valorPalavra += palavras * rtg.getValorPl();
	valorLauda += lauda * rtg.getValorLd();
}

if(formatacao != null){
	valorPaginas += paginas * ref.getValorPg();
	valorPalavra += palavras * ref.getValorPl();
	valorLauda += lauda * ref.getValorLd();
}

if(textualGramatical != null){
	valorPaginas += paginas * rtg.getValorPg();
	valorPalavra += palavras * rtg.getValorPl();
	valorLauda += lauda * rtg.getValorLd();
}



%>

<form action="GeraBoleto.jsp" method="post">
      <input type="hidden" name="valor" value="<%out.print(valorPaginas);%>" />
      <button> <%out.println("Revisao por Pagina: R$ " + valorPaginas);%> </button>
            
    </form>
    
    <form action="GeraBoleto.jsp" method="post">
      <input type="hidden" name="valor" value="<%out.print(valorPalavra);%>" />
      <button> <%out.println("Revisao por Palavra: R$ " + valorPalavra);%> </button>
            
    </form>
    
    <form action="GeraBoleto.jsp" method="post">
      <input type="hidden" name="valor" value="<%out.print(valorLauda);%>" />
      <button> <%out.println("Revisao por Lauda: R$ " + valorLauda);%> </button>
            
    </form>


</body>
</html>