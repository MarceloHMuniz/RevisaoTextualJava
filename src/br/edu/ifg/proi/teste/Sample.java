package br.edu.ifg.proi.teste;
 
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class Sample {

    public int contaPg(String txt){
        InputStream is = null;
        int paginas = 0;
        
       

        try {
            is = new BufferedInputStream(new FileInputStream(new File(txt)));

            Parser parser = new AutoDetectParser();
            ContentHandler handler = new BodyContentHandler();
                     
            Metadata metadata = new Metadata();

            parser.parse(is, handler, metadata, new ParseContext());
            
            for (String name : metadata.names()) {
                String value = metadata.get(name);

                if (name == "xmpTPg:NPages") {
                   //System.out.println("Metadata Value: " + value);
                   paginas = Integer.parseInt(value);
                	
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TikaException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return paginas;
    }
    
    
    public int contaPalavras(String txt) {
		int contadorDePalavras = 0;
		
		Scanner sc = new Scanner(txt);
		sc.useDelimiter("[,;:.!? ]");
		while (sc.hasNext()) {
			String proximaPalavra = sc.next();
			if (proximaPalavra.length() > 0) contadorDePalavras++;
			// System.out.println("[" + proximaPalavra + "]");
		}
		return contadorDePalavras;
	}
}