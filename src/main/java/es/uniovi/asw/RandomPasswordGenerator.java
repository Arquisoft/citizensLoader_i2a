package es.uniovi.asw;

import java.util.Random;

/**
 * Created by Carla on 09/02/2017.
 */
public class RandomPasswordGenerator {
    public static String generatePassword(){
        Random gen = new Random();
        Long number = gen.nextLong();
        return number.toString();
    }
}
