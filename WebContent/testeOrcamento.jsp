<%@page import="br.edu.ifg.proi.modelo.Servico"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

int paginas = Integer.parseInt(Npaginas); 
int palavras = Integer.parseInt(Npalavras); 
int caracteres = Integer.parseInt(Ncaracteres); 
int lauda = (caracteres/1250) + 1; 


float valorPaginas = 0;
float valorPalavra = 0;
float valorLauda = 0;

if(abnt != null){
	valorPaginas += paginas * 10;
	valorPalavra += palavras *1;
	valorLauda += lauda * 20;
}
if(gramatical != null){
	valorPaginas += paginas * 10;
	valorPalavra += palavras *1;
	valorLauda += lauda * 20;
}

if(formatacao != null){
	valorPaginas += paginas * 10;
	valorPalavra += palavras *1;
	valorLauda += lauda * 20;
}

if(textualGramatical != null){
	valorPaginas += paginas * 10;
	valorPalavra += palavras *1;
	valorLauda += lauda * 20;
}


//out.println(abnt);
//out.println(gramatical);
//out.println(formatacao);
//out.println(textualGramatical);
//out.println("Preco paginas: " + valorPaginas);
//out.println("Preco por Palavras: " +valorPalavra);
//out.println("Preco por Laudas: " +valorLauda);



%>
<button> <%out.println("Revisao por Pagina: R$ " + valorPaginas);%> </button>
<button> <%out.println("Revisao por Palavra: R$ " + valorPalavra);%> </button>
<button> <%out.println("Revisao por Lauda: R$ " + valorLauda);%> </button>

</body>
</html>