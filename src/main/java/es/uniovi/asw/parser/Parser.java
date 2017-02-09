package es.uniovi.asw.parser;

import es.uniovi.asw.User;

import java.io.File;
import java.util.List;

/**
 * Created by Carla on 09/02/2017.
 */
public interface Parser {
    List<User> parseFile(File file);
}
