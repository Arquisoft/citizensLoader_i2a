package es.uniovi.letters;

import es.uniovi.asw.Citizen;

public class SendLetters {

	/**
	 * This method is a greater one which calls all the other methods that "print"
	 * a letter in different formats.
	 * @param c (citizen)
	 */
	public void send(Citizen c) {
		//i don't know if the citizen can specify the format or not so meanwhile
		//i will just do the letter in all the formats and we can comment/discomment
		WordLetter word = new WordLetter(c.getFirstName(),c.getEmail(),c.getPassword()); 
		PDFLetter pdf = new PDFLetter(c.getFirstName(),c.getEmail(),c.getPassword()); 
		word.write();
		pdf.write();
		
	}

}
