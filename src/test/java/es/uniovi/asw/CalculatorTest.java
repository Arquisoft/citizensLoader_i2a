package es.uniovi.asw;

import org.junit.*;

import static junit.framework.TestCase.assertEquals;

public class CalculatorTest {

@Test
public void evalAdd() {
	Calculator calc = new Calculator();
	Integer expected = 5;
	assertEquals(calc.add(3, 2), expected);
}


}
