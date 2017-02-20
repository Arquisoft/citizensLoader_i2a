package es.uniovi.asw.letters;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import es.uniovi.asw.Citizen;

public class TxtLetter implements Writtable {

	@Override
	public void write(Citizen c) throws IOException {
		BufferedWriter fichero;
		String nombreFichero = "generatedFiles/Welcome"+c.getDni()+".txt";
		fichero = new BufferedWriter(new FileWriter(nombreFichero));
		String message = "Gracias por registrarse! Su user es: "
		        + c.getEmail()+ " y su contraseña: "+c.getPassword() ;
		fichero.write(message);
		fichero.close();
		
	}

}
