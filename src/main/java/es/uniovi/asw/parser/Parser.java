package es.uniovi.asw.parser;

import es.uniovi.asw.Citizen;

import java.io.File;
import java.util.List;

/**
 * Created by Carla on 09/02/2017.
 */
public interface Parser {
    List<Citizen> readList();
}
