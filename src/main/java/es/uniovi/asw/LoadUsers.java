package es.uniovi.asw;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import es.uniovi.asw.checker.CheckCitizen;
import es.uniovi.asw.checker.CheckDifferentData;
import es.uniovi.asw.logger.MyLogger;
import es.uniovi.asw.parser.Parser;
import es.uniovi.asw.parser.XlsxParser;
import es.uniovi.asw.persistence.Jpa;

/**
 * Main application
 * 
 * @author Claudia, Sara, Carla
 *
 */
public class LoadUsers {
	MyLogger log = new MyLogger();

	public static void main(String... args) throws IOException {
		final LoadUsers runner = new LoadUsers();
		runner.run(args);

	}

	void run(String... args) throws IOException {
		File file = new File(args[0]);
		// deberia ser args[1]??

		Parser parser = getParser(file);

		if (parser == null) {
			System.out.println("Este formato de archivo no está soportado");
		} else {
			log.createLog("generatedFiles/errors.log");
			sendToDB(parser.parseFile(file));
			log.close();
		}

	}

	private void sendToDB(List<Citizen> list) throws IOException {
		EntityManager mapper = Jpa.getEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();
		for (Citizen c : list) {
			// if the user is not in the database, persist
			if (!CheckCitizen.citizenExists(c)) {
				mapper.persist(c);
				// if it already exists, we record the error in the log file
			} else {
				log.record("The citizen " + c.getFirstName()
				+ " " + c.getLastName() + " has already an user");
				// and if the data is different we put that error in the log
				if (!CheckDifferentData.citizenHasSameData(c)){
					log.record("The citizen " + c.getFirstName()
					+ " " + c.getLastName() + " has different data in the"
							+ " database and in the document");	
				}
				continue;
			}
		}
		trx.commit();
	}

	private Parser getParser(File file) {
		Parser parser = null;
		String type = getFileExtension(file);
		if (type.equalsIgnoreCase("xlsx")) {
			parser = new XlsxParser();
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
