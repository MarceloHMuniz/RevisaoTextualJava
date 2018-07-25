<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="br.edu.ifg.proi.modelo.Cliente"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="cabecalho.jsp"%>
    <style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333333;
}

li {
    float: left;
}

li  {
    display: block;
    color: white;
    text-align: center;
    padding: 16px;
    text-decoration: none;
}

li :hover {
    background-color: #111111;
}
</style>
</head>
<body>

<%
Cliente c = (Cliente)session.getAttribute("usuarioAutenticado");
%>

 

	<center><p>Perfil do Cliente</p></center>
	
	<ul>
  <li>Nome: <%
String nome = request.getParameter("nome");
 if(nome!=null){
	  c.setNome(nome);  
  }
out.println(c.getNome());
%></li>
<li>CPF: <%
String cpf = request.getParameter("cpf");
if(cpf!=null){
	  c.setCpf(cpf);  
 }
out.println(c.getCpf());
%></li>
<li>Contato: <%
String contato = request.getParameter("contato");
if(contato!=null){
	  c.setContato(contato);  
 }
out.println(c.getContato());
%></li>
<li>Email: <%
String email = request.getParameter("email");
if(email!=null){
	  c.setEmail(email);  
 }
out.println(c.getEmail());
%></li>

</ul>

		

<td><a HREF="altera_cliente.jsp">Alterar Cadastro</a></td>

<td><a HREF="excluir_cadastro.jsp">Excluir Cadastro</a></td>
			

<INPUT  TYPE="button" VALUE ="Voltar" onClick="history.go(-1)"/>

<a href="C:/Users/Desktop Marcelo/workspaceRevisaoTextual/RevisaoTextualJavaWeb/WebContent/">link</a>


<%@ include file="rodape.jsp"%>
</body>
</html>