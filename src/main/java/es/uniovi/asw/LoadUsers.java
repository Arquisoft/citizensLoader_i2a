package es.uniovi.asw;

import java.io.File;
import java.io.IOException;

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

	}

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

	private Parser getParser(File file, Writtable letters) throws IOException {
		Parser parser = null;
		String type = getFileExtension(file);
		if (type.equalsIgnoreCase("xlsx")) {
			parser = new XlsxParser(file, letters);
		}
		return parser;
	}

	private String getFileExtension(File file) {
		String name = file.getName();
		try {
			return name.substring(name.lastIndexOf(".") + 1);
		} catch (Exception e) {
			return "";
		}
	}
}
