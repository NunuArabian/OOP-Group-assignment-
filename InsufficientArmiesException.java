/**
 * Exception class used in case of insufficient armies.
 */
public class InsufficientArmiesException extends Exception{
    public InsufficientArmiesException() {
        super("You don't have enough armies to move.Moving on.");
    }

    public InsufficientArmiesException(String msg) {
        super(msg);
    }
}
