package exceptions;

public class NullPowerHolderCallException extends Exception {
    public NullPowerHolderCallException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Power holder doesn't exist to call him";
    }
}
