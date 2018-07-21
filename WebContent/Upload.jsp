<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<%@ page import="org.apache.commons.io.output.*" %>
<%@ page import="br.edu.ifg.proi.teste.PDFManager" %>
<%@ page import="br.edu.ifg.proi.teste.Sample" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="cabecalho.jsp"%>
</head>
<body>
<%
/**
 * Classe utilizada para fazer upload de arquivos.
 *
 */

 //Limitando o Tamanho do arquivo
   File file ;
   int maxFileSize = 5000 * 1024;
   int maxMemSize = 5000 * 1024;
   String filePath = "D:\\";
   
   int paginas = 0;
   int palavras = 0;
   String Texto = null;
 
   String contentType = request.getContentType();
   if ((contentType.indexOf("multipart/form-data") >= 0)) {
 
      DiskFileItemFactory factory = new DiskFileItemFactory();
      factory.setSizeThreshold(maxMemSize);
      factory.setRepository(new File("c:\\temp"));
      ServletFileUpload upload = new ServletFileUpload(factory);
      upload.setSizeMax( maxFileSize );
      try{ 
         List fileItems = upload.parseRequest(request);
         Iterator i = fileItems.iterator();
         out.println("<html>");
         out.println("<body>");
         while ( i.hasNext () ) 
         {
            FileItem fi = (FileItem)i.next();
            if ( !fi.isFormField () )  {
                String fieldName = fi.getFieldName();
                String fileName = fi.getName();
                boolean isInMemory = fi.isInMemory();
                long sizeInBytes = fi.getSize();
                file = new File( filePath + fileName) ;
                fi.write( file ) ;
               
                PDFManager pdfManager = new PDFManager();
                pdfManager.setFilePath(filePath + fileName);
                   
                Texto = pdfManager.ToText();
                
                Sample sp = new Sample();
                paginas = sp.contaPg(filePath + fileName);
                
                palavras = sp.contaPalavras(Texto);
                
                
            }
         }
         out.println("</body>");
         out.println("</html>");
      }catch(Exception ex) {
         System.out.println(ex);
      }
   }
   
  %>
  
  <ul>
  <li><%out.println(" numero de paginas: " + paginas);%></li>
  <li><%out.println("numero de caracteres: " + Texto.length());%></li>
  <li><%out.println("numero de caracteres: "+ palavras);%></li>
            
</ul>

<form method="post" action="testeOrcamento.jsp">
<fieldset>
  <legend>Escolha os tipos de Revisao</legend>
   <div>
    <input type="checkbox" id="ABNT" name="ABNT" value="y">
    <label for="ABNT">Adequação às normas da ABNT</label>
  </div>
   
  <div>
    <input type="checkbox" id="gramatical" name="gramatical" value="y">
    <label for="gramatical">Revisão gramatical</label>
  </div>
   <div>
    <input type="checkbox" id="formatacao" name="formatacao" value="y">
    <label for="formatacao">Edição/formatação</label>
  </div>
   <div>
    <input type="checkbox" id="textualGramatical:" name="textualGramatical" value="y">
    <label for="textualGramatical">Revisão Textual-gramatical</label>
  </div>
  
   <input type="hidden" name="paginas" value="<%out.print(paginas);%>" />
    <input type="hidden" name="caracteres" value="<%out.print(Texto.length());%>" />
     <input type="hidden" name="palavras" value="<%out.print(palavras);%>" />
</fieldset>
<input type="submit" value="Ver Orcamento" />
</form>
  


</body>
</html>