package exceptions;

/**
 * Created by Tanasescu on 11/30/2014.
 */
public class InputException extends Exception {

    // Constructor care afiseaza un mesaj cu eroarea aparuta
    public InputException(String input, String errorMessage) {
        super("Input Format exception on \"" + input + "\" : " + errorMessage);
    }
}
