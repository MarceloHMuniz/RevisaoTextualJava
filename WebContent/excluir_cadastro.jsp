<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="br.edu.ifg.proi.modelo.Cliente"%> 
      <%@page import="br.edu.ifg.proi.dao.ClienteDAO"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="cabecalho.jsp"%>
</head>
<body>
<%
Cliente c = (Cliente)session.getAttribute("usuarioAutenticado");
ClienteDAO dao = new ClienteDAO();
dao.delete(c);
%>
Cadastro excluido!!!

<td><a HREF="login.html">Voltar</a></td>

</body>
</html>