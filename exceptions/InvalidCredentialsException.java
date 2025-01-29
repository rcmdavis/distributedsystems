package exceptions;

// Thrown when the credentials provided (username/password) are invalid
public class InvalidCredentialsException extends Exception {
    public InvalidCredentialsException(String message) {
        super(message);
    }
}
