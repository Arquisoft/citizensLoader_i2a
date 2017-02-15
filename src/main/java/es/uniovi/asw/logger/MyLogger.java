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
		fichero.append(linea);
		fichero.append(date.toString() +" "+ string );
		fichero.newLine();
		fichero.append("--------------------------");
		fichero.newLine();
	}

	public void close() {
		try {
			fichero.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
        
}