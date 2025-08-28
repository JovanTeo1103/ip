package baymax;

/**
 * Exception thrown when an invalid command is entered by the user.
 * This can occur when the input command does not match any recognized commands in the application.
 */
public class InvalidCommandException extends Exception {

    /**
     * Constructs a new InvalidCommandException with the specified detail message.
     *
     * @param message the detail message explaining the reason for the exception
     */
    public InvalidCommandException(String message) {
        super(message);
    }
}
