public class InvalidCombinationException extends Exception {
    public InvalidCombinationException() {
        super("This card combintatoin is invalid.Try again!");
    }

    public InvalidCombinationException(String msg) {
        super(msg);
    }

}
