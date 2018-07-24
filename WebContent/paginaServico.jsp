<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="br.edu.ifg.proi.dao.ServicoDAO"%> 
     <%@page import="br.edu.ifg.proi.modelo.Servico"%> 
    

  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
ServicoDAO dao = new ServicoDAO();
Servico sv = dao.consulta("revisao gramatical");

out.println(sv);

%>

</body>
</html>