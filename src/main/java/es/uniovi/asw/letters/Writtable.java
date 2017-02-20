package es.uniovi.asw.letters;

import java.io.IOException;

import es.uniovi.asw.Citizen;

public interface Writtable {

	//interface for all the different output formats
	
	/**
	 * Writes in a file a letter for each citizen,
	 * specifying its own login email and password
	 * @param c - citizen for which the letter will be written
	 * @throws IOException
	 */
	void write(Citizen c) throws IOException;

}
