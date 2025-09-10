package task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {

    private final LocalDate from;
    private final LocalDate to;

    public Event(String taskName, TaskType taskType, String fromStr, String toStr) {
        super(taskName, taskType);
        this.from = LocalDate.parse(fromStr);
        this.to = LocalDate.parse(toStr);
    }

    public Event(String taskName, TaskType taskType, String fromStr, String toStr, boolean isDone) {
        super(taskName, taskType, isDone);
        this.from = LocalDate.parse(fromStr);
        this.to = LocalDate.parse(toStr);
    }

    @Override
    public String toString() {
        String fromFormatted = from.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        String toFormatted = to.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        return "[E]" + super.toString() + " (from: " + fromFormatted + " to: " + toFormatted + ")";
    }


    public LocalDate getFrom() {
        return this.from;
    }

    public LocalDate getTo() {
        return this.to;
    }
}
