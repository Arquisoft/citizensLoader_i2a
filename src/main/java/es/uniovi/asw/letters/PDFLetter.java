package es.uniovi.asw.letters;

import java.io.FileNotFoundException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import es.uniovi.asw.Citizen;

public class PDFLetter implements Writtable{

	@Override
	public void write(Citizen c) throws FileNotFoundException {
		//Initialize PDF writer
        PdfWriter writer = new PdfWriter("files/Welcome"+c.getFirstName()+c.getLastName()+".docx");
 
        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);
 
        // Initialize document
        Document document = new Document(pdf);
 
        //Add paragraph to the document
        document.add(new Paragraph("Gracias por registrarse! Su user es: "+ c.getEmail()+ " y su contraseña: "+c.getPassword()));
 
        //Close document
        document.close();
	}

	

}
