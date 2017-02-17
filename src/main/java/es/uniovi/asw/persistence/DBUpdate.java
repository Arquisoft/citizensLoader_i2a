package es.uniovi.asw.persistence;

import java.io.IOException;
import java.util.List;

import es.uniovi.asw.Citizen;

public interface DBUpdate {

	public void sendToDB(List<Citizen> list, String filename) throws IOException;
	public boolean citizenExists(Citizen c);
	public boolean citizenHasSameData(Citizen c);
	public Citizen findByDNI(String dni);
}
