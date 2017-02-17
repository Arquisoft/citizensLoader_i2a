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
	public static void send(Citizen c, Writtable letter) throws IOException {
		letter.write(c);
		System.out.println("La carta para " + c.getFirstName() + " " + c.getLastName()+ " ha sido generada");
	}

}
