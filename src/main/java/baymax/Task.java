package baymax;

/**
 * Represents a generic task in the Baymax application.
 * A Task has a description, a completion status, and a type.
 * This class serves as the superclass for more specific task types such as {@link Todo}, {@link Deadline}, and {@link Event}.
 */
public class Task {

    /**
     * Description of the task
     */
    protected String taskDescripion;

    /**
     * Completion status of the task
     */
    protected boolean isDone;

    /**
     * Type of the task
     */
    protected TaskType taskType;

    /**
     * Constructs a new Task with the given name and type.
     * By default, the task is not done.
     *
     * @param taskName the name/description of the task
     * @param taskType the type of the task
     */
    public Task(String taskName, TaskType taskType) {
        this.taskDescripion = taskName;
        this.isDone = false;
        this.taskType = taskType;
    }

    /**
     * Constructs a new Task with the given name, type, and completion status.
     * Useful when loading tasks from a file.
     *
     * @param taskName the name/description of the task
     * @param taskType the type of the task
     * @param isDone   whether the task is completed
     */
    public Task(String taskName, TaskType taskType, boolean isDone) {
        this.taskDescripion = taskName;
        this.taskType = taskType;
        this.isDone = isDone;
    }

    /**
     * Marks the task as completed.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Marks the task as not completed.
     */
    public void markAsUndone() {
        this.isDone = false;
    }

    /**
     * Returns a string representation of the task, including its completion status.
     *
     * @return a string in the format "[X] description" if done, "[ ] description" if not done
     */
    @Override
    public String toString() {
        return isDone
                ? "[X] " + taskDescripion
                : "[ ] " + taskDescripion;
    }

    /**
     * Returns the description of the task.
     *
     * @return task description
     */
    public String getDescription() {
        return this.taskDescripion;
    }

    /**
     * Returns the completion status of the task.
     *
     * @return true if the task is done, false otherwise
     */
    public boolean getStatus() {
        return this.isDone;
    }
}

