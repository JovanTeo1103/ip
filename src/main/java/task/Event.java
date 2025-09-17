package task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents an event-type task in the Baymax task management system.
 * <p>
 * An Event task has a description, a status (done or not done), and a start and end date
 * represented as {@link LocalDate}.
 * <p>
 * This class extends {@link Task} and provides functionality to
 * retrieve the start and end dates and display the task in a human-readable format.
 */
public class Event extends Task {

    private final LocalDate from;
    private final LocalDate to;

    /**
     * Constructs an Event task with the given description, type, start date, and end date.
     *
     * @param taskName the description of the task
     * @param taskType the type of the task (should be TaskType.EVENT)
     * @param fromStr  the start date as a string in ISO_LOCAL_DATE format (yyyy-MM-dd)
     * @param toStr    the end date as a string in ISO_LOCAL_DATE format (yyyy-MM-dd)
     */
    public Event(String taskName, TaskType taskType, String fromStr, String toStr) {
        super(taskName, taskType);
        this.from = LocalDate.parse(fromStr);
        this.to = LocalDate.parse(toStr);
    }

    /**
     * Constructs an Event task with the given description, type, start date, end date, and completion status.
     *
     * @param taskName the description of the task
     * @param taskType the type of the task (should be TaskType.EVENT)
     * @param fromStr  the start date as a string in ISO_LOCAL_DATE format (yyyy-MM-dd)
     * @param toStr    the end date as a string in ISO_LOCAL_DATE format (yyyy-MM-dd)
     * @param isDone   the completion status of the task
     */
    public Event(String taskName, TaskType taskType, String fromStr, String toStr, boolean isDone) {
        super(taskName, taskType, isDone);
        this.from = LocalDate.parse(fromStr);
        this.to = LocalDate.parse(toStr);
    }

    /**
     * Returns a string representation of the Event task, including its type,
     * completion status, description, and formatted start and end dates.
     *
     * @return the string representation of the Event task
     */
    @Override
    public String toString() {
        String fromFormatted = from.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        String toFormatted = to.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        return "[E]" + super.toString() + " (from: " + fromFormatted + " to: " + toFormatted + ")";
    }


    /**
     * Returns the start date of the Event.
     *
     * @return the start date as a {@link LocalDate}
     */
    public LocalDate getFrom() {
        return this.from;
    }

    /**
     * Returns the end date of the Event.
     *
     * @return the end date as a {@link LocalDate}
     */
    public LocalDate getTo() {
        return this.to;
    }
}
