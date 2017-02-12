package es.uniovi.asw.letters;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.*;

import es.uniovi.asw.Citizen;

public class WordLetter implements Writtable{
	

	public void write(Citizen c) throws IOException {
	    XWPFDocument document = new XWPFDocument();
        //Write the Document in file system
	    FileOutputStream out = new FileOutputStream(
	    		new File("generatedFiles/Welcome"+c.getDni()+".pdf"));

        //create Paragraph
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("Gracias por registrarse! Su user es: "
        + c.getEmail()+ " y su contraseña: "
        		+c.getPassword() );
        document.write(out);
       
        //Close document
        out.close();
        document.close();
    }

	
}
