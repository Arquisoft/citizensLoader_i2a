package es.uniovi.asw.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.uniovi.asw.Citizen;
import es.uniovi.asw.letters.PDFLetter;
import es.uniovi.asw.persistence.DBFactory;
import es.uniovi.asw.persistence.DBUpdate;

/**
 * Created by Carla on 08/02/2017.
 */

public class XlsxParserTest {
	private DBUpdate db;
	private final static String JUAN = "Name: Juan; Surname: Torres Pardo; " +
            "Email: juan@example.com; Birth date: 10/10/1985; " +
            "Address: C/ Federico García Lorca 2; Nationality: " +
            "Español; DNI: 90500084Y; Polling station: 1";
	private final static String LUIS = "Name: Luis; Surname: López Fernando; " +
            "Email: luis@example.com; Birth date: 02/03/1970; " +
            "Address: C/ Real Oviedo 2; Nationality: " +
            "Español; DNI: 19160962F; Polling station: 2";
	private final static String ANA = "Name: Ana; Surname: Torres Pardo; " +
            "Email: ana@example.com; Birth date: 01/01/1960; " +
            "Address: Av. De la Constitución 8; Nationality: " +
            "Español; DNI: 09940449X; Polling station: 3";
	private final static String PEDRO = "Name: Pedro; Surname: Pérez García; " +
            "Email: pedro@example.com; Birth date: 04/09/1979; " +
            "Address: C/ La playa 7; Nationality: " +
            "Chileno; DNI: 56739582Y; Polling station: 4";
	
	
	@Before
	public void setUp() throws IOException{
		this.db = DBFactory.getDBImpl();
	}
	
    @Test
    public void testParseSmallFileCorrectly() throws IOException {
    	File file = new File("src/test/resources/testSmall.xlsx");
        XlsxParser parser = new XlsxParser(file, new PDFLetter());
        List<Citizen> users = parser.readList();

        assertEquals(JUAN, users.get(0).toString());

        assertEquals(LUIS, users.get(1).toString());

        assertEquals(ANA, users.get(2).toString());
        
        assertEquals(PEDRO, users.get(3).toString());
    }
    
    @Test
    public void testParseSmallFileDifferentInfo() throws IOException{
    	File file = new File("src/test/resources/testSmallDifferent.xlsx");
        XlsxParser parser = new XlsxParser(file, new PDFLetter());
        parser.readList();

        // demostramos que la info en la bbdd no cambió
        Citizen juan = db.findByDNI("90500084Y");
        assertNotNull(juan);
        assertEquals(JUAN, juan.toString());

        Citizen luis = db.findByDNI("19160962F");
        assertNotNull(luis);
        assertEquals(LUIS, luis.toString());

        Citizen ana = db.findByDNI("09940449X");
        assertNotNull(ana);
        assertEquals(ANA, ana.toString());
        
        Citizen pedro = db.findByDNI("56739582Y");
        assertNotNull(pedro);
        assertEquals(PEDRO, pedro.toString());
    }

}