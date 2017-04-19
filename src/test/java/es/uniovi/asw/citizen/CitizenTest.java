package es.uniovi.asw.citizen;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.uniovi.asw.User;

public class CitizenTest {

	User c1, c2, c3;

	@Before
	public void setUp() {
		Date date = new Date();
		c1 = new User("12345A", "Nombre", "Apellidos", date, "Direccion", "email@email.com", "español", 1);
		c1.setId(new Integer(1));
		c2 = c1;
		c3 = new User("09876B", "OtroNombre", "Apellidos", date, "Direccion2", "email@email.com", "español", 1);
		c3.setId(new Integer(2));
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
		c1 = new User();
		
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
		
		assertEquals(0, c1.getPollingStation());
		c1.setPollingStation(1);
		assertEquals(1, c1.getPollingStation());

		assertEquals(null, c1.getFirstName());
		assertEquals(null, c1.getLastName());
		c1.setName("Nombre");
		c1.setSurname("Apellidos");
		assertEquals("Nombre Apellidos", c1.getFirstName() + " " + c1.getLastName());		
		
	}


	
}
