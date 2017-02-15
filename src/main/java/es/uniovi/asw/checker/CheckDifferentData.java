package es.uniovi.asw.checker;

import es.uniovi.asw.Citizen;
import es.uniovi.asw.persistence.Jpa;

public class CheckDifferentData {

	/**
	 * Checks if there is some user already in the database with wrong data
	 * @param c Citizen
	 * @return true if there is no user with different data, false otherwise
	 */
	public static boolean citizenHasSameData(Citizen c) {
		Long count = (Long) Jpa.getEntityManager().createQuery("select count(c)"
				+ " from Citizen c"
				+ " where c.dni = ?1"
				+ " AND (c.firstName !=?2 OR"
				+ " c.lastName!=?3 OR"
				+ " c.email !=?4 OR"
				+ " c.birthdate!=?5 OR"
				+ " c.address!=?6 OR"
				+ " c.nationality!=?7 OR"
				+ " c.pollingStation!=?8)")
		.setParameter(1, c.getDni())
		.setParameter(2, c.getFirstName())
		.setParameter(3, c.getLastName())
		.setParameter(4, c.getEmail())
		.setParameter(5, c.getBirthdate())
		.setParameter(6, c.getAddress())
		.setParameter(7, c.getNationality())
		.setParameter(8, c.getPollingStation())
		.getSingleResult();
		return count == 0;
	}

}
