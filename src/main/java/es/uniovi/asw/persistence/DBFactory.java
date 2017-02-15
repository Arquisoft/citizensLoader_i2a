package es.uniovi.asw.persistence;

import java.io.IOException;

public class DBFactory {
	public DBUpdate getDBImpl() throws IOException{
		return new DBUpdateImpl();
	}
}
