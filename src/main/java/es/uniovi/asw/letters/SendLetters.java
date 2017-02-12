package es.uniovi.asw.letters;

import java.io.IOException;

import es.uniovi.asw.Citizen;

public class SendLetters {
	
	/**
	 * This method is a greater one which calls all the other methods that "print"
	 * a letter in different formats.
	 * @param c (citizen)
	 * @throws IOException 
	 */
	public void send(Citizen c) throws IOException {
		WordLetter word = new WordLetter();
		PDFLetter pdf = new PDFLetter();
		word.write(c);
		pdf.write(c);
		
	}

}
