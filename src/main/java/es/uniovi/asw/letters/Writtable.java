package es.uniovi.asw.letters;

import java.io.IOException;

import es.uniovi.asw.Citizen;

public interface Writtable {

	void write(Citizen c) throws IOException;

}
