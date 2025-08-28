public class Deadline extends Task {

    protected String by;

    public Deadline(String taskName, TaskType taskType, String by) {
        super(taskName, taskType);
        this.by = by;
    }

    public Deadline(String taskName, TaskType taskType, String by, boolean isDone) {
        super(taskName, taskType, isDone);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    public String getBy() {
        return this.by;
    }

}
