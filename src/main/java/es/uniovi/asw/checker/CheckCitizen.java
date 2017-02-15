package es.uniovi.asw.checker;

import es.uniovi.asw.Citizen;
import es.uniovi.asw.persistence.Jpa;

public class CheckCitizen {

	public static boolean citizenExists(Citizen c) {
		Long count = (Long) Jpa.getEntityManager().createQuery("select count(c)"
				+ " from Citizen c"
				+ " where c.dni = ?1")
		.setParameter(1, c.getDni())
		.getSingleResult();
		return count != 0;
	}

}
