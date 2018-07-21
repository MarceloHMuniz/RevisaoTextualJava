package br.edu.ifg.proi.teste;
import java.io.IOException;

public class JavaPDFTest {

    public static void main(String[] args) throws IOException {

       PDFManager pdfManager = new PDFManager();
       pdfManager.setFilePath("D:\\SISD_notas01_TrabalhoExtra.pdf");
       System.out.println(pdfManager.ToText());       
       String Texto = pdfManager.ToText();
       System.out.println(Texto.length());
}    
}