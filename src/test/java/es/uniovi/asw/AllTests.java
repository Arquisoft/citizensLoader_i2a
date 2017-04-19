package es.uniovi.asw;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import es.uniovi.asw.citizen.CitizenTest;
import es.uniovi.asw.letters.PdfLetterTest;
import es.uniovi.asw.letters.TextLetterTest;
import es.uniovi.asw.letters.WordLetterTest;
import es.uniovi.asw.parser.XlsxParserTest;

@RunWith(Suite.class)
@SuiteClasses({ CitizenTest.class, TextLetterTest.class, XlsxParserTest.class, 
	WordLetterTest.class, PdfLetterTest.class})
public class AllTests {

}
