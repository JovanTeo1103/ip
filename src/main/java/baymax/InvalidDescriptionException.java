package baymax;

/**
 * Exception thrown when a task is created with an invalid description.
 * This can occur when the description is empty or does not meet the application's requirements.
 */
public class InvalidDescriptionException extends Exception {

    /**
     * Constructs a new InvalidDescriptionException with the specified detail message.
     *
     * @param message the detail message explaining the reason for the exception
     */
    public InvalidDescriptionException(String message) {
        super(message);
    }
}
