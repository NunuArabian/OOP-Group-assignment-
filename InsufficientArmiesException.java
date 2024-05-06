public class InsufficientArmiesException extends Exception{
    public InsufficientArmiesException() {
        super("You don't have enough armies to move");
    }

    public InsufficientArmiesException(String msg) {
        super(msg);
    }
}
