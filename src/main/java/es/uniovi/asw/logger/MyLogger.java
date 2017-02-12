package es.uniovi.asw.logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class MyLogger {

	BufferedWriter fichero;
	
	public void createLog(String name) throws IOException {
		fichero = new BufferedWriter(new FileWriter(name));
	}
	
	public void record(String string) throws IOException {
		Date date = new Date();
		String linea = "";
		fichero.write(linea);
		fichero.write(string +" "+ date.toString() );
		fichero.newLine();
		fichero.write("--------------------------");
		fichero.close();
	}

	
        
}