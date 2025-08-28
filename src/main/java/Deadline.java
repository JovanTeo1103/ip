import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {

    private LocalDate by;

    public Deadline(String taskName, TaskType taskType, String byStr) {
        super(taskName, taskType);
        this.by = LocalDate.parse(byStr);
    }

    public Deadline(String taskName, TaskType taskType, String byStr, boolean isDone) {
        super(taskName, taskType, isDone);
        this.by = LocalDate.parse(byStr);
    }

    @Override
    public String toString() {
        String formattedDate = by.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        return "[D]" + super.toString() + " (by: " + formattedDate + ")";
    }

    public LocalDate getBy() {
        return this.by;
    }

}
