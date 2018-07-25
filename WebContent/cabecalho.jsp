<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="br.edu.ifg.proi.modelo.Cliente"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
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

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 16px;
    text-decoration: none;
}

li a:hover {
    background-color: #111111;
}
</style>
        
    </head>
    
    
    <body>
 
<ul>
  <li><a href="#home">Apresentação</a></li>
  <li><a href="#news">Serviços</a></li>
  <li><a href="#contact">Central do cliente</a></li>
  <li><a href="#about">Contato</a></li>
  <li><a href="telaUpload.jsp">Fazer orcamento</a></li>
  <li><a href="#usuario"><%         
            Cliente temporario = (Cliente)session.getAttribute("usuarioAutenticado");
            //String nome = temporario.getUsuario();
            out.println("Seja Bem Vindo " + temporario.getUsuario());
            
            
            %></a></li>
</ul>

   <a href="sair.jsp">Sair</a>
    
 
              
        
        
     
    </body>
</html>