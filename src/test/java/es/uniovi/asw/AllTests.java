package es.uniovi.asw;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import es.uniovi.asw.citizen.CitizenTest;
import es.uniovi.asw.citizen.JPATest;
import es.uniovi.asw.letters.TextLetterTest;
import es.uniovi.asw.parser.XlsxParserTest;

@RunWith(Suite.class)
@SuiteClasses({ CitizenTest.class, JPATest.class, TextLetterTest.class, XlsxParserTest.class})
public class AllTests {

}
