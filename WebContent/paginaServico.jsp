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
Servico sv1 = dao.consulta("Revisão gramatical");
Servico sv2 = dao.consulta("Adequação às normas da ABNT");
Servico sv3 = dao.consulta("Textual-gramatical");
Servico sv4 = dao.consulta("Edição/formatação");

%>

 <body> 
 
 <div>
    <p><b><% out.println(sv1.getDescricao()); %></b></p>
 
  <p><% out.println(sv1.getCaracteristicas()); %></p>
 
  <p>Valor por pagina: <% out.println(sv1.getValorPg()); %></p>
  
   <p>Valor por Lauda: <% out.println(sv1.getValorLd()); %></p>
   
    <p>Valor por palavra: <% out.println(sv1.getValorPl()); %></p>
    <br />
    <br />
    </div>
    
     <div>
    <p><b><% out.println(sv2.getDescricao()); %></b></p>
 
  <p><% out.println(sv2.getCaracteristicas()); %></p>
 
  <p>Valor por pagina: <% out.println(sv2.getValorPg()); %></p>
  
   <p>Valor por Lauda: <% out.println(sv2.getValorLd()); %></p>
   
    <p>Valor por palavra: <% out.println(sv2.getValorPl()); %></p>
    
    <br />
    <br />
    
    </div>
    
     <div>
    <p><b><% out.println(sv3.getDescricao()); %></b></p>
 
  <p><% out.println(sv3.getCaracteristicas()); %></p>
 
  <p>Valor por pagina: <% out.println(sv3.getValorPg()); %></p>
  
   <p>Valor por Lauda: <% out.println(sv3.getValorLd()); %></p>
   
    <p>Valor por palavra: <% out.println(sv3.getValorPl()); %></p>
    
    <br />
    <br />
    
    </div>
    
     <div>
    <p><b><% out.println(sv4.getDescricao()); %></b></p>
 
  <p><% out.println(sv4.getCaracteristicas()); %></p>
 
  <p>Valor por pagina: <% out.println(sv4.getValorPg()); %></p>
  
   <p>Valor por Lauda: <% out.println(sv4.getValorLd()); %></p>
   
    <p>Valor por palavra: <% out.println(sv4.getValorPl()); %></p>
    
    <br />
    <br />
    


</body>
</html>