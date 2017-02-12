package es.uniovi.asw;

import es.uniovi.asw.checker.CheckCitizen;
import es.uniovi.asw.logger.MyLogger;
import es.uniovi.asw.parser.Parser;
import es.uniovi.asw.parser.XlsxParser;
import es.uniovi.asw.persistence.Jpa;
import es.uniovi.letters.SendLetters;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.commons.lang.RandomStringUtils;



/**
 * Main application
 * 
 * @author Labra
 *
 */
public class LoadUsers {
	
	SendLetters send = new SendLetters();
	MyLogger log = new MyLogger();

	public static void main(String... args) throws IOException {
		final LoadUsers runner = new LoadUsers();
		runner.run(args);
	
	}
	
	void run(String... args) throws IOException {
		File file = new File (args[0]);
		// deberia ser args[1]??

        Parser parser = getParser(file);

		if (parser != null){
			parser.parseFile(file);
		}
		else{
			System.out.println("Este formato de archivo no está soportado");
		}

		sendToDB(parser.parseFile(file));
		log.createLog(file.getName());

	}

	
    private void sendToDB(List<Citizen> list) throws IOException {
    	EntityManager mapper = Jpa.getEntityManager();
    	EntityTransaction trx = mapper.getTransaction();
		trx.begin();
    	for(Citizen c : list) {
    		// create a random alphanumeric password and persists the user
    		c.setPassword(RandomStringUtils.randomAlphanumeric(10));
    		if (CheckCitizen.check(c)){
    			mapper.persist(c);
    		}else {
    			log.record("The citizen" + c.getFirstName() + " " + c.getLastName() + " already has an user");
    			continue;
    		}
    		// not really sure if this method has to be called here
    		send.send(c);
    	}
    	trx.commit();
    }

   

	private Parser getParser(File file) {
        Parser parser = null;
        String type = getFileExtension(file);
        if (type.equalsIgnoreCase("xlsx")){
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
