package es.uniovi.asw.persistence;

import java.io.IOException;
import java.util.List;

import es.uniovi.asw.User;

public interface UserDao {

	User getUserById(Integer id);
	
	void createUser(User user);

	List<String> findAllEmails();

	User getUserByEmail(String email);

	void sendToDB(List<User> users, String name) throws IOException;

	boolean citizenExists(User user);

	boolean citizenHasSameData(User user);
}
