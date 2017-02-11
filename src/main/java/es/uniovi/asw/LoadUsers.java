package es.uniovi.asw;

import es.uniovi.asw.parser.Parser;
import es.uniovi.asw.parser.XlsxParser;
import es.uniovi.asw.persistence.Jpa;

import java.io.File;
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

	public static void main(String... args) {
		final LoadUsers runner = new LoadUsers();
		runner.run(args);
	
	}
	
	void run(String... args) {
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

	}

	
    private void sendToDB(List<Citizen> list) {
    	EntityManager mapper = Jpa.getEntityManager();
    	EntityTransaction trx = mapper.getTransaction();
		trx.begin();
    	for(Citizen c : list) {
    		// create a random alphanumeric password and persists the user
    		c.setPassword(RandomStringUtils.randomAlphanumeric(10));
    		mapper.persist(c);
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
