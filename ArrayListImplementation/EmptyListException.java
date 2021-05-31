package ArrayListImplementation;

public class EmptyListException extends RuntimeException{

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public String getLocalizedMessage() {
        return super.getLocalizedMessage();
    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }

    @Override
    public synchronized Throwable initCause(Throwable cause) {
        return super.initCause(cause);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public EmptyListException(String message) {
        super("Empty List Exception");
    }

    public EmptyListException() {
        super("Empty List Exception");
    }

}
