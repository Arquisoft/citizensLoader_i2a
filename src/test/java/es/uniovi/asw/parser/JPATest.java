package es.uniovi.asw.parser;

import static org.junit.Assert.*;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.uniovi.asw.Citizen;
import es.uniovi.asw.persistence.Jpa;

public class JPATest {

	private Citizen c1, c2;

	@Before
	public void setUp() {
		c1 = new Citizen("1", "Name", "Surname", new Date(), "Address", "Email", "Nationality");
		c2 = new Citizen("1", "Nombre", "Apellidos", new Date(), "Direccion", "Correo", "Nacionalidad");
	}

	@After
	public void tearDown() {
		try {

			EntityManager mapper = Jpa.getEntityManager();
			EntityTransaction trx = mapper.getTransaction();
			trx.begin();
			Citizen c = mapper.find(Citizen.class, c1.getId());
			mapper.remove(c);

			c = mapper.find(Citizen.class, c2.getId());
			mapper.remove(c);
			trx.commit();
		} catch (Exception e) {
			System.out.println("Arrancar la base de datos");
		}
	}

	@Test
	public void test() {
		try {
			EntityManager mapper = Jpa.getEntityManager();
			EntityTransaction trx = mapper.getTransaction();
			trx.begin();

			mapper.persist(c1);
			mapper.persist(c1);

			trx.commit();

			trx.begin();

			Citizen c = mapper.merge(c1);
			assertNotNull(c);
			assertEquals(c1.getFirstName(), c.getFirstName());

			trx.commit();

			c = null;

			trx.begin();
			c2.setFirstName("Not the name");
			c = mapper.merge(c2);
			assertNotNull(c);
			assertEquals("Not the name", c.getFirstName());

			trx.commit();
		} catch (PersistenceException e) {
			System.out.println("Arrancar la base de datos");
		}
	}

}
