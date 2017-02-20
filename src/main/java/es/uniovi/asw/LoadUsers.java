package es.uniovi.asw;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import es.uniovi.asw.letters.PDFLetter;
import es.uniovi.asw.letters.TxtLetter;
import es.uniovi.asw.letters.WordLetter;
import es.uniovi.asw.letters.Writtable;
import es.uniovi.asw.parser.Parser;
import es.uniovi.asw.parser.XlsxParser;

/**
 * Main application
 * 
 * @author Claudia, Sara, Carla
 *
 */
public class LoadUsers {

	public static void main(String... args) throws IOException {
		final LoadUsers runner = new LoadUsers();
		runner.run(args);

	}

	/**
	 * Reads the file and output format of the letters specified
	 * @param args - file to parse and format of the letters
	 * that will be printed to the citizens.
	 * @throws IOException
	 */
	void run(String... args) throws IOException {
		// cazar excepciones???
		
		File file = new File(args[0]);
				
		Writtable letters = getWrittable(args[1]);
		Parser parser = getParser(file, letters);
		
		if (parser == null) {
			System.out.println("Este formato de archivo no está soportado");
		} else {
			parser.readList();
		}
		metodoClaudia();
		metodoClaudia2();
	}
	
	

	private void metodoClaudia2() throws FileNotFoundException {
		//Initialize PDF writer
        PdfWriter writer = new PdfWriter("generatedFiles/WelcomePruebaDNI3.pdf");
 
        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);
 
        // Initialize document
        Document document = new Document(pdf);
 
        //Add paragraph to the document
        document.add(new Paragraph("Gracias por registrarse! Su user es: "
        		+ "pruebaEmail@email.com y su contraseña: PruebaPassword."));
 
        //Close document
        document.close();
	}

	private void metodoClaudia() throws IOException {
		 XWPFDocument document = new XWPFDocument();
	        //Write the Document in file system
		    FileOutputStream out = new FileOutputStream(
		    		new File("generatedFiles/WelcomePruebaDNI3.docx"));

	        //create Paragraph
	        XWPFParagraph paragraph = document.createParagraph();
	        XWPFRun run = paragraph.createRun();
	        run.setText("Gracias por registrarse! Su user es: "
	        		+ "pruebaEmail@email.com y su contraseña: PruebaPassword.");
	        document.write(out);
	       
	        //Close document
	        out.close();
	        document.close();
	}

	/**
	 * Selects the class that matches the specified output type
	 * for the letters
	 * @param string - type of the output
	 * @return class of the specified output
	 */
	private Writtable getWrittable(String string) {
		Writtable writtable = null;
		if (string.equalsIgnoreCase("pdf")) {
			writtable = new PDFLetter();
		}
		else if (string.equalsIgnoreCase("docx")) {
			writtable = new WordLetter();
		}
		else if (string.equalsIgnoreCase("txt")) {
			writtable = new TxtLetter();
		}
		return writtable;
	}

	/**
	 * Method implemented in order to add in the future different input formats
	 * @param file - file that will be read by the parser
	 * @param letters - type of the output
	 * @return parser of the type of the file extension
	 * @throws IOException
	 */
	private Parser getParser(File file, Writtable letters) throws IOException {
		Parser parser = null;
		String type = getFileExtension(file);
		if (type.equalsIgnoreCase("xlsx")) {
			parser = new XlsxParser(file, letters);
		}
		return parser;
	}

	/**
	 * Returns the extension of a file 
	 * @param file - file for which we obtain the extension
	 * @return the extension of the file as a string
	 */
	private String getFileExtension(File file) {
		String name = file.getName();
		try {
			return name.substring(name.lastIndexOf(".") + 1);
		} catch (Exception e) {
			return "";
		}
	}
}
