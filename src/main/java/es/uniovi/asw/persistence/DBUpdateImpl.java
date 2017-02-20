package es.uniovi.asw.persistence;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import es.uniovi.asw.Citizen;
import es.uniovi.asw.logger.ReportWritter;

public class DBUpdateImpl implements DBUpdate {

	private ReportWritter log;
	
	public DBUpdateImpl() throws IOException {
		log = new ReportWritter();
	}

	/**
	 * Method that inserts in the database all the parsed users.
	 * Prints a log if there is some type of error.
	 * @param list - list of citizens that have been parsed
	 * @param filename - name of the document parsed which will appear in the log
	 */
	@Override
	public void sendToDB(List<Citizen> list, String filename) throws IOException {
		EntityManager mapper = Jpa.getEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();
		for (Citizen c : list) {
			// if the user is not in the database, persist
			if (!citizenExists(c)) {
				mapper.persist(c);
				// if it already exists, we record the error in the log file
			} else {
				log.record("The citizen " + c.getFirstName()
				+ " " + c.getLastName() + " has already an user", filename);
				// and if the data is different we put that error in the log
				if (!citizenHasSameData(c)){
					log.record("The citizen " + c.getFirstName()
					+ " " + c.getLastName() + " has different data in the"
							+ " database and in the document", filename);	
				}
			}
		}
		log.close();
		trx.commit();
	}

	/**
	 * Checks if a citizen already exists in the database
	 * @param c - citizen to check
	 * @return true if it exists, false if not
	 */
	@Override
	public boolean citizenExists(Citizen c) {
		Long count = (Long) Jpa.getEntityManager().createQuery("select count(c)"
				+ " from Citizen c"
				+ " where c.dni = ?1")
		.setParameter(1, c.getDni())
		.getSingleResult();
		return count != 0;
	}

	/**
	 * Checks if there is some user already in the database with wrong data
	 * @param c Citizen
	 * @return true if there is no user with different data, false otherwise
	 */
	@Override
	public boolean citizenHasSameData(Citizen c) {
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
	
	/**
	 * Finds a citizen giving as a parameter its dni
	 * @param dni of the citizen you want to find
	 * @return the citizen with the dni specified
	 */
	@Override
	public Citizen findByDNI(String dni) {
		@SuppressWarnings("unchecked")
		List<Citizen> citizen = (List<Citizen>)Jpa.getEntityManager().createQuery("select c"
				+ " from Citizen c"
				+ " where c.dni = ?1")				
				.setParameter(1, dni)
				.getResultList();
		return citizen.size() == 1? 
				citizen.get(0) : null;
	}

}
