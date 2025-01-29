package exceptions;

// Thrown when the question number provided is invalid/out-of-bounds
public class InvalidQuestionNumberException extends Exception {
    public InvalidQuestionNumberException(String message) {
        super(message);
    }
}
