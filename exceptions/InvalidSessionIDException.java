package exceptions;

// Thrown if a session ID (used to access ApplicationForm) is invalid
public class InvalidSessionIDException extends Exception {
    public InvalidSessionIDException(String message) {
        super(message);
    }
}
