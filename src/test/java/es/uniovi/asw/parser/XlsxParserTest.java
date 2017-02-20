package es.uniovi.asw.parser;

import es.uniovi.asw.Citizen;
import org.junit.*;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Carla on 08/02/2017.
 */

public class XlsxParserTest {
    @Test
    public void testParseSmallFile(){
        XlsxParser parser = new XlsxParser();
        File file = new File("src/test/resources/testSmall.xlsx");
        List<Citizen> users = parser.parseFile(file);

        assertEquals("Nombre: Juan; Apellidos: Torres Pardo; " +
                "Email: juan@example.com; Nacimiento: 10/10/1985; " +
                "Dirección: C/ Federico García Lorca 2; Nacionalidad: " +
                "Español; DNI: 90500084Y",
                users.get(0).toString());

        assertEquals("Nombre: Luis; Apellidos: López Fernando; " +
                        "Email: luis@example.com; Nacimiento: 02/03/1970; " +
                        "Dirección: C/ Real Oviedo 2; Nacionalidad: " +
                        "Español; DNI: 19160962F",
                users.get(1).toString());

        assertEquals("Nombre: Ana; Apellidos: Torres Pardo; " +
                        "Email: ana@example.com; Nacimiento: 01/01/1960; " +
                        "Dirección: Av. De la Constitución 8; Nacionalidad: " +
                        "Español; DNI: 09940449X",
                users.get(2).toString());
    }

}