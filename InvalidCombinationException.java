/**
 * Exception class used in case of invalid card combinations.
 */
public class InvalidCombinationException extends Exception {
    public InvalidCombinationException() {
        super("This card combintatoin is invalid.Moving on.");
    }

    public InvalidCombinationException(String msg) {
        super(msg);
    }

}
