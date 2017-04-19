package es.uniovi.asw.parser;

import java.util.List;

import es.uniovi.asw.User;

/**
 * Interface for all Parser objects. 
 * Expresses functionality to read a file and 
 * return a list of citizens.
 */
public interface Parser {
    List<User> readList();
}
