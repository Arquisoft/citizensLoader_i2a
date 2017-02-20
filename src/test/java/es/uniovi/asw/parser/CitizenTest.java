package es.uniovi.asw.parser;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.uniovi.asw.Citizen;

public class CitizenTest {

	Citizen c1, c2, c3;

	@Before
	public void setUp() {
		Date date = new Date();
		c1 = new Citizen("12345A", "Nombre", "Apellidos", date, "Direccion", "email@email.com", "español");
		c1.setId((long) 1);
		c2 = c1;
		c3 = new Citizen("09876B", "OtroNombre", "Apellidos", date, "Direccion2", "email@email.com", "español");
		c3.setId((long) 2);
	}
	
	@Test
	public void testEquals() {
		assertEquals(c1, c2);
		assert(c1.equals(c2));
		
		assertFalse(c1.equals(c3));
	}

	@Test
	public void testHashCode() {
		assertEquals(c1.hashCode(), c2.hashCode());
		assertNotEquals(c1.hashCode(), c3.hashCode());
		assertNotEquals(c2.hashCode(), c3.hashCode());
		
	}
	
	@Test
	public void test() {
		c1 = new Citizen();
		
		assertEquals(null, c1.getDni());
		c1.setDni("123456789A");
		assertEquals("123456789A", c1.getDni());
		
		assertEquals(null, c1.getAddress());
		c1.setAddress("Una direccion");
		assertEquals("Una direccion", c1.getAddress());

		assertEquals(null, c1.getBirthdate());
		Date date = new Date();
		c1.setBirthdate(date);
		assertEquals(date, c1.getBirthdate());

		assertEquals(null, c1.getNationality());
		c1.setNationality("Español");
		assertEquals("Español", c1.getNationality());

		assertEquals(null, c1.getEmail());
		c1.setEmail("email@email.com");
		assertEquals("email@email.com", c1.getEmail());

		assertEquals(null, c1.getFirstName());
		assertEquals(null, c1.getLastName());
		c1.setFirstName("Nombre");
		c1.setLastName("Apellidos");
		assertEquals("Nombre Apellidos", c1.getFirstName() + " " + c1.getLastName());		
		
	}


	
}
