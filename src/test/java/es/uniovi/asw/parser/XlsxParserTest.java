package es.uniovi.asw.parser;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.junit.Test;

import es.uniovi.asw.Citizen;

/**
 * Created by Carla on 08/02/2017.
 */

public class XlsxParserTest {
    @Test
    public void testParseSmallFile(){
        XlsxParser parser = new XlsxParser();
        File file = new File("src/test/resources/testSmall.xlsx");
        List<Citizen> users = parser.parseFile(file);

        assertEquals("Name: Juan; Surname: Torres Pardo; " +
                "Email: juan@example.com; Birth date: 10/10/1985; " +
                "Address: C/ Federico García Lorca 2; Nationality: " +
                "Español; DNI: 90500084Y; Polling station: 1",
                users.get(0).toString());

        assertEquals("Name: Luis; Surname: López Fernando; " +
                        "Email: luis@example.com; Birth date: 02/03/1970; " +
                        "Address: C/ Real Oviedo 2; Nationality: " +
                        "Español; DNI: 19160962F; Polling station: 2",
                users.get(1).toString());

        assertEquals("Name: Ana; Surname: Torres Pardo; " +
                        "Email: ana@example.com; Birth date: 01/01/1960; " +
                        "Address: Av. De la Constitución 8; Nationality: " +
                        "Español; DNI: 09940449X; Polling station: 3",
                users.get(2).toString());
    }

}