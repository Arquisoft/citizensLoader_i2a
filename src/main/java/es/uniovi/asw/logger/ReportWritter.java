package es.uniovi.asw.logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class ReportWritter {

	BufferedWriter fichero;
	
	public ReportWritter() throws IOException{
		createLog("generatedFiles/errors.log");
	}
	
	public void createLog(String name) throws IOException {
		fichero = new BufferedWriter(new FileWriter(name));
	}
	
	public void record(String message, String filename) throws IOException {
		Date date = new Date();
		String linea = "";
		fichero.append(linea);
		fichero.append("Filename: " + filename + " ");
		fichero.append(date.toString() +" "+ message );

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